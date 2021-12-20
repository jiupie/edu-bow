
CREATE DATABASE `edu_bow` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

-- ----------------------------
-- Table structure for promotion_space
-- ----------------------------
DROP TABLE IF EXISTS `promotion_space`;
CREATE TABLE `promotion_space` (
                                   `id` int NOT NULL AUTO_INCREMENT,
                                   `name` varchar(255) DEFAULT NULL COMMENT '名称',
                                   `space_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '广告位key',
                                   `create_time` datetime DEFAULT NULL,
                                   `update_time` datetime DEFAULT NULL,
                                   `is_del` int DEFAULT '0',
                                   PRIMARY KEY (`id`) USING BTREE,
                                   KEY `promotion_space_key_isDel` (`space_key`,`is_del`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;


-- ----------------------------
-- Table structure for promotion_ad
-- ----------------------------
DROP TABLE IF EXISTS `promotion_ad`;
CREATE TABLE `promotion_ad` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `name` varchar(255) DEFAULT NULL COMMENT '广告名',
                                `space_id` int DEFAULT NULL COMMENT '广告位id',
                                `keyword` varchar(255) DEFAULT NULL COMMENT '精确搜索关键词',
                                `html_content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '静态广告的内容',
                                `text` varchar(255) DEFAULT NULL COMMENT '文字',
                                `link` varchar(255) DEFAULT NULL COMMENT '链接',
                                `start_time` datetime DEFAULT NULL COMMENT '开始时间',
                                `end_time` datetime DEFAULT NULL COMMENT '结束时间',
                                `create_time` datetime DEFAULT NULL,
                                `update_time` datetime DEFAULT NULL,
                                `status` int NOT NULL DEFAULT '0',
                                `priority` int DEFAULT '0' COMMENT '优先级',
                                `img` varchar(255) DEFAULT NULL,
                                PRIMARY KEY (`id`) USING BTREE,
                                KEY `promotion_ad_SEG` (`space_id`,`start_time`,`end_time`,`status`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
                        `name` varchar(255) NOT NULL COMMENT '用户昵称',
                        `portrait` varchar(255) DEFAULT NULL COMMENT '用户头像地址',
                        `phone` varchar(255) NOT NULL COMMENT '注册手机',
                        `password` varchar(255) DEFAULT NULL COMMENT '用户密码（可以为空，支持只用验证码注册、登录）',
                        `reg_ip` varchar(255) DEFAULT NULL COMMENT '注册ip',
                        `account_non_expired` bit(1) DEFAULT b'1' COMMENT '是否有效用户',
                        `credentials_non_expired` bit(1) DEFAULT b'1' COMMENT '账号是否未过期',
                        `account_non_locked` bit(1) DEFAULT b'1' COMMENT '是否未锁定',
                        `status` varchar(20) NOT NULL DEFAULT 'ENABLE' COMMENT '用户状态：ENABLE能登录，DISABLE不能登录',
                        `is_del` int NOT NULL DEFAULT 0 COMMENT '是否删除',
                        `create_time` datetime NOT NULL COMMENT '注册时间',
                        `update_time` datetime NOT NULL COMMENT '记录更新时间',
                        PRIMARY KEY (`id`) USING BTREE,
                        UNIQUE KEY `idx_phone_is_del` (`phone`,`is_del`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

CREATE TABLE `social_user` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `uuid` varchar(256) COLLATE utf8mb4_general_ci NOT NULL COMMENT '第三方系统的唯一ID	',
                               `source` varchar(256) COLLATE utf8mb4_general_ci NOT NULL COMMENT '第三方用户来源',
                               `access_token` varchar(256) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户的授权令牌	',
                               `expire_in` int DEFAULT NULL COMMENT '第三方用户的授权令牌的有效期	',
                               `refresh_token` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '刷新令牌',
                               `open_id` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '第三方用户的 open id		',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `social_user_auth` (
                                    `id` int NOT NULL AUTO_INCREMENT,
                                    `user_id` int NOT NULL COMMENT '用户Id',
                                    `social_user_id` int NOT NULL COMMENT '社交用户Id',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;