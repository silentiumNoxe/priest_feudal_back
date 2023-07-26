package com.priestfeudal.libcommons.utils;

import org.slf4j.MDC;

import java.util.Optional;
import java.util.UUID;

public class RequestIdHolderImpl implements RequestIdHolder, RequestIdGenerator {

    @Override
    public Optional<UUID> get() {
        return Optional.ofNullable(MDC.get("request_id")).map(UUID::fromString);
    }

    @Override
    public void save(final UUID id) {
        MDC.remove("request_id");
        MDC.put("request_id", id.toString());
    }

    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}
