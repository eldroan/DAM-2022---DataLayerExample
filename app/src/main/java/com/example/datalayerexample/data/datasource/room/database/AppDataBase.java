package com.example.datalayerexample.data.datasource.room.database;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.util.UUIDUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.datalayerexample.data.OnResult;
import com.example.datalayerexample.data.datasource.room.AlojamientoRoomDataSource;
import com.example.datalayerexample.data.datasource.room.UUIDConverter;
import com.example.datalayerexample.data.datasource.room.dao.AlojamientoDAO;
import com.example.datalayerexample.data.datasource.room.dao.DepartamentoDAO;
import com.example.datalayerexample.data.datasource.room.dao.HabitacionDAO;
import com.example.datalayerexample.data.datasource.room.entities.AlojamientoEntity;
import com.example.datalayerexample.data.datasource.room.entities.DepartamentoEntity;
import com.example.datalayerexample.data.datasource.room.entities.HabitacionEntity;
import com.example.datalayerexample.data.model.Departamento;
import com.example.datalayerexample.data.model.Habitacion;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = { AlojamientoEntity.class, DepartamentoEntity.class, HabitacionEntity.class },
    version = 1,
    exportSchema = false)
@TypeConverters({ UUIDConverter.class })
public abstract class AppDataBase extends RoomDatabase {

    public abstract AlojamientoDAO alojamientoDAO();

    public abstract DepartamentoDAO departamentoDAO();

    public abstract HabitacionDAO habitacionDAO();

    private static final String DATABASE_NAME = "db_sistema_alojamientos";
    private static AppDataBase instance;

    public static final ExecutorService EXECUTOR_DB = Executors.newSingleThreadExecutor();

    public static synchronized AppDataBase getInstance(final Context context) {
        if (instance == null) {
            instance = buildDatabase(context);
        }
        return instance;
    }

    private static AppDataBase buildDatabase(final Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, DATABASE_NAME).addCallback(mRoomCallback).build();
    }

    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull final SupportSQLiteDatabase db) {
            super.onCreate(db);
            EXECUTOR_DB.execute(() -> {
                final OnResult<Departamento> dc = new OnResult<Departamento>() {

                    @Override
                    public void onSuccess(final Departamento result) {
                        // noop
                    }

                    @Override
                    public void onError(final Throwable exception) {
                        // noop
                    }
                };
                final OnResult<Habitacion> hc = new OnResult<Habitacion>() {

                    @Override
                    public void onSuccess(final Habitacion result) {
                        // noop
                    }

                    @Override
                    public void onError(final Throwable exception) {
                        // noop
                    }
                };

                final AlojamientoRoomDataSource ds = new AlojamientoRoomDataSource(instance);
                ds.guardarDepartamento(new Departamento(
                    "Departamento 1",
                    "Este departamente esta copado a pesar de tener un nombre no muy original",
                    0,
                    12.0,
                    true,
                    1.0,
                    1,
                    null
                ), dc);
                ds.guardarHabitacion(new Habitacion(
                    "Habitación 1",
                    "Esta es una habitación con una cama",
                    1,
                    12.0,
                    1,
                    0,
                    true,
                    null
                ), hc);
                ds.guardarDepartamento(new Departamento(
                    "Departamento 2",
                    "Este departamento tiene pileta",
                    0,
                    12.0,
                    true,
                    1.0,
                    2,
                    null
                ), dc);
                ds.guardarHabitacion(new Habitacion(
                    "Habitación 2",
                    "Esta es una habitación con dos camas",
                    1,
                    12.0,
                    2,
                    0,
                    true,
                    null
                ), hc);
                ds.guardarDepartamento(new Departamento(
                    "Departamento 3",
                    "Este departamento no esta muy bueno pero es barato",
                    0,
                    12.0,
                    true,
                    1.0,
                    2,
                    null
                ), dc);
                ds.guardarDepartamento(new Departamento(
                    "Departamento 4",
                    "En este departamento se pueden tener mascotas",
                    0,
                    12.0,
                    true,
                    1.0,
                    2,
                    null
                ), dc);
                ds.guardarDepartamento(new Departamento(
                    "Departamento 5",
                    "En este departamento es el 5",
                    0,
                    12.0,
                    true,
                    1.0,
                    2,
                    null
                ), dc);
                ds.guardarDepartamento(new Departamento(
                    "Departamento 6",
                    "En este departamento es el 6",
                    0,
                    12.0,
                    true,
                    1.0,
                    2,
                    null
                ), dc);
                ds.guardarDepartamento(new Departamento(
                    "Departamento 7",
                    "En este departamento es el 7",
                    0,
                    12.0,
                    true,
                    1.0,
                    2,
                    null
                ), dc);
                ds.guardarHabitacion(new Habitacion(
                    "Habitación 3",
                    "Esta es una habitación 3",
                    1,
                    12.0,
                    1,
                    0,
                    true,
                    null
                ), hc);
                ds.guardarHabitacion(new Habitacion(
                    "Habitación 4",
                    "Esta es una habitación 4",
                    1,
                    12.0,
                    1,
                    0,
                    true,
                    null
                ), hc);
                ds.guardarHabitacion(new Habitacion(
                    "Habitación 5",
                    "Esta es una habitación 5",
                    1,
                    12.0,
                    1,
                    0,
                    true,
                    null
                ), hc);
            });
        }
    };

    public void clearTables() {
        EXECUTOR_DB.execute(this::clearAllTables);
    }
}
