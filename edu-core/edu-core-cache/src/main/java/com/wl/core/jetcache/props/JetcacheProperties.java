package com.wl.core.jetcache.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@ConfigurationProperties(prefix = "jetcache")
@Data
public class JetcacheProperties {
    private Boolean enableLog=true;

    private Integer minutes = 1;

}
