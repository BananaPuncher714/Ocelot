package io.github.bananapuncher714.ocelot.api;

import java.util.List;
import java.util.Set;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface OcelotTracker {
	Entity getEntity();
	int getTrackingDistance();
	int getChunkRange();
	boolean isDeltaTracking();
	Set< Player > getPlayers();
	
	void track( Player player );
	void trackPlayers( List< Player > players );
	void update( Player player );
	void update();
	void untrack( Player player );
	
	void setVisibilityController( VisibilityController controller );
	VisibilityController getVisiblityController();
}