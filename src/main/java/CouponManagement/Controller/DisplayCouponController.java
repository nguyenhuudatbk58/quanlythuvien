package CouponManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CouponManagement.View.DisplayCouponView;
import DAO.PhieuMuonDAO;
import Model.PhieuMuon;
import Model.SachMuon;

public class DisplayCouponController {
	private PhieuMuonDAO pmd;

	private DisplayCouponView displayCouponView;

	private String couponCode;

	public DisplayCouponController(DisplayCouponView displayCouponView, String couponCode) {

		this.displayCouponView = displayCouponView;
		this.couponCode = couponCode;

		loadLoanBook(couponCode);

		this.displayCouponView.setExitButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayCouponController.this.displayCouponView.setVisible(false);
				DisplayCouponController.this.displayCouponView.dispose();
			}

		});
	}

	public void loadLoanBook(String selectedCouponCode) {

		JTable loanBookTable = this.displayCouponView.getLoanBookTable();

		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		PhieuMuon coupon = pmd.getByCouponCode(selectedCouponCode);

		this.displayCouponView.setCouponCode(coupon.getMaPhieu());
		this.displayCouponView.setMemberCode(coupon.getMaThanhVien());

		Set<SachMuon> sachMuons = (Set<SachMuon>) coupon.getSachMuon();

		Iterator iterator = sachMuons.iterator();

		Vector<Object> v = null;
		while (iterator.hasNext()) {
			v = new Vector<Object>();
			SachMuon sm = (SachMuon) iterator.next();
			v.add(sm.getMaSach());
			v.add(sm.getNgayMuon());
			v.add(sm.getNgayTra());
			tableModel.addRow(v);
		}
	}

}
