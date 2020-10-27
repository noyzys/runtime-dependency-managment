package io.github.noyzys.rdm.core.logging.system;

import io.github.noyzys.rdm.core.logging.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys on 17:59, 27.10.2020
 **/
public final class LoggerProfiler implements Logger {

    private final LoggerChannel loggerChannel;

    public LoggerProfiler(final LoggerChannel loggerChannel) {
        this.loggerChannel = loggerChannel;
    }

    @Override
    public void log(final @NotNull LoggerChannel channel, final @NotNull String message) {
        if (channel.getPriority() >= loggerChannel.getPriority()) {
            // : (
        }
    }

    @Override
    public void error(final @NotNull String message) {

    }
}
