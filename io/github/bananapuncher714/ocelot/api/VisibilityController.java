package io.github.bananapuncher714.ocelot.api;

import org.bukkit.entity.Player;

public interface VisibilityController {
	BooleanResult isVisible( Player player, OcelotTracker tracker );
}
