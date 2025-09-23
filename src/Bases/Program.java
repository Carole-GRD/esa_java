package Bases;
//Créer un dossier "SRC"
//clique droit sur "SRC" -> Mark Directory as -> Sources Root
//sélectionner "SRC" et cliquer sur le plus (+) au dessus pour créer un package nommé "Bases"
//sélectionner "Bases" et cliquer sur le plus (+) au dessus pour créer une classe nommé "Program"

//dans "SRC" créer un dossier "test"
//clique droit sur "test" -> Mark Directory as ->  Test Sources Root

//Par convention, le nom d'une classe se fait avec la première lettre en majuscule et les autres (variables...) en camelCase

public class Program {
    public static void main(String[] args) { //cette méthode est le point d'entrée du programme
        //-----------------------------------------
        //System.out.println("coucou");
        //System.out.print("ne va pas à la ligne sauf si j'ajoute un backslash n \n");
        //System.out.printf("1ère valeur = %d %n", 12);
        //-----------------------------------------

        //RMQ : On déclare les variables juste avant de les utiliser
        int entier = 12;
        int unAutreEntier = 9;
        //-----------------------------------------
        //System.out.println(entier + unAutreEntier);
        //-----------------------------------------

        //RMQ : préciser le type permet mieux gérer la mémoire
        byte unByte = 100; // sur 1 byte (8 bits = 256 valeurs → de -128 à 127)
        short unShort; // sur 2 bytes
        int unInt; // sur 4 bytes
        long unLong = 5000; // sur 8 bytes

        int a = 5, b = 8;
        a = a + b++; // a = a + b; b = b + 1; => a = 13
        a = a + ++b; // b = b + 1; a = a + b; => a = 14


        char unChar; //sur 2 bytes → caractère dans la table Unicode 16
        // mais c'est aussi un nombre entier qui va de 0 65535

        boolean unBool = true; // true - false

        float unFloat;  // 4 bytes
        double unDouble;  // 8 bytes

        String unString;

        unChar = 'a'; // simple quote pour les char !
        unString = "Chaîne"; // double quote pour les String !

        unChar = 'a' + 5;
        unString = "chaîne " + 2;
        //-----------------------------------------
        //System.out.println(unChar); // f
        //System.out.println(unString); // chaine 2
        //-----------------------------------------


        //RMQ : on ne peut utiliser var qu'à l'intérieur d'une méthode
        var debrouilleToi = 1l; // long
        var uneC = "coucou"; // String
        var unI = 8; // int
        var unD = 1.5; // double
        var unB = true; // boolean

        unInt = unByte; // 1 byte dans 4 bytes => OK
        //unByte = unLong; // 8 butes dans un byte => NON => il faut caster !
        unByte = (byte) unLong; // caster => forcer un type à être dans un autre type compatible !
        unLong = (long) unInt; // tu peux l'indiquer mais ce n'est pas nécessaire (car on met 4 bytes dans 8 bytes)

        unInt = 12 + 7 / 5; // 7/5=1.4 mais cela donnera 1
        //-----------------------------------------
        System.out.println(unInt); // 13
        //-----------------------------------------

        //var resultat = 12 + 7 / 5.;
        var resultat = 12 + 7 / 5;
        //-----------------------------------------
        System.out.println(resultat); // sans le "." donne 13 et avec le "." donne 13.4
        //-----------------------------------------

        resultat += 11;
        //-----------------------------------------
        System.out.println(resultat); // 24.4
        //-----------------------------------------

        resultat *= 2;
        //-----------------------------------------
        //System.out.println(resultat); // 24 * 2 = 48
        //-----------------------------------------

        resultat <<= 2;  // décalage de 2 positions vers la gauche
        //-----------------------------------------
        System.out.println(resultat); // 192
        /*
            00110000 (48)
            << 1 → 01100000 (96)
            << 2 → 11000000 (192)
         */
        //-----------------------------------------

        unBool = !unBool;


        if (unBool) {
            System.out.println("unBool est true");
        } else {
            System.out.println("unBool est false");
        }


        if (unInt == 1) {
            // RMQ : le == ne fonctionne que pour les nombres, les chaînes de caractères et les booleen
            System.out.println("unInt vaut 1");
        }


        if (unInt != 2 && unInt != 3) {
            System.out.println("unInt ne vaut pas 2 ni 3");
        }


        if (unInt == 1 || unInt == 2) {
            System.out.println("unInt vaut 1 ou 2");
        } else if (unInt == 3 || unInt == 4) {
            System.out.println("unInt vaut 3 ou 4");
        }


        switch (unInt) {
            case 1:
                System.out.println("unInt vaut 1");
                break;
            case 2:
                System.out.println("unInt vaut 2");
                break;
            case 4:
                System.out.println("unInt vaut 4");
                break;
            case 3: case 5:
                System.out.println("unInt vaut 3");
                break;
            default:
                System.out.println("unInt ne vaut pas 1, 2, 3 ou 4");
                break;
        }


//        // RMQ : ne jamais tester == avec un String ! ???? =>...
//        if (unString == "Bonjour") {
//            System.out.println("unString vaut Bonjour");
//        }
//        // => À NE JAMAIS FAIRE !!!


//        if (5 > unInt) {
//            System.out.println("unInt < 5");
//        }

        // Opérateur ternaire
        unInt = (unBool == true ? 1 : 0);
        // idem à...
        if (unBool) {
            unInt = 1;
        } else {
            unInt = 0;
        }
        // RMQ : utiliser le code le plus lisible et pas le plus élégant !


//        while (unInt < 10) {
//            System.out.println(unInt++); // de 0 à 9
//        }

//        while (unInt < 10) {
//            System.out.println(++unInt); // de 1 à 10
//        }

//        while (unInt++ < 10) {
//            System.out.println(unInt); // de 1 à 10
//        }

//        while ((unInt+=2) < 10) {
//            System.out.println(unInt); //2 4 6 8
//        }


//        do {
//            System.out.println(unInt);
//        } while (unInt++ < 10);


//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }


//        for (int i = 0, j = 2; i < 10; i++, j = j + 2) {
//            if (i == 3) continue;
//            System.out.println("i = " + i + " - j = " + j);
//            if (i == 6) break;
//        }


//        int i = 0;
//        for (; i++ <= 4 ;) {
//            System.out.println(i); // !! de 1 à 5 !!
//        }


//        int[] monTableau = {1, 2, 3, 4, 5};
//        System.out.println(monTableau[0]);
//        System.out.println(monTableau.length);


//        int[] maTable = new int[10];
//        System.out.println(maTable[1]);  // 0
//        maTable[1] = 5;
//        System.out.println(maTable[1]);  // 5


        //-----------------------------------------
        //-----------------------------------------


    }
}
