/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Grafo;

import Controlador.ListaEnlazada.ListaEnlazada;

/**
 *
 * @author David Campoverde
 */
public abstract class Grafo {

    /**
     * Es el numero de vertices del grafo
     *
     * @return
     */
    public abstract Integer numVertices();

    public abstract Integer numAristas();

    public abstract Boolean existeArista(Integer origen, Integer destino) throws Exception;

    public abstract Double pesoArista(Integer origen, Integer destino);

    public abstract void insertarArista(Integer origen, Integer destino) throws Exception;

    public abstract void insertarArista(Integer origen, Integer destino, Double peso) throws Exception;

    public abstract ListaEnlazada<Adyacencia> adyacentes(Integer vertice);

    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer("");
        try {
            for (int i = 1; i <= numVertices(); i++) {
                grafo.append("Vertice " + String.valueOf(i));
                ListaEnlazada<Adyacencia> lista = adyacentes(i);
                for (int j = 0; j < lista.getSize(); j++) {

                    Adyacencia a = lista.obtener(j);
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append("-- vertice destino: " + a.getDestino() + " -- SP");
                    } else {
                        grafo.append("-- vertice destino: " + a.getDestino() + " -- Peso: " + a.getPeso());
                    }
                }
                grafo.append("\n");
            }
        } catch (Exception e) {
            grafo.append(e.getMessage());
        }
        return grafo.toString();
    }

    public ListaEnlazada caminoMinimo(Integer origen, Integer destino) throws Exception {
        ListaEnlazada camino = new ListaEnlazada();
        if (estaConectado()) {
            ListaEnlazada pesos = new ListaEnlazada();
            Boolean finalizar = false;
            Integer inicial = origen;
            camino.insertar(inicial);
            while (!finalizar) {
                ListaEnlazada<Adyacencia> adyacencia = adyacentes(inicial);
                Double peso = 10000000.0;
                int T = -1;
                for (int i = 0; i < adyacencia.getSize(); i++) {
                    Adyacencia ad = adyacencia.obtener(i);
                    if (!estaEnCamino(camino, destino)) {
                        Double pesoArista = ad.getPeso();
                        if (destino.intValue() == ad.getDestino().intValue()) {
                            T = ad.getDestino();
                            peso = pesoArista;
                            break;
                        } else if (pesoArista < peso) {
                            T = ad.getDestino();
                            peso = pesoArista;
                        }
                    }

                }
                pesos.insertar(peso);
                camino.insertar(T);
                inicial = T;
                if (destino.intValue() == inicial.intValue()) {
                    finalizar = true;
                }
            }
        } else {
            throw new Exception("Grafo no conectado");
        }
        return camino;
    }

    private Boolean estaConectado() {
        Boolean band = true;
        for (int i = 1; i <= numVertices(); i++) {
            ListaEnlazada<Adyacencia> lista = adyacentes(i);
            if (lista.estaVacia() || lista.getSize() == 0) {
                band = false;
                break;
            }
        }
        return band;
    }

    private Boolean estaEnCamino(ListaEnlazada<Integer> lista, Integer vertice) throws Exception {
        Boolean band = false;
        for (int i = 0; i < lista.getSize(); i++) {
            if (lista.obtener(i).intValue() == vertice.intValue()) {
                band = true;
                break;
            }
        }
        return band;
    }

    //enviar nro nodo -1 xd
    public ListaEnlazada caminoMinimoDijkstra(Integer origen) throws Exception {
        ListaEnlazada caminoDijkstra = new ListaEnlazada();
        Integer s = origen;
        Integer n = this.numVertices();
        Double[] D = new Double[n];  //guarda los costos mínimos de cada vertice
        Boolean[] F = new Boolean[n]; // si el vertice ya fue visitado
        Integer[] ultimo = new Integer[n];
        Double[][] pesos = pesosGrafo(this);
//        System.out.println("\t1\t2\t3\t4\t5");
//        for(int i = 0; i < n; i++){
//            System.out.print(i+1+"\t");
//            for(int j = 0; j < n; j++){
//                System.out.print(pesos[i][j]+"\t");
//            }
//            System.out.println("\n");
//        }
        for (int i = 0; i < n; i++) {
            F[i] = false;
            D[i] = pesos[s][i];
            ultimo[i] = s;
            System.out.println("nodo " + (i + 1) + ": " + F[i] + " - " + D[i] + " - " + ultimo[i]);
        }
        F[s] = true;
        D[s] = 0.0;
        for (int i = 0; i < n; i++) {
//            System.out.println("nodo "+(i+1)+": "+F[i]+" - "+D[i]+" - "+ultimo[i]);
            Integer v = minimo(n, F, D);
            F[v] = true;
            for (int w = 0; w < n; w++) {
                if (!F[w]) {
//                    System.out.println((D[v] +" + "+ pesos[v][w])+" < "+D[w]);
                    if ((D[v] + pesos[v][w]) < D[w]) {
//                        System.out.println((D[v] +" + "+ pesos[v][w])+" < "+D[w]);
                        D[w] = D[v] + pesos[v][w];
                        ultimo[w] = v;
                        caminoDijkstra.insertar(D[w]);
                    }
                }
            }
        }
        return caminoDijkstra;
    }

    private Integer minimo(Integer n, Boolean[] F, Double[] D) {
        Double mx = 10000000.0;
        Integer v = 1;
        for (int j = 0; j < n; j++) {
            if (!F[j] && (D[j] <= mx)) {
//                System.out.println(j);
//                System.out.println(!F[j]+" - "+D[j]+" <= "+mx);
                mx = D[j];
                v = j;
////                System.out.println("mx: "+mx+" - v: "+v);
            }
        }
        System.out.println(v);
        return v;
    }

    private Double[][] pesosGrafo(Grafo grafo) throws Exception {
        Integer vertices = grafo.numVertices();
        Double[][] matriz = new Double[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
//                System.out.println((i+1)+" "+(j+1));
                Double peso = grafo.pesoArista(i + 1, j + 1);
                matriz[i][j] = peso;
//                System.out.println(matriz[i][j]);
            }
        }
        return matriz;
    }

    public void caminoMinimoFloyd() throws Exception {
        ListaEnlazada caminoFloyd = new ListaEnlazada();
        Double[][] pesos = pesosGrafo(this);
        Integer n = this.numVertices();
        Integer[][] traza = new Integer[n][n];
        Double[][] d = new Double[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = pesos[i][j];
                traza[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            d[i][i] = 0.0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if((d[i][k] + d[k][j]) < d[i][j]){
                        d[i][j] = d[i][k] + d[k][j];
                        System.out.println(d[i][k]+" + "+d[k][j]+" < "+d[i][j]);
                        traza[i][j]= k;
                    }
                }
            }
        }
        System.out.println("\t1\t2\t3\t4\t5");
        for(int i = 0; i < n; i++){
            System.out.print(i+1+"\t");
            for(int j = 0; j < n; j++){
                System.out.print(traza[i][j]+"\t");
            }
            System.out.println("\n");
        }
//        return caminoFloyd;
    }

}
