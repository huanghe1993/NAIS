package com.anyikang.controller.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.ProductAgreement;
import com.anyikang.model.ProductManual;
import com.anyikang.model.ProductVersion;
import com.anyikang.service.RescueProductService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;


/**
 * 紧急救助系统查询控制器
 * @author LvXiaoxiong 
 * @date   2017/07/13
 *
 */
@RestController
@RequestMapping(value = "/web/product/")
public class RescueProductController extends BaseController {

    private Logger logger = Logger.getLogger(RescueProductController.class);
    @Value("${spring.files.images-path}")
   	private String filePath;
    
    @Autowired
    private RescueProductService rescueProductService;
    

    /**
     * 添加版本信息
     * @param request
     * @param tokenId
     * @return
     */
    @PostMapping("version/update")
    public BaseResponse<?> addVersion( int versionNumber,
    		                           String softwareName,
    		                           String tokenId,
    		                           String versionName,
    		                           int versionDevice,
    		                           @RequestParam(value="remark",required=false) String remark,
    		                           @RequestParam(value="file",required=true) MultipartFile multiReq) {
    	BaseResponse<String> responseMessage = new BaseResponse<>();
        if(softwareName==null||versionName==null){
        	responseMessage.setMsg("添加失败,请完成必填项后再提交");
			responseMessage.setStatus(0);
		    return responseMessage;
        }
        ProductVersion pv = new ProductVersion();
		if(multiReq.isEmpty()){
			responseMessage.setMsg("添加失败,文件不能为空");
			responseMessage.setStatus(0);
		    return responseMessage;
 		}
  	    // 获取上传文件的路径
		String uploadFilePath = multiReq.getOriginalFilename();
		// 截取上传文件的文件名
		String uploadFileName = uploadFilePath.substring(uploadFilePath.lastIndexOf('\\') + 1,uploadFilePath.lastIndexOf('.'));
		// 截取上传文件的后缀
		String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.lastIndexOf('.') + 1, uploadFilePath.length());
		FileOutputStream fos = null;
		FileInputStream fis = null;
		String startName =UUID.randomUUID().toString();
		try {
			File folder = new File(filePath);
	        if (!folder.exists()) {
	          	folder.mkdirs();
	        }
			fis = (FileInputStream) multiReq.getInputStream();
			System.err.println(filePath);
			fos = new FileOutputStream(new File(filePath + uploadFileName+ ".")+ uploadFileSuffix);
			byte[] temp = multiReq.getBytes();
			int i = fis.read(temp);
			while (i != -1) {
				fos.write(temp, 0, temp.length);
				fos.flush();
				i = fis.read(temp);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
	    pv.setCreateTime(new Timestamp(System.currentTimeMillis()));
	    pv.setVersionDevice(versionDevice);
	    pv.setVersionId(UUID.randomUUID().toString());
	    pv.setVersionName(versionName);
	    pv.setVersionNumber(versionNumber);
	    pv.setSoftwareName(softwareName);
	    pv.setDownloadLink(uploadFileName+"."+uploadFileSuffix);
	    //版本名称应该先查数据库中 该设备有几个版本,就是版本更新次数;
	    int updateTimes = rescueProductService.findVersionUpdateTimes(versionDevice);
	    pv.setUpdateTimes(updateTimes);
	    boolean flag =rescueProductService.addProductVersion(pv);
	    if(flag){
	    	responseMessage.setMsg("添加成功");
    		responseMessage.setStatus(1);
    		return responseMessage;
	    }
	    responseMessage.setMsg("添加失败");
		responseMessage.setStatus(0);
		return responseMessage;
    }
    
    
	/**
 	 * 查询所有app种类
 	 * @param tokenId
 	 * @return
 	 */
 	@RequestMapping(value ="findAppKinds", method = RequestMethod.GET)
 	public BaseResponse<?> findAppKinds(String tokenId) {
 		BaseResponse<List<Map<String,Object>>> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
  
    	List<Map<String,Object>> appList =rescueProductService.findAppKinds();
    	if(appList!=null&&appList.size()!=0){
    		baseResponse.setStatus(1);
 			baseResponse.setMsg("查询成功");
 			baseResponse.setData(appList);
 			return baseResponse;
    	}
    	baseResponse.setStatus(0);
		baseResponse.setMsg("查询失败");
		return baseResponse;
		
	}
    
    
    
    
   /**
    * 查询最新版本信息
    * @param tokenId
    * @return
    */
    @GetMapping("version/find")
    public BaseResponse<?> findVersion(@RequestParam String tokenId,int pageIndex,int pageSize) {
    	BaseResponse<PageInfo<List<Map<String,Object>>>> responseMessage = new BaseResponse<>();
    	PageMethod.startPage(pageIndex, pageSize);
    	@SuppressWarnings("unchecked")
		PageInfo<List<Map<String,Object>>> list = page(rescueProductService.findVersion());
	    if(list==null){
	    	responseMessage.setMsg("查询失败");
    		responseMessage.setStatus(0);
    		return responseMessage;
	    }
	    responseMessage.setMsg("查询成功");
		responseMessage.setStatus(1);
		responseMessage.setData(list);
		return responseMessage;
    }
    
    
    /**
     * 查询最新版本信息
     * @param tokenId
     * @return
     */
     @GetMapping("version/findDownloadLink")
     public BaseResponse<?> findDownloadLink(HttpServletRequest request) {
     	BaseResponse<String> responseMessage = new BaseResponse<>();
     	String versionId=request.getParameter("versionId");
     	String fileName = rescueProductService.findDownloadLink(versionId);
 	    if(fileName==null){
 	    	responseMessage.setMsg("查询失败");
     		responseMessage.setStatus(0);
     		return responseMessage;
 	    }
 	    String fileNames = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
 	    String downloadLink =fileName;
 	    System.err.println("====="+downloadLink+"======");
 	    responseMessage.setMsg("查询成功");
 	  	responseMessage.setStatus(1);
 	  	responseMessage.setData(downloadLink);
 	  	return responseMessage;
     }
     
    
     /**
 	 * 文件下载
 	 * 
 	 * @param res
     * @return 
 	 */
 	@RequestMapping(value = "/downloadFile/{fileName}", method = RequestMethod.GET)
 	public void downloadFile(HttpServletResponse res,HttpServletRequest req) {
 		String [] fileNames =req.getRequestURI().split("/");
 		String fileName=fileNames[fileNames.length-1];
 		res.setHeader("content-type", "application/octet-stream");
 		res.setContentType("application/octet-stream");
 		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
 		byte[] buff = new byte[1024];
 		BufferedInputStream bis = null;
 		OutputStream os = null;
 		try {
 			os = res.getOutputStream();
 			bis = new BufferedInputStream(new FileInputStream(new File(filePath + fileName)));
 			int i = bis.read(buff);
 			while (i != -1) {
 				os.write(buff, 0, buff.length);
 				os.flush();
 				i = bis.read(buff);
 			}
 		} catch (IOException e) {
 			e.printStackTrace();
 		} finally {
 			if (bis != null) {
 				try {
 					bis.close();
 				} catch (IOException e) {
 					e.printStackTrace();
 				}
 			}
 		}
 		System.err.println("========下载成功=========");
 	}

 	
 	  /**
     * 添加产品说明信息
     * @param request
     * @param tokenId
     * @return
     */
    @PostMapping("manual/update")
    public BaseResponse<?> addManual(String tokenId,
    		                         String softwareName,
    		                         String manualName,
    		                         String manualVersion,
    		                         String manualDevice,
    		                         String manualInstructions,
    		                         @RequestParam (value="remark",required=false)String remark) {
    	BaseResponse<String> responseMessage = new BaseResponse<>();
    	if(manualName==null||manualVersion==null||manualDevice==null||manualInstructions==null){
    		 responseMessage.setMsg("添加失败");
    		 responseMessage.setStatus(0);
    		 return responseMessage;
    	}
    	ProductManual pm = new ProductManual();
    	pm.setCreateTime(new Timestamp(System.currentTimeMillis()));
    	pm.setManualId(UUID.randomUUID().toString());
    	pm.setManualDevice(manualDevice);
    	pm.setManualInstructions(manualInstructions);
    	pm.setManualName(manualName);
    	pm.setManualVersion(manualVersion);
    	pm.setSoftwareName(softwareName);
    	if(remark!=null){
    		pm.setRemark(remark);
    	}    	
	    //版本名称应该先查数据库中 该设备有几个版本,就是版本更新次数;
	    int updateTimes = rescueProductService.findManualUpdateTimes(manualDevice);
	    pm.setUpdateTimes(updateTimes);
	    boolean flag =rescueProductService.addManual(pm);
	    if(flag){
	    	responseMessage.setMsg("添加成功");
    		responseMessage.setStatus(1);
    		return responseMessage;
	    }
	    responseMessage.setMsg("添加失败");
		responseMessage.setStatus(0);
		return responseMessage;
    }
    
    
    /**
     * 查询最新产品说明信息
     * @param tokenId
     * @return
     */
     @GetMapping("manual/find")
     public BaseResponse<?> findManual(@RequestParam String tokenId,int pageIndex,int pageSize) {
     	BaseResponse<PageInfo<List<ProductManual>>> responseMessage = new BaseResponse<>();
     	PageMethod.startPage(pageIndex, pageSize);
     	@SuppressWarnings("unchecked")
 		PageInfo<List<ProductManual>> list = page(rescueProductService.findManual());
 	    if(list==null){
 	    	responseMessage.setMsg("查询失败");
     		responseMessage.setStatus(0);
     		return responseMessage;
 	    }
 	    responseMessage.setMsg("查询成功");
 		responseMessage.setStatus(1);
 		responseMessage.setData(list);
 		return responseMessage;
     }
    
    
    
    
    /**
     * 添加服务协议信息
     * @param request
     * @param tokenId
     * @return
     */
    @PostMapping("agreement/update")
    public BaseResponse<?> addAgreement(String tokenId,
    		                            String softwareName,
    		                            String agreementName,
    		                            String agreementVersion,
    		                            String agreementDevice,
    		                            String agreementInstructions,
    		                            @RequestParam (value="remark",required=false)String remark) {
    	BaseResponse<String> responseMessage = new BaseResponse<>();
    	if(agreementName==null||agreementVersion==null||agreementDevice==null||agreementInstructions==null){
    		 responseMessage.setMsg("添加失败");
    		 responseMessage.setStatus(0);
    		 return responseMessage;
    	}
    	ProductAgreement pa = new ProductAgreement();
    	pa.setCreateTime((new Timestamp(System.currentTimeMillis())));
    	pa.setAgreementId(UUID.randomUUID().toString());
    	pa.setAgreementInstructions(agreementInstructions);
    	pa.setAgreementName(agreementName);
    	pa.setAgreementVersion(agreementVersion);
    	pa.setAgreementDevice(agreementDevice);
    	pa.setSoftwareName(softwareName);
    	if(remark!=null){
    		pa.setRemark(remark);
    	}    	
	    //版本名称应该先查数据库中 该设备有几个版本,就是版本更新次数;
	    int updateTimes = rescueProductService.findAgreementUpdateTimes(agreementDevice);
	    pa.setUpdateTimes(updateTimes);
	    boolean flag =rescueProductService.addAgreement(pa);
	    if(flag){
	    	responseMessage.setMsg("添加成功");
    		responseMessage.setStatus(1);
    		return responseMessage;
	    }
	    responseMessage.setMsg("添加失败");
		responseMessage.setStatus(0);
		return responseMessage;
    }
    
    
    
    /**
     * 查询最新产品说明信息
     * @param tokenId
     * @return
     */
     @GetMapping("agreement/find")
     public BaseResponse<?> findAgreement(@RequestParam String tokenId,int pageIndex,int pageSize) {
     	BaseResponse<PageInfo<List<ProductAgreement>>> responseMessage = new BaseResponse<>();
     	PageMethod.startPage(pageIndex, pageSize);
     	@SuppressWarnings("unchecked")
 		PageInfo<List<ProductAgreement>> list = page(rescueProductService.findAgreement());
 	    if(list==null){
 	    	responseMessage.setMsg("查询失败");
     		responseMessage.setStatus(0);
     		return responseMessage;
 	    }
 	    responseMessage.setMsg("查询成功");
 		responseMessage.setStatus(1);
 		responseMessage.setData(list);
 		return responseMessage;
     }
    
}
