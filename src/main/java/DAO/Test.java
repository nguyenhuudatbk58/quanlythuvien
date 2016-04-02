package DAO;

import java.util.ArrayList;

import Model.ThanhVien;

public class Test {
	private static ThanhVienDAO tvd;

	public static void main(String[] args) {
		// ThanhVien mem = new ThanhVien();
		// mem.setTen("Nguyễn Hoàng Sơn");
		// mem.setMaThanhVien("2013 0038");
		// mem.setEmail("sonhn@gmail.com");
		// mem.setDiaChi("Hà Nội");
		//
		// tvd.save(mem);

		ArrayList<ThanhVien> mems = tvd.getAll();

		for (ThanhVien mem : mems) {
			System.out.println("Ten: " + mem.getTen());
			System.out.println("Ma thanh vien: " + mem.getMaThanhVien());
			System.out.println("Email: " + mem.getEmail());
			System.out.println("Dia chi: " + mem.getDiaChi());
			System.out.println("-----------------");

		}

	}

}
