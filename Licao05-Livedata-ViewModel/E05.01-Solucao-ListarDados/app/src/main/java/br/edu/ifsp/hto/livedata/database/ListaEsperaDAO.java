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

//TODO(8) Utilizar a annotation Dao
@Dao
public interface ListaEsperaDAO {

    //TODO(9) Definir um método chamado loadAllListaEspera, que retorna uma LiveData de lista de ListaEspera
    //TODO(10) Utilizar a annotation query e passar a consulta SQL para listar todos os dados da tabela lista_espera.
        //Ordenar pela data de cadastro
    @Query("SELECT * FROM lista_espera ORDER BY data_cadastro")
    LiveData<List<ListaEspera>> loadAllListaEspera();

    //TODO(11) Definir um método chamado insertListaEspera, que recebe um ListaEspera
    //TODO(12) Utilizar a annotation Insert
    @Insert
    void insertListaEspera(ListaEspera listaEspera);

    //TODO(13) Definir um método chamado updateListaEspera que recebe um ListaEspera
    //TODO(14) Utilizar a annotation Update com onConflict = OnConflictStrategy.REPLACE
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateListaEspera(ListaEspera listaEspera);

    //TODO(15) Definir um método chamado deleteListaEspera que recebe um ListaEspera
    //TODO(16) Utilizar a annotation Delete
    @Delete
    void deleteListaEspera(ListaEspera listaEspera);

    @Insert
    void insertListaEspera(List<ListaEspera> listaEsperas);

    @Query("DELETE FROM lista_espera")
    void clearTable();
}
