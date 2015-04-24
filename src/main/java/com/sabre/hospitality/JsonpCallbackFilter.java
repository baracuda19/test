package com.sabre.hospitality;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 
 * @author Juan Hall
 */
public class JsonpCallbackFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		OutputStream out = null;
		ByteArrayOutputStream baos = null;
		String queryString = StringUtils
				.defaultString(request.getQueryString());
		boolean hasJsonpCallback = queryString.startsWith("callback=")
				|| queryString.contains("&callback=");

		if (hasJsonpCallback) {
			baos = new ByteArrayOutputStream();
			out = response.getOutputStream();
			response = new WrappedHttpServletResponse(response, baos);
		}

		filterChain.doFilter(request, response);

		if (hasJsonpCallback) {
			outputJsonpResponse(request, response, out, baos);
		}
	}

	private void outputJsonpResponse(HttpServletRequest request,
			HttpServletResponse response, OutputStream out,
			ByteArrayOutputStream baos) throws IOException {
		boolean isJsonResponse = "application/json".equals(response
				.getContentType());

		if (isJsonResponse) {
			response.setContentType("text/javascript;charset=UTF-8");

			out.write((request.getParameter("callback") + '(').getBytes());
		}

		out.write(baos.toByteArray());

		if (isJsonResponse) {
			out.write(");".getBytes());
		}

		out.close();
	}
}

class WrappedHttpServletResponse extends HttpServletResponseWrapper {

	private ByteArrayOutputStream baos;

	public WrappedHttpServletResponse(HttpServletResponse response,
			ByteArrayOutputStream baos) {
		super(response);
		this.baos = baos;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return new ServletOutputStream() {

			@Override
			public void write(int arg0) throws IOException {
				baos.write(arg0);
			}
		};
	}
}