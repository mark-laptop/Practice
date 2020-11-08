package ru.ndg.practice.controller;


import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultController {

    protected Map<String, Object> putViewInBody(String param, Object view) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(param, view);
        return body;
    }
}
