package vn.framgia.service;

import java.io.Serializable;

import vn.framgia.bean.BillBeanClient;

public interface IPaymentBillService extends Serializable{
	public BillBeanClient getBeanClient(int bookingId);
}
