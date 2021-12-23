package com.wl.test.encrypt;

import com.wl.common.base.ResponseDTO;
import com.wl.core.encrypt.annotation.SeparateEncrypt;
import com.wl.core.encrypt.annotation.SignEncrypt;
import com.wl.test.domain.UserReq;
import com.wl.user.feign.IUserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 测试加解密  签名
 *
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestUserController {
    private final IUserProvider iUserProvider;

    @SeparateEncrypt
    @PostMapping("/getUserById")
    public ResponseDTO getUserById() {
        return iUserProvider.getUserById(1L);
    }


    @GetMapping("/getUserById")
    public ResponseDTO getMappingUserById(Long id) {
        return iUserProvider.getUserById(id);
    }


    @SignEncrypt
    @PostMapping("/sign/getUserById")
    public ResponseDTO getSignUserById(@RequestBody UserReq user) {
        return iUserProvider.getUserById(user.getId());
    }

}
