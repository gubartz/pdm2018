package br.edu.ifsp.hto.listaespera.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Essa Classe representa um registro de ListaEspera
 */
public class ListaEsperaEntry {
    //TODO(1) Adicionar os seguintes atributos:
        //int id
        //String nomeReserva - Utilizar anotação @SerializedName("nome_reserva")
        //int totalPessoas - @SerializedName("total_pessoas")
        //java.util.Date dataCadastro - @SerializedName("data_cadastro")
    //TODO(2) Criar os métodos setters and getters correspondentes
    private int id;

    @SerializedName("nome_reserva")
    private String nomeReserva;

    @SerializedName("total_pessoas")
    private int totalPessoas;

    @SerializedName("data_cadastro")
    private Date dataCadastro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeReserva() {
        return nomeReserva;
    }

    public void setNomeReserva(String nomeReserva) {
        this.nomeReserva = nomeReserva;
    }

    public int getTotalPessoas() {
        return totalPessoas;
    }

    public void setTotalPessoas(int totalPessoas) {
        this.totalPessoas = totalPessoas;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
