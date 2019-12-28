package io.github.bananapuncher714.ocelot.implementation.v1_15_R1;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftEntity;
import org.bukkit.plugin.Plugin;

import net.minecraft.server.v1_15_R1.Entity;
import net.minecraft.server.v1_15_R1.PlayerChunkMap;
import net.minecraft.server.v1_15_R1.PlayerChunkMap.EntityTracker;
import net.minecraft.server.v1_15_R1.WorldServer;

public class NMSHandler implements io.github.bananapuncher714.ocelot.api.NMSHandler {
	private static Field ENTITYTRACKER_ENTITY;
	
	private boolean init = false;
	
	static {
		try {
			ENTITYTRACKER_ENTITY = EntityTracker.class.getDeclaredField( "tracker" );
			ENTITYTRACKER_ENTITY.setAccessible( true );
		} catch ( Exception exception ) {
			exception.printStackTrace();
		}
	}
	
	protected NMSHandler() {
	}
	
	@Override
	public void init( Plugin plugin ) {
		if ( init ) {
			return;
		}
		
		Bukkit.getScheduler().runTaskTimer( plugin, this::tick, 0, 1 );
		
		init = true;
	}
	
	protected void tick() {
		replaceEntityTrackers();
	}
	
	@Override
	public CustomEntityTracker getEntityTrackerFor( org.bukkit.entity.Entity bukkitEntity ) {
		Entity entity = ( ( CraftEntity ) bukkitEntity ).getHandle();
		
		PlayerChunkMap tracker = ( ( WorldServer ) entity.getWorld() ).getChunkProvider().playerChunkMap;
		
		EntityTracker entry = tracker.trackedEntities.get( entity.getId() );
		
		CustomEntityTracker customTracker;
		if ( !( entry instanceof CustomEntityTracker ) ) {
			customTracker = new CustomEntityTracker( tracker, entity, entity.getEntityType().getChunkRange() * 16, entity.getEntityType().getUpdateInterval(), entity.getEntityType().isDeltaTracking() );
			
			customTracker.trackedPlayers.addAll( entry.trackedPlayers );
			
			tracker.trackedEntities.put( entity.getId(), customTracker );
		} else {
			customTracker = ( CustomEntityTracker ) entry;
		}
		
		return customTracker;
	}
	
	private void replaceEntityTrackers() {
		for ( World world : Bukkit.getWorlds() ) {
			PlayerChunkMap tracker = ( ( WorldServer ) ( ( CraftWorld ) world ).getHandle() ).getChunkProvider().playerChunkMap;
			
			Set< EntityTracker > previous = new HashSet< EntityTracker >( tracker.trackedEntities.values() );
			for ( EntityTracker tracked : previous ) {
				if ( !( tracked instanceof CustomEntityTracker ) ) {
					Entity entity;
					
					try {
						entity = ( Entity ) ENTITYTRACKER_ENTITY.get( tracked );
					} catch ( Exception exception ) {
						exception.printStackTrace();
						continue;
					}
					CustomEntityTracker customTracker = new CustomEntityTracker( tracker, entity, entity.getEntityType().getChunkRange() * 16, entity.getEntityType().getUpdateInterval(), entity.getEntityType().isDeltaTracking() );
					
					customTracker.trackedPlayers.addAll( tracked.trackedPlayers );
					
					tracker.trackedEntities.put( entity.getId(), customTracker );
				}
			}
		}
	}
}
