/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarbol;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class PracticaArbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion=0, elm;
        String nombre;
        ArbolBinario arbol = new ArbolBinario();
        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un Nodo\n"
                        + "2. Recorrer el Arbol InOrden\n"
                        + "3. Recorrer el Arbol PreOrden\n"
                        + "4. Recorrer el Arbol PostOrden\n"
                        + "5. Buscar un Nodo del Arbol\n"
                        + "6. Eliminar un Nodo del Arbol\n"
                        + "7. Salir\n"
                        + "Elige una Opción...","Arboles Binarios",JOptionPane.QUESTION_MESSAGE));
                switch(opcion){
                    case 1:
                        elm = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el Numero del Nodo"
                                , "Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,
                                "Ingresa el Nombre del Nodo..."
                                , "Agregando Nodo", JOptionPane.QUESTION_MESSAGE);
                        arbol.agregarNodo(elm, nombre);
                        break;
                    case 2:
                        if(!arbol.estaVacio()){
                            System.out.println();
                            arbol.inOrden(arbol.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null, "El Árbol esta vacio", "!Cuidado!",JOptionPane.INFORMATION_MESSAGE);        
                        }
                        break;
                    case 3:
                        if(!arbol.estaVacio()){
                            System.out.println();
                            arbol.preOrden(arbol.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null, "El Árbol esta vacio", "!Cuidado!",JOptionPane.INFORMATION_MESSAGE);        
                        }
                        break;
                    case 4:
                        if(!arbol.estaVacio()){
                            System.out.println();
                            arbol.postOrden(arbol.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null, "El Árbol esta vacio", "!Cuidado!",JOptionPane.INFORMATION_MESSAGE);        
                        }
                        break;
                    case 5:
                        if(!arbol.estaVacio()){
                            elm = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el Numero del Nodo Buscado..."
                                , "Buscando Nodo", JOptionPane.QUESTION_MESSAGE));
                            arbol.buscarNodo(elm);
                            if(arbol.buscarNodo(elm)==null){
                                JOptionPane.showMessageDialog(null, "El Nodo no se encuentra en el Árbol", "!Nodo No Encontrado!",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                System.out.println("Nodo Encontrado, sus datos son: "+arbol.buscarNodo(elm));
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El Árbol esta vacio", "!Cuidado!",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        if(!arbol.estaVacio()){
                            elm = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese el Numero del Nodo a Eliminar..."
                                , "Eliminando Nodo", JOptionPane.QUESTION_MESSAGE));
                            arbol.buscarNodo(elm);
                            if(arbol.eliminar(elm)==false){
                                JOptionPane.showMessageDialog(null, "El Nodo no se encuentra en el Árbol", "!Nodo No Encontrado!",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "El Nodo ha sido Eliminado del Árbol", "!Nodo Eliminado!",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El Árbol esta vacio", "!Cuidado!",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicacion finalizada", "Fin",JOptionPane.INFORMATION_MESSAGE);
                       break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
                }    
            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(null, "Error"+ n.getMessage());
            }
        }while(opcion!=7);
    }
    
}
