package br.edu.ifsp.hto.livedata.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import br.edu.ifsp.hto.livedata.entities.ListaEspera;

//TODO(5) Adicionar a annotation Database
//TODO(6) Definir em entities a ListaEspera, colocar version 1 e exportSchema para falso
//TODO(7) Utilizar a annotation TypeConverters passando a classe DateConverter
public abstract class AppDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "lista_espera";
    private static AppDatabase sInstance;

    public static AppDatabase getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME).build();
            }
        }

        return sInstance;
    }

    //TODO(17) Declarar um método abstrato chamado listaEsperaDAO que retorna um ListaEsperaDAO
}
