package ec.gob.mag.exception.constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ TYPE })
public @interface PredioVerificadorsIncluyente {
	PredioVerificadorIncluyente[] value();
}
