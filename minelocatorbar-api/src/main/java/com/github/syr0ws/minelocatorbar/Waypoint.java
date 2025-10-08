package com.github.syr0ws.minelocatorbar;

import java.util.UUID;

/**
 * Represents a waypoint with a unique identifier, location, and icon.
 */
public class Waypoint {

    private UUID waypointId;
    private WaypointLocation location;
    private WaypointIcon icon;

    /**
     * Constructs a new {@code Waypoint}.
     *
     * @param waypointId the unique identifier of the waypoint
     * @param location   the location of the waypoint
     * @throws IllegalArgumentException if any parameter is {@code null}
     */
    public Waypoint(UUID waypointId, WaypointLocation location) {
        this.waypointId = waypointId;
        this.location = location;
    }

    /**
     * Constructs a new {@code Waypoint}.
     *
     * @param waypointId the unique identifier of the waypoint
     * @param location   the location of the waypoint
     * @param icon       the icon representing the waypoint
     * @throws IllegalArgumentException if any parameter is {@code null}
     */
    public Waypoint(UUID waypointId, WaypointLocation location, WaypointIcon icon) {
        this(waypointId, location);
        this.setIcon(icon);
    }

    /**
     * Returns the unique identifier of the waypoint.
     *
     * @return the waypoint ID
     */
    public UUID getWaypointId() {
        return this.waypointId;
    }

    /**
     * Sets the unique identifier of the waypoint.
     *
     * @param waypointId the unique identifier of the waypoint
     * @throws IllegalArgumentException if {@code waypointId} is {@code null}
     */
    public void setWaypointId(UUID waypointId) {
        if (waypointId == null) {
            throw new IllegalArgumentException("waypointId cannot be null");
        }
        this.waypointId = waypointId;
    }

    /**
     * Returns the location of the waypoint.
     *
     * @return the waypoint location
     */
    public WaypointLocation getLocation() {
        return this.location;
    }

    /**
     * Sets the location of the waypoint.
     *
     * @param location the location of the waypoint
     * @throws IllegalArgumentException if {@code location} is {@code null}
     */
    public void setLocation(WaypointLocation location) {
        if (location == null) {
            throw new IllegalArgumentException("location cannot be null");
        }
        this.location = location;
    }

    /**
     * Returns the icon representing the waypoint.
     *
     * @return the waypoint icon
     */
    public WaypointIcon getIcon() {
        return this.icon;
    }

    /**
     * Sets the icon representing the waypoint.
     *
     * @param icon the icon representing the waypoint
     * @throws IllegalArgumentException if {@code icon} is {@code null}
     */
    public void setIcon(WaypointIcon icon) {
        if (icon == null) {
            throw new IllegalArgumentException("icon cannot be null");
        }
        this.icon = icon;
    }
}
