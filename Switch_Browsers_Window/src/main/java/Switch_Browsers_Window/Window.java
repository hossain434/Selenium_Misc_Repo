package Switch_Browsers_Window;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import com.google.inject.BindingAnnotation;

@BindingAnnotation @Target({
    TYPE
}) @Retention(RUNTIME)
public @interface Window {
    int value() default 0;
}