package com.wl.common.exception;

import com.wl.common.base.IResultCode;
import com.wl.common.enums.ResultCode;
import lombok.Getter;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class BadRequestException extends RuntimeException{
    @Getter
    private final IResultCode resultCode;
    public BadRequestException(String message) {
        super(message);
        this.resultCode= ResultCode.ERROR;
    }


}
