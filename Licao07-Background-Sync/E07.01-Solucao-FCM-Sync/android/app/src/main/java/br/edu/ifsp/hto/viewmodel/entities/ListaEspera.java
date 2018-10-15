package br.edu.ifsp.hto.viewmodel.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity(tableName = "lista_espera")
public class ListaEspera implements Parcelable{

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nome_reserva")
    private String nomeReserva;

    @ColumnInfo(name = "total_pessoas")
    private int totalPessoas;

    @ColumnInfo(name = "data_cadastro")
    private Date dataCadastro;

    public ListaEspera(int id, String nomeReserva, int totalPessoas, Date dataCadastro) {
        this.id = id;
        this.nomeReserva = nomeReserva;
        this.totalPessoas = totalPessoas;
        this.dataCadastro = dataCadastro;
    }

    @Ignore
    public ListaEspera(String nomeReserva, int totalPessoas, Date dataCadastro) {
        this.nomeReserva = nomeReserva;
        this.totalPessoas = totalPessoas;
        this.dataCadastro = dataCadastro;
    }

    @Ignore
    public ListaEspera(String nomeReserva, int totalPessoas) {
        this.nomeReserva = nomeReserva;
        this.totalPessoas = totalPessoas;
    }

    protected ListaEspera(Parcel in) {
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

    public static final Creator<ListaEspera> CREATOR = new Creator<ListaEspera>() {
        @Override
        public ListaEspera createFromParcel(Parcel in) {
            return new ListaEspera(in);
        }

        @Override
        public ListaEspera[] newArray(int size) {
            return new ListaEspera[size];
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

    public static List<ListaEspera> populateData(){
        //Datas
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 8, 15, 15, 7);
        Date data1 = calendar.getTime();

        calendar.set(2018, 8, 15, 10, 7);
        Date data2 = calendar.getTime();

        calendar.set(2018, 8, 15, 15, 10);
        Date data3 = calendar.getTime();

        calendar.set(2018, 8, 15, 13, 10);
        Date data4 = calendar.getTime();

        return Arrays.asList(
                new ListaEspera("Pedro", 5, data1),
                new ListaEspera("Maria", 8, data2),
                new ListaEspera("José", 3, data3),
                new ListaEspera("Paulo", 2, data4)
        );
    }
}
