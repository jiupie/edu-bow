package com.wl.common.exception;

import com.wl.common.base.IResultCode;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class ValidCodeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final Integer code;

    public ValidCodeException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }
}
