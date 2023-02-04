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
        GrafoNoDirigidoEtiquetado gde = new GrafoNoDirigidoEtiquetado(5, String.class);
//        System.out.println(gde.toString());
        gde.etiquetar(1, "Bosco");
        gde.etiquetar(2, "Soto");
        gde.etiquetar(3, "Pe");
        gde.etiquetar(4, "Intriago");
        gde.etiquetar(5, "Mercurio");
        try {
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(5), gde.obtenerEtiqueta(2), 10.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(2), 25.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(5), 1.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(4), -10.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(2), gde.obtenerEtiqueta(3), 55.0);
            gde.insertarAristaEtiquetada(gde.obtenerEtiqueta(1), gde.obtenerEtiqueta(4), 1000.0);
//            System.out.println(gde.toString());
            
//            gde.caminoMinimo(1, 5).imprimir();
            new FrmGrafo(null, true, gde, 1).setVisible(true);
            
        } catch (Exception e) {
        }
    }

}
