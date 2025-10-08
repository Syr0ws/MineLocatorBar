package com.github.syr0ws.minelocatorbar;

import java.util.Optional;

/**
 * Represents an icon for a waypoint.
 */
public class WaypointIcon {

    private String style;
    private int color = 0xFFFFFF;

    /**
     * Constructs a {@link WaypointIcon} with the specified style and color.
     *
     * @param style the style to set
     * @param color the color to set
     */
    public WaypointIcon(String style, int color) {
        this.setStyle(style);
        this.setColor(color);
    }

    /**
     * Returns the style of this icon.
     *
     * @return an {@link Optional} containing the style, or empty if not set
     */
    public Optional<String> getStyle() {
        return Optional.ofNullable(this.style);
    }

    /**
     * Sets the style of this icon.
     *
     * @param style the style to set
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Returns the color of this icon.
     *
     * @return the color as an integer
     */
    public int getColor() {
        return color;
    }

    /**
     * Sets the color of this icon.
     *
     * @param color the color to set
     * @throws IllegalArgumentException if the color is not between {@code 0x000000} and {@code 0xFFFFFF}
     */
    public void setColor(int color) {
        if (color < 0x000000 || color > 0xFFFFFF) {
            throw new IllegalArgumentException("Color must be between 0x000000 and 0xFFFFFF");
        }
        this.color = color;
    }
}
