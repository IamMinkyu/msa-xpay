package com.xpay.common;

//@Aspect
//@Component
//public class LoggingAspect {
//  private final LoggingProducer loggingProducer;
//
//  public LoggingAspect(LoggingProducer loggingProducer) {
//    this.loggingProducer = loggingProducer;
//  }
//  @Before("execution(* com.xpay.*.adapter.in.web.*.*(..))")
//  public void beforeMethodExecution(JoinPoint joinPoint) {
//    String methodName = joinPoint.getSignature().getName();
//    loggingProducer.sendMessage("Logging", "Before execution method: " + methodName);
//    // Produce Access Log
//  }
//}
