package kr.co.yapp.recruit.security;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.multipart.support.MultipartFilter;

public class SecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	
	/**
	 * 
	 * @author seungchanbaeg
	 * 2018.03.10
	 * 파일 전송은 시큐리티 필터보다 우선순위 앞섬.
	 *
	 */
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		insertFilters(servletContext, new MultipartFilter());
	}
}
