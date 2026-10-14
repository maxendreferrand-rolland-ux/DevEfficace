package ProjetMatriceCreuse;

import java.util.ArrayList;

public class Matrice {

    private final static int DIMENSION_PAR_DEFAUT = 5;

    private ArrayList<Coefficient> listeCoefficient;
    private int lignes;
    private int colonnes;

    public Matrice() {
        this.lignes = DIMENSION_PAR_DEFAUT;
        this.colonnes = DIMENSION_PAR_DEFAUT;
        this.listeCoefficient = new ArrayList<Coefficient>();
    }

    public Matrice(int lignes, int colonnes) throws IllegalArgumentException {
        if (lignes <= 0 || colonnes <= 0) {
            throw new IllegalArgumentException("erreur lors de la construction de la matrice : "
                    + "le nombre de lignes (" + lignes + ") et de colonnes (" + colonnes
                    + ") doit être strictement positif.");
        }
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.listeCoefficient = new ArrayList<Coefficient>();
    }

    private int rechercher(int numLigne, int numColonne) {
        int i;

        for (i = 0; i < this.listeCoefficient.size()
                && !this.listeCoefficient.get(i).estSitue(numLigne, numColonne); i++);

        if (i < this.listeCoefficient.size()) {
            return i;
        } else {
            return -1;
        }
    }

    private boolean supprimer(int numLigne, int numColonne) {
        int i;

        for (i = 0; i < this.listeCoefficient.size()
                && !this.listeCoefficient.get(i).estSitue(numLigne, numColonne); i++);

        if (i < this.listeCoefficient.size()) {
            this.listeCoefficient.remove(i);
            return true;
        } else {
            return false;
        }
    }

    public void setValeur(int numLigne, int numColonne, double valeur) throws IllegalArgumentException {
        int position;

        if (numLigne < 1 || numLigne > this.lignes || numColonne < 1 || numColonne > this.colonnes) {
            throw new IllegalArgumentException("erreur lors d'une tentative de modification d'un "
                    + "coefficient de la matrice : coordonnées incorrectes, ligne = " + numLigne
                    + ", colonne = " + numColonne);
        }

        if (valeur == 0) {
            supprimer(numLigne, numColonne);
        } else {
            position = rechercher(numLigne, numColonne);
            if (position != -1) {
                this.listeCoefficient.get(position).setValeur(valeur);
            } else {
                this.listeCoefficient.add(new Coefficient(numLigne, numColonne, valeur));
            }
        }
    }

    public void afficher() {
        if (this.listeCoefficient.isEmpty()) {
            System.out.println("La matrice est nulle.");
        } else {
            for (int i = 0; i < this.listeCoefficient.size(); i++) {
                System.out.println(this.listeCoefficient.get(i).toString());
            }
        }
    }

    public double getValeur(int numLigne, int numColonne) throws IllegalArgumentException {
        int position;

        if (numLigne < 1 || numLigne > this.lignes || numColonne < 1 || numColonne > this.colonnes) {
            throw new IllegalArgumentException("erreur lors de l'appel à l'accesseur getValeur : "
                    + "coordonnées incorrectes, ligne = " + numLigne + ", colonne = " + numColonne);
        }

        position = rechercher(numLigne, numColonne);

        if (position != -1) {
            return this.listeCoefficient.get(position).getValeur();
        } else {
            return 0;
        }
    }

}
