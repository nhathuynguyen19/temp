package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.SinhVienABean;

public class SinhVienADAO {
	public Boolean isExist(String maSinhVien) throws Exception {
		Connector cn = new Connector();
		String query = "select 1 from SinhVienA where maSinhVien = ?;";
		PreparedStatement cmd = null;
		ResultSet rs = null;
		try {
			cn.connect();
			cmd = Connector.connection.prepareStatement(query);
			cmd.setString(1, maSinhVien);
			rs = cmd.executeQuery();
			return rs.next();
		} finally {
			if (cmd != null) cmd.close();
			if (rs != null) rs.close();
			cn.disconnect();
		}
	}
	public void insert(SinhVienABean sv) throws Exception {
		if (isExist(sv.getMaSinhVien())) {
			System.out.println("Sinh vien da ton tai");
			return;
		}
		Connector cn = new Connector();
		String query = "insert into SinhVienA values (?, ?, ?, ?, ?);";
		PreparedStatement cmd = null;
		try {
			cn.connect();
			cmd = Connector.connection.prepareStatement(query);
			cmd.setString(1, sv.getMaSinhVien());
			cmd.setString(2, sv.getHoTen());
			cmd.setFloat(3, sv.getDiemWin());
			cmd.setFloat(4, sv.getDiemWord());
			cmd.setFloat(5, (sv.getDiemWin() + sv.getDiemWord()) / 2);
			cmd.executeUpdate();
		} finally {
			if (cmd != null) cmd.close();
			cn.disconnect();
			System.out.println("Chen sinh vien a thanh cong");
		}
		
	}
	public SinhVienABean find(String hoTen) throws Exception {
		Connector cn = new Connector();
		String query = "select top 1 * from SinhVienA where hoTen like ? or hoTen like ? or hoTen like ? or hoTen like ?;";
		ResultSet rs = null;
		PreparedStatement cmd = null;
		Boolean dk = true;
		try {
			cn.connect();
			cmd = Connector.connection.prepareStatement(query);
			cmd.setString(1, "%" + hoTen.strip() + "%");
			cmd.setString(2, "%" + hoTen.strip());
			cmd.setString(3, hoTen.strip() + "%");
			cmd.setString(4, hoTen.strip());
			rs = cmd.executeQuery();
			
			while(rs.next() && dk) {
				String maSinhVien = rs.getString("maSinhVien");
				String hoTen1 = rs.getString("hoTen");
				Float diemWin = rs.getFloat("diemWin");
				Float diemWord = rs.getFloat("diemWord");
				return new SinhVienABean(maSinhVien, hoTen1, diemWin, diemWord);
			}
		} finally {
			if (cmd != null) cmd.close();
			if (rs != null) rs.close();
			cn.disconnect();
		}
		return null;
	}
}
