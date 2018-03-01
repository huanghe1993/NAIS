package com.anyikang.exception;


/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public class MyException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MyException(String message) {
        super(message);
    }
}
