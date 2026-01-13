package Devoirs.Devoir_05_cours;

import Devoirs.Devoir_05_cours.Structure.FilePile;

public class Program {
    public static void main(String[] args) {
        var pile1 = new Pile();
        var pile2 = new File(10);

        for(int i = 0; i < 10; i++)
            pile2.push(i);

        System.out.println("Pile2 est plein ? : " + pile2.estPleine());
        System.out.println(pile2);

        for(int i = 0; i < 8; i++)
            pile2.pop();

        System.out.println("Pile2 est plein ? : " + pile2.estPleine());
        System.out.println(pile2);

        pile2.clear();
        pile2.push(100);
        System.out.println(pile2);

        for (int i=0; i<10; i++) {
            var valeur = pile2.pop();
            if (valeur.isPresent())
                System.out.println(valeur.getAsInt());
        }
        System.out.println(pile2);


    }
}
