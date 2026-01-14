package Devoirs.Devoir_07.Interfaces;

public interface IMsgPrinter<T> {
    void print(T msg);
}


/*
    Cette interface est un Consumer personnalisé

    Un Consumer est une interface fonctionnelle (depuis Java 8) qui représente une opération
    acceptant une seule donnée en entrée (de type T) mais ne renvoyant aucun résultat (void),
    se concentrant sur des effets de bord comme l'affichage ou la modification d'un objet,
    souvent utilisée avec des expressions lambda.
*/