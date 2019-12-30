package io.github.bananapuncher714.ocelot;

import org.apache.commons.lang.Validate;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.bananapuncher714.ocelot.api.NMSHandler;
import io.github.bananapuncher714.ocelot.api.OcelotTracker;

public class Ocelot extends JavaPlugin {
	private static Ocelot MAIN;
	
	private NMSHandler handler;
	
	@Override
	public void onEnable() {
		MAIN = this;
		
		handler = ReflectionUtil.getNMSHandler();
		
		getLogger().info( "Detected version " + ReflectionUtil.VERSION );
	}
	
	public OcelotTracker getTrackerFor( Entity entity ) {
		Validate.notNull( entity );
		
		return handler.getEntityTrackerFor( entity );
	}
	
	public Ocelot getInstance() {
		return MAIN;
	}
}
