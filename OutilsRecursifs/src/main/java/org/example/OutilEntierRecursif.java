package org.example;

public class OutilEntierRecursif {
    public static int fibonacci(int n) {
        if (n< 0){
            throw new IllegalArgumentException("Fibonnacci non défini pour nb négatif");
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void initialiser(int[] tableau, int valeur) {
        initialiser(tableau, valeur, 0);
    }
    private static void initialiser(int[] tableau, int valeur, int indice) {
        if (indice < tableau.length) {
            tableau[indice] = valeur;
            initialiser(tableau, valeur, indice + 1);
        }
    }

    public static int ackermann(int m, int n) {
        if (m < 0 || n < 0 || (m == 0 && n == 0)) {
            return -1;
        }
        if (m == 0) {
            return n + 1;
        }
        if (n == 0) {
            return ackermann(m - 1, 1);
        }
        return ackermann(m - 1, ackermann(m, n - 1));
    }

    public static void main (String[] args){
        int[] tableau = new int[10];
        initialiser(tableau, -1);
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(tableau[i] + " ");
        }
        System.out.println();
        System.out.println("Ack(0,4) = " + ackermann(0, 4));
        System.out.println("Ack(4,0) = " + ackermann(4, 0));
        System.out.println("Ack(3,4) = " + ackermann(3, 4));
        System.out.println("Ack(0,0) = " + ackermann(0, 0));
    }


}
