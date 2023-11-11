package ru.netology.SpringBoot_HW2_AuthorizationService.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.SpringBoot_HW2_AuthorizationService.model.User;


public class UserParamHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    // Определяем, поддерживается ли тип параметра для преобразования
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserParam.class); //Возвращает, объявлен ли параметр с заданным типом аннотации.
    }

    // Если поддерживается, выполнить соответствующее преобразование
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String user = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");
        return new User(user, password);
    }
}
