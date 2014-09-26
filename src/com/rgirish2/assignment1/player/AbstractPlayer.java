package com.rgirish2.assignment1.player;

import com.rgirish2.assignment1.piece.AbstractPieceSet;
import com.rgirish2.assignment1.piece.NormalPlayerOrdinal;

/**
 * A super class for a chess player. Represents all the information
 * that is common across all kinds of chess player.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public abstract class AbstractPlayer {
	protected String playerName;
	protected NormalPlayerOrdinal ordinal;
	protected AbstractPieceSet pieceSet;
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Represents the ordinal of the chess players.
	 * This is unique across all the players for a chess game.
	 * In case of 2 player game, we have this as ONE and TWO.
	 * @return the ordinal for the player.
	 */
	public int getOrdinal() {
		return NormalPlayerOrdinal.getOrdinal(ordinal);
	}
	
	public void setOrdinal(NormalPlayerOrdinal ordinal) {
		this.ordinal = ordinal;
	}
	
	public AbstractPieceSet getPieceSet() {
		return pieceSet;
	}
	
	public void setPieceSet(AbstractPieceSet pieceSet) {
		this.pieceSet = pieceSet;
	}
}
