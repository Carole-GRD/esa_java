package Devoirs;

public class Devoir_01 {
    public static void main(String[] args) {
        /*
            1) Encode dans un tableau les lettres de l'alphabet en minuscule
         */

        char[] lettres = new char[26];

        //for (int i = 0; i < 26; i++) {
        //    lettres[i] = (char) ('a' + i);
        //}

        // OU BIEN
        for (char c = 'a'; c <= 'z' ; c++) {
            lettres[c-'a'] = c;
        }

        //for (int i = 0; i < 26; i++) {
        //    System.out.println(lettres[i]);
        //}


        /*
            2) Copie le premier tableau dans un 2è tableau de manière à ce que les lettres
            soient en majuscules et en sens inverse (de Z -> A)
         */

        char[] lettresMAJ = new char[lettres.length];

        //for (int i = 0, j = lettres.length - 1; i < lettres.length; i++, j--) {
        //    lettresMAJ[i] = (char)  (lettres[j] - 32);
        //}

        //OU BIEN
        for (int i = lettres.length - 1; i >= 0; i--) {
            lettresMAJ[lettres.length - 1 - i] = Character.toUpperCase(lettres[i]);
        }

        //for (int i = 0; i < 26; i++) {
        //    System.out.println(lettresMAJ[i]);
        //}

        //for (char c : lettresMAJ) {
        //    System.out.println(c);
        //}




        /*
            3) Créer un tableau à 2 dimensions (10 lignes et 10 colonnes) qui contiendra les nombres de 1 à 100.
         */

        int[][] tableau = new int[10][10];
        int k = 1;
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau.length; j++) {
                tableau[i][j] = k++;
            }
        }

        //for (int i = 0; i < tableau.length; i++) {
        //    for (int j = 0; j < tableau[i].length; j++) {
        //        System.out.printf("%d ", tableau[i][j]);
        //    }
        //    System.out.println();
        //}



        /*
            4) Effacer le numéro 1 et ensuite effacer tous les multiples de chaque nombre que vous trouverez
         */

        tableau[0][0] = 0;
        int nbPrimes = 0;
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j] == 0) {
                    continue;
                }
                int m = tableau[i][j];
                //System.out.println(m);
                nbPrimes++;
                for (int l = 0; l < tableau.length; l++) {
                    for (int n = 0; n < tableau[l].length; n++) {
                        if (i == l && j == n) continue;
                        if (tableau[l][n] != 0 && tableau[l][n] % m == 0) {
                            tableau[l][n] = 0;
                        }
                    }
                }
            }
        }


        //for (int i = 0; i < tableau.length; i++) {
        //    for (int j = 0; j < tableau[i].length; j++) {
        //        System.out.printf("%d ", tableau[i][j]);
        //    }
        //    System.out.println();
        //}


        /*
            5) Créer un nouveau tableau qui ne contiendra que les nombres restants du tableau précédent
         */

        int[] tabPrimes = new int[nbPrimes];
        for (int i = 0, b = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j] ==0) {
                    continue;
                }
                tabPrimes[b++] = tableau[i][j];

            }
        }


        /*
            6) Afficher les nombres premiers inférieures à 100
         */

        for (int valeur : tabPrimes) {
            System.out.println(valeur);
        }

    }
}
