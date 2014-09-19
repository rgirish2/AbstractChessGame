package com.rgirish2.assignment1.movement;

/**
 * Enum representing all the possible movements in a 2 dimensional normal chess game.
 * Every piece movement can be broken down to these directions.
 * We can get rid of the bottom 4 enum values since, they can also be broken down into the top 4 values.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public enum MovementDirection {
	NORTH,
	SOUTH,
	WEST,
	EAST,
	NORTHEAST,
	NORTHWEST,
	SOUTHEAST,
	SOUTHWEST;
	
	@Override
	public String toString() {
		switch (this) {
			case NORTH :
				return "north";
			case SOUTH :
				return "south";
			case EAST :
				return "east";
			case WEST :
				return "west";
			case NORTHWEST :
				return "northWest";
			case NORTHEAST :
				return "northEast";
			case SOUTHWEST :
				return "southWest";
			case SOUTHEAST :
				return "southEast";
			default :
				return null;
		}
	}
}
