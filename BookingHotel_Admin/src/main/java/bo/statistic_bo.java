package bo;

import java.util.ArrayList;

import bean.statistic_bean;
import dao.statistic_dao;

public class statistic_bo {
	statistic_dao sdao = new statistic_dao();

	public ArrayList<statistic_bean> getRevenue() throws Exception {
		return sdao.getRevenue();
	}

	public Long getTotalRevenue() throws Exception {
		Long t = (long) 0;
		for (statistic_bean s : sdao.getRevenue()) {
			t += s.getTotal();
		}

		return t;
	}
}
