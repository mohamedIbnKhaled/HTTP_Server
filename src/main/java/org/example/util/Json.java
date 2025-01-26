package org.example.util;


import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class Json {
    private static ObjectMapper myObjectMapper= defaultObjectmapper();
    private static ObjectMapper defaultObjectmapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return objectMapper;
    }
    public static JsonNode parse(String jsonSrc) throws IOException {
        return myObjectMapper.readTree(jsonSrc);
    }

    public static <T> T fromJson(JsonNode node , Class<T> tClass) throws IOException{
        //set the values of json node into the class property
        //from json value to java object
        return myObjectMapper.treeToValue(node,tClass);
    }

    public static JsonNode toJson (Object obj ){
        //from java object to json tree
        return myObjectMapper.valueToTree(obj);
    }
    public static String stringify(JsonNode node) throws IOException{
        return generateJson(node,false);
        //example
        // {"name":"John","age":30}
    }
    public static String stringifyPretty(JsonNode node) throws IOException{
        return generateJson(node,true);
        //example
        // {
        //   "name": "John",
        //   "age": 30
       // }
    }

    private static String generateJson(Object object, boolean pretty) throws IOException{
        ObjectWriter writer =  myObjectMapper.writer();
        if (pretty){
            writer = writer.with(SerializationFeature.INDENT_OUTPUT);
        }
        return writer.writeValueAsString(object);
    }



}
