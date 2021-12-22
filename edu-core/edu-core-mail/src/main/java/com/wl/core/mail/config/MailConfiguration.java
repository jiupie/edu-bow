package com.wl.core.mail.config;

import com.wl.common.factory.YamlPropertySourceFactory;
import com.wl.core.mail.service.JavaMailTemplate;
import com.wl.core.mail.service.MailTemplate;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;

/**
 * 邮件配置
 *
 */
@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class,value = "classpath:edu-mail.yml")
public class MailConfiguration {

	@Resource
	private JavaMailSender mailSender;

	@Resource
	private MailProperties mailProperties;

	@Bean
	public MailTemplate mailTemplate() {
		return new JavaMailTemplate(mailSender,mailProperties);
	}
}
