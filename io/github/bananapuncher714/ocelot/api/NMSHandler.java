package io.github.bananapuncher714.ocelot.api;

import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

public interface NMSHandler {
	void init( Plugin plugin );
	OcelotTracker getEntityTrackerFor( Entity entity );
}
