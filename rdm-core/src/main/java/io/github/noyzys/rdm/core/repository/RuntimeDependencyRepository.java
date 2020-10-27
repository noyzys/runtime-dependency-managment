package io.github.noyzys.rdm.core.repository;

import io.github.noyzys.rdm.core.RuntimeDependency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author: NoyZys on 18:35, 27.10.2020
 **/
public final class RuntimeDependencyRepository implements RuntimeDependency {

    private final Collection<String> urls;
    private final byte[] checksum;
    private final String groupId, artifactId, version, classifier;
    private String path;

    public RuntimeDependencyRepository(
            final Collection<String> urls,
            final byte[] checksum,
            final String groupId, final String artifactId, final String version,
            final String classifier
    ) {
        this.urls = urls != null ? Collections.unmodifiableList(new ArrayList<>(urls)) : Collections.emptyList();
        this.checksum = checksum;
        this.groupId = groupId.replace("{}", ".");
        this.artifactId = artifactId;
        this.version = version;
        this.classifier = classifier;

        path = this.groupId.replace('.', '/') + '/' + artifactId + '/' + version + '/' + artifactId + '-' + version;
        if (hasClassifier()) {
            path += '-' + classifier;
        }

        path = path + ".jar";
    }

    public Collection<String> getUrls() {
        return urls;
    }

    public byte[] getChecksum() {
        return checksum;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }

    public String getClassifier() {
        return classifier;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean hasClassifier() {
        return classifier != null;
    }

    @Override
    public boolean hasChecksum() {
        return checksum != null;
    }
}
