package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.account_bean;
import bean.statistic_bean;

public class statistic_dao {
	public ArrayList<statistic_bean> getRevenue() throws Exception {
		ArrayList<statistic_bean> ds = new ArrayList<statistic_bean>();
		// b1: Kết nối vào csdl
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: Tạo câu lệnh sql
		String sql = "WITH Months AS (\r\n" + "  SELECT 1 AS month\r\n"
				+ "  UNION SELECT 2 UNION SELECT 3 UNION SELECT 4\r\n"
				+ "  UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8\r\n"
				+ "  UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12\r\n" + ")\r\n" + "\r\n"
				+ "SELECT\r\n" + "  m.month,\r\n" + "  ISNULL(SUM(\r\n" + "    CASE \r\n"
				+ "      WHEN r.status = 'Checked out' THEN (DATEDIFF(day, r.check_out, r.check_in) + 1) * r.num_of_rooms * r.price\r\n"
				+ "      WHEN r.status = 'Cancel' THEN (r.price * r.num_of_rooms * 10) / 100\r\n" + "      ELSE 0\r\n"
				+ "    END\r\n" + "  ), 0) AS total\r\n" + "FROM Months m\r\n"
				+ "LEFT JOIN reserved_room r ON m.month = MONTH(r.check_out) AND YEAR(r.check_out) = 2023\r\n"
				+ "GROUP BY m.month\r\n" + "ORDER BY m.month";
		// b3: Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		// b4: Truyền tham số vào câu lệnh (nếu có) ...

		// b5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		// b6: Duyệt rs
		while (rs.next()) {
			int month = rs.getInt("month");
			Long total = rs.getLong("total");

			ds.add(new statistic_bean(month, total));
		}

		// b7: Đóng các đối tượng
		rs.close();
		kn.cn.close();

		return ds;
	}
}
