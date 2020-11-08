package ru.ndg.practice.controller;


import java.util.LinkedHashMap;
import java.util.Map;

public interface DefaultController {

    default Map<String, Object> putViewInBody(String param, Object view) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(param, view);
        return body;
    }
}
