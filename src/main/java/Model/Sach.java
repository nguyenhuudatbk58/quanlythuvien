package Model;

public class Sach {
	private int id;
	private String ten;
	private String maSach;
	private String tacGia;
	private String nhaXuatBan;
	private String gia;
	private String chuDe;

	public Sach( String ten, String maSach, String tacGia, String nhaXuatBan, String gia, String chuDe) {
		super();
		this.ten = ten;
		this.maSach = maSach;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.gia = gia;
		this.chuDe = chuDe;
	}

	public Sach() {

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

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getChuDe() {
		return chuDe;
	}

	public void setChuDe(String chuDe) {
		this.chuDe = chuDe;
	}

}
