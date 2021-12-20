package com.wl.user.feign;

import com.wl.common.base.ResponseDTO;
import com.wl.common.constanst.AppConstant;
import com.wl.user.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@FeignClient(value = AppConstant.APPLICATION_EDU_USER)
public interface IUserProvider {

    /**
     * 根据id查询用户信息
     *
     * @param id id
     * @return ResponseDTO
     */
    @GetMapping(AppConstant.PROVIDER + "/user/id")
    ResponseDTO<User> getUserById(@RequestParam("id") Long id);

    /**
     * 根据userName查询用户信息
     *
     * @param userName 　用户名
     * @return ResponseDTO
     */
    @GetMapping(AppConstant.PROVIDER+"user/username")
    ResponseDTO<User> getUserByUserName(@RequestParam("userName") String userName);

    /**
     * 根据手机号查询用户信息
     *
     * @param mobile 　手机号码
     * @return ResponseDTO
     */
    @GetMapping(AppConstant.PROVIDER+"user/mobile")
    ResponseDTO<User> getUserByMobile(@RequestParam("mobile") String mobile);

}
