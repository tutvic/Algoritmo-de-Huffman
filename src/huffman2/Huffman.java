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
public class Huffman {

    private String mensaje;
    private String resultado;
    private Lista camino;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Huffman(String msg) {
        mensaje = msg;
        camino = new Lista();
        resultado = "";
    }

    public Lista ToNodos() {
        Lista l = new Lista();
        for (int i = 0; i < mensaje.length(); i++) {
            l.insertarFinal((mensaje.charAt(i)));
        }
        return l;

    }

    public ListaArboles cuentaLetras(Lista l) {
        ListaArboles la = new ListaArboles();
        Nodo aux = l.getInicio();
        while (aux != null) {
            Integer x = l.eliminarValor(aux.getDato());
            NodoArbol nuevo = new NodoArbol(aux.getDato(), x);
            Arbol a = new Arbol(nuevo);
            la.insertarOrdenado(a);
            aux = l.getInicio();
        }
        return la;
    }

    public NodoArbol uneNodos(NodoListaArbol a, NodoListaArbol b) {
        NodoArbol c = new NodoArbol('\u0000',
                ((a.getDato().getRaiz().getDato()) + (b.getDato().getRaiz()
                .getDato())));
        c.setIzq(a.getDato().getRaiz());
        c.setDer(b.getDato().getRaiz());
        return c;
    }

    public ListaArboles juntaNodo(ListaArboles l) {
        NodoListaArbol aux = l.getInicio();
        NodoListaArbol aux2 = null;
        while ((aux != null) && (aux.getSiguiente() != null)) {
            l.setInicio(aux.getSiguiente());
            aux.setSiguiente(null);
            aux2 = l.getInicio();
            l.setInicio(aux2.getSiguiente());
            aux2.setSiguiente(null);
            NodoArbol nuevo = uneNodos(aux, aux2);
            Arbol a = new Arbol(nuevo);
            l.insertarOrdenado(a);
            aux = l.getInicio();
        }
		// Arbol a=l.getInicio().getDato();
        // a.enOrder(a.getRaiz());
        // a.encuentraCamino(a.getRaiz(), "");
        // System.out.println("dato: "+l.getInicio().getDato().getRaiz().getDato());
        // System.out.println("letra: "+l.getInicio().getDato().getRaiz().getLetra());
        return l;
    }

    public void recorrer2(Lista l) {
        Nodo n = l.getInicio();
        while (n != null) {
            System.out.print(n.getDato() + n.getCamino() + "->");
            n = n.getSiguiente();
        }
    }

    public String eliminarUltimo(String re) {
        String cadena = "";
        for (int i = 0; i < re.length() - 1; i++) {
            cadena += re.charAt(i);
        }
        return cadena;
    }

    public void encuentraCamino(NodoArbol r, String c) {
        // Lista camino = new Lista();
        resultado += c;
        if (r != null) {
            if (r.getLetra() != '\u0000') { // si es una letra
                camino.insertarFinal(r.getLetra(), resultado);
            }
            encuentraCamino(r.getIzq(), "0");
            if (r.getIzq() != null) {
                resultado = eliminarUltimo(resultado);
            }
            encuentraCamino(r.getDer(), "1");
            if (r.getDer() != null) { // si no es un nodo hoja
                resultado = eliminarUltimo(resultado);
            }
        } else {
            resultado = eliminarUltimo(resultado);
        }
    }

    public Lista regresaCaminos() { // retornamos la lista que contiene los
        // caminos de cada caracter
        return camino;
    }

    public String busca(char s, Lista l) {
        String camino = "";
        Nodo aux = l.getInicio();
        while (aux != null) {
            if (aux.getDato() == s) {
                camino = aux.getCamino();
            }
            aux = aux.getSiguiente();
        }
        return camino;
    }

    public String convierte(Lista camino) {
        String c = "";
        for (int i = 0; i < mensaje.length(); i++) {
            c = c + busca(mensaje.charAt(i), camino);
        }
        return c;
    }

    public char toAscii(String s) {// obtiene un codigo de 8 o menor
        String ascii = "";
        int numero = 0;
        int contador = 0;
        for (int i = 0; i < s.length(); i++) {// binario es string
            if (contador <= 8) {
                ascii = ascii + s.charAt(i);
                numero = Integer.parseInt(ascii, 2);
                if (contador == 8) {
                    ascii = "";
                    contador = 0;
                }
            }
        }
        return (char) numero;
    }

    public void encripta(String codigoHuffman) {
        String bites = "";
        String codigo = "";
        char c;
        int contador = 0;
        if (codigoHuffman.length() >= 8) {
            for (int i = 0; i < codigoHuffman.length(); i++) {
                if (contador <= 8) {
                    bites = bites + codigoHuffman.charAt(i);
                    contador++;
                    if (contador == 8) {
                        c = toAscii(bites);
                        codigo = codigo + c;
                        contador = 0;
                        bites = "";
                    }
                }
            }
        } else {
            c = toAscii(codigoHuffman);
            codigo = codigo + c;
        }
        System.out.println("Codigo Encriptado " + codigo);
    }

    public void encripta2(String codigoHuffman) {
        String bites = "";
        String codigo = "";
        char c;
        int contador = 0;
        for (int i = 0; i < codigoHuffman.length(); i++) {
            bites = bites + codigoHuffman.charAt(i);
            contador++;
            if (contador == 8) {
                c = toAscii(bites);
                codigo = codigo + c;
                contador = 0;
                bites = "";
            }
        }
        System.out.println("Codigo Encriptado " + codigo);
    }

    public void desencripta() {

    }

    public static void main(String args[]) {
        Huffman h = new Huffman("Victor Alfonso Vargas Martinez");
        Lista l = h.ToNodos();
        ListaArboles la = h.cuentaLetras(l);
        ListaArboles l2 = h.juntaNodo(la);
		// System.out.println(l2.getInicio().toString());
        // Arbol a= new Arbol();
        // a.enOrder(l2.getInicio().getDato().getRaiz());
        h.encuentraCamino(l2.getInicio().getDato().getRaiz(), "");
        Lista listaCaminos = h.regresaCaminos();
        String x = h.convierte(listaCaminos);
        System.out.println(x);
		// char a=h.toAscii("1001000");
        // System.out.println(a);
        h.encripta(x);

    }

}
