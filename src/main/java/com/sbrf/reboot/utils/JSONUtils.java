package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class JSONUtils {

    public static String toJSON(Request obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

    public static String toJSON(Response obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }

    public static Response JSONtoResponse(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, Response.class);
    }

    public static Request JSONtoRequest(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, Request.class);
    }

}
