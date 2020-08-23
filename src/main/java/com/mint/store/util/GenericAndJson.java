package com.mint.store.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mint.store.exception.http.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MintsBerry
 * @date 2020/8/23
 */
@Component
public class GenericAndJson {
  private static ObjectMapper objectMapper;

  @Autowired
  public void setObjectMapper(ObjectMapper objectMapper) {
    GenericAndJson.objectMapper = objectMapper;
  }

  public static String objectToJson(Object o) {
    if (o == null) {
      return null;
    }
    try {
      return GenericAndJson.objectMapper.writeValueAsString(o);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new ServerException();
    }
  }

//  public List<T> jsonToList(String json) {
//    if (json == null) {
//      return null;
//    }
//    try {
//      List<T> o = objectMapper.readValue(json, new TypeReference<List<T>>() {
//      });
//      return o;
//    } catch (JsonProcessingException e) {
//      e.printStackTrace();
//      throw new ServerException();
//    }
//  }


  public static <T> T jsonToObject(String json, TypeReference<T> tr) {
    if (json == null) {
      return null;
    }
    try {
      T o = GenericAndJson.objectMapper.readValue(json, tr);
      return o;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new ServerException();
    }
  }
}
