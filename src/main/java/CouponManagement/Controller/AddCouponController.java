package CouponManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import CouponManagement.View.AddCouponView;
import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import DAO.ThanhVienDAO;
import Model.PhieuMuon;
import Model.SachMuon;

public class AddCouponController {

	private PhieuMuonDAO pmd;

	private AddCouponView addCouponView;

	private CouponManagementController cmc;

	public AddCouponController(AddCouponView addCouponView, CouponManagementController cmc) {
		this.addCouponView = addCouponView;
		this.cmc = cmc;

		loadBookCodes();
		loadMemberCodes();

		this.addCouponView.setAddButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bookCode = AddCouponController.this.addCouponView.getBookCode();
				Date loanDate = AddCouponController.this.addCouponView.getLoanDate();
				Date payDate = AddCouponController.this.addCouponView.getPayDate();

				if (loanDate == null) {
					JOptionPane.showMessageDialog(null, "Nhập ngày mượn sách");
					return;
				}
				if (payDate == null) {
					JOptionPane.showMessageDialog(null, "Nhập hạn trả sách");
					return;
				}
				AddCouponController.this.addCouponView.addLoanBookInTable(bookCode, loanDate, payDate);

			}
		});
		this.addCouponView.setEditButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = AddCouponController.this.addCouponView.getSelectedRow();
				if (selectedRow != -1) {
					String selectedBookCode = AddCouponController.this.addCouponView.getBookCodeAtRow(selectedRow);
					Date loanDate = AddCouponController.this.addCouponView.getLoanDateAtRow(selectedRow);
					Date payDate = AddCouponController.this.addCouponView.getPayDateAtRow(selectedRow);
					new EditLoanBook(selectedBookCode, loanDate, payDate, AddCouponController.this.addCouponView,
							selectedRow);
				} else {
					JOptionPane.showMessageDialog(null, "Chọn sách cần chỉnh sửa.");
				}
			}

		});

		this.addCouponView.setDeleteButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int selectedRow = AddCouponController.this.addCouponView.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Chọn sách muốn xóa");

				} else {
					AddCouponController.this.addCouponView.deleteLoanBookInTable(selectedRow);
				}

			}

		});

		this.addCouponView.setAddCouponButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String couponCode = AddCouponController.this.addCouponView.getCouponCode();
				String memberCode = AddCouponController.this.addCouponView.getMemberCode();

				if (couponCode == null) {
					JOptionPane.showMessageDialog(null, "Nhập mã phiếu mượn.");
					return;
				}
				HashSet<SachMuon> sms = AddCouponController.this.addCouponView.getSachMuons();

				if (sms.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nhập sách mượn");
					return;
				}

				PhieuMuon pm = new PhieuMuon();

				pm.setMaPhieu(couponCode);
				pm.setMaThanhVien(memberCode);
				pm.setSachMuon(sms);

				pmd.save(pm);

				AddCouponController.this.cmc.loadCoupons();

			}

		});
		this.addCouponView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCouponController.this.addCouponView.setVisible(false);
				AddCouponController.this.addCouponView.dispose();
			}

		});

		this.addCouponView.setMemberComboBoxListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String memberCode = AddCouponController.this.addCouponView.getMemberCode();
				ThanhVienDAO tvd = null;
				String memberName = tvd.getMemberNameByMemberCode(memberCode);
				AddCouponController.this.addCouponView.setMemberName(memberName);
				AddCouponController.this.addCouponView.setCouponCode(null);
				AddCouponController.this.addCouponView.resetTable();
				PhieuMuon pm = pmd.getByMemberCode(memberCode);
				if (pm == null) {
					return;
				} else {

					AddCouponController.this.addCouponView.setCouponCode(pm.getMaPhieu());
					Set<SachMuon> sms = (Set<SachMuon>) pm.getSachMuon();
					Iterator iterator = sms.iterator();
					while (iterator.hasNext()) {
						SachMuon sm = (SachMuon) iterator.next();
						AddCouponController.this.addCouponView.addLoanBookInTable(sm.getMaSach(), sm.getNgayMuon(),
								sm.getNgayTra());
					}
				}
			}
		});

		this.addCouponView.setCouponTFDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {
				AddCouponController.this.addCouponView.setError(null);

			}

			public void insertUpdate(DocumentEvent e) {
				String couponCode = AddCouponController.this.addCouponView.getCouponCode();
				PhieuMuon pm = pmd.getByCouponCode(couponCode);
				if (pm != null) {
					if ( (pm.getMaThanhVien()).equals(AddCouponController.this.addCouponView.getMemberCode()) == false) {
						AddCouponController.this.addCouponView.setError("Mã phiếu đã tồn tại");
					}
				}

			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

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
		String memberCode = AddCouponController.this.addCouponView.getMemberCode();
		String memberName = tvd.getMemberNameByMemberCode(memberCode);
		AddCouponController.this.addCouponView.setMemberName(memberName);
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

class EditLoanBook extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	private AddCouponView addCouponView;

	public EditLoanBook(String selectedItem, Date loanDate, Date payDate, AddCouponView addCouponView,
			int selectedRow) {
		this.addCouponView = addCouponView;
		initComponents(selectedItem, loanDate, payDate, selectedRow);
	}

	private void initComponents(String selectedItem, Date loanDate, Date payDate, final int selectedRow) {

		titileLabel = new javax.swing.JLabel();
		bookCodeLabel = new javax.swing.JLabel();
		loanDateLabel = new javax.swing.JLabel();
		payDateLabel = new javax.swing.JLabel();
		bookCodeComboBox = new javax.swing.JComboBox<String>();
		loadBookCodes();
		bookCodeComboBox.setSelectedItem(selectedItem);
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			loanDateFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##-##-####"));
			payDateFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##-##-####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loanDateFormattedTF.setText(dateFormat.format(loanDate));
		payDateFormattedTF.setText(dateFormat.format(payDate));
		updateButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		titileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titileLabel.setText("Chỉnh sửa thông tin sách");

		bookCodeLabel.setText("Mã sách:");

		loanDateLabel.setText("Ngày mượn:");

		payDateLabel.setText("Hạn trả:");

		updateButton.setText("Cập nhật");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date loanDate = null;
				Date payDate = null;
				try {
					loanDate = dateFormat.parse(loanDateFormattedTF.getText());
					payDate = dateFormat.parse(payDateFormattedTF.getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (loanDate == null) {
					JOptionPane.showMessageDialog(null, "Nhập ngày mượn sách");
					return;
				}
				if (payDate == null) {
					JOptionPane.showMessageDialog(null, "Nhập hạn trả sách");
					return;
				}
				String bookCode = (String) bookCodeComboBox.getSelectedItem();
				addCouponView.setLoanBookInTableAtRow(bookCode, loanDate, payDate, selectedRow);
			}

		});

		cancelButton.setText("Hủy    ");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(104, 104, 104).addComponent(updateButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
										cancelButton))
						.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(
										titileLabel,
										javax.swing.GroupLayout.PREFERRED_SIZE, 185,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
												.createSequentialGroup()
												.addComponent(payDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(payDateFormattedTF))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
												.createSequentialGroup()
												.addComponent(loanDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(loanDateFormattedTF))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
												.createSequentialGroup()
												.addComponent(bookCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(bookCodeComboBox,
														javax.swing.GroupLayout.PREFERRED_SIZE, 145,
														javax.swing.GroupLayout.PREFERRED_SIZE))))))
				.addContainerGap(92, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
						.addComponent(titileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(bookCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(bookCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(loanDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createSequentialGroup().addGap(3, 3, 3).addComponent(loanDateFormattedTF,
												javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(payDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(payDateFormattedTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(updateButton).addComponent(cancelButton))
						.addGap(22, 22, 22)));

		setVisible(true);

		pack();
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

		this.bookCodeComboBox.setModel(new DefaultComboBoxModel<String>(mbc));
	}

	private javax.swing.JComboBox bookCodeComboBox;
	private javax.swing.JLabel bookCodeLabel;
	private javax.swing.JButton cancelButton;
	private javax.swing.JFormattedTextField loanDateFormattedTF;
	private javax.swing.JLabel loanDateLabel;
	private javax.swing.JFormattedTextField payDateFormattedTF;
	private javax.swing.JLabel payDateLabel;
	private javax.swing.JLabel titileLabel;
	private javax.swing.JButton updateButton;

}
