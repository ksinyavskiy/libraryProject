package com.nix.lpr.library.aop;

import com.nix.lpr.library.entity.Author;
import com.nix.lpr.library.entity.User;
import com.nix.lpr.library.event.RestCustomEventPublisher;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackingEventManager {

    private final RestCustomEventPublisher restCustomEventPublisher;

    @Autowired
    public TrackingEventManager(RestCustomEventPublisher restCustomEventPublisher) {
        this.restCustomEventPublisher = restCustomEventPublisher;
    }

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

    @Around(value = "(execution(* com.nix.lpr.library.service.UserService.addUser(com.nix.lpr.library.entity.User))) && args(user)")
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

    @Around("(execution(* com.nix.lpr.library.service.AuthorService.addAuthor(com.nix.lpr.library.entity.Author))) " +
            "&& args(author)")
    public Object trackAuthorAddAction(ProceedingJoinPoint proceedingJoinPoint, Author author) {
        Object result;
        String authorFullName = author.getLastName().concat(" ").concat(author.getFirstName());

        try {
            restCustomEventPublisher.sendCreateEntityEvent(String.format("Author %s is going to be added to DB",
                    authorFullName));
            result = proceedingJoinPoint.proceed();
            restCustomEventPublisher.sendCreateEntityEvent(String.format("Author %s is successfully added",
                    authorFullName));
        } catch (Throwable e) {
            System.out.println("An exception occurred when adding user " + authorFullName);
            throw new RuntimeException();
        }

        return result;
    }
}
