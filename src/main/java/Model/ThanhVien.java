package Model;

public class ThanhVien {
	private int id;
	private String ten;
	private String maThanhVien;
	private String cMTND;
	private String sDT;

	public ThanhVien() {

	}

	public ThanhVien(int id, String ten, String maThanhVien, String cMTND, String sDT) {
		super();
		this.id = id;
		this.ten = ten;
		this.maThanhVien = maThanhVien;
		this.cMTND = cMTND;
		this.sDT = sDT;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getcMTND() {
		return cMTND;
	}

	public void setcMTND(String cMTND) {
		this.cMTND = cMTND;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

}
