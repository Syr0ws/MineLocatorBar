![link](https://img.shields.io/badge/API-Spigot-blue) ![link](https://img.shields.io/badge/Version-1.21.6+-yellow)

# MineLocatorBar

A lightweight Spigot library for displaying static waypoints in the Minecraft locator bar.

## Compatibility

The library is currently compatible with the following Minecraft versions: `1.21.6`, `1.21.7`, `1.21.8`, `1.21.9`, `1.21.10`.

## Install

MineLocatorBar can be included in your project by using a dependency manager like **Maven** or **Gradle**.

**Maven**
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.Syr0ws</groupId>
    <artifactId>MineLocatorBar</artifactId>
    <version>{VERSION}</version>
    <scope>compile</scope>
</dependency>
```

**Gradle**
```groovy

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.Syr0ws:MineLocatorBar:{VERSION}'
}
```

Another option is to directly include the JAR file as a dependency of your plugin. This latest version of the JAR file 
can be downloaded on the [Releases page](https://github.com/Syr0ws/MineLocatorBar/releases).

## Usage

MineLocatorBar uses NMS to show and hide waypoints to players. The `WaypointManager` interface is responsible for hiding 
NMS implementation details and provides a simple API. An instance of this class compatible with your current server version 
can be retrieved with the following code:

```java
WaypointManager manager = MineLocatorBar.getWaypointManager();
```

This class provides the following methods :

```java
// Show a waypoint to a player.
void show(Player player, Waypoint waypoint);

// Hide a waypoint from a player.
void hide(Player player, UUID waypointId);
```

The `Waypoint` class represents a waypoint to be displayed in the locator bar. A waypoint must have a unique ID and a location
represented by a `WaypointLocation` class. Optionally, a style and an icon can be set using the `WaypointIcon` class.

```java
// Build the waypoint.
UUID waypointId = UUID.randomUUID();
WaypointLocation location = new WaypointLocation(0, 60, 0);
WaypointIcon icon = new WaypointIcon("minecraft:key", 0xFFFFFF);

Waypoint waypoint = new Waypoint(waypointId, location, icon);

// Show the waypoint to a player.
manager.show(player, waypoint);
```


