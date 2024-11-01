package annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // For classes and interfaces
public @interface Entity {
    String tableName() default "";
}

