package com.crv.erais.sys.manage.exception;

/**
 * @author MingLi
 * @version First.0
 * @date 2019/8/23 17:20
 * 定义全局的处理异常。。。。。
 */

public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = -5598865415547474216L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
