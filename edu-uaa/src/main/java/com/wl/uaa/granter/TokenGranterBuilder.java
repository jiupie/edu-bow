package com.wl.uaa.granter;

import com.wl.common.exception.SecureException;
import com.wl.common.utils.SpringUtil;
import com.wl.uaa.enums.LoginType;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Chill
 */
@AllArgsConstructor
public class TokenGranterBuilder {

	/**
	 * TokenGranter缓存池
	 */
	private static final Map<LoginType, ITokenGranter> GRANTER_POOL = new ConcurrentHashMap<>();

	static {
		GRANTER_POOL.put(PasswordTokenGranter.GRANT_TYPE, SpringUtil.getBean(PasswordTokenGranter.class));
		GRANTER_POOL.put(SMSTokenGranter.GRANT_TYPE, SpringUtil.getBean(SMSTokenGranter.class));
		GRANTER_POOL.put(EmailTokenGranter.GRANT_TYPE, SpringUtil.getBean(EmailTokenGranter.class));
		GRANTER_POOL.put(UsernameTokenGranter.GRANT_TYPE, SpringUtil.getBean(EmailTokenGranter.class));
	}

	/**
	 * 获取TokenGranter
	 *
	 * @param grantType 授权类型
	 * @return ITokenGranter
	 */
	public static ITokenGranter getGranter(String grantType) {
		ITokenGranter tokenGranter = GRANTER_POOL.get(LoginType.findValue(grantType));
		if (tokenGranter == null) {
			throw new SecureException("no grantType was found");
		} else {
			return tokenGranter;
		}
	}

}
