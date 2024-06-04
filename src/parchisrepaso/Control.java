package parchisrepaso;

import java.util.Scanner;

public class Control {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String nombre1 = "";
		String nombre2 = "";
		PartesParchis parchis = null;
		String seguir;

		System.out.println("Nombre del primer jugador");
		nombre1 = sc.nextLine();
		do {
			System.out.println("Nombre del segundo jugador");
			nombre2 = sc.nextLine();
		} while (nombre1.equals(nombre2));

		parchis = new PartesParchis(nombre1, nombre2);

		
		while (parchis.esGanador().equals("")) {
			do {
				System.out.println("Introduzca cualquier carácter para tirar dados de " + nombre1);
				seguir=sc.next();
				parchis.avanzaPosiciones(1);
				System.out.println("Los dados han salido :"+PartesParchis.dado1+":"+PartesParchis.dado2);
				parchis.pintaTablero();
				parchis.estadoCarrera();
			} while (PartesParchis.dado1 == PartesParchis.dado2);

			if (parchis.esGanador().equals("")) {
				do {
					System.out.println("Introduzca cualquier carácter para tirar dados de " + nombre2);
					seguir=sc.next();
					parchis.avanzaPosiciones(2);
					System.out.println("Los dados han salido :"+PartesParchis.dado1+":"+PartesParchis.dado2);
					parchis.pintaTablero();
					parchis.estadoCarrera();
				} while (PartesParchis.dado1 == PartesParchis.dado2);
			}
		}

	}
}
