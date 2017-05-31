package vn.framgia.service;

import vn.framgia.bean.ClientBean;
import vn.framgia.model.Client;

import java.io.Serializable;

/**
 * Created by FRAMGIA\duong.van.tien on 21/03/2017.
 *
 */
public interface IClientService extends Serializable {
    public Integer addClient(ClientBean clientBean);
    public Client getClientById(Integer id);
}
