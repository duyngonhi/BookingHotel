package vn.framgia.service.impl;

import org.apache.log4j.Logger;
import vn.framgia.bean.ClientBean;
import vn.framgia.model.Client;
import vn.framgia.service.IClientService;

/**
 * Created by FRAMGIA\duong.van.tien on 21/03/2017.
 */
public class ClientServiceImpl extends BaseserviceImpl implements IClientService {
    private static final Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public Integer addClient(ClientBean clientBean) {
        try {
            Client client = new Client();
            client.setFullName(clientBean.getFullName());
            client.setAddress(clientBean.getAddress());
            client.setBirthDay(clientBean.getBirthDay());
            client.setCardNumber(clientBean.getCardNumber());
            client.setPhone(clientBean.getPhone());
            clientDAO.save(client);
            return client.getId();
        } catch (Exception e) {
            logger.info("Exception at function addClient in ClientServiceImpl: ", e);
        }
        return null;
    }

    @Override
    public Client getClientById(Integer id) {
        try {
            return clientDAO.findById(id);
        } catch (Exception e) {
            logger.info("Exception at function getClientById in ClientServiceImpl: ", e);
        }
        return null;
    }
}
