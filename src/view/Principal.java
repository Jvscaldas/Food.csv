package view;

import java.io.IOException;

import controller.FruitController;
import controller.ItcFruit;

public class Principal {
	public static void main(String[] args) {

		ItcFruit arqCont = new FruitController();
		String dirWin = "C:\\temp";
		String path = "C:\\temp";
		String nome = "generic_food.csv";

		try {
			arqCont.readDir(dirWin);
			arqCont.readFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
