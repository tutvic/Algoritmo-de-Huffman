/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman2;

/**
 *
 * @author Victor
 */
public class NodoArbol {

    private Integer dato;
    private char letra;
    private NodoArbol izq;
    private NodoArbol der;

    public Integer getDato() {
        return dato;
    }

    public void setDato(Integer dato) {
        this.dato = dato;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public NodoArbol(char l, Integer d) {
        letra = l;
        dato = d;
        izq = null;
        der = null;
    }

    @Override
    public String toString() {
        return letra + ":" + dato;
    }

}
