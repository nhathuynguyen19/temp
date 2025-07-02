package BO;

import Bean.SinhVienABean;
import DAO.SinhVienADAO;

public class SinhVienABO {
	public SinhVienADAO ad = new SinhVienADAO();
	public void insert(SinhVienABean sv) throws Exception {
		ad.insert(sv);
	}
	public SinhVienABean find(String hoTen) throws Exception {
		return ad.find(hoTen);
	}
}
