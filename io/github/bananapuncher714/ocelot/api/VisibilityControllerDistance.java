package io.github.bananapuncher714.ocelot.api;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

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
