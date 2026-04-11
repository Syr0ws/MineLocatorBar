package com.github.syr0ws.minelocatorbar;
import com.github.syr0ws.crafter.version.NMSVersion;
import com.github.syr0ws.crafter.version.ServerVersionNotFoundException;
import com.github.syr0ws.crafter.version.ServerVersionUtil;
import com.github.syr0ws.minelocatorbar.version.WaypointManager_v1_21_R5;
import com.github.syr0ws.minelocatorbar.version.WaypointManager_v1_21_R6;
import com.github.syr0ws.minelocatorbar.version.WaypointManager_v1_21_R7;
import com.github.syr0ws.minelocatorbar.version.WaypointManager_v26_1;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Main utility class for the MineLocatorBar library.
 */
public class MineLocatorBar {

    /**
     * Map of NMS versions associated with their corresponding WaypointManager implementation.
     */
    // Intentionally using lambda instead of ::new to avoid early class loading and classes of other versions
    // to be imported.
    private static final Map<NMSVersion, Supplier<WaypointManager>> WAYPOINT_MANAGERS = Map.of(
            NMSVersion.v1_21_R5, () -> new WaypointManager_v1_21_R5(),
            NMSVersion.v1_21_R6, () -> new WaypointManager_v1_21_R6(),
            NMSVersion.v1_21_R7, () -> new WaypointManager_v1_21_R7(),
            NMSVersion.v26_1, () -> new WaypointManager_v26_1()
    );

    /**
     * Get a {@link WaypointManager} for the current server version.
     *
     * @return an instance of {@link WaypointManager}
     * @throws WaypointManagerException if the server version cannot be retrieved, if no manager is found for the
     *                                  current server version
     */
    public static WaypointManager getWaypointManager() {

        NMSVersion version;

        try {
            version = ServerVersionUtil.getCurrentNMSVersion();
        } catch (ServerVersionNotFoundException exception) {
            throw new WaypointManagerException("An error occurred while retrieving the NMS server version", exception);
        }

        if (!WAYPOINT_MANAGERS.containsKey(version)) {
            throw new WaypointManagerException("No WaypointManager found for the current NMS version: %s".formatted(version));
        }

        return WAYPOINT_MANAGERS.get(version).get();
    }
}
