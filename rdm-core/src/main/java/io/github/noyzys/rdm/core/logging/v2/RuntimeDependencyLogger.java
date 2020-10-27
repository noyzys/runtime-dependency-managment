package io.github.noyzys.rdm.core.logging.v2;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: NoyZys on 18:08, 27.10.2020
 **/
public final class RuntimeDependencyLogger implements LogAdapter {

    private final Logger logger;

    public RuntimeDependencyLogger(final Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(final LogLevel level, final @NotNull String message) {
        switch (level) {
            case DEBUG:
                logger.log(Level.FINE, message);
                break;
            case INFO:
                logger.log(Level.INFO, message);
                break;
            case WARN:
                logger.log(Level.WARNING, message);
                break;
            case ERROR:
                logger.log(Level.SEVERE, message);
                break;
        }
    }

    @Override
    public void log(final LogLevel level, final @NotNull String message, final Throwable throwable) {
        switch (level) {
            case DEBUG:
                logger.log(Level.FINE, message, throwable);
                break;
            case INFO:
                logger.log(Level.INFO, message, throwable);
                break;
            case WARN:
                logger.log(Level.WARNING, message, throwable);
                break;
            case ERROR:
                logger.log(Level.SEVERE, message, throwable);
                break;
        }
    }
}
