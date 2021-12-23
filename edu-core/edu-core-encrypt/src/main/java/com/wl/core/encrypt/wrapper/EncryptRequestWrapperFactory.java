package com.wl.core.encrypt.wrapper;

import com.wl.core.encrypt.handler.EncryptHandler;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 请求加密包装器工厂
 *
 * @author gaoyang
 */
public class EncryptRequestWrapperFactory {

	public static boolean contentIsJson(String contentType) {
		return contentType.equals(MediaType.APPLICATION_JSON_VALUE.toLowerCase()) ||
				contentType.equals(MediaType.APPLICATION_JSON_UTF8_VALUE.toLowerCase());
	}
}
