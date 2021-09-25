package com.nix.lpr.library.aop;

import com.nix.lpr.library.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackingEventManager {
    @Pointcut("execution(* com.nix.lpr.library.service.UserService.deleteUser(Integer)) && args(userId)")
    public void trackUserDeleteAction(Integer userId) {

    }

    @Before(value = "trackUserDeleteAction(userId)", argNames = "userId")
    public void trackStartDeleteAction(Integer userId) {
        System.out.printf("User %d is going to be deleted!%n", userId);
    }

    @After(value = "trackUserDeleteAction(userId)", argNames = "userId")
    public void trackStartFinishAction(Integer userId) {
        System.out.printf("User %d has been deleted!%n", userId);
    }

    @Around(value = "(execution(* com.nix.lpr.library..service.UserService.addUser(com.nix.lpr.library.entity.User))) && args(user)")
    public Object trackUserAddAction(ProceedingJoinPoint proceedingJoinPoint, User user) {
        Object result;

        try {
            System.out.println("User " + user.getLogin() + " is going to be added to the database!");
            result = proceedingJoinPoint.proceed();
            System.out.println("User " + user.getLogin() + " has been added to the database!");
        } catch (Throwable e) {
            System.out.println("An exception occurred when adding user " + user.getLogin());
            throw new RuntimeException();
        }

        return result;
    }
}
