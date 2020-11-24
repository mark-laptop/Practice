package ru.ndg.practice.controller;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.ndg.practice.controller.util.ControllerUtils;

import java.util.Map;

@ControllerAdvice
public class AdviceController implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null) {
            return ControllerUtils.putViewInBody("result", "success");
        }

        if (body instanceof Map && ((Map)body).containsKey("error")) {
            return body;
        } else {
            return ControllerUtils.putViewInBody("data", body);
        }
    }
}
