package io.qameta.allure;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})

@LabelAnnotation(name = "url")
public @interface UrlPath {

    String value();

}
