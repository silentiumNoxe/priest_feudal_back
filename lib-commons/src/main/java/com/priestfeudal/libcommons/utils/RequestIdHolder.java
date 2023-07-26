package com.priestfeudal.libcommons.utils;

import java.util.Optional;
import java.util.UUID;

public interface RequestIdHolder {

    Optional<UUID> get();

    default UUID mustGet() {
        return get().orElseThrow(RuntimeException::new);
    }

    void save(UUID id);
}
