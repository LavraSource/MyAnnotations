package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    String name();
    String desc();
    int minArgs() default 0;
    int maxArgs() default 0;
    String[] aliases();
    String args();
    boolean hasArgs() default false;
}
