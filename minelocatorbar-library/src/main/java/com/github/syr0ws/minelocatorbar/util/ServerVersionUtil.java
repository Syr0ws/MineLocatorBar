package com.github.syr0ws.minelocatorbar.util;

import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerVersionUtil {

    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\d\\.\\d+\\.\\d+)");

    public static String getCurrentMinecraftVersion() throws ServerVersionNotFoundException {

        // Bukkit version should always contain the Minecraft version.
        String bukkitVersion = Bukkit.getVersion();
        Matcher matcher = VERSION_PATTERN.matcher(bukkitVersion);

        if(!matcher.find()) {
            throw new ServerVersionNotFoundException("Cannot parse server version from '%s'".formatted(bukkitVersion));
        }

        return matcher.group(1);
    }

    public static String getCurrentNMSVersion() throws ServerVersionNotFoundException {

        String minecraftVersion = getCurrentMinecraftVersion();

        ServerVersion serverVersion = ServerVersion.getServerVersion(minecraftVersion)
                .orElseThrow(() -> new ServerVersionNotFoundException("Unsupported Minecraft version '%s'".formatted(minecraftVersion)));

        return serverVersion.getNmsVersion();
    }
}
