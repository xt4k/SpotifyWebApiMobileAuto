package io.qameta.allure;

import java.lang.annotation.*;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Repeatable(JiraIssues.class)

@LabelAnnotation(name = "jira")
public @interface JiraIssue {

    String value();

}
