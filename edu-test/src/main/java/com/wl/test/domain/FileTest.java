package com.wl.test.domain;

import java.io.File;
import java.io.IOException;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/dile/soft/nacos/test.txt");
        file.createNewFile();
    }
}
