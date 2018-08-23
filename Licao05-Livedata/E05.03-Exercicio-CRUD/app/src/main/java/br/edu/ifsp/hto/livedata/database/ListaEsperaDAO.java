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

@Dao
public interface ListaEsperaDAO {

    @Query("SELECT * FROM lista_espera ORDER BY data_cadastro")
    LiveData<List<ListaEspera>> loadAllListaEspera();

    @Insert
    void insertListaEspera(ListaEspera listaEspera);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateListaEspera(ListaEspera listaEspera);

    @Delete
    void deleteListaEspera(ListaEspera listaEspera);

    @Insert
    void insertListaEspera(List<ListaEspera> listaEsperas);

    @Query("DELETE FROM lista_espera")
    void clearTable();
}
