package vn.framgia.service;

import java.io.Serializable;

import vn.framgia.bean.BillBeanClient;

public interface IBillService extends Serializable{
	public BillBeanClient getBillForClient();
}
