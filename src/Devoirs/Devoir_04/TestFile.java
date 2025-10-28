package Devoirs.Devoir_04;

public class TestFile {
    public static void main(String[] args) {

        MaClasseFile file = new MaClasseFile();
        //afficherFile(file);

        file.push(10);
        //afficherFile(file);

        file.push(20);
        //afficherFile(file);

        file.push(30);
        //afficherFile(file);

        file.push(40);
        //afficherFile(file);

        file.push(50);
        //afficherFile(file);

        file.push(60);
        //afficherFile(file);

        file.push(70);
        //afficherFile(file);

        file.push(80);
        //afficherFile(file);

        file.pop();
        //afficherFile(file);

        file.pop();
        //afficherFile(file);

        file.pop();
        //afficherFile(file);

        file.pop();
        //afficherFile(file);

        file.pop();
        //afficherFile(file);

        file.pop();
        //afficherFile(file);

        file.pop();
        //afficherFile(file);

        file.pop();
        //afficherFile(file);

        file.push(222);
        //afficherFile(file);

    }

//    static void afficherFile(MaClasseFile file) {
//        for (int i = 0; i < file.getTailleTableau(); i++) {
//            System.out.printf("Case %d => Element : %d%n", i, file.tableau[i]);
//        }
//        System.out.println("-> Taille de la file : " + file.getTaille());
//        System.out.println("-> Taille du tableau : " + file.getTailleTableau());
//    }
}
