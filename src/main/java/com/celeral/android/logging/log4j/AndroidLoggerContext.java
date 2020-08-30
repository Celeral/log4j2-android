/*
 * Copyright © 2020 Celeral.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
