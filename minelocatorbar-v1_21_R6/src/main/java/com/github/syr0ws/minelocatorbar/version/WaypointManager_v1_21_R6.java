package com.github.syr0ws.minelocatorbar.version;

import com.github.syr0ws.minelocatorbar.Waypoint;
import com.github.syr0ws.minelocatorbar.WaypointIcon;
import com.github.syr0ws.minelocatorbar.WaypointLocation;
import com.github.syr0ws.minelocatorbar.WaypointManager;
import net.minecraft.core.Vec3i;
import net.minecraft.network.protocol.game.ClientboundTrackedWaypointPacket;
import net.minecraft.world.waypoints.WaypointStyleAssets;
import org.bukkit.craftbukkit.v1_21_R6.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public class WaypointManager_v1_21_R6 implements WaypointManager {

    @Override
    public void show(Player player, Waypoint waypoint) {

        UUID waypointId = waypoint.getWaypointId();
        WaypointIcon icon = waypoint.getIcon();
        WaypointLocation location = waypoint.getLocation();

        net.minecraft.world.waypoints.Waypoint.Icon nmsIcon = new net.minecraft.world.waypoints.Waypoint.Icon();

        icon.getStyle().ifPresent(style -> nmsIcon.style = WaypointStyleAssets.createId(style));
        nmsIcon.color = Optional.of(icon.getColor());

        Vec3i vec3i = new Vec3i((int) location.x(), (int) location.y(), (int) location.z());

        ClientboundTrackedWaypointPacket packet = ClientboundTrackedWaypointPacket.addWaypointPosition(waypointId, nmsIcon, vec3i);

        ((CraftPlayer) player).getHandle().connection.send(packet);
    }

    @Override
    public void hide(Player player, UUID waypointId) {
        ClientboundTrackedWaypointPacket packet = ClientboundTrackedWaypointPacket.removeWaypoint(waypointId);
        ((CraftPlayer) player).getHandle().connection.send(packet);
    }
}
