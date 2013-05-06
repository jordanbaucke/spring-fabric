package foo.api;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceUsageAop {
//	@Pointcut("execution(* foo.api.ApiController.jsonGetMethods(..))")
//	public void jsonGetMethods() {
//	}
//
//	@Before("jsonGetMethods()")
//	public void log() {
//		System.out.println("Hello");
//	}
//
//	@AfterReturning(pointcut = "execution(* foo.api.ApiController.jsonGetMethods(..))", returning = "retVal")
//	public void doAccessCheck(Object retVal) {
//		System.out.println("Hello");
//	}
}
