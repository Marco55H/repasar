package parchisrepaso;

import java.util.Random;

/**
 * Clase que se encargará de crear todas las funciones necesarias para crear el
 * juego
 */
public class PartesParchis {

	/**
	 * Atributo que marcará el tamaño del tablero
	 */
	final static int TAM_TABLERO = 10;

	/**
	 * Atributo que se encarga de guardar y modificar la posición del primer jugador
	 */
	int ficha1 = 0;
	/**
	 * Atributo que se encarga de guardar y modificar la posición del segundo
	 * jugador
	 */
	int ficha2 = 0;

	/**
	 * Atributo que guardará el valor del primer dado
	 */
	static int dado1 = 0;
	/**
	 * Atributo que guardará el valor del segundo dado
	 */
	static int dado2 = 0;

	/**
	 * Atributo que guardará el nombre del primer jugador
	 */
	String nom1 = "";
	/**
	 * Atributo que guardará el nombre del segundo jugador
	 */
	String nom2 = "";

	/**
	 * Constructor que tiene como valores de entrada los nombres de los jugadores
	 * 
	 * @param nom1 nombre jugador 1
	 * @param nom2 nombre jugador 2
	 */
	public PartesParchis(String nom1, String nom2) {
		super();
		this.nom1 = nom1;
		this.nom2 = nom2;
	}

	/**
	 * Contructor sin parámetros
	 */
	public PartesParchis() {
		super();
	}

	/**
	 * Funcion qeu se encarga de tirar los dados
	 */
	public static void tiraDados() {
		// Creamos una variable random
		Random r = new Random();

		// Les damos a los dados números aleatorios entre el 1 y el 6
		dado1 = r.nextInt(1, 7);
		dado2 = r.nextInt(1, 7);

	}

	void pintaTablero() {

		for (int i = 0; i <= TAM_TABLERO; i++) {

			if (i == 0) {
				System.out.print("\tI");
			} else if (i == TAM_TABLERO) {
				System.out.println("\tF");
			} else {
				System.out.print("\t" + i);
			}
		}

		for (int j1 = 0; j1 <= TAM_TABLERO; j1++) {

			if (j1 == 0) {

				System.out.print(nom1);

				System.out.print("\tI");

			} else if (j1 == TAM_TABLERO) {

				System.out.println("\tF");

			} else {

				if (j1 == ficha1 + 1) {

					System.out.print("o");
					System.out.print("\t");

				} else {

					System.out.print("\t");
				}
			}
		}

		for (int j2 = 0; j2 <= TAM_TABLERO; j2++) {

			if (j2 == 0) {

				System.out.print(nom2);

				System.out.print("\tI");

			} else if (j2 == TAM_TABLERO) {

				System.out.println("\tF");

			} else {

				if (j2 == ficha2 + 1) {

					System.out.print("o");
					System.out.print("\t");

				} else {

					System.out.print("\t");
				}
			}
		}
	}

	void avanzaPosiciones(int jugador) {

		tiraDados();
		int pasado = 0;

		if (jugador == 1) {
			ficha1 = ficha1 + dado1 + dado2;
			if (ficha1 > TAM_TABLERO) {
				pasado = ficha1 - TAM_TABLERO;
				ficha1 = TAM_TABLERO - pasado;
			}
		}

		if (jugador == 2) {
			ficha2 = ficha2+dado1 + dado2;
			if (ficha2 > TAM_TABLERO) {
				pasado = ficha2 - TAM_TABLERO;
				ficha2 = TAM_TABLERO - pasado;
			}
		}
	}

	void estadoCarrera() {
		if (ficha1 > ficha2) {
			System.out.println("Va ganando el jugador " + nom1);
		} else if (ficha1 < ficha2) {
			System.out.println("Va ganando el jugador " + nom2);
		} else {
			System.out.println("Van empate");
		}
	}

	String esGanador() {
		String cadena = "";
		
		if (ficha1 == TAM_TABLERO) {
			cadena = "Ganó " + nom1;
		} else if (ficha2 == TAM_TABLERO) {
			cadena = "Ganó " + nom2;
		}

		return cadena;
	}
}
