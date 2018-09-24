package com.zh.controller.aspect;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * controller接口日志
 *
 * @Author zh2683
 */
@Component("controllerLog")
@Aspect
public class LogAspect {

    private static final Logger logger = Logger.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.zh.controller.*.*(..))")
    public void point() {
    }

    @Around(value = "point()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        // 全路径名
        String clazz = joinPoint.getTarget().getClass().getCanonicalName();
        // 方法名
        String method = joinPoint.getSignature().getName();
        StringBuilder msg = new StringBuilder();
        msg.append(clazz).append(".").append(method).append("(");
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                msg.append(arg).append(",");
            }
            msg = msg.replace(msg.length() - 1, msg.length(), "");
        }
        msg.append(")");
        Object result = null;
        try {
            if (args != null)
                result = joinPoint.proceed(args);
            else
                result = joinPoint.proceed();
            if (result != null) {
                msg.append(" ").append(JSONObject.toJSONString(result));
            }
        } catch (Throwable t) {
            logger.error("调用失败: " + msg, t);
        } finally {
            logger.info(msg);
        }
        return result;
    }
}
