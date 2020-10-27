package io.github.noyzys.rdm.core;

import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys on 16:55, 27.10.2020
 **/
public interface RuntimeDependencyInfo<T> {

    @NotNull
    T url(final String url);

    @NotNull
    T groupId(final String groupId);

    @NotNull
    T artifactId(final String artifactId);

    @NotNull
    T version(final String version);

    @NotNull
    T classifier(final String classifier);
    
    @NotNull
    T checksum(final byte[] bytes);
}
