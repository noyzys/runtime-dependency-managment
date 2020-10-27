package io.github.noyzys.rdm.core;

import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys on 16:43, 27.10.2020
 **/
public interface RuntimeDependency extends Cloneable {

    boolean hasClassifier();
    boolean hasChecksum();
}
