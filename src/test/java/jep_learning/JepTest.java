package jep_learning;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static jep_learning.util.LoggerUtil.log;

public class JepTest {

  @Test
  void unstructured() throws ExecutionException, InterruptedException {
    try (ExecutorService es = Executors.newFixedThreadPool(8)) {
      Future<String> user = es.submit(Tasks::findUser);
      Future<Integer> order = es.submit(Tasks::fetchOrder);
      String theUser = user.get();
      Integer theOrder = order.get();
      log.info("User: {}, Order: {}", theUser, theOrder);
    }
  }

  @Test
  void structured() {
    // TODO
  }

}
