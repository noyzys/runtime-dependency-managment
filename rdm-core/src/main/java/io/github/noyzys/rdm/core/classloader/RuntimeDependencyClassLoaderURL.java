package io.github.noyzys.rdm.core.classloader;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

/**
 * @author: NoyZys on 18:28, 27.10.2020
 **/
public final class RuntimeDependencyClassLoaderURL extends URLClassLoader implements RuntimeDependencyClassLoaderClasspath.RuntimeDependencyClassLoaderPath {

    public RuntimeDependencyClassLoaderURL(final URL... urls) {
        super(urls, ClassLoader.getSystemClassLoader().getParent());
    }

    @Override
    public void addURL(final @NotNull URL url) {
        super.addURL(url);
    }

    @Override
    public void addPath(final @NotNull Path path) {
        try {
            addURL(path.toUri().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}