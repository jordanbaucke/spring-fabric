package foo.api;

import javax.servlet.ServletResponse;

import org.omg.SendingContext.RunTime;
import org.springframework.stereotype.Service;

/**
 * @author jordanbaucke
 */
@Service
public class MyServletResponse {

	private ServletResponse response;

	private static ThreadLocal<MyServletResponse> tLocal = new ThreadLocal<MyServletResponse>();

	public static void set(MyServletResponse myServletResponse) {
		tLocal.set(myServletResponse);
	}

	public static RunTime get() {
		return (RunTime) tLocal.get();
	}

	public void setServletResponse(ServletResponse response) {
		this.response = response;
	}

	public ServletResponse gettServletResponse() {
		return response;
	}
}
