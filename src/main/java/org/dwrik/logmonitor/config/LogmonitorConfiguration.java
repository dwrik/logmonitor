package org.dwrik.logmonitor.config;

import org.dwrik.logmonitor.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LogmonitorConfiguration {

	@Bean
	public FilterRegistrationBean<LoggingFilter> loggingFilter() {
		var registrationBean = new FilterRegistrationBean<LoggingFilter>();
		registrationBean.setFilter(new LoggingFilter());
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}

}
