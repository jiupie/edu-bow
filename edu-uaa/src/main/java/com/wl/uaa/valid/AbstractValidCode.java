package com.wl.uaa.valid;

import com.wl.uaa.dto.LoginDTO;
import com.wl.uaa.dto.ValidCodeDTO;

import java.util.Map;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public abstract class AbstractValidCode {
    /**
     * 创建验证码
     *
     * @param validCodeDTO /
     * @return /
     */
    public abstract Map creatValidCode(ValidCodeDTO validCodeDTO);


    public boolean valid(LoginDTO loginDTO) {

        return false;
    }

}
