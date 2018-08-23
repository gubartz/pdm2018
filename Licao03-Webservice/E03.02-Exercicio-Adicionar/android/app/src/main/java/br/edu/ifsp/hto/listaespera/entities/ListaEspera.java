package br.edu.ifsp.hto.listaespera.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Essa Classe representa um registro de ListaEspera
 */
public class ListaEspera {
    private int id;

    @SerializedName("nome_reserva")
    private String nomeReserva;

    @SerializedName("total_pessoas")
    private int totalPessoas;

    @SerializedName("data_cadastro")
    private Date dataCadastro;

    public ListaEspera(int id, String nomeReserva, int totalPessoas, Date dataCadastro) {
        this.id = id;
        this.nomeReserva = nomeReserva;
        this.totalPessoas = totalPessoas;
        this.dataCadastro = dataCadastro;
    }

    public ListaEspera(String nomeReserva, int totalPessoas) {
        this.nomeReserva = nomeReserva;
        this.totalPessoas = totalPessoas;
    }

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
