/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.ModeloTabla;

import Controlador.Grafo.GrafoNoDirigidoEtiquetado;
import Modelo.EstacionBus;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author David Campoverde
 */
public class ModeloTablaFloyd extends AbstractTableModel {

    private GrafoNoDirigidoEtiquetado<EstacionBus> grafo;
    private Integer[][] recorridoFloyd;
    private String[] columnas;

    @Override
    public int getRowCount() {
        return grafo.numVertices();
    }

    @Override
    public int getColumnCount() {
        return grafo.numVertices() + 1;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return columnas[rowIndex + 1];
        } else {
            try {
                recorridoFloyd = grafo.caminoMinimoFloyd();
                if (recorridoFloyd[rowIndex][columnIndex] != 0) {
                    return grafo.obtenerEtiqueta(recorridoFloyd[rowIndex][columnIndex-1]);
                } else {
                    return "--";
                }
            } catch (Exception e) {
            }
        }
        return "";
    }

    private String[] generarColumnas() {
        columnas = new String[grafo.numVertices() + 1];
        columnas[0] = "--V--";
        for (Integer i = 1; i < columnas.length; i++) {
            columnas[i] = grafo.obtenerEtiqueta(i).toString();
        }
        return columnas;
    }

    public GrafoNoDirigidoEtiquetado<EstacionBus> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<EstacionBus> grafo) {
        this.grafo = grafo;
        generarColumnas();
    }

}
