package io.github.bananapuncher714.ocelot.api;

import java.util.List;
import java.util.Set;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Interface for an entity tracker. Ability to set the {@link VisibilityController}.
 * 
 * @author BananaPuncher714
 */
public interface OcelotTracker {
	/**
	 * Get the entity associated with this tracker.
	 * 
	 * @return
	 * The Bukkit entity, may be a player.
	 */
	Entity getEntity();
	
	/**
	 * The distance for how far away the entity is visible.
	 * 
	 * @return
	 * Returns the NMS value, may be vanilla or from the spigot config.
	 */
	int getTrackingDistance();
	
	/**
	 * Not sure what this is, most likely a rough tracking distance.
	 * 
	 * @return
	 * Amount in chunks.
	 */
	int getChunkRange();
	
	/**
	 * Not sure what this is for.
	 * 
	 * @return
	 * The NMS boolean for "delta tracking".
	 */
	boolean isDeltaTracking();
	
	/**
	 * Get a set of all players who can see the entity associated with this tracker.
	 * 
	 * @return
	 * A new set containing all players. Modifications to this set do not affect the real collection.
	 */
	Set< Player > getPlayers();
	
	/**
	 * Same thing as calling {@link OcelotTracker#update( Player )}.
	 * 
	 * @param player
	 * The player to update visibility for.
	 */
	void track( Player player );
	
	/**
	 * Same thing as calling {@link OcelotTracker#track( Player )} on all the players in the list.
	 * 
	 * @param players
	 * The list of players who need to update visiblity for.
	 */
	void trackPlayers( List< Player > players );
	
	/**
	 * Update the visibility of the player provided.
	 * 
	 * @param player
	 * Will either grant or remove visibility of the entity based on the VisibilityController.
	 */
	void update( Player player );
	
	/**
	 * Same thing as calling {@link OcelotTracker#update( Player )} on every player who can see the entity associated with this tracker.
	 */
	void update();
	
	/**
	 * Remove visibility of the entity associated with this tracker for the player provided.
	 * 
	 * @param player
	 * The player to remove visibility of.
	 */
	void untrack( Player player );
	
	/**
	 * Set the current {@link VisibilityController} for this tracker.
	 * 
	 * @param controller
	 * Can be null to remove current {@link VisibilityController}.
	 */
	void setVisibilityController( VisibilityController controller );
	
	/**
	 * Get the current {@link VisibilityController} associated with this tracker.
	 * 
	 * @return
	 * The current {@link VisibilityController}, may be null.
	 */
	VisibilityController getVisiblityController();
}