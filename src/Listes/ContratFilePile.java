//package Devoirs.Devoir_06_initial.Listes;
//
//import java.util.OptionalInt;
//
//public interface ContratFilePile {
//    void push(int element);
//    OptionalInt pop();
//    void clear();
//    int size();
//    boolean estPleine();
//    boolean estVide();
//}
package Listes;

import java.util.Optional;

public interface ContratFilePile<T> {
    void push(T element);
    Optional<T> pop();
    void clear();
    int size();
    boolean estPleine();
    boolean estVide();
}
