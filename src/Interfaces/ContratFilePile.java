package Interfaces;

import java.util.Optional;
import java.util.OptionalInt;

public interface ContratFilePile <T> {
    void push(T element);
    Optional<T> pop();
    void clear();
    int size();
    boolean estPleine();
    boolean estVide();
}
