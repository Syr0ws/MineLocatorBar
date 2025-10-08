package com.github.syr0ws.minelocatorbar;

import org.bukkit.Bukkit;

/**
 * Main utility class for the MineLocatorBar library.
 */
public class MineLocatorBar {

    private static final String WAYPOINT_MANAGER_PACKAGE = "com.github.syr0ws.minelocatorbar.version";
    private static final String WAYPOINT_MANAGER_CLASS_NAME = "WaypointManager";

    /**
     * Get a {@link WaypointManager} for the current server version.
     *
     * @return an instance of {@link WaypointManager}
     * @throws WaypointManagerException if no manager is found for the current server version or if an error occurs
     *                                  while instantiating it
     */
    public static WaypointManager getWaypointManager() {

        String version = getServerVersion();

        try {
            Class<?> clazz = Class.forName("%s.%s_%s".formatted(WAYPOINT_MANAGER_PACKAGE, WAYPOINT_MANAGER_CLASS_NAME, version));

            if (!WaypointManager.class.isAssignableFrom(clazz)) {
                throw new IllegalStateException("Class '%s' does not implement WaypointManager".formatted(clazz.getName()));
            }

            return (WaypointManager) clazz.getConstructor().newInstance();

        } catch (ClassNotFoundException exception) {
            throw new WaypointManagerException("No WaypointManager found for version %s".formatted(version), exception);
        } catch (Exception exception) {
            throw new WaypointManagerException("An error occurred while instantiating a manager for version %s".formatted(version), exception);
        }
    }

    /**
     * Get the server version in the format used by CraftBukkit package names (example: v1_21_R5).
     *
     * @return the server version
     */
    private static String getServerVersion() {
        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        return packageName.substring(packageName.lastIndexOf('.') + 1);
    }
}
