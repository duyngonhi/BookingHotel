package vn.framgia.dao.impl;

import org.apache.log4j.Logger;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IClientDAO;
import vn.framgia.model.Client;

/**
 * Created by FRAMGIA\duong.van.tien on 21/03/2017.
 */
public class ClienDAOImpl  extends GenericDAO<Client, Integer> implements IClientDAO {
    private static final Logger logger = Logger.getLogger(ClienDAOImpl.class);
    public ClienDAOImpl() {
        super.setPersistentClass(Client.class);
    }
}
