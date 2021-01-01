package br.com.fabricio.game.core;

import br.com.fabricio.game.board.Board;
import br.com.fabricio.game.counter.Counter;
import br.com.fabricio.game.counter.Counters;

/**
 * Classe que representa o jogo
 * @author Fabricio
 *
 */
public class Game {

	private static final int NUM_SPACES = 30;
	private static final int NUM_PLAYERS = 2;
	
	/**
	 * Inicia o jogo
	 */
	public void play() {
		Board board = new Board(NUM_SPACES + 2); 
		
		addTransitions(board);
		
		board.print();
		
		Counters counters = new Counters(board, NUM_PLAYERS);
		counters.print();
		
		while (!board.gameFineshed()) {
			Counter currentCounter = counters.next();
			currentCounter.play(board);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.format("O Jogador '%s' GANHOU!\n", board.getWinnerCounter().getName());
	}

	/**
	 * Adiciona as transições
	 * @param board Tabuleiro do jogo
	 */
	private void addTransitions(Board board) {
		board.addTransition(4, 12);
		board.addTransition(7, 9);
		board.addTransition(11, 25);
		board.addTransition(14, 2);
		board.addTransition(22, 5);
		board.addTransition(28, 18);
	}

}
