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
public class ModeloTablaDijkstra extends AbstractTableModel {
    private GrafoNoDirigidoEtiquetado<EstacionBus> grafo;
    private ListaEnlazada lista = new ListaEnlazada();
    
    @Override
    public int getRowCount() {
        return grafo.numVertices();
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Estación";
            case 1: return "Tiempo estimado";
            default:return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        EstacionBus estacion = null;
        Double aux = 0.0;
        try {
            estacion = grafo.obtenerEtiqueta(rowIndex+1);
            aux = (Double) lista.obtener(rowIndex);
        } catch (Exception e) {
        }
        
        switch(columnIndex) {
            case 0: return estacion.getNombre();
            case 1: return aux;
            default:return null;
        }
    }
    
    public GrafoNoDirigidoEtiquetado<EstacionBus> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<EstacionBus> grafo) {
        this.grafo = grafo;
    }

    public ListaEnlazada getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada lista) {
        this.lista = lista;
    }
    
    
}
