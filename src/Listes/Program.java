package Listes;

import Interfaces.ContratFilePile;
import Interfaces.Pile;

public class Program {
    public static void main(String[] args) {
        ContratFilePile<Integer> liste = new Pile<>();
        System.out.printf("Nombre d'éléments : %d%n", liste.size());

        liste.push(10);
        System.out.printf("Nombre d'éléments : %d%n", liste.size());

        liste.push(20);
        liste.push(30);
        System.out.printf("Nombre d'éléments : %d%n", liste.size());

        liste.pop();
        liste.push(40);

        while (true) {
            var temp = liste.pop();
            if (!temp.isPresent()) break;

            System.out.printf("Valeur retournée : %d%n",temp.get());
        }
        System.out.println("La liste est vide");
    }
}
