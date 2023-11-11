package ru.netology.SpringBoot_HW2_AuthorizationService.resolver;

import java.lang.annotation.*;

//@Target, @Retention - аннотации для аннотаций или мета-аннотации
@Target(ElementType.PARAMETER) //указывает контекст, для которого применима аннотация; ElementType.PARAMETER - применяется для определения параметра
@Retention(RetentionPolicy.RUNTIME) //указывает, до какого шага во время компиляции аннотация будет доступна; аннотация сохраняется в файле .class во время компиляции и доступна через JVM во время выполнения
@Documented //информирует, что такая аннотация должна быть задокументирована с помощью инструмента javadoc
public @interface UserParam {
    boolean required() default true;
}
