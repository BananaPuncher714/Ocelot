package io.github.bananapuncher714.ocelot;

import org.apache.commons.lang.Validate;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.bananapuncher714.ocelot.api.NMSHandler;
import io.github.bananapuncher714.ocelot.api.OcelotTracker;

/**
 * Main Ocelot entry point.
 * 
 * @author BananaPuncher714
 */
public class Ocelot extends JavaPlugin {
	private static Ocelot MAIN;
	
	private NMSHandler handler;
	
	@Override
	public void onEnable() {
		MAIN = this;
		
		handler = ReflectionUtil.getNMSHandler();
		
		getLogger().info( "Detected version " + ReflectionUtil.VERSION );
	}
	
	/**
	 * Get the OcelotTracker responsible for this entity.
	 * 
	 * @param entity
	 * Any Bukkit entity
	 * @return
	 * The server version specific implementation of OcelotTracker.
	 */
	public OcelotTracker getTrackerFor( Entity entity ) {
		Validate.notNull( entity );
		
		return handler.getEntityTrackerFor( entity );
	}
	
	/**
	 * Singleton getter.
	 * 
	 * @return
	 * Get the Ocelot singleton.
	 */
	public Ocelot getInstance() {
		return MAIN;
	}
}
