package io.github.noyzys.rdm.core.classloader;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

/**
 * @author: NoyZys on 18:11, 27.10.2020
 **/
public final class RuntimeDependencyClassLoader implements RuntimeDependencyClassLoaderClasspath {

    private final Method addURLMethod;

    public RuntimeDependencyClassLoader(final URLClassLoader classLoader) {

        try {
            addURLMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addURLMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addToClasspath(final @NotNull URL url) {
        try {
            addURLMethod.invoke(addURLMethod, url);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addToClasspath(final @NotNull Path path) {
        try {
            addToClasspath(path.toUri().toURL());
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
