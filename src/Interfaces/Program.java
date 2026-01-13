package Interfaces;

public class Program {
    static void main() {
        File f1 = new File();
        Pile p1 = new Pile();

        ContratFilePile<Boolean> c1 = new File<>();
        c1.push(true);
        c1 = f1;
        c1.push(true);

        c1 = p1;
        c1.push(false);

        File<Boolean> f = new File(4);
        c1 = f;
        c1.push(false);
        f.push(true);
        f.push(true);
        System.out.println(c1);
        System.out.println(f);
    }
}
