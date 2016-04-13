package CouponManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CouponManagement.View.AddCouponView;
import CouponManagement.View.EditCouponView;
import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import DAO.ThanhVienDAO;
import Model.PhieuMuon;
import Model.SachMuon;

public class EditCouponController {

	private PhieuMuonDAO pmd;

	private String couponCode;

	private PhieuMuon coupon;

	private AddCouponView addCouponView;

	private CouponManagementController cmc;

	public EditCouponController(AddCouponView addCouponView, CouponManagementController cmc, String couponCode) {
		this.addCouponView = addCouponView;
		this.cmc = cmc;
		

		this.couponCode = couponCode;
		loadBookCodes();
		loadMemberCodes();
		loadLoanBook(couponCode);

		this.addCouponView.setAddButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bookCode = EditCouponController.this.addCouponView.getBookCode();
				Date loanDate = EditCouponController.this.addCouponView.getLoanDate();
				Date payDate = EditCouponController.this.addCouponView.getPayDate();

				EditCouponController.this.addCouponView.addLoanBookInTable(bookCode, loanDate, payDate);

			}
		});
		this.addCouponView.setEditButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = EditCouponController.this.addCouponView.getSelectedRow();
				if (selectedRow != -1) {
					String selectedBookCode = EditCouponController.this.addCouponView.getBookCodeAtRow(selectedRow);
					Date loanDate = EditCouponController.this.addCouponView.getLoanDateAtRow(selectedRow);
					Date payDate = EditCouponController.this.addCouponView.getPayDateAtRow(selectedRow);
					new EditLoanBook(selectedBookCode, loanDate, payDate, EditCouponController.this.addCouponView,
							selectedRow);
				} else {
					JOptionPane.showMessageDialog(null, "Chọn sách cần chỉnh sửa.");
				}
			}

		});

		this.addCouponView.setDeleteButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = EditCouponController.this.addCouponView.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Chọn sách muốn xóa");

				} else {
					EditCouponController.this.addCouponView.deleteLoanBookInTable(selectedRow);
				}

			}

		});

		this.addCouponView.setAddCouponButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String couponCode = EditCouponController.this.addCouponView.getCouponCode();
				String memberCode = EditCouponController.this.addCouponView.getMemberCode();

				HashSet<SachMuon> sms = EditCouponController.this.addCouponView.getSachMuons();

				PhieuMuon pm = new PhieuMuon();

				pm.setMaPhieu(couponCode);
				pm.setMaThanhVien(memberCode);
				pm.setSachMuon(sms);

				pmd.save(pm);

				EditCouponController.this.cmc.loadCoupons();

			}

		});
		this.addCouponView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCouponController.this.addCouponView.setVisible(false);
				EditCouponController.this.addCouponView.dispose();
			}

		});

		this.addCouponView.setMemberComboBoxListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String memberCode = EditCouponController.this.addCouponView.getMemberCode();
				ThanhVienDAO tvd = null;
				String memberName = tvd.getMemberNameByMemberCode(memberCode);
				EditCouponController.this.addCouponView.setMemberName(memberName);
			}
		});

	}

	public void loadLoanBook(String selectedCouponCode) {

		JTable loanBookTable = this.addCouponView.getLoanBookTable();

		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		coupon = pmd.getByCouponCode(selectedCouponCode);

		this.addCouponView.setCouponCode(coupon.getMaPhieu());
		this.addCouponView.setMemberCode(coupon.getMaThanhVien());

		ThanhVienDAO tvd = null;
		String memberName = tvd.getMemberNameByMemberCode(coupon.getMaThanhVien());
		this.addCouponView.setMemberName(memberName);

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

	public void loadMemberCodes() {
		ThanhVienDAO tvd = null;
		ArrayList<String> memberCodes = tvd.getMemberCodes();
		String[] mbc = new String[memberCodes.size()];
		int i = 0;
		for (String memberCode : memberCodes) {
			mbc[i] = memberCode;
			i++;
		}

		this.addCouponView.setMemberCodeComboBoxValue(mbc);
	}

	public void loadBookCodes() {
		SachDAO sachDAO = null;
		ArrayList<String> bookCodes = sachDAO.getBookCodes();

		String[] mbc = new String[bookCodes.size()];

		int i = 0;
		for (String bookCode : bookCodes) {
			mbc[i] = bookCode;
			i++;
		}

		this.addCouponView.setBookCodeComboBoxValue(mbc);
	}

}
