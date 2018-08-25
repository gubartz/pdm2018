package br.edu.ifsp.hto.listaespera.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Essa Classe representa um registro de ListaEspera
 */
//TODO(10) implementar a interface Parcelable e os métodos necessários
public class ListaEsperaEntry implements Parcelable{
    private int id;

    @SerializedName("nome_reserva")
    private String nomeReserva;

    @SerializedName("total_pessoas")
    private int totalPessoas;

    @SerializedName("data_cadastro")
    private Date dataCadastro;

    public ListaEsperaEntry(int id, String nomeReserva, int totalPessoas, Date dataCadastro) {
        this.id = id;
        this.nomeReserva = nomeReserva;
        this.totalPessoas = totalPessoas;
        this.dataCadastro = dataCadastro;
    }

    public ListaEsperaEntry(String nomeReserva, int totalPessoas) {
        this.nomeReserva = nomeReserva;
        this.totalPessoas = totalPessoas;
    }

    protected ListaEsperaEntry(Parcel in) {
        id = in.readInt();
        nomeReserva = in.readString();
        totalPessoas = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nomeReserva);
        dest.writeInt(totalPessoas);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListaEsperaEntry> CREATOR = new Creator<ListaEsperaEntry>() {
        @Override
        public ListaEsperaEntry createFromParcel(Parcel in) {
            return new ListaEsperaEntry(in);
        }

        @Override
        public ListaEsperaEntry[] newArray(int size) {
            return new ListaEsperaEntry[size];
        }
    };

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
