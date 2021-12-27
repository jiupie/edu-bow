package com.wl.user.feign;

import com.wl.common.base.ResponseDTO;
import com.wl.common.constanst.AppConstant;
import com.wl.user.domain.User;
import com.wl.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@ApiIgnore
@RestController
@AllArgsConstructor
public class UserProvider implements IUserProvider{

    private final UserService userService;

    @Override
    @GetMapping(AppConstant.PROVIDER + "/user/id")
    public ResponseDTO<User> getUserById(Long id) {
        int i=1/0;
        return ResponseDTO.success(userService.getUserById(id));
    }

    @GetMapping(AppConstant.PROVIDER+"user/username")
    @Override
    public ResponseDTO<User> getUserByUserName(String userName) {
        return ResponseDTO.success(userService.getUserByUsername(userName));
    }

    @GetMapping(AppConstant.PROVIDER+"user/mobile")
    @Override
    public ResponseDTO<User> getUserByMobile(String mobile) {
        return ResponseDTO.success(userService.getUserByMobile(mobile));
    }

    @GetMapping(AppConstant.PROVIDER + "user/email")
    @Override
    public ResponseDTO<User> getUserByEmail(String email) {
        return ResponseDTO.success(userService.getUserByEmail(email));
    }
}
