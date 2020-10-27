package io.github.noyzys.rdm.core.classloader;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

/**
 * @author: NoyZys on 17:07, 27.10.2020
 **/
public interface RuntimeDependencyClassLoaderClasspath {

    void addToClasspath(@NotNull final URL url);
    void addToClasspath(@NotNull final Path path);

    interface RuntimeDependencyClassLoaderPath {

        void addPath(@NotNull final Path path);
        void addURL(@NotNull final URL url);
    }
}
