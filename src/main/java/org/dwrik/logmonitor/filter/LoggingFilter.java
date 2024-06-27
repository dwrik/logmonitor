package org.dwrik.logmonitor.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/")
public class LoggingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long startTime = System.currentTimeMillis();

		var httpRequest = (HttpServletRequest) request;
		var httpResponse = (HttpServletResponse) response;
		chain.doFilter(request, response);

		long duration = System.currentTimeMillis() - startTime;
		log.info("{} {} {} {} {} {}",
				fixedWidth(httpRequest.getMethod(), 6),
				fixedWidth(httpRequest.getRequestURI(), 15),
				fixedWidth(httpRequest.getProtocol(), 8),
				fixedWidth(httpResponse.getStatus(), 3),
				fixedWidth(duration + "ms",6),
				httpRequest.getHeader("User-Agent"));
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}

	private static String fixedWidth(Object object, int width) {
		return String.format("%-" + width + "s", object);
	}

}
