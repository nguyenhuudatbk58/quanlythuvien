package CouponManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import CouponManagement.View.AddCouponView;
import CouponManagement.View.CouponManagementView;
import CouponManagement.View.DisplayCouponView;
import CouponManagement.View.PrintCouponView;
import DAO.PhieuMuonDAO;
import Model.PhieuMuon;

public class CouponManagementController {

	private PhieuMuonDAO phieuMuonDAO;

	private CouponManagementView couponManagementView;

	private ArrayList<PhieuMuon> coupons;

	public CouponManagementController(CouponManagementView couponManagementView) {
		this.couponManagementView = couponManagementView;

		loadCoupons();

		this.couponManagementView.setAddButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddCouponController(new AddCouponView(), CouponManagementController.this);
			}

		});

		this.couponManagementView.setEditButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String selectedCouponCode = CouponManagementController.this.couponManagementView
						.getSelectedCouponCode();

				new EditCouponController(new AddCouponView(), CouponManagementController.this, selectedCouponCode);

			}

		});
		this.couponManagementView.setViewButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String selectedCouponCode = CouponManagementController.this.couponManagementView
						.getSelectedCouponCode();
				if (selectedCouponCode.equals(null)) {
					JOptionPane.showMessageDialog(null, "Chọn phiếu mượn cần xem.");

					return;
				}
				new DisplayCouponController(new DisplayCouponView(), selectedCouponCode);
			}

		});

		this.couponManagementView.setPrintButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedCouponCode = CouponManagementController.this.couponManagementView
						.getSelectedCouponCode();
				if (selectedCouponCode == null) {
					JOptionPane.showMessageDialog(null, "Chọn phiếu mượn cần in.");
					return;
				}
				new PrintCouponController(new PrintCouponView(), selectedCouponCode);
			}

		});
	}

	public void loadCoupons() {
		JTable couponTable = couponManagementView.getCouponTable();
		javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(null,
				new String[] { "STT ", "Mã phiếu mượn", "Mã thành viên" }) {
			public Class getColumnClass(int column) {
				return String.class;
			}

			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		couponTable.setModel(tableModel);
		this.couponManagementView.setSizeColumn();
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
		couponTable.setRowSorter(sorter);
		coupons = phieuMuonDAO.getAll();

		Vector<Object> v;
		for (int i = 0; i < coupons.size(); i++) {
			PhieuMuon coupon = coupons.get(i);
			v = new Vector<Object>();
			v.add(i + 1);
			v.add(coupon.getMaPhieu());
			v.add(coupon.getMaThanhVien());
			tableModel.addRow(v);
		}

		this.couponManagementView.setSearchButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String keySearch = CouponManagementController.this.couponManagementView.getKeySearch();
				String subjectSearch = CouponManagementController.this.couponManagementView.getSubjectSearch();
				new SearchCouponController(sorter, keySearch.trim(), subjectSearch);
			}

		});

		this.couponManagementView.setRefreshButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sorter.setRowFilter(null);
				CouponManagementController.this.couponManagementView.setKeySearch(null);
			}

		});

		this.couponManagementView.setPrintButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}

		});

	}

}
