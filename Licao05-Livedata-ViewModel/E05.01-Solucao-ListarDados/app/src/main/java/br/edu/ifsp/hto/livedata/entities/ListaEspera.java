package br.edu.ifsp.hto.livedata.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//TODO(2) Utilizar a annotation Entity com lista_espera como nome da tabela
@Entity(tableName = "lista_espera")
public class ListaEspera {

    //TODO(3) Utilizar a annotation Primary Key com autoGenerate como true
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

    //TODO(4) Utilizar a annotation ignore, para que o room utilize o outro construtor
    @Ignore
    public ListaEspera(String nomeReserva, int totalPessoas, Date dataCadastro) {
        this.nomeReserva = nomeReserva;
        this.totalPessoas = totalPessoas;
        this.dataCadastro = dataCadastro;
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
