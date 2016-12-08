package org.bedoing.exception;

import org.bedoing.vo.ErrorDetail;

import static javax.ws.rs.core.Response.*;

/**
 * Created by ken on 12/7/2016.
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 3867638276637067905L;
    private Status statusCode;
    private ErrorDetail error;

    public ServiceException() {
        this.statusCode = Status.INTERNAL_SERVER_ERROR;
    }

    public ServiceException(ErrorDetail error, String message) {
        super(message);
        this.statusCode = Status.INTERNAL_SERVER_ERROR;
        this.error = error;
    }

    public ServiceException(Status statusCode, ErrorDetail error) {
        super(error.getErrorDescription());
        this.statusCode = Status.INTERNAL_SERVER_ERROR;
        this.statusCode = statusCode;
        this.error = error;
    }

    public ServiceException(Status statusCode, ErrorDetail error, String message) {
        super(message);
        this.statusCode = Status.INTERNAL_SERVER_ERROR;
        this.statusCode = statusCode;
        this.error = error;
    }

    public ServiceException(Status statusCode, ErrorDetail error, String message, Throwable cause) {
        super(message, cause);
        this.statusCode = Status.INTERNAL_SERVER_ERROR;
        this.statusCode = statusCode;
        this.error = error;
    }

    public ServiceException(ErrorDetail error, Throwable cause) {
        super(cause);
        this.statusCode = Status.INTERNAL_SERVER_ERROR;
        this.error = error;
    }

    public Status getStatusCode() {
        return this.statusCode;
    }

    public ErrorDetail getError() {
        return this.error;
    }
}
