package io.github.noyzys.rdm.core;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.Collection;

/**
 * @author: NoyZys on 17:01, 27.10.2020
 **/
public interface RuntimeDependencyRepositoryInfo {

    @NotNull
    Collection<String> getRepositories();
    @NotNull
    Collection<String> resolveLibrary();

    @NotNull
    byte[] downloadLibrary(final String urlRepository);

    @NotNull
    Path downloadLibrary(final RuntimeDependency runtimeDependency);

    void addRepository(@NotNull final String urlRepository);
    void addMavenLocal();
    void addMavenCentral();
    void addSonatype();
    void addJCenter();
    void addJitPack();
}
