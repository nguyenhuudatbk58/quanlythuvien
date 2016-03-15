package DAO;

import java.util.ArrayList;

import Model.Sach;

public class Test {
	public static void main(String[] args) {
		SachDAO sd = new SachDAO();
		// sd.save(new Sach("Thep Da Toi The Day", "ISBN 893 508 997 891",
		// "NHICALAI AXTOROPXKI", "Nha Xuat Ban Van Hoc", "99 000",
		// "Sach Van Hoc"));
		// ArrayList<Sach> sach = sd.getAll();
		// for (Sach s : sach) {
		// System.out.println(" Ma: " + s.getMaSach());
		// }
		Sach sach = sd.getByBookCode("ISBN 978-604-943-255-2");
		System.out.println("Ten: " + sach.getTen() + ",Tac Gia: " + sach.getTacGia());
	}

}
