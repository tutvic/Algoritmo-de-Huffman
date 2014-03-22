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
public class NodoListaArbol {

    private Arbol dato;
    private NodoListaArbol siguiente;

    public Arbol getDato() {
        return dato;
    }

    public void setDato(Arbol dato) {
        this.dato = dato;
    }

    public NodoListaArbol getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaArbol siguiente) {
        this.siguiente = siguiente;
    }

    public NodoListaArbol(Arbol d) {
        this.setDato(d);
        this.setSiguiente(null);
    }

    @Override
    public String toString() {
        return dato.toString();
    }

}
