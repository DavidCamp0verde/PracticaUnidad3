/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTabla;

import Controlador.Grafo.GrafoNoDirigidoEtiquetado;
import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.EstacionBus;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author David Campoverde
 */
public class ModeloTablaBusquedas extends AbstractTableModel{
    private ListaEnlazada lista = new ListaEnlazada();
    private GrafoNoDirigidoEtiquetado<EstacionBus> grafo;
    
    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }
    
    @Override
    public String getColumnName(int column) {
        return "Recorrido";

    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Integer aux = null;
        try {
            aux = (Integer)lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getStackTrace());
        }
        
        switch(columnIndex) {
            case 0: return grafo.obtenerEtiqueta(aux);
            default:return null;
        }
    }
    
    public ListaEnlazada getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada lista) {
        this.lista = lista;
    }

    public GrafoNoDirigidoEtiquetado<EstacionBus> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<EstacionBus> grafo) {
        this.grafo = grafo;
    }
    
    
    
    
    
}
