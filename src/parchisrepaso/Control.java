package parchisrepaso;

import java.util.Scanner;

public class Control {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String nombre1 = "";
		String nombre2 = "";
		PartesParchis parchis = null;
		String seguir;
		int turno = 1;
		String ganador;

		System.out.println("Nombre del primer jugador");
		nombre1 = sc.nextLine();
		do {
			System.out.println("Nombre del segundo jugador");
			nombre2 = sc.nextLine();
		} while (nombre1.equals(nombre2));

		parchis = new PartesParchis(nombre1, nombre2);

		ganador = parchis.esGanador();

		while (ganador.equals("")) {
			do {

				System.out.println("Introduzca cualquier carácter para tirar dados de " + (turno == 1 ? nombre1 : nombre2));
				seguir = sc.next();

				PartesParchis.tiraDados();

				parchis.avanzaPosiciones(turno);

				System.out.println("Los dados han salido :" + PartesParchis.dado1 + ":" + PartesParchis.dado2);
				parchis.pintaTablero();
				parchis.estadoCarrera();

			} while (PartesParchis.dado1 == PartesParchis.dado2);
			if (ganador.equals("")) {
				turno = turno == 1 ? 2 : 1;
			}

			ganador = parchis.esGanador();
		}
		System.out.println("Ganó " +ganador);
	}
}
