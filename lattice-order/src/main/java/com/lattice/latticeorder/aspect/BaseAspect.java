package com.lattice.latticeorder.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @program: e3
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-10-21 21:23
 **/
@Aspect
@Component
public  class BaseAspect {
	@Autowired
	private static Logger logger = LoggerFactory.getLogger(BaseAspect.class);

	@Pointcut("execution(public * com.lattice.*.*.*.*(..))")
	public void addLog(){
	}

	@Before("addLog()")
	public void doBefor(JoinPoint joinPoint){
		logger.info("-------------------------------------------开始请求-------------------------------------------");
		this.logServiceMessage(joinPoint);
	}

	@AfterReturning(returning = "ret",pointcut = "addLog()")
	public void afterRunningItemController(Object ret){
		logger.info("返回数据\t"+ret);
	}

	@AfterThrowing("addLog()")
	public void throwss(JoinPoint jp){
		logger.info("-------------------------------------------请求出现异常" +
				"-------------------------------------------");
	}
	@After("addLog()")
	public void after(JoinPoint jp){
		logger.info("-------------------------------------------结束请求" +
				"-------------------------------------------");
	}

	public void logControllerMessage(JoinPoint joinPoint){
		ServletRequestAttributes requestAttributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String url = request.getRequestURI();
		String httpMethod = request.getMethod();
		String ip = request.getRemoteAddr();
		String classMethod = joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("url:\t"+url + "\tmethod:\t"+httpMethod + "\t请求者的ip:\t"+ip);
		logger.info("classMethod:\t" + classMethod + "\targs:\t" +args);
		logger.info("用户的session:\t"+request.getSession().getId());
	}
	public void logServiceMessage(JoinPoint joinPoint){

		String classMethod = joinPoint.getSignature().getDeclaringTypeName() +"."+ joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("classMethod:\t" + classMethod + "\targs:\t" +args);

	}


}
