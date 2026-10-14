package org.example;

public class FigureGeometrique {

    public static void blanc(int n) {
        if (n > 0) {
            System.out.print(' ');
            blanc(n - 1);
        }
    }
    public static void main (String[] args){
        triangleIsocele(4);

    }

    public static void etoile(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Nombre non positif ");
        }
        if (n == 0) {
            System.out.println();
        }
        if (n>0){
            System.out.print('*');
            etoile(n-1);
        }
    }
    public static void triangle(int n){
        if (n<0){
            throw new IllegalArgumentException("Nombre non positif ");
        }
        if (n>0){
            triangle(n-1);
            etoile(n);
        }
    }
    public static void triangleIsocele(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Nombre non positif ");
        }
        ligneIsocele(n, n);
    }
    private static void ligneIsocele(int ligne, int hauteur) {
        if (ligne > 0) {
            ligneIsocele(ligne - 1, hauteur);
            blanc(hauteur - ligne);
            etoile(2 * ligne - 1);
        }
    }
}
