/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import Controlador.Grafo.GrafoDirigido;
import Controlador.Grafo.GrafoDirigidoEtiquetado;
import Controlador.Grafo.GrafoNoDirigido;
import Controlador.Grafo.GrafoNoDirigidoEtiquetado;
import Controlador.ListaEnlazada.ListaEnlazada;
import Controlador.Utilidades.Utilidades;
import Vista.FrmGrafo;

/**
 *
 * @author David Campoverde
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        GrafoDirigido gd = new GrafoDirigido(4);
//        GrafoNoDirigido gnd = new GrafoNoDirigido(4);
//        System.out.println("Grafo dirigido");
//        System.out.println(gd);
//        System.out.println("---------------------------------------------------");
//        try {
//            gd.insertarArista(1, 3);
//            gd.insertarArista(1, 2);
//            gd.insertarArista(1, 4);
//            System.out.println(gd);
//            System.out.println("Grafo no dirigido");
//            gnd.insertarArista(4, 2);
//            gnd.insertarArista(4, 1);
//            gnd.insertarArista(4, 3);
//            new FrmGrafozzz(null, true, gnd, 1).setVisible(true);
//            System.out.println(gnd);
//
//        } catch (Exception e) {
//            System.out.println("Error: "+e.getMessage());
//        }
        GrafoNoDirigidoEtiquetado gde = new GrafoNoDirigidoEtiquetado(6, String.class);
//        System.out.println(gde.toString());
        gde.etiquetar(1, "1");
        gde.etiquetar(2, "2");
        gde.etiquetar(3, "3");
        gde.etiquetar(4, "4");
        gde.etiquetar(5, "5");
        gde.etiquetar(6, "6");
        try {
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(5), gde.obtenerEtiqueta(4), 6.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(5), gde.obtenerEtiqueta(2), 4.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(5), gde.obtenerEtiqueta(1), 3.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(2), 5.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(3), 8.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(2), gde.obtenerEtiqueta(4), 1.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(2), 9.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(4), gde.obtenerEtiqueta(6), 2.0);
//            System.out.println(gde.toString());
            
//            gde.caminoMinimo(1, 5).imprimir();
            
            try {
                Integer nodo = 1;
//                ListaEnlazada lista = gde.caminoMinimoDijkstra(nodo-1);
//                System.out.println("Nodo "+(nodo));
//                for(int i = 0; i < lista.getSize(); i++){
//                    System.out.println("al nodo "+(i+1)+", recorrido más corto: "+lista.obtener(i));
//                }
                gde.caminoMinimoFloyd();
            } catch (Exception e) {
                System.out.println("no se pudo pipipi");
            }
            new FrmGrafo(null, true, gde, 1).setVisible(true);
            
        } catch (Exception e) {
        }
    }

}
