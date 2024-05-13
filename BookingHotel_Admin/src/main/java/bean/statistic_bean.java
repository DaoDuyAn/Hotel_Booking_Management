package bean;

public class statistic_bean {
	private int month;
	private Long total;

	public statistic_bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public statistic_bean(int month, Long total) {
		super();
		this.month = month;
		this.total = total;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
