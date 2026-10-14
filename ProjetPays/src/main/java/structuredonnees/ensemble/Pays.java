package structuredonnees.ensemble;

import java.util.ArrayList;
import java.util.TreeSet;

public class Pays {

    private String nomPays;

    private TreeSet<String> paysLimitrophes;

    public Pays(String nomPays) throws IllegalArgumentException {
        if (!nomValide(nomPays)) {
            throw new IllegalArgumentException("nom du pays non valide");
        }
        this.nomPays = nomPays;
        this.paysLimitrophes = new TreeSet<String>();
    }

    public Pays(String nomPays, String[] paysLimitrophes) throws IllegalArgumentException {
        if (!nomValide(nomPays)) {
            throw new IllegalArgumentException("nom du pays non valide");
        }
        this.nomPays = nomPays;
        this.paysLimitrophes = new TreeSet<String>();
        for (int i = 0; i < paysLimitrophes.length; i++) {
            if (nomPays.equals(paysLimitrophes[i])) {
                throw new IllegalArgumentException("un pays ne peut pas etre voisin de lui-meme");
            }
            this.ajouterVoisin(paysLimitrophes[i]);
        }
    }

    private static boolean nomValide(String nom) {
        return nom != null && !nom.isBlank();
    }

    public String toString() {
        return this.nomPays + " a pour voisin : " + this.paysLimitrophes.toString();
    }

    public void ajouterVoisin(String nomVoisin) throws IllegalArgumentException {
        if (!nomValide(nomVoisin)) {
            throw new IllegalArgumentException("nom du pays voisin non valide");
        }
        this.paysLimitrophes.add(nomVoisin);
    }

    public boolean estLimitrophe(String nomPays) {
        return this.paysLimitrophes.contains(nomPays);
    }

    public int nbLimitrophes() {
        return this.paysLimitrophes.size();
    }

    public boolean memeLimitrophes(ArrayList<String> liste) {
        return this.paysLimitrophes.containsAll(liste)
                && liste.containsAll(this.paysLimitrophes);
    }

    public int nbPaysCommuns(ArrayList<String> liste) {
        TreeSet<String> communs = new TreeSet<String>(liste);
        communs.retainAll(this.paysLimitrophes);
        return communs.size();
    }

    public String getNomPays() {
        return this.nomPays;
    }

    public TreeSet<String> getPaysLimitrophes() {
        return this.paysLimitrophes;
    }
}