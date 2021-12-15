
create database edu_ad;

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

