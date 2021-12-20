package com.wl.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Data
public class PageDTO implements Serializable {
    private int current;
    private int size;
    private static final long serialVersionUID = 1L;
}
