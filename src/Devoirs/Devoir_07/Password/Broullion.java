//package Devoirs.Devoir_07;
//import java.util.Scanner;
//
//public class Broullion {
//
//    // Liste des caractères spéciaux autorisés
//    private static final String SPECIALS = "-+_!@#$%^&*., ?";
//
//    public static void main(String[] args) {
//
//        // Consumer pour afficher en utilsant la méthode accept()
//        IAfficheMsg consumeMsgList = System.out::println;
//
//        // ====== RÈGLES (Predicate) ======
//
//        // 1) Ne peut pas être null
//        IPassword<String> notNull = p -> p != null;
//
//        // 2) Ne peut pas être vide (ou blanc)
//        // "   " -> trim() devient "" donc invalide
//        IPassword<String> notBlank = notNull.and(p -> p.trim().length() > 0);
//
//        // 3) Minimum 10 caractères
//        IPassword<String> minLength10 = notNull.and(p -> p.length() >= 10);
//
//        // 4) Minimum 1 lettre en minuscule
//        IPassword<String> hasLowercase = notNull.and(p -> {
//            for (int i = 0; i < p.length(); i++) {
//                if (Character.isLowerCase(p.charAt(i))) return true;
//            }
//            return false;
//        });
//
//        // 5) Minimum 1 lettre en majuscule
//        IPassword<String> hasUppercase = notNull.and(p -> {
//            for (int i = 0; i < p.length(); i++) {
//                if (Character.isUpperCase(p.charAt(i))) return true;
//            }
//            return false;
//        });
//
//        // 6) Minimum 1 caractère spécial parmi la liste
//        IPassword<String> hasSpecial = notNull.and(p -> {
//            for (int i = 0; i < p.length(); i++) {
//                char c = p.charAt(i);
//                if (SPECIALS.indexOf(c) >= 0) return true;
//            }
//            return false;
//        });
//
//        // ====== RÈGLE GLOBALE (chaînage .and comme dans le cours) ======
//        IPassword<String> passwordOk =
//                notNull
//                        .and(notBlank)
//                        .and(minLength10)
//                        .and(hasLowercase)
//                        .and(hasUppercase)
//                        .and(hasSpecial);
//
//        // ====== TEST CONSOLE ======
//        //String password = "Test56789#";
//        //password = "";
//        Scanner sc = new Scanner(System.in);
//        consumeMsgList.stock("Tape un mot de passe :");
//        String password = sc.nextLine();
//
//        boolean ok = passwordOk.check(password);
//
//        if (ok) {
//            consumeMsgList.stock("✅ Mot de passe VALIDE");
//        } else {
//            consumeMsgList.stock("❌ Mot de passe INVALIDE. Problèmes :");
//
//            // On affiche les règles ratées (test + affichage)
//            if (!notNull.check(password)) consumeMsgList.stock(" - Ne peut pas être NULL");
//            if (!notBlank.check(password)) consumeMsgList.stock(" - Ne peut pas être vide ou blanc");
//            if (!minLength10.check(password)) consumeMsgList.stock(" - Minimum 10 caractères");
//            if (!hasLowercase.check(password)) consumeMsgList.stock(" - Minimum 1 lettre minuscule");
//            if (!hasUppercase.check(password)) consumeMsgList.stock(" - Minimum 1 lettre majuscule");
//            if (!hasSpecial.check(password)) consumeMsgList.stock(" - Minimum 1 caractère spécial parmi: " + SPECIALS);
//        }
//
//        sc.close();
//    }
//}
//
//
