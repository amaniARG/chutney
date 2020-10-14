package com.chutneytesting.design.domain.plugins.linkifier;

import java.util.List;

public interface Linkifiers {

    List<Linkifier> getAll();

    Linkifier add(Linkifier linkifier);

    Linkifier update(String id, Linkifier linkifier);

    void remove(String id);
}
