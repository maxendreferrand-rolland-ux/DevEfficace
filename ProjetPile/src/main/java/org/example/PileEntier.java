/*-----------------------------------------------------------------------------
 * IUT de Rodez                                                               *
 * Département Informatique                                                   *
 * Semestre 3 - Programmation Efficace                                        *
 *                                                                            *
 *                  CORRECTION - TP CLASSE PILE D'ENTIERS                     *
 *                        - Avec IllegalArgumentException                     *
 *                            et IllegalStateException                        *
 *                                                                            *
 * ----------------------------------------------------------------------------
 */

/*
 *  gestion d'une pile d'entiers  avec exceptions prédéfinies
 *  fichier PileEntier.java                                              09/26
 */
package org.example;

/**
 * Cette classe représente une pile d'entiers.
 * Les opérations possibles sont
 *      création de la pile,
 *      tester si la pile est vide ou pleine,
 *      empiler une valeur,
 *      dépiler,
 *      consulter la valeur du sommet,
 *      renvoyer le contenu de la pile sous-la forme d'une chaîne de caractères,
 *      déterminer si 2 piles ont la même capacité,
 *      déterminer si 2 piles sont égales
 * Les méthodes qui ne peuvent pas être exécutées normalement provoquent
 * la levée d'une exception : IllegalArgumentException et IllegalStateException
 * @author INFO2
 * @version 1.0
 */
public class PileEntier {


    /**
     * Valeur par défaut pour la capacité de la pile
     */
    private static final int CAPACITE_DEFAUT = 10;

    /**
     * Capacité de la pile, ou nombre maximum d'éléments qu'elle peut contenir
     */
    private int capacite;

    /**
     * Taille de la pile (ou nombre d'éléments qu'elle contient)
     * Le sommet de la pile se trouve donc à l'indice taille-1
     */
    private int taille;

    /**
     * Tableau contenant les entiers éléments de la pile
     */
    private int[] element;


    /**
     * Constructeur par défaut (pile vide avec la capacité par défaut)
     */
    public PileEntier() {

        // création d'une pile vide ayant la capacité par défaut
        taille = 0;             // à sa création, la pile est vide
        element = new int[CAPACITE_DEFAUT];
        capacite = CAPACITE_DEFAUT;
    }

    /**
     * Construit une pile vide avec la capacité argument
     *
     * @param capacite capacité de la pile à créer
     * @throws IllegalArgumentException levée si la capacité est invalide
     */
    public PileEntier(int capacite) throws IllegalArgumentException {

        // si la capacite argument est invalide, l'exception est levée
        if (capacite <= 0) {
            throw new IllegalArgumentException();
        }

        // sinon : création d'une pile vide avec la capacité argument
        taille = 0;
        element = new int[capacite];
        this.capacite = capacite;
    }

    /**
     * Détermine si la pile est pleine
     *
     * @return un booléen égal à vrai ssi la pile est pleine
     */
    public boolean estPleine() {
        return taille == capacite;
    }


    /**
     * Renvoie la valeur du sommet de la pile
     *
     * @return le sommet de la pile (un entier)
     * @throws IllegalStateException levée si la pile est vide
     */
    public int sommet() throws IllegalStateException {

        // si la pile est vide, on lève l'exception IllegalStateException
        if (estVide()) {
            throw new IllegalStateException();
        }

        // sinon : on renvoie le sommet
        return element[taille - 1];
    }

    /**
     * Détermine si la pile est vide
     *
     * @return un booléen égal à vrai ssi la pile est vide
     */
    public boolean estVide() {
        return taille == 0 ;
    }

    /**
     * Empile l'entier argument
     *
     * @param n entier à empiler
     * @throws IllegalStateException levée si la pile est pleine
     */
    public void empiler(int n) throws IllegalStateException {
        if (estPleine()) {
            throw new IllegalStateException();
        }
        element[taille] = n;
        taille++;
    }

    /**
     * Dépile l'élément sommet de la pile
     *
     * @throws IllegalStateException levée si la pile est vide
     */
    public void depiler() throws IllegalStateException {
        if (estVide()) {
            throw new IllegalStateException();
        }
        taille--;
    }

    /**
     * Renvoie le contenu de la pile sous forme de chaîne de caractères
     * @return une chaîne représentant la pile, du sommet vers la base
     */
    @Override
    public String toString() {
        String resultat = "[ sommet = ";
        for (int i = taille - 1; i >= 0; i--) {
            resultat = resultat + " " + element[i] + " |";
        }
        resultat = resultat + "  ]";
        return resultat;
    }

    /**
     * Détermine si 2 piles ont la même capacité
     *
     * @param p1 première pile
     * @param p2 deuxième pile
     * @return un booléen égal à vrai ssi p1 et p2 ont la même capacité
     */
    public static boolean memeCapacite(PileEntier p1, PileEntier p2) {
        return p1.capacite == p2.capacite;
    }

    /**
     * Détermine si la pile courante est égale à la pile argument
     * @param autre pile à comparer avec la pile courante
     * @return un booléen égal à vrai ssi autre est une pile identique
     */
    public boolean equals(PileEntier autre) {
        if (!memeCapacite(this, autre) || this.taille != autre.taille) {
            return false;
        }
        for (int i = 0; i < taille; i++) {
            if (this.element[i] != autre.element[i]) {
                return false;
            }
        }
        return true;
    }
}
   