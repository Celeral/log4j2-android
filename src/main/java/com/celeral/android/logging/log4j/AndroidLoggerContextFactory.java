/* Copyright © 2020 Celeral. */
package com.celeral.android.logging.log4j;

import java.net.URI;

import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.LoggerContextFactory;

public class AndroidLoggerContextFactory implements LoggerContextFactory {
  private static LoggerContext context = new AndroidLoggerContext();

  @Override
  public LoggerContext getContext(
      String fqcn, ClassLoader loader, Object externalContext, boolean currentContext) {
    return context;
  }

  @Override
  public LoggerContext getContext(
      String fqcn,
      ClassLoader loader,
      Object externalContext,
      boolean currentContext,
      URI configLocation,
      String name) {
    return context;
  }

  @Override
  public void removeContext(LoggerContext context) {
    /* there is nothing for us to remove! */
  }
}
