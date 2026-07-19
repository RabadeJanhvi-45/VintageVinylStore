package registry;

import java.util.HashMap;
import java.util.Map;

public class ErrorRegistry {

  private static Map<String, Class<?>> registry = new HashMap<>();

  public static void register(
      String errorCode,
      Class<?> clazz) {

    registry.put(
        errorCode,
        clazz);

  }

  public static int size() {

    return registry.size();

  }

  public static boolean contains(String errorCode) {

    return registry.containsKey(errorCode);

  }
}