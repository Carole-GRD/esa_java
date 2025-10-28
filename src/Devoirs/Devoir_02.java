package Devoirs;

public class Devoir_02 {
    public static void main(String[] args) {
        var compteur = 0L;
        var prime = true;
        //var MAX = 1_000_000;
        var MAX = 100;
        var timeDivisor = 1000000;

        System.out.println("Version 1 : générique");
//        System.out.print("  2");
        long start = System.nanoTime();
        for (int i = 3; i <= MAX; i++) {
            for (int j = 2; j < i; j++) {
                compteur++;
                if (i % j == 0) {
//                    prime = false;
                    break;
                }
            }
//            if (prime) {
//                System.out.printf(",%3d", i);
//            } else
//                prime = true;
        }
        System.out.printf("\nNombre d'opérations : %,d%n", compteur);
        System.out.printf("Durée : %,d ms %n%n",  (System.nanoTime() - start) / timeDivisor);

        System.out.println("Version 2 : que les nombres impairs");
//        System.out.print("  2");
//        prime = true;
        compteur = 0;
        start = System.nanoTime();
        for (int i = 3; i <= MAX; i += 2) {
            for (int j = 3; j < i; j++) {
                compteur++;
                if (i % j == 0) {
//                    prime = false;
                    break;
                }
            }
//            if (prime) {
//                System.out.printf(",%3d", i);
//            } else
//                prime = true;
        }
        System.out.printf("\nNombre d'opérations : %,d%n", compteur);
        System.out.printf("Durée : %,d ms %n%n",  (System.nanoTime() - start) / timeDivisor);

        System.out.println("Version 3 : diviseur impair");
//        System.out.print("  2");
//        prime = true;
        compteur = 0;
        start = System.nanoTime();
        for (int i = 3; i <= MAX; i += 2) {
            for (int j = 3; j < i; j += 2) {
                compteur++;
                if (i % j == 0) {
//                    prime = false;
                    break;
                }
            }
//            if (prime) {
//                System.out.printf(",%3d", i);
//            } else
//                prime = true;
        }
        System.out.printf("\nNombre d'opérations : %,d%n", compteur);
        System.out.printf("Durée : %,d ms %n%n",  (System.nanoTime() - start) / timeDivisor);

        System.out.println("Version 4 : règle du carré");
//        System.out.print("  2");
//        prime = true;
        compteur = 0;
        start = System.nanoTime();
        for (int i = 3; i <= MAX; i += 2) {  // nombres impairs
            int k = (int) Math.sqrt(i);
            for (int j = 3; j <= k; j += 2) {   // diviseurs impairs (plus petits que la racine carrée du nombre)
                compteur++;
                if (i % j == 0) {
//                    prime = false;
                    break;
                }
            }
//            if (prime) {
//                System.out.printf(",%3d", i);
//            } else
//                prime = true;
        }
        System.out.printf("\nNombre d'opérations : %,d%n", compteur);
        System.out.printf("Durée : %,d ms %n%n",  (System.nanoTime() - start) / timeDivisor);

        System.out.println("Version 5 : règle du polynome");
        System.out.print("  2");
        int[] liste = new int[MAX / 2];
        var nbPrime = 0;
//        prime = true;
        compteur = 0;
        start = System.nanoTime();
        for (int i = 3; i < MAX; i += 2) {
            int j = 0;
            var k = (int) Math.sqrt(i);
            /*
             * Tant qu’il me reste des nombres premiers connus à tester (j < nbPrime)
             * et que le nombre premier courant liste[j] ne dépasse pas √i (<= k), je fais le test.
             */
            while (j < nbPrime && liste[j] <= k) {
                compteur++;
                if (i % liste[j] == 0) {
                    prime = false;
                    break;
                }
                j++;
            }
            if (prime) {
//                System.out.printf(",%3d", i);
                liste[nbPrime++] = i;
            } else
                prime = true;
        }
        System.out.printf("\nNombre d'opérations : %,d%n", compteur);
        System.out.printf("Durée : %,d ms %n%n",  (System.nanoTime() - start) / timeDivisor);
        System.out.printf("Nombre de premiers : %d%n", ++nbPrime);

        System.out.println();

    }
}



