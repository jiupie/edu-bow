package com.wl.common.exception;

import com.wl.common.base.IResultCode;
import com.wl.common.enums.ResultCode;
import lombok.Getter;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class OSSException extends RuntimeException {
    private static final long serialVersionUID = 2359767895161832954L;

    @Getter
    private final IResultCode resultCode;

    public OSSException(String message) {
        super(message);
        this.resultCode = ResultCode.UN_AUTHORIZED;
    }

    public OSSException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public OSSException(IResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
