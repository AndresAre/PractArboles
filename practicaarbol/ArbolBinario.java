/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarbol;

/**
 *
 * @author Andres Arenas
 */
public class ArbolBinario {
    NodoArbol raiz;
    public ArbolBinario(){
        raiz=null;
    }
    //Metodo para insertar un Nodo en el Arbol
    public void agregarNodo(int d, String nom){
        NodoArbol nuevo = new NodoArbol(d,nom);
        if(raiz==null){
            raiz=nuevo;
        }else{
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while(true){
                padre = auxiliar;
                if(d<auxiliar.dato){
                    auxiliar = auxiliar.hijoIzquierda;
                    if(auxiliar==null){
                        padre.hijoIzquierda=nuevo;
                        return;
                    }
                }else{
                    auxiliar = auxiliar.hijoDerecha;
                    if(auxiliar==null){
                        padre.hijoDerecha = nuevo;
                        return;
                    }
                }
            }
        }
    }
    
    //Metodo para saber cuando el arbol esta vacio
    public boolean estaVacio(){
        return raiz==null;
    }
    //Metodo para recorrer el Arbol InOrden
    public void inOrden(NodoArbol r){
        if(r!=null){
            inOrden(r.hijoIzquierda);
            System.out.println(r.dato+", ");
            inOrden(r.hijoDerecha);
        }
    }
    //Metodo para recorrer el Arbol PreOrden
    public void preOrden(NodoArbol r){
        if(r!=null){
            System.out.println(r.dato+", ");
            preOrden(r.hijoIzquierda);
            preOrden(r.hijoDerecha);
        }
    }
    //Metodo para recorrer el Árbol PostOrden
    public void postOrden(NodoArbol r){
        if(r!=null){
            postOrden(r.hijoIzquierda);
            postOrden(r.hijoDerecha);
            System.out.println(r.dato+", ");
        }
    }
    //Metodo para buscar un Nodo en el Arbol
    public NodoArbol buscarNodo(int d){
        NodoArbol aux = raiz;
        while(aux.dato!=d){
            if(d<aux.dato){
                aux = aux.hijoIzquierda;
            }else{
                aux = aux.hijoDerecha;
            }
            if(aux==null){
                return null;
            }
        }
        return aux;
    }
    //Metodo para eliminar un Nodo del Arbol
    public boolean eliminar(int d){
        NodoArbol auxiliar=raiz;
        NodoArbol padre= raiz;
        boolean esHijoIzq=true;
        while(auxiliar.dato!=d){
            padre=auxiliar;
            if(d<auxiliar.dato){
                esHijoIzq=true;
                auxiliar = auxiliar.hijoIzquierda;
            }else{
                esHijoIzq=false;
                auxiliar = auxiliar.hijoDerecha;
            }
            if(auxiliar==null){
                return false;
            }
        }
        if(auxiliar.hijoIzquierda==null && auxiliar.hijoDerecha==null){
            if(auxiliar==raiz){
                raiz=null;
            }else if(esHijoIzq){
                padre.hijoIzquierda=null;
            }else{
                padre.hijoDerecha=null;
            }
        }else if(auxiliar.hijoDerecha==null){
            if(auxiliar==raiz){
                raiz=auxiliar.hijoIzquierda;
            }else if(esHijoIzq){
                padre.hijoIzquierda=auxiliar.hijoIzquierda;
            }else{
                padre.hijoDerecha=null;
            }
        }else if(auxiliar.hijoIzquierda==null){
            if(auxiliar==raiz){
                raiz=auxiliar.hijoDerecha;
            }else if(esHijoIzq){
                padre.hijoIzquierda=auxiliar.hijoDerecha;
            }else{
                padre.hijoDerecha=auxiliar.hijoIzquierda;
            }
        }else{
            NodoArbol reemplazo = obtenerNodoReemplazo(auxiliar);
            if(auxiliar==raiz){
                raiz = reemplazo;
            }else if(esHijoIzq){
                padre.hijoIzquierda=reemplazo;
            }else{
                padre.hijoDerecha=reemplazo;
            }
            reemplazo.hijoIzquierda=auxiliar.hijoIzquierda;
        }
        return true;
    }
    //Metodo encargado de devolvernos el nodo Reemplazo
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp){
        NodoArbol reemplazarPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol auxiliar = nodoReemp.hijoDerecha;
        while(auxiliar!=null){
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierda;
        }
        if(reemplazo!=nodoReemp.hijoDerecha){
            reemplazarPadre.hijoIzquierda= reemplazo.hijoDerecha;
            reemplazo.hijoDerecha = nodoReemp.hijoDerecha;
        }
        System.out.println("El Nodo Reemplazo es "+reemplazo);
        return reemplazo;
    }
}
