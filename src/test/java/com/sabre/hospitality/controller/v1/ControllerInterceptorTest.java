package com.sabre.hospitality.controller.v1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sabre.hospitality.controller.v1.ControllerInterceptor;

/**
 * 
 * @author Juan Hall
 */
@RunWith(JUnit4.class)
public class ControllerInterceptorTest {

	private ControllerInterceptor interceptor;
	@Mock
	private HttpServletRequest httpServletRequestMock;
	@Mock
	private HttpServletResponse httpServletResponseMock;
	private boolean slept;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		slept = false;

		interceptor = new ControllerInterceptor() {
			@Override
			protected void sleep(long elapsedTime) throws InterruptedException {
				assertTrue("elapsed time not > 0", elapsedTime > 0);
				slept = true;
			}
		};
		interceptor.setErrorDelayInMillis(10000);
	}

	@Test
	public void preHandle() throws Exception {
		interceptor.preHandle(httpServletRequestMock, httpServletResponseMock,
				null);

		verify(httpServletRequestMock).setAttribute(Mockito.eq("START_TIME"),
				Mockito.anyLong());
	}

	@Test
	public void afterCompletionWithoutError() throws Exception {
		when(httpServletRequestMock.getAttribute("START_TIME")).thenReturn(0L);
		when(httpServletResponseMock.getStatus()).thenReturn(399);

		interceptor.afterCompletion(httpServletRequestMock,
				httpServletResponseMock, null, null);

		assertFalse(slept);
	}

	@Test
	public void afterCompletionWithErrorAndWithoutSleep() throws Exception {
		when(httpServletRequestMock.getAttribute("START_TIME")).thenReturn(0L);
		when(httpServletResponseMock.getStatus()).thenReturn(400);

		interceptor.afterCompletion(httpServletRequestMock,
				httpServletResponseMock, null, null);

		assertFalse(slept);
	}

	@Test
	public void afterCompletionWithErrorAndWithSleep() throws Exception {
		when(httpServletRequestMock.getAttribute("START_TIME")).thenReturn(
				System.currentTimeMillis());
		when(httpServletResponseMock.getStatus()).thenReturn(400);

		interceptor.afterCompletion(httpServletRequestMock,
				httpServletResponseMock, null, null);

		assertTrue(slept);
	}
}
