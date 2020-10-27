package io.github.noyzys.rdm.core.logging.v2;

import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys on 18:07, 27.10.2020
 **/
public interface LogAdapter {

    void log(final LogLevel level, @NotNull final String message);

    void log(final LogLevel level, @NotNull final String message, final Throwable throwable);
}
