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

import android.util.Log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

public class AndroidLogger extends SimpleLogger {
  final String tag;

  public AndroidLogger(String name, Level defaultLevel, MessageFactory messageFactory) {
    super(
        name,
        defaultLevel,
        false,
        false,
        false,
        false,
        null,
        messageFactory,
        PropertiesUtil.getProperties(),
        null);

    if (name == null) {
      tag = null;
    } else {
      int lastIndex = name.lastIndexOf('.');
      tag = lastIndex == -1 ? name : name.substring(lastIndex + 1);
    }
  }

  @Override
  public void logMessage(
      String fqcn, Level mgsLevel, Marker marker, Message msg, Throwable throwable) {
    switch (mgsLevel.getStandardLevel()) {
      case ALL:
      case TRACE:
        Log.v(tag, msg.getFormattedMessage(), throwable);
        break;

      case DEBUG:
        Log.d(tag, msg.getFormattedMessage(), throwable);
        break;

      case INFO:
        Log.i(tag, msg.getFormattedMessage(), throwable);
        break;

      case WARN:
        Log.w(tag, msg.getFormattedMessage(), throwable);
        break;

      case ERROR:
        Log.e(tag, msg.getFormattedMessage(), throwable);
        break;

      case FATAL:
        Log.wtf(tag, msg.getFormattedMessage(), throwable);
        break;

      case OFF:
      default:
        break;
    }
  }
}
