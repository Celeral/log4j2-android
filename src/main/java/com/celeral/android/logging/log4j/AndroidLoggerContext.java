/* Copyright © 2020 Celeral. */
package com.celeral.android.logging.log4j;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.LoggerRegistry;

public class AndroidLoggerContext implements LoggerContext {
  private final LoggerRegistry<ExtendedLogger> loggerRegistry = new LoggerRegistry<>();

  @Override
  public Object getExternalContext() {
    return null;
  }

  @Override
  public ExtendedLogger getLogger(String name) {
    return getLogger(name, null);
  }

  @Override
  public ExtendedLogger getLogger(String name, MessageFactory messageFactory) {
    final ExtendedLogger extendedLogger = loggerRegistry.getLogger(name, messageFactory);
    if (extendedLogger != null) {
      AbstractLogger.checkMessageFactory(extendedLogger, messageFactory);
      return extendedLogger;
    }

    final AndroidLogger logger = new AndroidLogger(name, Level.ALL, messageFactory);

    loggerRegistry.putIfAbsent(name, messageFactory, logger);
    return loggerRegistry.getLogger(name, messageFactory);
  }

  @Override
  public boolean hasLogger(String name) {
    return false;
  }

  @Override
  public boolean hasLogger(String name, MessageFactory messageFactory) {
    return false;
  }

  @Override
  public boolean hasLogger(String name, Class<? extends MessageFactory> messageFactoryClass) {
    return false;
  }
}
