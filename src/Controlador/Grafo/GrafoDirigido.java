/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Grafo;

import Controlador.Grafo.Exception.VerticeOfSizeException;
import Controlador.ListaEnlazada.ListaEnlazada;

/**
 *
 * @author David Campoverde
 */
public class GrafoDirigido extends Grafo{
    protected Integer  numVertices;
    protected Integer  numAristas;
    protected ListaEnlazada<Adyacencia> listaAdyacente[];

    public GrafoDirigido(Integer numVertices) {
        this.numVertices = numVertices;
        numAristas = 0;
        listaAdyacente = new ListaEnlazada[numVertices+1];
        for(int i = 0; i <= this.numVertices; i++){
            listaAdyacente[i] = new ListaEnlazada<>();
        }
    }
    
    @Override
    public Integer numVertices(){
        return numVertices;
    }
    
    @Override
    public Integer numAristas(){
        return numAristas;
    }

    @Override
    public Boolean existeArista(Integer origen, Integer destino) throws Exception {
        Boolean existe = false;
        if(origen.intValue() <= numVertices && destino.intValue() <= numVertices){
            ListaEnlazada<Adyacencia> lista = listaAdyacente[origen];
            for(int i = 0; i < lista.getSize(); i++){
                Adyacencia a = lista.obtener(i);
                if(a.getDestino().intValue() == destino){
                    existe = true;
                    break;
                }
            }
            
        }else{
            throw new VerticeOfSizeException();
        }
        return existe;
    }

    @Override //Hay algo que no está bien pipipipi
    public Double pesoArista(Integer origen, Integer destino) {
        Double peso = 0.0; //Not a Number xd (valor por defecto)
        try {
            if(existeArista(origen, destino)){
                ListaEnlazada<Adyacencia> adyacentes = listaAdyacente[origen];
                for(int i = 0; i < adyacentes.getSize(); i++){
                    Adyacencia a = adyacentes.obtener(i);
                    if(a.getDestino().intValue() == destino.intValue()){
                        peso = a.getPeso();
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
        return peso;
    }

    @Override
    public void insertarArista(Integer origen, Integer destino) throws Exception{
        insertarArista(origen, destino, Double.NaN);
    }

    @Override
    public void insertarArista(Integer origen, Integer destino, Double peso) throws Exception{
        try {
            if(origen.intValue() <= numVertices && destino.intValue() <= numVertices){
                if(!existeArista(origen, destino)){
                    numAristas++;
                    listaAdyacente[origen].insertar(new Adyacencia(destino, peso));
                }
            }else{
                throw new VerticeOfSizeException();
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }

    @Override
    public ListaEnlazada<Adyacencia> adyacentes(Integer vertice) {
        return listaAdyacente[vertice];
    }
    
    
    
}
