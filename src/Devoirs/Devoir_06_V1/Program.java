package Devoirs.Devoir_06_V1;

import java.util.Optional;

public class Program {
    public static void main(String[] args) {
        TableauPile<Object> test = new TableauPile<>();
//        TableauFile<Object> test = new TableauFile<>();

//        ListePile<Object> test = new ListePile<>();
//        ListeFile<Object> test = new ListeFile<>();

        System.out.println(test);

        for(int i = 0; i < 10; i++)
            test.push(i);
        System.out.println(test);

        for(int i = 0; i < 8; i++)
            test.pop();
        System.out.println(test);

        test.clear();
        System.out.println(test);

        test.push(100);
        System.out.println(test);


        for (int i=0; i<10; i++) {
            Optional<Object> valeur = test.pop();
            //valeur.ifPresent(System.out::println);
            if (valeur != null && valeur.isPresent()) {
                System.out.println("donnée retournée : " + valeur.get());
            }
        }
        System.out.println(test);

    }
}
