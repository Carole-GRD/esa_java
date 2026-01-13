package Devoirs.Devoir_06_V1.Interfaces;

import java.util.Optional;

/**
 * Interface pour la manipulation d'une structure d'éléments
 * Cette interface est utilisée pour la gestion d'une pile ou d'une file
 * @param <T> Elément qui est le cœur de l'information manipulée
 */
public interface IFilePile<T> {

    /**
     * Ajoute un nouvel élément dans la Structure
     * @param donnee la valeur à ajouter
     */
    void push(T donnee);

    /**
     * Retourne et supprime un élément de la structure.
     * La stratégie de suppression dépend de l'implémentation concrète.
     * @return un Optional contenant l'élément retiré,
     *         ou Optional.empty() si la structure est vide
     */
    Optional<T> pop();

    /**
     * Retourne le nombre d'éléments dans la Structure
     * @return le nombre d'éléments dans la Structure
     */
    int size();

    /**
     * Vide la Structure de tous ses éléments
     * Après l'appel de clear(), size() doit retourner 0
     */
    void clear();

    /**
     * Indique si la structure est vide.
     * @return true si aucun élément n'est stocké,
     *         false sinon.
     */
    boolean estVide();

    /**
     * Retourne les éléments de la Structure sous la forme d'un String
     * en tenant compte s'il s'agit d'une file ou d'une pile
     *
     * @return un String qui comprend la liste des éléments de la Structure
     */
    String toString();
}
