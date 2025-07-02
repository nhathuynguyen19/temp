package Bean;

public class SinhVienABean extends SinhVien {
	private Float diemWin;
	private Float diemWord;
	public Float getDiemWin() {
		return diemWin;
	}
	public void setDiemWin(Float diemWin) {
		this.diemWin = diemWin;
	}
	public Float getDiemWord() {
		return diemWord;
	}
	public void setDiemWord(Float diemWord) {
		this.diemWord = diemWord;
	}
	public SinhVienABean(String maSinhVien, String hoTen, Float diemWin, Float diemWord) {
		super(maSinhVien, hoTen);
		this.diemWin = diemWin;
		this.diemWord = diemWord;
	}
	@Override
	public String toString() {
		return super.toString() + diemWin + "," + diemWord + "," + (diemWin + diemWord) / 2;
	}
	
	
}
