package anotacao;

import java.lang.annotation.*;

/**
 * Created by Nebula Stardust
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}
