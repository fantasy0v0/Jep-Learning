package jep_learning;

import org.junit.jupiter.api.Test;

import static jep_learning.util.LoggerUtil.log;

public class JepTest {

  @Test
  void test() {
    log.info("java version: {}", System.getProperty("java.version"));
  }

}
