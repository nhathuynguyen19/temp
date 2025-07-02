package BO;

import Bean.SinhVienBBean;
import DAO.SinhVienBDAO;

public class SinhVienBBO {
	public SinhVienBDAO bd = new SinhVienBDAO();
	public void insert(SinhVienBBean sv) throws Exception {
		bd.insert(sv);
	}
	public SinhVienBBean find(String hoTen) throws Exception {
		return bd.find(hoTen);
	}
}
