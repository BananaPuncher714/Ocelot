package io.github.bananapuncher714.ocelot.api;

import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

public interface NMSHandler {
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
