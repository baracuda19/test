package com.sabre.hospitality;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.sabre.hospitality.JsonpCallbackFilter;

/**
 * 
 * @author Juan Hall
 */
public class JsonpCallbackFilterTest {

	private JsonpCallbackFilter filter;
	private HttpServletRequest httpServletRequestMock;
	private HttpServletResponse httpServletResponseMock;
	private ServletOutputStream servletOutputStreamMock;

	@Before
	public void setUp() {
		httpServletRequestMock = mock(HttpServletRequest.class);
		httpServletResponseMock = mock(HttpServletResponse.class);
		servletOutputStreamMock = mock(ServletOutputStream.class);

		filter = new JsonpCallbackFilter();
	}

	@Test
	public void doFilterInternal() throws Exception {
		when(httpServletRequestMock.getQueryString()).thenReturn(
				"callback=jsoncallback");
		when(httpServletRequestMock.getParameter("callback")).thenReturn(
				"jsoncallback");
		when(httpServletResponseMock.getOutputStream()).thenReturn(
				servletOutputStreamMock);
		when(httpServletResponseMock.getContentType()).thenReturn(
				"application/json");

		FilterChain filterChainStub = new FilterChain() {

			@Override
			public void doFilter(ServletRequest request,
					ServletResponse response) throws IOException,
					ServletException {
				response.getOutputStream().print("{}");
			}
		};

		filter.doFilterInternal(httpServletRequestMock,
				httpServletResponseMock, filterChainStub);

		verify(httpServletResponseMock).setContentType(
				"text/javascript;charset=UTF-8");
		verify(servletOutputStreamMock).write("jsoncallback(".getBytes());
		verify(servletOutputStreamMock).write("{}".getBytes());
		verify(servletOutputStreamMock).write(");".getBytes());
		verify(servletOutputStreamMock).close();
	}
}
