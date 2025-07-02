package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.SinhVienBBean;

public class SinhVienBDAO {
	public Boolean isExist(String maSinhVien) throws Exception {
		Connector cn = new Connector();
		String query = "select 1 from SinhVienB where maSinhVien = ?;";
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
	public void insert(SinhVienBBean sv) throws Exception {
		if (isExist(sv.getMaSinhVien())) {
			System.out.println("Sinh vien da ton tai");
			return;
		}
		Connector cn = new Connector();
		String query = "insert into SinhVienB values (?, ?, ?, ?, ?, ?);";
		PreparedStatement cmd = null;
		try {
			cn.connect();
			cmd = Connector.connection.prepareStatement(query);
			cmd.setString(1, sv.getMaSinhVien());
			cmd.setString(2, sv.getHoTen());
			cmd.setFloat(3, sv.getDiemExcel());
			cmd.setFloat(4, sv.getDiemPowerPoint());
			cmd.setFloat(5, sv.getDiemWeb());
			cmd.setFloat(6, (sv.getDiemExcel() + sv.getDiemPowerPoint() + sv.getDiemWeb()) / 3);
			cmd.executeUpdate();
		} finally {
			if (cmd != null) cmd.close();
			cn.disconnect();
			System.out.println("Chen sinh vien a thanh cong");
		}
		
	}
	public SinhVienBBean find(String hoTen) throws Exception {
		Connector cn = new Connector();
		String query = "select top 1 * from SinhVienB where hoTen like ? or hoTen like ? or hoTen like ? or hoTen like ?;";
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
				Float diemExcel = rs.getFloat("diemExcel");
				Float diemPowerPoint = rs.getFloat("diemPowerPoint");
				Float diemWeb = rs.getFloat("diemWeb");
				return new SinhVienBBean(maSinhVien, hoTen1, diemExcel, diemPowerPoint, diemWeb);
			}
		} finally {
			if (cmd != null) cmd.close();
			if (rs != null) rs.close();
			cn.disconnect();
		}
		return null;
	}
}
