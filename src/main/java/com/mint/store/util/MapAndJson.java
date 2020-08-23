package com.mint.store.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mint.store.exception.http.ServerException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MintsBerry
 * @date 2020/8/23
 */
public class MapAndJson implements AttributeConverter<Map<String, Object>, String> {
  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public String convertToDatabaseColumn(Map hashMap) {
    try {
      return objectMapper.writeValueAsString(hashMap);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new ServerException();
    }
  }

  @Override
  public HashMap convertToEntityAttribute(String s) {
    try {
      return objectMapper.readValue(s, HashMap.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new ServerException();
    }
  }
}
