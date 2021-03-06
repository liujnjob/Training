package com.cetc.training.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import com.cetc.training.entity.PEDDate;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "PEDDATE".
*/
public class PEDDateDao extends AbstractDao<PEDDate, Long> {

    public static final String TABLENAME = "PEDDATE";

    /**
     * Properties of entity PEDDate.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property PedTs = new Property(1, String.class, "pedTs", false, "PED_TS");
        public final static Property PedSteps = new Property(2, int.class, "pedSteps", false, "PED_STEPS");
        public final static Property PedCalories = new Property(3, int.class, "pedCalories", false, "PED_CALORIES");
        public final static Property PedDistance = new Property(4, int.class, "pedDistance", false, "PED_DISTANCE");
        public final static Property PedActcalories = new Property(5, int.class, "pedActcalories", false, "PED_ACTCALORIES");
        public final static Property PedStepbpm = new Property(6, int.class, "pedStepbpm", false, "PED_STEPBPM");
        public final static Property PedEnergy = new Property(7, int.class, "pedEnergy", false, "PED_ENERGY");
        public final static Property PedMode = new Property(8, int.class, "pedMode", false, "PED_MODE");
        public final static Property PedSleepPhase = new Property(9, int.class, "pedSleepPhase", false, "PED_SLEEP_PHASE");
    }


    public PEDDateDao(DaoConfig config) {
        super(config);
    }
    
    public PEDDateDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PEDDATE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PED_TS\" TEXT NOT NULL ," + // 1: pedTs
                "\"PED_STEPS\" INTEGER NOT NULL ," + // 2: pedSteps
                "\"PED_CALORIES\" INTEGER NOT NULL ," + // 3: pedCalories
                "\"PED_DISTANCE\" INTEGER NOT NULL ," + // 4: pedDistance
                "\"PED_ACTCALORIES\" INTEGER NOT NULL ," + // 5: pedActcalories
                "\"PED_STEPBPM\" INTEGER NOT NULL ," + // 6: pedStepbpm
                "\"PED_ENERGY\" INTEGER NOT NULL ," + // 7: pedEnergy
                "\"PED_MODE\" INTEGER NOT NULL ," + // 8: pedMode
                "\"PED_SLEEP_PHASE\" INTEGER NOT NULL );"); // 9: pedSleepPhase
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PEDDATE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PEDDate entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getPedTs());
        stmt.bindLong(3, entity.getPedSteps());
        stmt.bindLong(4, entity.getPedCalories());
        stmt.bindLong(5, entity.getPedDistance());
        stmt.bindLong(6, entity.getPedActcalories());
        stmt.bindLong(7, entity.getPedStepbpm());
        stmt.bindLong(8, entity.getPedEnergy());
        stmt.bindLong(9, entity.getPedMode());
        stmt.bindLong(10, entity.getPedSleepPhase());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PEDDate entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getPedTs());
        stmt.bindLong(3, entity.getPedSteps());
        stmt.bindLong(4, entity.getPedCalories());
        stmt.bindLong(5, entity.getPedDistance());
        stmt.bindLong(6, entity.getPedActcalories());
        stmt.bindLong(7, entity.getPedStepbpm());
        stmt.bindLong(8, entity.getPedEnergy());
        stmt.bindLong(9, entity.getPedMode());
        stmt.bindLong(10, entity.getPedSleepPhase());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PEDDate readEntity(Cursor cursor, int offset) {
        PEDDate entity = new PEDDate( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // pedTs
            cursor.getInt(offset + 2), // pedSteps
            cursor.getInt(offset + 3), // pedCalories
            cursor.getInt(offset + 4), // pedDistance
            cursor.getInt(offset + 5), // pedActcalories
            cursor.getInt(offset + 6), // pedStepbpm
            cursor.getInt(offset + 7), // pedEnergy
            cursor.getInt(offset + 8), // pedMode
            cursor.getInt(offset + 9) // pedSleepPhase
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PEDDate entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPedTs(cursor.getString(offset + 1));
        entity.setPedSteps(cursor.getInt(offset + 2));
        entity.setPedCalories(cursor.getInt(offset + 3));
        entity.setPedDistance(cursor.getInt(offset + 4));
        entity.setPedActcalories(cursor.getInt(offset + 5));
        entity.setPedStepbpm(cursor.getInt(offset + 6));
        entity.setPedEnergy(cursor.getInt(offset + 7));
        entity.setPedMode(cursor.getInt(offset + 8));
        entity.setPedSleepPhase(cursor.getInt(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PEDDate entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PEDDate entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PEDDate entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
