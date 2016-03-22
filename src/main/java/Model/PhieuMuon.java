package Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "phieu_muon", uniqueConstraints = { @UniqueConstraint(columnNames = "maPhieu"),
		@UniqueConstraint(columnNames = "maThanhVien") })
public class PhieuMuon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "ma_phieu", nullable = false)
	private String maPhieu;

	@Column(name = "ma_thanh_vien", nullable = false)
	private String maThanhVien; // nguoi muon sach

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "phieuMuon", fetch = FetchType.LAZY)
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
