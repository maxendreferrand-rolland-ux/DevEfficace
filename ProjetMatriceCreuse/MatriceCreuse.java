package ProjetMatriceCreuse;

import java.util.ArrayList;

public class MatriceCreuse {

    private final static int LIGNE = 5;
    private final static int COLONNE = 5;

    private ArrayList<Coefficient> coefficients;

    private int lignes,
                colonnes;

    public MatriceCreuse() {
        this.lignes = LIGNE;
        this.colonnes = COLONNE;
        this.coefficients = new ArrayList<Coefficient>();
    }
    public MatriceCreuse(int lignes, int colonnes) throws IllegalArgumentException {
        if (lignes <= 0 || colonnes <= 0) {
            throw new IllegalArgumentException("erreur lors de la construction de la matrice : "
                    + "le nombre de lignes et de colonnes doit être strictement positif");
        }
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.coefficients = new ArrayList<Coefficient>();
    }

    public double getValeur(int ligne, int colonne) {
        if (lignes <= 0 || colonnes <= 0) {
            throw new IllegalArgumentException("le nombre de lignes et de colonnes doit être strictement positif");
    }
}
