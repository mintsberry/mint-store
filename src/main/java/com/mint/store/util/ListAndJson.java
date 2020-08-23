package com.mint.store.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mint.store.exception.http.ServerException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/23
 */
public class ListAndJson implements AttributeConverter<List<Object>, String> {
  @Autowired
  private ObjectMapper objectMapper;


  @Override
  public String convertToDatabaseColumn(List<Object> objects) {
    try {
      return objectMapper.writeValueAsString(objects);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new ServerException();
    }
  }

  @Override
  public List<Object> convertToEntityAttribute(String s) {
    try {
      if (s == null) {
        return null;
      }
      return objectMapper.readValue(s,List.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      throw new ServerException();
    }
  }
}
