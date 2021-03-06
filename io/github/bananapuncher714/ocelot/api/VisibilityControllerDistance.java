package io.github.bananapuncher714.ocelot.api;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Example {@link VisibilityController}.
 * 
 * @author BananaPuncher714
 */
public class VisibilityControllerDistance implements VisibilityController {
	protected double distance;
	protected double distanceSquared;
	
	/**
	 * @param distance
	 * Distance in blocks for how far away an entity is visible.
	 */
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
