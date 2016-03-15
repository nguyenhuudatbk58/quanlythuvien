package Model;

import java.util.Calendar;
import java.util.Date;

public class SachMuon {
	private int id;
	private PhieuMuon phieuMuon;
	private String maSach;
	private Calendar ngayMuon;
	private Calendar ngayTra;

	public SachMuon() {

	}

	public SachMuon(PhieuMuon phieuMuon, String maSach, Calendar ngayMuon, Calendar ngayTra) {
		super();
		this.phieuMuon = phieuMuon;
		this.maSach = maSach;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PhieuMuon getPhieuMuon() {
		return phieuMuon;
	}

	public void setPhieuMuon(PhieuMuon phieuMuon) {
		this.phieuMuon = phieuMuon;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public Calendar getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Calendar ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public Calendar getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Calendar ngayTra) {
		this.ngayTra = ngayTra;
	}

}
