package com.theiconic.spockexamples.shop.entities;

import java.util.HashMap;

public class ProductAttributes {

  private HashMap<String, String> attributes = new HashMap<>();

  public ProductAttributes() {

  }

  public void setAttribute(String key, String value) {

    attributes.put(key, value);
  }

  public String getAttribute(String key) {
    return attributes.get(key);
  }
}

