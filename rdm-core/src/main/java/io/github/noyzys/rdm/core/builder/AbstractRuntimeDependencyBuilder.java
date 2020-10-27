package io.github.noyzys.rdm.core.builder;

import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys on 19:12, 27.10.2020
 **/
abstract class AbstractRuntimeDependencyBuilder<T extends AbstractRuntimeDependencyBuilder<T>> {

    abstract T context();

    public T uri(@NotNull final String url) {
        return this.context();
    }
}
