package com.rgirish2.assignment1.piece;

/**
 * Ordinal values for players in this chess game. Presently only ONE and TWO.
 * Should be extended if we want to have more players possible.
 * We will have to extend the boardBuild method in case of more than 2 players, 
 * since piece placement would have to change.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public enum NormalPlayerOrdinal {
	ONE,
	TWO;
}
