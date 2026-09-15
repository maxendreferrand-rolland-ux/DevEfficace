/*
 * TP CLASSE PILE - PREMIER PROGRAMME DE TEST
 * -------------------------------------------
 *
 * teste les méthodes de la classe PileEntier
 * TestPile.java                                                09/26
 */
package org.example;

/**
 * Premier programme de test de la classe PileEntier.
 * Suit les étapes demandées dans les questions 2 et 3 du sujet.
 */
public class TestPile {

    /**
     * Fonction principale pour lancer les tests
     * @param args paramètre non utilisé
     */
    public static void main(String[] args) {

        try {
            /* 1) créer une pile de capacité 5 */
            PileEntier p = new PileEntier(5);
            System.out.println("Pile créée avec capacité 5 : " + p);

            /* 2) vérifier que la pile ainsi créée est vide */
            System.out.println("La pile est vide ? " + p.estVide());

            /* 3) empiler 3 entiers quelconques dans cette pile */
            p.empiler(10);
            p.empiler(20);
            p.empiler(30);
            System.out.println("Après avoir empilé 10, 20, 30 : " + p);

            /* 4) vérifier que la pile n'est pas vide */
            System.out.println("La pile est vide ? " + p.estVide());

            /* 5) afficher à l'écran la valeur située au sommet de la pile */
            System.out.println("Sommet de la pile : " + p.sommet());

            /* 6) afficher à l'écran le contenu de la pile */
            System.out.println("Contenu de la pile : " + p);

            /* 7) dépiler l'élément sommet */
            p.depiler();
            System.out.println("Après avoir dépilé l'élément sommet");

            /* 8) afficher à nouveau le contenu de la pile */
            System.out.println("Contenu de la pile : " + p);

            /* 9) empiler 3 entiers quelconques dans la pile */
            p.empiler(40);
            p.empiler(50);
            p.empiler(60);
            System.out.println("Après avoir empilé 40, 50, 60 : " + p);

            /* 10) vérifier qu'elle est pleine */
            System.out.println("La pile est pleine ? " + p.estPleine());

            /* 11) empiler un élément dans la pile (doit provoquer une exception) */
            p.empiler(70);

        } catch (RuntimeException e) {
            System.out.println("Une erreur s'est produite pendant les tests.");
        }

        /* question 3 : tester les erreurs de capacité invalide et pile vide */

        /* 1) créer une pile avec une capacité invalide */
        try {
            PileEntier pInvalide = new PileEntier(-3);
        } catch (RuntimeException e) {
            System.out.println("Erreur : capacité invalide, impossible de créer la pile.");
        }

        /* 2) dépiler alors que la pile est vide */
        try {
            PileEntier pVide = new PileEntier(3);
            pVide.depiler();
        } catch (RuntimeException e) {
            System.out.println("Erreur : impossible de dépiler, la pile est vide.");
        }

        /* 3) utiliser l'opération sommet sur une pile vide */
        try {
            PileEntier pVide2 = new PileEntier(3);
            pVide2.sommet();
        } catch (RuntimeException e) {
            System.out.println("Erreur : impossible de consulter le sommet, la pile est vide.");
        }
    }
}