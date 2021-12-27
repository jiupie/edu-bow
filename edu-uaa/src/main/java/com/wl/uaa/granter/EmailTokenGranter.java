package com.wl.uaa.granter;

import com.wl.common.enums.ResultCode;
import com.wl.common.exception.ValidCodeException;
import com.wl.common.utils.SpringUtil;
import com.wl.uaa.dto.LoginDTO;
import com.wl.uaa.dto.ValidCodeDTO;
import com.wl.uaa.enums.LoginType;
import com.wl.uaa.enums.ValidCodeType;
import com.wl.uaa.valid.AbstractValidCode;
import com.wl.uaa.valid.ValidBuilder;
import com.wl.user.domain.User;
import com.wl.user.feign.IUserProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class EmailTokenGranter implements ITokenGranter{
    public static final LoginType GRANT_TYPE = LoginType.EMAIL;

    @Override
    public User grant(LoginDTO loginDTO, AbstractValidCode abstractValidCode) {
//        ValidCodeDTO validCodeDTO = new ValidCodeDTO();
//        validCodeDTO.setCode(loginDTO.getCode());
//        validCodeDTO.setAction(ValidCodeType.VALID_CODE_LOGIN_TYPE.getType());
//        validCodeDTO.setTarget(loginDTO.getLogin());
//        boolean valid = abstractValidCode.valid(validCodeDTO);
//        if(!valid){
//            throw new ValidCodeException(ResultCode.VALID_CODE_ERROR);
//        }
        //查询用户表通过邮件
//        IUserProvider userProvider = SpringUtil.getBean(IUserProvider.class);
//        new UsernamePasswordAuthenticationToken(loginDTO.getLogin(),loginDTO.getPassword());
//        return  userProvider.getUserByEmail(loginDTO.getLogin()).getContent();
        return null;
    }
}
