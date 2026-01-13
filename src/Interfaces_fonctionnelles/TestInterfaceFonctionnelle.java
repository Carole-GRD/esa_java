package Interfaces;

import java.util.ArrayList;
import java.util.function.*;

public class TestInterfaceFonctionnelle {
    static void main() {
        MonInterface test = new MonInterface() {
            @Override
            public void affiche() {
                System.out.println("Coucou");
            }
        };
        MonInterface test2 = new MonInterface() {
            @Override
            public void affiche() {
                System.out.println("Hello");
            }
        };
        test.affiche();
        test2.affiche();

        MonInterface test3 = () -> System.out.println("test3");
        test3.affiche();

        MonInterface test4 = () -> {
            System.out.println("test4");
            var i = 2 * 4;
            System.out.printf("%d%n", i);
        };
        test4.affiche();

        Lambda1Param l1 = s -> System.out.println(s);
        l1.affiche("1 Param");

        Lambda2Params l2 = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        l2.affiche("P1", "P2");

        LambdaReturn lr = new LambdaReturn() {
            @Override
            public long retour() {
                return System.currentTimeMillis();
            }
        };

        LambdaReturn lr2 = () -> System.currentTimeMillis();
        System.out.println(lr2.retour());

        LambdaReturn lr3 = () -> {
            long a = 15;
            return a * 100;
        };
        System.out.println(lr3.retour());

        System.out.println("******************************");
        Afficher(test);
        Afficher(test2);
        Afficher(test3);
        Afficher(test4);

        Afficher(()-> System.out.println("test"));
        Afficher(()-> {
            var x = getX();
            var y = getY();
            System.out.printf("La somme est égale à %d%n", x + y);
        });

        Executer(s1 ->  {
            var x = getX();
            var y = getY();
            System.out.printf("La forme %s à une surface de %d%n", s1, y*x);
        }, "carré");

        Predicate<String> commenceParA = s -> s.startsWith("A");
        System.out.println(commenceParA.test("Bonjour"));
        System.out.println(commenceParA.test("Attention"));

        BiPredicate<Integer, Integer> estPlusPetitQue = (x1,x2) -> x1 < x2;
        System.out.printf("3 < 5 ? %b%n", estPlusPetitQue.test(3, 5));

        Consumer<String> consumer = x -> System.out.println(x);

        ArrayList<String> al =  new ArrayList<>();
        al.add("1");
        al.add("2");
        al.add("3");
        al.forEach(consumer);

        for(var s : al)  {
            System.out.println(s);
        }

        Supplier<String> supplier = () -> "test";

        Function<String, Integer> function = x -> Integer.parseInt(x);

        System.out.println(function.apply("12"));



    }

    public static int getX() { return 4; }
    public static int getY() { return 6; }

    public static void Afficher(MonInterface test) {
        test.affiche();
    }

    public static void Executer(Lambda1Param l1, String s) {
        l1.affiche(s);
    }

}
