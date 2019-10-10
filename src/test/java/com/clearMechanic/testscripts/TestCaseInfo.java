package com.clearMechanic.testscripts;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;

@Documented
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(METHOD)
public @interface TestCaseInfo {

	String testCaseID();
    String title();
    String description() default "";
    String bug() default "";
    boolean isAutomationBug() default false;
    
}
