package com.github.syr0ws.minelocatorbar;

import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Manages the display of waypoints for players.
 */
public interface WaypointManager {

    /**
     * Shows a {@link Waypoint} to a {@link Player}.
     *
     * @param player   the player to show the waypoint to
     * @param waypoint the waypoint to show
     */
    void show(Player player, Waypoint waypoint);

    /**
     * Hides a waypoint from a {@link Player}.
     *
     * @param player     the player to hide the waypoint from
     * @param waypointId the ID of the waypoint to hide
     */
    void hide(Player player, UUID waypointId);
}
