
package practicaarbol;

/**
 *
 * @author Andres Arenas
 */
public class NodoArbol {
    int dato;
    String nombre;
    NodoArbol hijoIzquierda, hijoDerecha;
    public NodoArbol(int d, String nom){
        this.dato = d;
        this.nombre = nom;
        this.hijoDerecha = null;
        this.hijoIzquierda = null;
    }
    public String toString(){
        return nombre + " Su dato es "+dato;
    }
}
