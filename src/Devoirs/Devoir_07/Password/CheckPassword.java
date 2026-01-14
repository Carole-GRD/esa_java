package Devoirs.Devoir_07.Password;

import Devoirs.Devoir_07.Interfaces.IValidator;

import java.util.Arrays;

public class CheckPassword {

    // Construit les règles de validation via l'interface IPassword
    // IPassword est une interface fonctionnelle (Predicate personnalisé)

    // Liste des caractères spéciaux autorisés
    private static final String SPECIALS = "-+_!@#$%^&*., ?";


    // ======================================================================================
    // ===================     Règles privées (on cache les détails)   ======================
    // ======================================================================================

    // 1) Ne peut pas être null
    private final IValidator<String> notNull = p -> p != null;

    // 2) Ne peut pas être vide (ou blanc)
    private final IValidator<String> notBlank = notNull.and(p -> p.trim().length() > 0);

    // 3) Minimum 10 caractères
    private final IValidator<String> minLength10 = notNull.and(p -> p.length() >= 10);

    // 4) Minimum 1 lettre en minuscule
    private final IValidator<String> hasLowercase = notNull.and(p -> {
        for (int i = 0; i < p.length(); i++) {
            if (Character.isLowerCase(p.charAt(i))) return true;
        }
        return false;
    });

    // 5) Minimum 1 lettre en majuscule
    private final IValidator<String> hasUppercase = notNull.and(p -> {
        for (int i = 0; i < p.length(); i++) {
            if (Character.isUpperCase(p.charAt(i))) return true;
        }
        return false;
    });

    // 6) Minimum 1 caractère spécial parmi la liste
    private final IValidator<String> hasSpecial = notNull.and(p -> {
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (SPECIALS.indexOf(c) >= 0) return true;
        }
        return false;
    });

    // Règle globale privée
    private final IValidator<String> passwordOk =
            notNull
                    .and(notBlank)
                    .and(minLength10)
                    .and(hasLowercase)
                    .and(hasUppercase)
                    .and(hasSpecial);


    // ======================================================================================
    // ===========================     API publique (simple)   ==============================
    // ======================================================================================

    public boolean isValid(String password) {
        return passwordOk.test(password);
    }


    // ======================================================================================
    // ================     API publique : liste d'erreurs (sans List)   ====================
    // ======================================================================================

    public String[] errors(String password) {
        String[] errors = new String[6];
        int count = 0;

        if (!notNull.test(password)) {
            errors[count++] = "Ne peut pas être NULL";
            return Arrays.copyOf(errors, count);
        }

        if (!notBlank.test(password)) errors[count++] = "Ne peut pas être vide ou blanc";
        if (!minLength10.test(password)) errors[count++] = "Minimum 10 caractères";
        if (!hasLowercase.test(password)) errors[count++] = "Minimum 1 lettre minuscule";
        if (!hasUppercase.test(password)) errors[count++] = "Minimum 1 lettre majuscule";
        if (!hasSpecial.test(password)) errors[count++] = "Minimum 1 caractère spécial parmi: " + SPECIALS;

        return Arrays.copyOf(errors, count);
    }

}
