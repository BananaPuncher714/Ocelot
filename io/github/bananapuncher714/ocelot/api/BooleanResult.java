package io.github.bananapuncher714.ocelot.api;

public enum BooleanResult {
	TRUE, FALSE, UNSET;
	
	public boolean isTrue() {
		return this == TRUE;
	}
	
	public boolean isUnset() {
		return this == UNSET;
	}
}
