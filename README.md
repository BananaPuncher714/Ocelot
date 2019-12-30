# **Ocelot**
Allows developers to track entities much more easily, without having to rely on packets or NMS.

## Where to start
To get started, add `Ocelot` to  your plugin's dependencies. You can get the Ocelot instance like so:
```java
Ocelot ocelot = Ocelot.getInstance();
```
Once you have your Ocelot instance, you can get an `OcelotTracker` for an entity:
```java
Entity entity;
OcelotTracker entityTracker = ocelot.getTrackerFor( entity );
```
The `OcelotTracker` will show you which players can view the given player, and can let you set the `VisibilityController`, which will allow you to determine whether an entity is visible to a player.

## Custom VisibilityController
An example is provided below:
```java
public class VisibilityControllerDistance implements VisibilityController {
    protected double distance;
    protected double distanceSquared;

    public VisibilityControllerDistance( double distance ) {
        this.distance = distance;
        distanceSquared = distance * distance;
    }

    @Override
    public BooleanResult isVisible( Player player, OcelotTracker tracker ) {
        Entity entity = tracker.getEntity();
        if ( entity.getWorld() == player.getWorld() && entity.getLocation().distanceSquared( player.getLocation() ) <= distanceSquared ) {
            return BooleanResult.TRUE;
        }

        return BooleanResult.FALSE;
    }
}
```
Once you have a `VisibilityController` created, you can set it for any `OcelotTracker`:
```java
OcelotTracker entityTracker;
VisibilityController controller = new VisibilityControllerDistance( 10 ); // 10 block viewing range
entityTracker.setVisibilityController( controller );
```
Calling the `OcelotTracker#update()` method is recommended after setting the visibility controller. Note that the trackers do not persist over entity despawn and respawn.

## Spigot
Find the latest version on Spigot [here](https://www.spigotmc.org/resources/73853/).

## Supported Versions
Ocelot supports these versions:
- 1.14.4
- 1.15
- 1.15.1