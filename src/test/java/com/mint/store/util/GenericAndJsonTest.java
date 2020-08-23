package com.mint.store.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mint.store.MintStoreApplicationTests;
import com.mint.store.model.Spec;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author MintsBerry
 * @date 2020/8/23
 */
class GenericAndJsonTest extends MintStoreApplicationTests {

  @Test
  void objectToJson() {
    HashMap hashMap = new HashMap();
    hashMap.put("1", "2");
    List<Spec> specs = GenericAndJson.jsonToObject("[{\"key\": \"颜色\", \"value\": \"青蓝色\", \"key_id\": 1, \"value_id\": 1}, {\"key\": \"尺寸\", \"value\": \"7英寸\", \"key_id\": 2, \"value_id\": 5}]",
            new TypeReference<List<Spec>>() {
            });

    System.out.println(specs);
  }

  @Test
  void jsonToList() {
  }
}