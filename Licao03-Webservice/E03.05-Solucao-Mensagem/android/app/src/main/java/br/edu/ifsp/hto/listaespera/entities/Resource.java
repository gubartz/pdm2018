package br.edu.ifsp.hto.listaespera.entities;

import androidx.annotation.Nullable;

//TODO(1) Colocar um generic T na declaração da classe
public class Resource<T> {
    //TODO(2) Definir um atributo final do tipo generic T chamado data
    @Nullable public final T data;
    //TODO(3) Definir um atributo final do tipo String chamado message
    @Nullable public final String message;

    //TODO(4) Definir um construtor com os atributos de classe
    public Resource(T data, String message) {
        this.data = data;
        this.message = message;
    }
}
