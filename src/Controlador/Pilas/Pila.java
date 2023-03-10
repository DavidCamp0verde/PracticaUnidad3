/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pilas;

import Controlador.ListaEnlazada.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazada.Excepciones.PosicionNoEncontradaException;
import Controlador.ListaEnlazada.ListaEnlazada;
import Controlador.Pilas.Excepciones.PilaLlenaException;
import Controlador.Pilas.Excepciones.PilaVaciaException;

/**
 *
 * @author David Campoverde
 */
public class Pila<E> extends ListaEnlazada<E> {
    private Integer tope;

    public Pila() {
    }

    public Pila(Integer tope) {
        this.tope = tope;
    }
    
    public Boolean estaLleno(){
        return tope == getSize();
    }
    
    public void push(E dato) throws PilaLlenaException{
        if(!estaLleno()){
            insertarCabecera(dato);
        } else throw new PilaLlenaException();
    }
    
    public E pop() throws PilaVaciaException, ListaVaciaExcepcion, PosicionNoEncontradaException{
        if (!estaVacia()){
            E dato = eliminar(0);
            
            return dato;
        } else throw new PilaVaciaException();
    }
    
}
