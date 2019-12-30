package io.github.bananapuncher714.ocelot.api;

import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

/**
 * Internal interface for getting version specific tracker.
 * 
 * @author BananaPuncher714
 */
public interface NMSHandler {
	/**
	 * Initialize with a plugin. Accepts only one plugin once for scheduling a runnable.
	 * 
	 * @param plugin
	 * Any plugin instance.
	 */
	void init( Plugin plugin );

	/**
	 * Get the OcelotTracker responsible for this entity.
	 * 
	 * @param entity
	 * Any Bukkit entity.
	 * @return
	 * The server version specific implementation of OcelotTracker.
	 */
	OcelotTracker getEntityTrackerFor( Entity entity );
}
