package Bean;

public class SinhVienBBean extends SinhVien {
	private Float diemExcel;
	private Float diemPowerPoint;
	private Float diemWeb;
	public Float getDiemExcel() {
		return diemExcel;
	}
	public void setDiemExcel(Float diemExcel) {
		this.diemExcel = diemExcel;
	}
	public Float getDiemPowerPoint() {
		return diemPowerPoint;
	}
	public void setDiemPowerPoint(Float diemPowerPoint) {
		this.diemPowerPoint = diemPowerPoint;
	}
	public Float getDiemWeb() {
		return diemWeb;
	}
	public void setDiemWeb(Float diemWeb) {
		this.diemWeb = diemWeb;
	}
	public SinhVienBBean(String maSinhVien, String hoTen, Float diemExcel, Float diemPowerPoint, Float diemWeb) {
		super(maSinhVien, hoTen);
		this.diemExcel = diemExcel;
		this.diemPowerPoint = diemPowerPoint;
		this.diemWeb = diemWeb;
	}
	@Override
	public String toString() {
		return super.toString() + diemExcel + "," + diemPowerPoint + "," + diemWeb + (diemExcel + diemPowerPoint + diemWeb) / 3;
	}
	
}
