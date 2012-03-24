package com.blogspot.javahowto;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Documented
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Contains {
    String value() default "";
}
