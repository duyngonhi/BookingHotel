package vn.framgia.service;

import java.io.Serializable;

import vn.framgia.bean.BillBean;
import vn.framgia.bean.BillBeanClient;
import vn.framgia.bean.PaymentBean;

public interface IPaymentService extends Serializable{
	public PaymentBean getinfoPayment(Integer bookingId);
	public boolean savePayment(BillBean billBean);
	public BillBeanClient getInfoPrintlBill(int bookingId, Integer billId);
}
