/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.ModeloTabla;

import javax.swing.table.AbstractTableModel;
import Controlador.Arbol.Arbol;
import Controlador.Arbol.NodoArbol;
import Controlador.ListaEnlazada.ListaEnlazada;

/**
 *
 * @author David Campoverde
 */
public class ModeloTablaArbolBinario extends AbstractTableModel {

    private Arbol arbol;

    @Override
    public int getRowCount() {
        return arbol.getNiveles().getSize();
    }

    @Override
    public int getColumnCount() {
        return arbol.getNro_nodos();
    }

    @Override
    public String getColumnName(int column) {
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return arbol.getNiveles().obtener(0).obtener(0).getDato().toString();
//            for (int i = 0; i < arbol.getNiveles().obtener(i).getSize(); i++) {
//                ListaEnlazada<NodoArbol> aux = arbol.getNiveles().obtener(i);
//                aux.imprimir();
//                for(int j = 0; j < aux.getSize(); j++){
//                    NodoArbol nodo = aux.obtener(j);
//                    setValueAt(nodo.getDato().toString(), rowIndex/2, columnIndex);
//                }
//            }
        } catch (Exception e) {
//            System.out.println(e);
//            System.out.println(e.getStackTrace()[0].getLineNumber()+" "+e.getStackTrace()[0].getClassName());
        }
        return "";
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

}
