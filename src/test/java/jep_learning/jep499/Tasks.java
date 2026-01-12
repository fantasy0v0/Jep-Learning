package jep_learning.jep499;

import java.security.SecureRandom;
import java.util.Random;

import static jep_learning.util.LoggerUtil.log;

public class Tasks {

  private static final Random rnd = new SecureRandom();

  public static String findUser() {
    try {
      Thread.sleep(rnd.nextInt(5000) + 500);
      log.info("findUser end");
      return "User";
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static Integer fetchOrder() {
    try {
      Thread.sleep(rnd.nextInt(3000) + 500);
      log.info("fetchOrder end");
      return rnd.nextInt(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
