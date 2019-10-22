package br.edu.ifsp.hto.livedata.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

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
