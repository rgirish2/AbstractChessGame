package com.rgirish2.piece;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.board.EightByEightBoard;
import com.rgirish2.assignment1.player.AbstractPlayer;
import com.rgirish2.assignment1.player.NormalChessPlayer;

public class KnightPieceTest {
	private AbstractTwoDimensionalBoard chessBoard;
	private List<AbstractPieceSet> allPieceSet;
	private AbstractPlayer [] players;
	private final int playerCount = 2;
	
	@Before
	public void init() {
		this.chessBoard = new EightByEightBoard();
		this.allPieceSet = new ArrayList<AbstractPieceSet>();
		this.players = new NormalChessPlayer[playerCount];
		
		for (int i = 0; i < playerCount; i++) {
			this.players[i] = new NormalChessPlayer("", i + 1);
			this.allPieceSet.add(players[i].getPieceSet());
		}
		this.chessBoard.buildBoard(this.allPieceSet);
	}
	
	@Test
	public void validMoveTest() {
		assert (this.chessBoard.moveTile(6, 0, 7, 2)) == true;
		assert (this.chessBoard.moveTile(7, 2, 5, 3)) == true;
		assert (this.chessBoard.moveTile(5, 3, 7, 4)) == true;
		assert (this.chessBoard.moveTile(7, 4, 5, 6)) == true;
		assert (this.chessBoard.moveTile(5, 6, 3, 7)) == true;
		assert (this.chessBoard.moveTile(3, 7, 1, 6)) == true;
		assert (this.chessBoard.moveTile(1, 6, 2, 4)) == true;
		assert (this.chessBoard.moveTile(2, 4, 3, 2)) == true;
		assert (this.chessBoard.moveTile(3, 2, 5, 3)) == true;
	}
	
	@Test
	public void inValidMoveTest() {
		assert (this.chessBoard.moveTile(6, 0, 0, 0)) == false;
		assert (this.chessBoard.moveTile(6, 0, Integer.MAX_VALUE, Integer.MIN_VALUE)) == false;
		assert (this.chessBoard.moveTile(6, 0, 8, 8)) == false;
		assert (this.chessBoard.moveTile(6, 0, 4, 7)) == false;
		assert (this.chessBoard.moveTile(6, 0, 3, 1)) == false;
		assert (this.chessBoard.moveTile(6, 0, 5, 1)) == false;
		assert (this.chessBoard.moveTile(6, 0, 5, 0)) == false;
		assert (this.chessBoard.moveTile(6, 0, 7, 2)) == false;
	}
}
