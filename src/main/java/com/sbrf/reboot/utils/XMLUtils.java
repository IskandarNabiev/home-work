package com.sbrf.reboot.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;

public class XMLUtils {

    public static String toXML(Request obj) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(obj);
    }

    public static Response XMLtoResponse(String xml) throws JsonProcessingException {
        return new XmlMapper().readValue(xml, Response.class);
    }

    public static Request XMLtoRequest(String xml) throws JsonProcessingException {
        return new XmlMapper().readValue(xml, Request.class);
    }

}
