package com.sabre.hospitality;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;

		if (req instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest) req;
			if (request.getMethod().equalsIgnoreCase("OPTIONS")
					&& request.getRequestURL().toString().contains("debug")) {
				String additionalHeader = request
						.getHeader("Access-Control-Request-Headers");
				if (additionalHeader != null) {
					response.setHeader("Access-Control-Allow-Headers",
							additionalHeader);
				}
				response.setHeader("Access-Control-Max-Age", "3600");
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods",
						"POST, GET, OPTIONS, DELETE");
			}
		}

		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}