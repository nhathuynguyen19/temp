package View;

import BO.SinhVienABO;
import BO.SinhVienBBO;
import Bean.SinhVienABean;
import Bean.SinhVienBBean;
import FileManager.QuanLyFile;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuanLyFile qlf = new QuanLyFile();
		SinhVienABO abo = new SinhVienABO();
		SinhVienBBO bbo = new SinhVienBBO();
		String hoTen = "A";
		try {
			// hien thi sinh vien sau khi chen tu file vao database
			for(SinhVienABean sv : qlf.loadSinhVienAFromFile()) {
				abo.insert(sv);
				System.out.println(sv.toString());
			}
			for(SinhVienBBean sv : qlf.loadSinhVienBFromFile()) {
				bbo.insert(sv);
				System.out.println(sv.toString());
			}
			// tim sinh vien tuong doi
			if (abo.find(hoTen) != null) {
				SinhVienABean sv = abo.find(hoTen);
				System.out.println("Sinh vien tim duoc tuong doi");
				System.out.println(sv.toString());
				
			} else if (bbo.find(hoTen) != null) {
				SinhVienBBean sv = (SinhVienBBean) bbo.find(hoTen);
				System.out.println("Sinh vien tim duoc tuong doi");
				System.out.println(sv.toString());
			} else {
				System.out.println("Khong tim thay sinh vien voi hoTen like " + hoTen);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
