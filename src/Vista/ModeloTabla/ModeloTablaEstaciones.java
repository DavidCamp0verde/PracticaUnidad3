/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTabla;

import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.EstacionBus;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author David Campoverde
 */
public class ModeloTablaEstaciones extends AbstractTableModel{
    private ListaEnlazada<EstacionBus> estaciones;
    
    @Override
    public int getRowCount() {
        return estaciones.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Longitud";
            case 3: return "Latitud";
            default:return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        EstacionBus eb = null;
        try {
            eb = estaciones.obtener(rowIndex);
        } catch (Exception e) {
        }
        
        switch(columnIndex){
            case 0: return eb.getId();
            case 1: return eb.getNombre();
            case 2: return eb.getLongitud().toString();
            case 3: return eb.getLatitud().toString();
            default:return null;
        }
    }
    
    public ListaEnlazada<EstacionBus> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(ListaEnlazada<EstacionBus> estaciones) {
        this.estaciones = estaciones;
    }
    
    
}
