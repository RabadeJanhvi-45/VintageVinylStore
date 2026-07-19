package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ErrorContext implements Serializable {

  private static final long serialVersionUID = 1L;

  private Map<String, String> context = new HashMap<>();

  public void put(String key, String value) {

    context.put(key, value);

  }

  public String get(String key) {

    return context.get(key);

  }

  public Map<String, String> getContext() {

    return context;

  }

}