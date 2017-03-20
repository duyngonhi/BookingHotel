package vn.framgia.bean;

public class PaymentDetail {
	private String nameService;
	private Integer price;
	
	public PaymentDetail() {
		super();
	}

	public PaymentDetail(String nameService, Integer price) {
		super();
		this.nameService = nameService;
		this.price = price;
	}

	public String getNameService() {
		return nameService;
	}

	public void setNameService(String nameService) {
		this.nameService = nameService;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
