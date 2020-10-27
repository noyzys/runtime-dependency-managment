package io.github.noyzys.rdm.core.builder;

import io.github.noyzys.rdm.core.RuntimeDependencyInfo;
import io.github.noyzys.rdm.core.repository.RuntimeDependencyRepository;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;

/**
 * @author: NoyZys on 18:50, 27.10.2020
 **/
public final class RuntimeDependencyBuilder implements RuntimeDependencyInfo<RuntimeDependencyBuilder> {

    private final Collection<String> urls = new ArrayList<>();
    private String groupId, artifactId, version, classifier;
    private byte[] checksum;

    public static RuntimeDependencyBuilder of() {
        return new RuntimeDependencyBuilder();
    }

    @Override
    public @NotNull RuntimeDependencyBuilder url(final String url) {
        urls.add(url);
        return this;
    }

    @Override
    public @NotNull RuntimeDependencyBuilder groupId(final String groupId) {
        this.groupId = groupId;
        return this;
    }

    @Override
    public @NotNull RuntimeDependencyBuilder artifactId(final String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    @Override
    public @NotNull RuntimeDependencyBuilder version(final String version) {
        this.version = version;
        return this;
    }

    @Override
    public @NotNull RuntimeDependencyBuilder classifier(final String classifier) {
        this.classifier = classifier;
        return this;
    }

    @Override
    public @NotNull RuntimeDependencyBuilder checksum(final byte[] bytes) {
        return checksum(Base64.getDecoder().decode(checksum));
    }

    public RuntimeDependencyRepository build() {
        return new RuntimeDependencyRepository(urls, checksum, groupId, artifactId, version, classifier);
    }
}
