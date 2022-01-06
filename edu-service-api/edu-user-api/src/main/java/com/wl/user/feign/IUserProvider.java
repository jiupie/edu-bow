package com.wl.user.feign;

import com.wl.common.base.ResponseDTO;
import com.wl.common.constanst.AppConstant;
import com.wl.user.domain.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@FeignClient(value = AppConstant.APPLICATION_EDU_USER, fallback = UserProviderFallback.class)
public interface IUserProvider {

    /**
     * 根据id查询用户信息
     *
     * @param id id
     * @return ResponseDTO
     */
    @GetMapping(AppConstant.PROVIDER + "/user/id")
    ResponseDTO<SysUser> getUserById(@RequestParam("id") Long id);

    /**
     * 根据userName查询用户信息
     *
     * @param userName 　用户名
     * @return ResponseDTO
     */
    @GetMapping(AppConstant.PROVIDER + "user/username")
    ResponseDTO<SysUser> getUserByUserName(@RequestParam("userName") String userName);

    /**
     * 根据手机号查询用户信息
     *
     * @param mobile 　手机号码
     * @return ResponseDTO
     */
    @GetMapping(AppConstant.PROVIDER + "user/mobile")
    ResponseDTO<SysUser> getUserByMobile(@RequestParam("mobile") String mobile);

    /**
     * 根据邮件查询用户信息
     *
     * @param email 　邮件
     * @return ResponseDTO
     */
    @GetMapping(AppConstant.PROVIDER + "user/email")
    ResponseDTO<SysUser> getUserByEmail(@RequestParam("email") String email);
}
