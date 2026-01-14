package Devoirs.Devoir_07.Password;

import Devoirs.Devoir_07.Interfaces.IMsgPrinter;

import java.util.Scanner;

public class TestPassword {
    public static void main(String[] args) {

        IMsgPrinter<String> msg = System.out::println;
        CheckPassword ckPwd = new CheckPassword();

        Scanner sc = new Scanner(System.in);
        msg.print("Tape un mot de passe :");
        String password = sc.nextLine();

        if (ckPwd.isValid(password)) {
            msg.print("✅ Mot de passe VALIDE");
        } else {
            msg.print("❌ Mot de passe INVALIDE. Problèmes :");
            for (String err : ckPwd.errors(password)) {
                msg.print(" - " + err);
            }
        }

        sc.close();
    }
}
