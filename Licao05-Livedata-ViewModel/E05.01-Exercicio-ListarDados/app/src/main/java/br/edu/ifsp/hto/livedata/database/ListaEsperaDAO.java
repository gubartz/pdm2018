package br.edu.ifsp.hto.livedata.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.edu.ifsp.hto.livedata.entities.ListaEspera;

//TODO(8) Utilizar a annotation Dao
public interface ListaEsperaDAO {

    //TODO(9) Definir um método chamado loadAllListaEspera, que retorna uma LiveData de lista de ListaEspera
    //TODO(10) Utilizar a annotation query e passar a consulta SQL para listar todos os dados da tabela lista_espera.
        //Ordenar pela data de cadastro

    //TODO(11) Definir um método chamado insertListaEspera, que recebe um ListaEspera
    //TODO(12) Utilizar a annotation Insert

    //TODO(13) Definir um método chamado updateListaEspera que recebe um ListaEspera
    //TODO(14) Utilizar a annotation Update com onConflict = OnConflictStrategy.REPLACE

    //TODO(15) Definir um método chamado deleteListaEspera que recebe um ListaEspera
    //TODO(16) Utilizar a annotation Delete

    @Insert
    void insertListaEspera(List<ListaEspera> listaEsperas);

    @Query("DELETE FROM lista_espera")
    void clearTable();
}
