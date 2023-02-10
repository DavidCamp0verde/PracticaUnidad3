/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Utilidades;

import Controlador.EstacionBusController;
import Controlador.Grafo.Grafo;
import Controlador.ListaEnlazada.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazada.Excepciones.PosicionNoEncontradaException;
import Controlador.ListaEnlazada.ListaEnlazada;
import Modelo.EstacionBus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import javax.swing.JComboBox;

/**
 *
 * @author David Campoverde
 */
public class Utilidades {
    
    public static JComboBox cargarComboEstaciones(JComboBox cbx, EstacionBusController ec){
        cbx.removeAllItems();
        for(int i = 0; i < ec.getEstaciones().getSize(); i++){
            try {
                cbx.addItem(ec.getEstaciones().obtener(i).toString());
            } catch (Exception e) {
            }
        }
        return cbx;
    }
    
    public static void guardarEstacion(EstacionBus estacion) {
        ListaEnlazada<EstacionBus> lista = listarEstaciones();
        lista.insertar(estacion);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("estaciones.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    public static ListaEnlazada<EstacionBus> listarEstaciones() {
        ListaEnlazada<EstacionBus> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("estaciones.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
            Type tipoLista = new TypeToken<ListaEnlazada<EstacionBus>>() {
            }.getType();
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }
    
    public static void modificarEstacion(EstacionBus estacion, Integer posicion) throws PosicionNoEncontradaException {
        ListaEnlazada<EstacionBus> lista = listarEstaciones();
        lista.modificarPosicion(estacion, posicion);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("estaciones.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    
    public static void eliminarEstacion(Integer posicion) throws PosicionNoEncontradaException, ListaVaciaExcepcion {
        ListaEnlazada<EstacionBus> lista = listarEstaciones();
        lista.eliminar(posicion);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("estaciones.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }

    
}
