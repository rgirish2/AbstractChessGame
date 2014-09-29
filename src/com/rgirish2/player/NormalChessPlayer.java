package com.rgirish2.player;

import com.rgirish2.assignment1.piece.NormalPieceSet;
import com.rgirish2.assignment1.piece.NormalPlayerOrdinal;

/**
 * Represents a normal chess player, i.e. a players in a two player game.
 * This abstraction would not be needed if we represent player ordinal as
 * an integer rather than as an ENUM. Would remove this moving forward.
 *  
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class NormalChessPlayer extends AbstractPlayer {
	
	public NormalChessPlayer (String playerName, int ordinal) {
		this.ordinal = ordinal == 1 ? NormalPlayerOrdinal.ONE : NormalPlayerOrdinal.TWO;
		this.playerName = playerName;
		this.pieceSet = new NormalPieceSet(this.ordinal, this.playerName);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player Ordinal: ");
		builder.append(this.ordinal);
		builder.append(System.getProperty("line.separator"));
		builder.append("Player Name: ");
		builder.append(this.playerName);
		builder.append(System.getProperty("line.separator"));
		builder.append(this.pieceSet.toString());
		return builder.toString();
	}
}
