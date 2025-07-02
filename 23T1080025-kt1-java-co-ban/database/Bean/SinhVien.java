package Bean;

public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public SinhVien(String maSinhVien, String hoTen) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
	}
	@Override
	public String toString() {
		return maSinhVien + "," + hoTen + ",";
	}
	
}
