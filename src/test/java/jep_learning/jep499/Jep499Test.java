package jep_learning.jep499;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.function.Supplier;

import static jep_learning.util.LoggerUtil.log;

public class Jep499Test {

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
  void structured() throws InterruptedException {
    try (var scope = StructuredTaskScope.open()) {
      Supplier<String> user = scope.fork(Tasks::findUser);
      Supplier<Integer> order = scope.fork(Tasks::fetchOrder);
      scope.join();
      String result = user.get() + " " + order.get();
      log.info("Result: {}", result);
    }
  }

}
