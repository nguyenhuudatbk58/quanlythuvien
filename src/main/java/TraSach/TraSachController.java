package TraSach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JTable;

import Common.CaculateDate;
import DAO.PhieuMuonDAO;
import DAO.ThanhVienDAO;
import Model.PhieuMuon;
import Model.SachMuon;

public class TraSachController {

	private TraSachView traSachView;

	private PhieuMuonDAO pmd;

	public TraSachController(TraSachView traSachView) {
		this.traSachView = traSachView;

		ArrayList<String> couponCodes = pmd.getCouponCode();
		String[] ccs = new String[couponCodes.size()];
		int i = 0;
		for (String couponCode : couponCodes) {
			ccs[i] = couponCode;
			i++;
		}

		this.traSachView.setCouponCodes(ccs);

		this.traSachView.setCouponCodeComboBoxListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String selectedCouponCode = TraSachController.this.traSachView.getCouponCode();
				PhieuMuon pm = pmd.getByCouponCode(selectedCouponCode);
				ThanhVienDAO tvDAO = null;

				String memberName = tvDAO.getMemberNameByMemberCode(pm.getMaThanhVien());
				TraSachController.this.traSachView.setMemberCode(pm.getMaThanhVien());
				TraSachController.this.traSachView.setMemberName(memberName);

				JTable table = TraSachController.this.traSachView.getBookTable();
				javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(
						new Object[][] {},
						new String[] { "Mã sách", "Ngày mượn", "Hạn trả", "Trạng thái", "Tiền phạt", "Chọn sách" });
				table.setModel(tableModel);

				Set<SachMuon> sms = pm.getSachMuon();
				Long totalMulct = 0L;
				Iterator iterator = sms.iterator();
				Vector<Object> v = null;
				while (iterator.hasNext()) {
					v = new Vector<Object>();
					SachMuon sm = (SachMuon) iterator.next();
					v.add(sm.getMaSach());
					v.add(sm.getNgayMuon());
					v.add(sm.getNgayTra());
					Long i = CaculateDate.tru(new Date(), sm.getNgayTra());
					if (i < 0) {
						v.add("Còn: " + (-i) + " ngày");
						v.add((-i * 5) + "000 (Đồng)");
					} else {
						v.add("Muộn: " + i + " ngày");
						v.add((i) * 5 + "000 (Đồng)");
					}
					v.add(false);
					tableModel.addRow(v);
					totalMulct += Math.abs(i) * 5;
				}
				TraSachController.this.traSachView.setMulct(totalMulct + "000");
			}
		});
	}

	public Long caculateMulct() {
		return 1l;
	}

	public static void main(String[] args) {
		new TraSachController(new TraSachView());
	}

}
