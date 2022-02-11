package com.sbrf.reboot.functionalinterface;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceTest {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class SomeObject {
        private String objectName;
    }

    @FunctionalInterface
    interface ObjectToJsonFunction<T> {
        String applyAsJson(T t) throws JsonProcessingException;
    }

    @FunctionalInterface
    interface ObjectToXmlFunction<T> {
        String applyAsXml(T t) throws JsonProcessingException;
    }

    static class ListConverter<T> {
        public List<String> toJsonsList(@NonNull List<T> someObjects, ObjectToJsonFunction<T> objectToJsonFunction) throws JsonProcessingException {
            List<String> result = new ArrayList<>();
            if (someObjects.isEmpty())
                throw new IllegalArgumentException("The list is empty");

            for (T el: someObjects) {
                result.add(objectToJsonFunction.applyAsJson(el));
            }
            return result;
        }
    }


    @Test
    public void successCallFunctionalInterface() throws JsonProcessingException {
        ListConverter<SomeObject> ListConverter = new ListConverter<>();

        ObjectToJsonFunction<SomeObject> objectToJsonFunction = someObject ->
                new ObjectMapper().writeValueAsString(someObject);

        List<String> strings = ListConverter.toJsonsList(
                Arrays.asList(
                        new SomeObject("Object-1"),
                        new SomeObject("Object-2")
                ),
                objectToJsonFunction
        );

        Assertions.assertTrue(strings.contains("{\"objectName\":\"Object-1\"}"));
        Assertions.assertTrue(strings.contains("{\"objectName\":\"Object-2\"}"));
    }

    static class ListXmlConverter<T> {
        public List<String> toXmlList(@NonNull List<T> someObjects, ObjectToXmlFunction<T> objectToXmlFunction) throws JsonProcessingException {
            List<String> result = new ArrayList<>();
            if (someObjects.isEmpty())
                throw new IllegalArgumentException("The list is empty");

            for (T el: someObjects) {
                result.add(objectToXmlFunction.applyAsXml(el));
            }
            return result;
        }
    }

    @Test
    public void successCallFunctionalInterfaceXml() throws JsonProcessingException {
        ListXmlConverter<SomeObject> ListConverter = new ListXmlConverter<>();

        ObjectToXmlFunction<SomeObject> objectToXmlFunction = someObject ->
                new XmlMapper().writeValueAsString(someObject);

        List<String> strings = ListConverter.toXmlList(
                Arrays.asList(
                        new SomeObject("Object-1"),
                        new SomeObject("Object-2")
                ),
                objectToXmlFunction
        );

        Assertions.assertTrue(strings.contains("<SomeObject><objectName>Object-1</objectName></SomeObject>"));
        Assertions.assertTrue(strings.contains("<SomeObject><objectName>Object-2</objectName></SomeObject>"));
    }

}
