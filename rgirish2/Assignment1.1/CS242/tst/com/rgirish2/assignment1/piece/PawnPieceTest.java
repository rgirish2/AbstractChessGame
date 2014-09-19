package com.rgirish2.assignment1.piece;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.board.EightByEightBoard;
import com.rgirish2.assignment1.player.AbstractPlayer;
import com.rgirish2.assignment1.player.NormalChessPlayer;

public class PawnPieceTest {
	
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
	public void validMovesTest() {
		assert (this.chessBoard.moveTile(3, 1, 3, 3)) == true;
		assert (this.chessBoard.moveTile(6, 1, 6, 3)) == true;
		assert (this.chessBoard.moveTile(5, 6, 5, 4)) == true;
		assert (this.chessBoard.moveTile(7, 6, 7, 5)) == true;
		assert (this.chessBoard.moveTile(4, 1, 4, 3)) == true;
		assert (this.chessBoard.moveTile(5, 4, 4, 3)) == true;
		assert (this.chessBoard.moveTile(7, 5, 7, 4)) == true;
		assert (this.chessBoard.moveTile(6, 3, 7, 4)) == true; 
	}
	
	@Test
	public void inValidMovesTest() {
		assert (this.chessBoard.moveTile(3, 1, 100, 100)) == false;
		assert (this.chessBoard.moveTile(6, 1, Integer.MAX_VALUE, Integer.MIN_VALUE)) == false;
		assert (this.chessBoard.moveTile(5, 6, 5, 6)) == false;
		assert (this.chessBoard.moveTile(7, 6, 7, 7)) == false;
		assert (this.chessBoard.moveTile(4, 1, 4, 0)) == false;
		assert (this.chessBoard.moveTile(5, 4, 4, 4)) == false;
		assert (this.chessBoard.moveTile(7, 5, 6, 5)) == false;
		assert (this.chessBoard.moveTile(6, 3, 4, 4)) == false; 
	}
}
