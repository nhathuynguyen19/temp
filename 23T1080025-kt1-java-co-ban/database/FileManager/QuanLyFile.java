package FileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Bean.SinhVien;
import Bean.SinhVienABean;
import Bean.SinhVienBBean;

public class QuanLyFile {
	public ArrayList<SinhVien> loadSinhVienFromFile() throws Exception {
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		FileReader f = new FileReader("ds.txt");
		BufferedReader bf = new BufferedReader(f);
		String line = null;
		while ((line = bf.readLine()) != null) {
			String[] st = line.split(",");
			if (st.length == 4) {
				SinhVienABean sva = new SinhVienABean(st[0], st[1], Float.parseFloat(st[2]), Float.parseFloat(st[3]));
				ds.add((SinhVien)sva);
			} else if (st.length == 5) {
				SinhVienBBean svb = new SinhVienBBean(st[0], st[1], Float.parseFloat(st[2]), Float.parseFloat(st[3]), Float.parseFloat(st[4]));
				ds.add((SinhVien)svb);
			}
		}
		bf.close();
		return ds;
	}
	
	public ArrayList<SinhVienABean> loadSinhVienAFromFile() throws Exception {
		ArrayList<SinhVienABean> dsa = new ArrayList<SinhVienABean>();
		for(SinhVien sv : loadSinhVienFromFile()) {
			if (sv instanceof SinhVienABean) {
				dsa.add((SinhVienABean)sv);
			}
		}
		return dsa;
	}
	
	public ArrayList<SinhVienBBean> loadSinhVienBFromFile() throws Exception {
		ArrayList<SinhVienBBean> dsb = new ArrayList<SinhVienBBean>();
		for(SinhVien sv : loadSinhVienFromFile()) {
			if (sv instanceof SinhVienBBean) {
				dsb.add((SinhVienBBean)sv);
			}
		}
		return dsb;
	}
}
