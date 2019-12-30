package io.github.bananapuncher714.ocelot.api;

import org.bukkit.entity.Player;

/**
 * Used with {@link OcelotTracker} to determine whether a player can see an entity.
 * 
 * @author BananaPuncher714
 */
public interface VisibilityController {
	/**
	 * Controls whether a player can see an entity. This is called frequently, often whenever a player moves.
	 * 
	 * @param player
	 * The player who is viewing the entity.
	 * @param tracker
	 * The OcelotTracker for the entity who may or may not be visible.
	 * @return
	 * TRUE for yes, FALSE for no, and UNSET to use the NMS visibility.
	 */
	BooleanResult isVisible( Player player, OcelotTracker tracker );
}
