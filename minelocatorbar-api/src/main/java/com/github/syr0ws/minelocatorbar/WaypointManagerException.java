package com.github.syr0ws.minelocatorbar;

/**
 * Exception thrown when a waypoint manager operation fails.
 */
public class WaypointManagerException extends RuntimeException {

    /**
     * @see RuntimeException#RuntimeException(String)
     */
    public WaypointManagerException(String message) {
        super(message);
    }

    /**
     * @see RuntimeException#RuntimeException(String, Throwable)
     */
    public WaypointManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
