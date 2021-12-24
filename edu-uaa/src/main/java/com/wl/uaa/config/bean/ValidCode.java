package com.wl.uaa.config.bean;

import lombok.Data;

import java.util.Map;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Data
public class ValidCode {
    private String key;
    private String value;
    private Map<String,Object> info;

}
