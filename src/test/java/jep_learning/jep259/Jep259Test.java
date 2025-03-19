package jep_learning.jep259;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static jep_learning.util.LoggerUtil.log;

/**
 * @author fan 2025/3/19
 */
public class Jep259Test {

  @Test
  void test() {
    // 获取调用者的类信息
    Class<?> caller = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass();
    log.debug("Caller: {}", caller);
    Runnable runnable = () -> {
      Class<?> caller2 = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass();
      log.debug("Caller2: {}", caller2);
    };
    runnable.run();
    // 遍历调用栈
    List<StackWalker.StackFrame> frames = StackWalker.getInstance().walk(Stream::toList);
    for (StackWalker.StackFrame frame : frames) {
      log.debug("Frame {}", frame);
    }
    // 排除当前方法，并且排除org.junit相关的方法
    List<StackWalker.StackFrame> frames2 = StackWalker.getInstance()
      .walk(s -> s
        .skip(1)
        .filter(f -> !f.getClassName().startsWith("org.junit"))
        .toList()
      );
    for (StackWalker.StackFrame frame : frames2) {
      log.debug("Frame2 {}", frame);
    }
  }
}
