/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.Grafo.GrafoNoDirigidoEtiquetado;
import Controlador.ListaEnlazada.ListaEnlazada;
import Controlador.Utilidades.Utilidades;
import Modelo.EstacionBus;

/**
 *
 * @author David Campoverde
 */
public class EstacionBusController {
    private GrafoNoDirigidoEtiquetado<EstacionBus> grafo;
    private ListaEnlazada<EstacionBus> estaciones = new ListaEnlazada<>();
    
    public void crearGrafoLista() {
        grafo = new GrafoNoDirigidoEtiquetado<>(estaciones.getSize(), EstacionBus.class);
        grafo.etiquetar(0, new EstacionBus());
        for (int i = 1; i <= estaciones.getSize(); i++) {
            try {
                grafo.etiquetar(i, estaciones.obtener(i - 1));

            } catch (Exception e) {
            }
        }
    }
    
    public Double calcularTiempo(Integer o, Integer d) throws Exception{
        EstacionBus origen = getGrafo().obtenerEtiqueta(o);
        EstacionBus destino = getGrafo().obtenerEtiqueta(d);
        Double distancia = Utilidades.calcularDistancia(origen.getLatitud(), destino.getLatitud(), origen.getLongitud(), destino.getLongitud());
        Double velocidad = (60*1000)/3600.0;
        return Utilidades.redondear((distancia/velocidad));
    }

    public GrafoNoDirigidoEtiquetado<EstacionBus> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<EstacionBus> grafo) {
        this.grafo = grafo;
    }

    public ListaEnlazada<EstacionBus> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(ListaEnlazada<EstacionBus> estaciones) {
        this.estaciones = estaciones;
    }
    
    
}
