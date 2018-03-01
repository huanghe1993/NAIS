package com.anyikang.exception;

import com.anyikang.base.Constants;
import com.anyikang.base.BaseResponse;
import com.anyikang.base.ResponseMSG;
import com.anyikang.utils.DateUtil;

import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@ControllerAdvice
public class GlobalExceptionHandler{
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(value={Exception.class})
    @ResponseBody
    public BaseResponse<String> exceptionHandle(Exception ex) {
        System.out.print("message=" + ex);
        String message = ex.getMessage();
        BaseResponse<String> baseResponse = new BaseResponse<String>();
        if (ex instanceof BindException){
            BindException bindException = (BindException) ex;
            message = getBindingErrors(bindException.getBindingResult());
            baseResponse.setCode(Constants.PARAMETER_VALIDATION_ERROR);
            logger.error(message);
        }else if (ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
            message = getBindingErrors(methodArgumentNotValidException.getBindingResult());
            baseResponse.setCode(Constants.PARAMETER_VALIDATION_ERROR);
            logger.error(message);
        } else if(ex instanceof UnauthorizedException){
            UnauthorizedException e = (UnauthorizedException) ex;
            message = "无权限操作    "+ e.getMessage();
            baseResponse.setCode(6);
        }else {
            baseResponse.setCode(Constants.SYSTEM_ERROR);
            logger.error(message,ex);
        }
        baseResponse.setError(message);
        // SysLogUtil.log(Constants.OPERATION_FAILED,new Date(),message);
        return baseResponse;
    }
    
    
    @ExceptionHandler(value = {MyException.class })
    @ResponseBody
    public BaseResponse myException(Exception exception, WebRequest request) {
    	logger.error(exception.getMessage());
    	BaseResponse baseResponse = new BaseResponse();
    	baseResponse.setCode(Constants.BUSINESS_ERROR);
    	return baseResponse;
    }
    
    @ExceptionHandler(value = {RuntimeException.class })
	@ResponseBody
	public BaseResponse exception(Exception exception, WebRequest request) {
		logger.info("Catch an exception:", exception);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setMsg(exception.getMessage());
		return baseResponse;
	}
    
    
    @ExceptionHandler(value = { NoHandlerFoundException.class })
	@ResponseBody
	public BaseResponse noMapping(Exception exception, WebRequest request) {
		logger.info("No mapping exception", exception);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setMsg(exception.getMessage());
		return baseResponse;
	}

	@ExceptionHandler(value = { UnknownAccountException.class })
	@ResponseBody
	public BaseResponse noUser(Exception exception, WebRequest request) {
		logger.error("No User");
		return new BaseResponse(ResponseMSG.E_USER_ERROR);
	}

    /**
     * 组装参数校验错误信息
     * @param bindingResult
     * @return
     */
    private String getBindingErrors(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder errorMsg = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            errorMsg.append(fieldError.getDefaultMessage()).append(";");
        }
        return errorMsg.toString();
    }

    /**
     * 参数绑定
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtil.str2Date(text));
            }
        });
    }

}
