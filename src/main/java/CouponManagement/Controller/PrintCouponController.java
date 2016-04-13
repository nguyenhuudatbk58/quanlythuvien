package CouponManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CouponManagement.View.PrintCouponView;
import DAO.PhieuMuonDAO;
import Model.PhieuMuon;
import Model.SachMuon;

public class PrintCouponController {
	private PhieuMuonDAO pmd;

	private PrintCouponView printCouponView;

	private String couponCode;

	public PrintCouponController(PrintCouponView printCouponView, String couponCode) {

		this.printCouponView = printCouponView;
		this.couponCode = couponCode;

		loadLoanBook(couponCode);

		this.printCouponView.setExitButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintCouponController.this.printCouponView.setVisible(false);
				PrintCouponController.this.printCouponView.dispose();
			}

		});
		
		this.printCouponView.setPrintButtonListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
	}

	public void loadLoanBook(String selectedCouponCode) {

		JTable loanBookTable = this.printCouponView.getLoanBookTable();

		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		PhieuMuon coupon = pmd.getByCouponCode(selectedCouponCode);

		this.printCouponView.setCouponCode(coupon.getMaPhieu());
		this.printCouponView.setMemberCode(coupon.getMaThanhVien());

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
