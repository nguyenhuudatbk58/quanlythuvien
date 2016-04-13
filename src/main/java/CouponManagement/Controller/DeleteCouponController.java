package CouponManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CouponManagement.View.DeleteCouponView;
import CouponManagement.View.DisplayCouponView;
import DAO.PhieuMuonDAO;
import Model.PhieuMuon;
import Model.SachMuon;

public class DeleteCouponController {
	private PhieuMuonDAO pmd;

	private DeleteCouponView deleteCouponView;

	private String couponCode;

	public DeleteCouponController(DisplayCouponView displayCouponView, String couponCode) {

		this.deleteCouponView = deleteCouponView;
		this.couponCode = couponCode;

		loadLoanBook(couponCode);

		this.deleteCouponView.setDeleteButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCouponController.this.deleteCouponView.setVisible(false);
				DeleteCouponController.this.deleteCouponView.dispose();
			}

		});
	}

	public void loadLoanBook(String selectedCouponCode) {

		JTable loanBookTable = this.deleteCouponView.getLoanBookTable();

		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		PhieuMuon coupon = pmd.getByCouponCode(selectedCouponCode);

		this.deleteCouponView.setCouponCode(coupon.getMaPhieu());
		this.deleteCouponView.setMemberCode(coupon.getMaThanhVien());

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
