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
public class Nodo {

    private char dato;
    private Nodo siguiente;
    private String camino;

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String getCamino() {
        return camino;
    }

    public void setCamino(String camino) {
        this.camino = camino;
    }

    public Nodo(char d) {
        this.setDato(d);
        this.setSiguiente(null);
    }

    public Nodo(char letra, String camino) {
        this.setDato(letra);
        this.setCamino(camino);
        this.setSiguiente(null);
    }

}
