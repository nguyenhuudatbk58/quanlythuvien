package DAO;

import java.util.ArrayList;

public class Test {
	private static ThanhVienDAO tvd;

	private static PhieuMuonDAO pmd;

	public static void main(String[] args) {

		// PhieuMuon pm = new PhieuMuon();
		// pm.setMaPhieu("03");
		// pm.setMaThanhVien("2013 0347");
		// SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyyy");
		// Date ngayMuon = null;
		// Date ngayTra = null;
		// try {
		// ngayMuon = dateFormat.parse("01-09-2015");
		// ngayTra = dateFormat.parse("20-12-2016");
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// SachMuon sm = new SachMuon();
		// sm.setMaSach("IBSN 0009 9999");
		// sm.setNgayMuon(ngayMuon);
		// sm.setNgayTra(ngayTra);
		//
		// SachMuon sm2 = new SachMuon();
		//
		// sm2.setMaSach("IBSN 0010 9999");
		// try {
		// sm2.setNgayMuon(dateFormat.parse("23-02-2016"));
		// sm2.setNgayTra(dateFormat.parse("01-4-2016"));
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// pm.setSachMuon(sm);
		// pm.setSachMuon(sm2);
		//
		// pmd.save(pm);

		// ArrayList<PhieuMuon> pms = pmd.getAll();
		//
		// for (PhieuMuon pm : pms) {
		// System.out.println(pm.getMaPhieu());
		// System.out.println(pm.getMaThanhVien());
		// pm.getSachMuon().iterator().next().getMaSach();
		// }

		ArrayList<String> memberCodes = tvd.getMemberCodes();

		String[] mbc = new String[memberCodes.size()];

		int i = 0;
		for (String memberCode : memberCodes) {
			mbc[i] = memberCode;
			i++;
		}

		for (i = 0; i < mbc.length; i++) {
			System.out.println(mbc[i]);
		}

	}

}
