package genericite;

public class Noeud<T extends Comparable<T> > {

    /// Valeur du noeud à ajouter
    private T valeur ;

    private Noeud<T> filsGauche;
    private Noeud<T> filsDroit;

    public Noeud(T valeur) {
        this.valeur = valeur;
        filsGauche = null;
        filsDroit = null;
    }

    public boolean estPresente(T aChercher) {
        if (valeur.equals(aChercher)) {
            return true ;
        }
        if (valeur.)
    }

}
