package com.wl.uaa.granter;

import com.wl.uaa.dto.LoginDTO;
import com.wl.uaa.valid.AbstractValidCode;
import com.wl.user.domain.User;

/**
 * 授权认证统一接口.
 *
 * @author Chill
 */
public interface ITokenGranter {

	/**
	 * 获取用户信息
	 *
	 * @param loginDTO 授权参数
	 * @param abstractValidCode 验证码
	 * @return UserInfo
	 */
	User grant(LoginDTO loginDTO, AbstractValidCode abstractValidCode);

}