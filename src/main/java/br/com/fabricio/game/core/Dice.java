package br.com.fabricio.game.core;

import java.util.Random;

public class Dice {
	
	private static final int MAX_NUMBER = 6;
	
	private static Dice instance;
	private Random random = new Random();

	private Dice() {
		
	}
	
	public static Dice get() {
		if (instance == null) {
			instance = new Dice();
		}
		
		return instance;
	}
	
	/**
	 * Lança o dado
	 * @return Retorna o número do dado
	 */
	public int roll() {
		return random.nextInt(MAX_NUMBER) + 1;
	}
}
