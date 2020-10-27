package io.github.noyzys.rdm.core.logging;

import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys on 17:58, 27.10.2020
 **/
@FunctionalInterface
public interface LoggerHolder {
    
    @NotNull
    Logger getLogger();
}
