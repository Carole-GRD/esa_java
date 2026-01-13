package Devoirs.Devoir_06_V1.Base;

/**
 * Représente un maillon (nœud) d'une liste chaînée simple.
 *
 * @author Carole Gérard
 */
public class ListeElement<T> {
    private T info = null;
    private ListeElement<T> suivant = null;

    public ListeElement() {}

    // Getters / Setters
    public T getInfo() { return info; }
    public void setInfo(T info) { this.info = info; }
    public ListeElement<T> getSuivant() { return suivant; }
    public void setSuivant(ListeElement<T> suivant) { this.suivant = suivant; }
}
