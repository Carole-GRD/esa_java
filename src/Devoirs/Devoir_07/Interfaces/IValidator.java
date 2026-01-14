package Devoirs.Devoir_07.Interfaces;

@FunctionalInterface
public interface IValidator <T> {
    boolean test(T password);

    default IValidator<T> and(IValidator<? super T> otherPassword) {
        return (T password) -> test(password) && otherPassword.test(password);
    }
}

/*
    Cette interface est un Predicate personnalisé

   Un Predicate est une interface fonctionnelle (depuis Java 8) qui représente
   une fonction prenant un argument et retournant une valeur booléenne (true ou false).

   Son rôle principal est de filtrer des données ou de tester des conditions,
   notamment avec les flux (Streams) et les collections,
   permettant de vérifier si un objet satisfait un critère spécifique.

   On peut combiner plusieurs Predicates avec and(), or(), et negate()
   pour créer des conditions complexes.
*/
