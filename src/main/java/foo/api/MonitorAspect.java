package foo.api;

import java.lang.reflect.Method;

import javassist.bytecode.SignatureAttribute.MethodSignature;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sun.xml.internal.ws.client.ResponseContextReceiver;

import foo.user.User;
import foo.user.UserService;

@Aspect
@Component
public class MonitorAspect {

	@Autowired
	MyServletResponse servletResponse;

	@Autowired
	MonitorService monitorService;

	@Autowired
	UserService userService;

/*	@Around(value = "@annotation(foo.api.Monitor)")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		Object retVal = pjp.proceed();
		long endTime = System.currentTimeMillis();
		long executionTime = (endTime - startTime);
		HttpServletResponse response = (HttpServletResponse) servletResponse
				.gettServletResponse();
		int status = ((HttpServletResponse) response).getStatus();
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		UserDetails user = userService.loadUserByUsername(authentication
				.getName());
		UsageMonitor usage = new UsageMonitor(1, "requestid", "failed", pjp
				.getSignature().getName(), startTime, endTime, executionTime,
				null);
		monitorService.logUsage(usage);
	}*/

}
