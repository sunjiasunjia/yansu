/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/16 17:06
 * Description:
 * History:
 */
package com.jk.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author admin
 * @create 2019/1/16
 * @since 1.0.0
 */
@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {


    public static final Logger logger = LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);

    /**
      * 切换到从库
      *
      * @param proceedingJoinPoint
      * @param readOnlyConnection
      * @return
      * @throws Throwable
      */
     @Around("@annotation(readOnlyConnection)")
     public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
              try {
                  logger.info("读取从库");
                  DbContextHolder.setDbType(DbContextHolder.DbType.SLAVE);
                  Object result = proceedingJoinPoint.proceed();
                     return result;
               } finally {
                  DbContextHolder.clearDbType();
              logger.info("restore database connection");
             }
    }


    @Override
    public int getOrder() {
      return 0;
    }

}
