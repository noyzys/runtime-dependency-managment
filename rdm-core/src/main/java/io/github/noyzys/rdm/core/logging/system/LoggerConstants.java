package io.github.noyzys.rdm.core.logging.system;

import io.github.noyzys.rdm.core.collection.Lists;
import org.jetbrains.annotations.Contract;

/**
 * @author: NoyZys on 17:27, 27.10.2020
 **/
public final class LoggerConstants {

    public static final LoggerChannel FATAL = Lists.add(LoggerChannel.VALUES_CHANNELS, new LoggerChannel("fatal", 6.0));
    public static final LoggerChannel ERROR = Lists.add(LoggerChannel.VALUES_CHANNELS, new LoggerChannel("error", 5.0));
    public static final LoggerChannel WARN = Lists.add(LoggerChannel.VALUES_CHANNELS, new LoggerChannel("warn", 4.0));
    public static final LoggerChannel INFO = Lists.add(LoggerChannel.VALUES_CHANNELS, new LoggerChannel("info", 3.0));

    @Contract(pure = true)
    public LoggerConstants() {
    }
}
