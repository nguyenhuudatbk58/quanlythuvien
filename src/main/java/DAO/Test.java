package DAO;

import java.util.Iterator;
import java.util.Set;

import Model.PhieuMuon;
import Model.SachMuon;

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
		// Sach sach = sd.getByBookCode("ISBN 978-604-943-255-2");
		// System.out.println("Ten: " + sach.getTen() + ",Tac Gia: " +
		// sach.getTacGia());
		// Set<SachMuon> set = new HashSet<SachMuon>();
		// SachMuon sm1 = new SachMuon();
		// PhieuMuon pm = new PhieuMuon("01", "2013 0837", null);
		// pm.setId(3);
		PhieuMuonDAO pmd = new PhieuMuonDAO();
		PhieuMuon pm = pmd.getByItemCode("01");
		Set<SachMuon> set = pm.getSachMuon();
		Iterator iterator = (Iterator) set.iterator();
		SachMuon sm = (SachMuon) iterator.next();
		set.remove(sm);
		pmd.save(pm);
	}

}
