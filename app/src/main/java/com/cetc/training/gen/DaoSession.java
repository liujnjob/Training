package com.cetc.training.gen;

import com.cetc.training.entity.NsDevice;
import com.cetc.training.entity.PEDDate;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig nsDeviceDaoConfig;
    private final DaoConfig pEDDateDaoConfig;

    private final NsDeviceDao nsDeviceDao;
    private final PEDDateDao pEDDateDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        nsDeviceDaoConfig = daoConfigMap.get(NsDeviceDao.class).clone();
        nsDeviceDaoConfig.initIdentityScope(type);

        pEDDateDaoConfig = daoConfigMap.get(PEDDateDao.class).clone();
        pEDDateDaoConfig.initIdentityScope(type);

        nsDeviceDao = new NsDeviceDao(nsDeviceDaoConfig, this);
        pEDDateDao = new PEDDateDao(pEDDateDaoConfig, this);

        registerDao(NsDevice.class, nsDeviceDao);
        registerDao(PEDDate.class, pEDDateDao);
    }
    
    public void clear() {
        nsDeviceDaoConfig.clearIdentityScope();
        pEDDateDaoConfig.clearIdentityScope();
    }

    public NsDeviceDao getNsDeviceDao() {
        return nsDeviceDao;
    }

    public PEDDateDao getPEDDateDao() {
        return pEDDateDao;
    }

}
