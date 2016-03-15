package Model;

import java.util.ArrayList;
import java.util.Set;

public class PhieuMuon {
	private int id;
	private String maPhieu;
	private String maThanhVien; // nguoi muon sach
	private Set<SachMuon> sachMuon;

	public PhieuMuon() {

	}

	public PhieuMuon(String maPhieu, String maThanhVien, Set<SachMuon> sachMuon) {
		super();
		this.id = id;
		this.maPhieu = maPhieu;
		this.maThanhVien = maThanhVien;
		this.sachMuon = sachMuon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public Set<SachMuon> getSachMuon() {
		return sachMuon;
	}

	public void setSachMuon(Set<SachMuon> sachMuon) {
		this.sachMuon = sachMuon;
	}

}
