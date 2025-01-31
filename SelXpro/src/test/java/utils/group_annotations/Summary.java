package utils.group_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // Retain the annotation at runtime
@Target(ElementType.METHOD)          // Applicable to methods only
public @interface Summary {
    String value();
}
