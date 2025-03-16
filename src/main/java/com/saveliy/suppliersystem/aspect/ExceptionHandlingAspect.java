package com.saveliy.suppliersystem.aspect;

import com.saveliy.suppliersystem.exception.ResourceAlreadyExistsException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {
    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    public Object handleDataIntegrityViolationException(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (DataIntegrityViolationException e) {
            throw new ResourceAlreadyExistsException("Resource already exists");
        }
    }
}
