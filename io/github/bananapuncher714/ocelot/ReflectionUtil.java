package io.github.bananapuncher714.ocelot;

import org.bukkit.Bukkit;

import io.github.bananapuncher714.ocelot.api.NMSHandler;

/**
 * Internal use only
 * 
 * @author BananaPuncher714
 */
public final class ReflectionUtil {
	public static final String VERSION;
	
	static {
		VERSION = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
	}

	private ReflectionUtil() {
	}
	
	protected static NMSHandler getNMSHandler() {
		try {
			Class< ? > clazz = Class.forName( "io.github.bananapuncher714.ocelot.implementation." + VERSION + ".NMSHandler" );
			return ( NMSHandler ) clazz.newInstance();
		} catch ( ClassNotFoundException | InstantiationException | IllegalAccessException e ) {
			e.printStackTrace();
			return null;
		}
	}
}
