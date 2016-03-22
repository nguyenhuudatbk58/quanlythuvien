package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "thanh_vien", uniqueConstraints = { @UniqueConstraint(columnNames = "maThanhVien"),
		@UniqueConstraint(columnNames = "email") })
public class ThanhVien {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "ten", nullable = false)
	private String ten;

	@Column(name = "ma_thanh_vien", nullable = false)
	private String maThanhVien;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "dia_chi", nullable = false)
	private String diaChi;

	public ThanhVien() {

	}

	public ThanhVien(int id, String ten, String maThanhVien, String cMTND, String sDT) {
		super();
		this.id = id;
		this.ten = ten;
		this.maThanhVien = maThanhVien;
		this.email = cMTND;
		this.diaChi = sDT;
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
		return email;
	}

	public void setcMTND(String cMTND) {
		this.email = cMTND;
	}

	public String getsDT() {
		return diaChi;
	}

	public void setsDT(String sDT) {
		this.diaChi = sDT;
	}

}
