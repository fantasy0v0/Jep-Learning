package jep_learning.jep264;

import jep_learning.jep259.Jep259Test;
import org.junit.jupiter.api.Test;

/**
 * @author fan 2025/3/19
 */
public class Jep264Test {

  @Test
  void test() {
    System.Logger logger = System.LoggerFinder.getLoggerFinder()
      .getLogger("Jep264Test", Jep264Test.class.getModule());
    logger.log(System.Logger.Level.INFO, "Hello, World!");
  }

}
