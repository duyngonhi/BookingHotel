package vn.framgia.service;

import java.io.Serializable;

import vn.framgia.bean.PaymentBean;

public interface IPaymentService extends Serializable{
	public PaymentBean getinfoPayment(Integer bookingId);
	public boolean savePayment();
}
