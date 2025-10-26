package com.github.syr0ws.minelocatorbar.util;

import java.util.Arrays;
import java.util.Optional;

public enum ServerVersion {

    v1_21_6("1_21_R5"),
    v1_21_7("1_21_R5"),
    v1_21_8("1_21_R5"),
    v1_21_9("1_21_R6"),
    v1_21_10("1_21_R6");

    private final String minecraftVersion;
    private final String nmsVersion;

    ServerVersion(String nmsVersion) {
        this.minecraftVersion = this.name().substring(1).replace("_", ".");
        this.nmsVersion = nmsVersion;
    }

    private String getMinecraftVersion() {
        return this.minecraftVersion;
    }

    public String getNmsVersion() {
        return nmsVersion;
    }

    public static Optional<ServerVersion> getServerVersion(String minecraftVersion) {

        if(minecraftVersion == null) {
            throw new IllegalArgumentException("minecraftVersion cannot be null");
        }

        return Arrays.stream(values())
                .filter(version -> version.getMinecraftVersion().equals(minecraftVersion))
                .findFirst();
    }
}
