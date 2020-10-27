package io.github.noyzys.rdm.core.logging;

import io.github.noyzys.rdm.core.logging.system.LoggerChannel;
import io.github.noyzys.rdm.core.logging.system.LoggerConstants;
import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys on 17:55, 27.10.2020
 **/
public interface Logger {

    void log(@NotNull final LoggerChannel channel, @NotNull final String message);

    default void fatal(@NotNull final String message) {
        log(LoggerConstants.FATAL, message);
    }

    default void error(@NotNull final String message) {
        log(LoggerConstants.ERROR, message);
    }

    default void warn(@NotNull final String message) {
        log(LoggerConstants.WARN, message);
    }

    default void info(@NotNull final String message) {
        log(LoggerConstants.INFO, message);
    }
}
