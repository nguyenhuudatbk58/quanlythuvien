package CouponManagement.View;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Model.SachMuon;

public class EditCouponView extends javax.swing.JFrame {

	public EditCouponView() {
		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		memberCodeLabel = new javax.swing.JLabel();
		couponCodeLabel = new javax.swing.JLabel();
		couponCodeTextField = new javax.swing.JTextField("Ma phiue");
		memberCodeTextField = new javax.swing.JTextField("Ma thanh vien");
		ToolBar = new javax.swing.JToolBar();
		bookCodeLabel = new javax.swing.JLabel();
		bookCodeTextField = new javax.swing.JTextField();
		dayLoanLabel = new javax.swing.JLabel();
		try {
			dayLoanFormattedTextField = new javax.swing.JFormattedTextField(new MaskFormatter("##-##-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dayPayLabel = new javax.swing.JLabel();
		try {
			dayPayFormattedTextField = new javax.swing.JFormattedTextField(new MaskFormatter("##-##-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		addButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		loanBookTable = new javax.swing.JTable() {

			public Class getClassColumn(int column) {
				if (column == 0) {
					return String.class;
				} else {
					return Date.class;
				}
			}

			public boolean isEditableColumn(int column) {
				return false;
			}
		};
		cancelButton = new javax.swing.JButton();
		addCouponButton = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();

		setTitle("Thêm phiếu mượn");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		memberCodeLabel.setText("Mã thành viên");

		couponCodeLabel.setText("Mã phiếu mượn");

		ToolBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		ToolBar.setFloatable(false);
		ToolBar.setRollover(true);

		bookCodeLabel.setText("Mã sách");
		bookCodeLabel.setMaximumSize(new java.awt.Dimension(50, 30));
		ToolBar.add(bookCodeLabel);

		bookCodeTextField.setMaximumSize(new java.awt.Dimension(200, 30));
		ToolBar.add(bookCodeTextField);

		dayLoanLabel.setText("Ngày mượn :");
		dayLoanLabel.setMaximumSize(new java.awt.Dimension(80, 30));
		ToolBar.add(dayLoanLabel);

		dayLoanFormattedTextField.setText("00--00-0000");
		dayLoanFormattedTextField.setMaximumSize(new java.awt.Dimension(100, 30));
		ToolBar.add(dayLoanFormattedTextField);

		dayPayLabel.setText("Ngày trả :");
		dayPayLabel.setMaximumSize(new java.awt.Dimension(60, 30));
		ToolBar.add(dayPayLabel);

		dayPayFormattedTextField.setText("00--00-0000");
		dayPayFormattedTextField.setMaximumSize(new java.awt.Dimension(100, 30));
		ToolBar.add(dayPayFormattedTextField);

		addButton.setText("Thêm");
		addButton.setBorder(null);
		addButton.setFocusable(false);
		addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		addButton.setMaximumSize(new java.awt.Dimension(47, 25));
		addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		ToolBar.add(addButton);

		editButton.setText("Sửa");
		editButton.setBorder(null);
		editButton.setFocusable(false);
		editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		editButton.setMaximumSize(new java.awt.Dimension(47, 25));
		editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		ToolBar.add(editButton);

		deleteButton.setText("Xóa");
		deleteButton.setBorder(null);
		deleteButton.setFocusable(false);
		deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		deleteButton.setMaximumSize(new java.awt.Dimension(47, 25));
		deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		ToolBar.add(deleteButton);

		loanBookTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		loanBookTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Mã sách", "Ngày mượn", "Ngày trả" }));
		jScrollPane3.setViewportView(loanBookTable);

		cancelButton.setText("Hủy");

		addCouponButton.setText("Thêm");

		jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(45, 45, 45)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(couponCodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 102,
										Short.MAX_VALUE)
								.addComponent(memberCodeLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(40, 40, 40)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(couponCodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 198,
										Short.MAX_VALUE)
								.addComponent(memberCodeTextField))
						.addContainerGap(373, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(addCouponButton).addGap(18, 18, 18).addComponent(cancelButton).addGap(21, 21, 21))
				.addGroup(layout.createSequentialGroup()
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 725,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jScrollPane3));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(37, 37, 37)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(couponCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												couponCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
										layout.createSequentialGroup().addGap(11, 11, 11).addComponent(memberCodeLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(memberCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cancelButton).addComponent(addCouponButton))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		setVisible(true);
		pack();
	}

	public void setCouponCode(String coponCode) {
		this.couponCodeTextField.setText(coponCode);
	}

	public void setMemberCode(String memberCode) {
		this.memberCodeTextField.setText(memberCode);
	}

	public JTable getLoanBookTable() {
		return loanBookTable;
	}

	public int getSelectedRow() {
		if (loanBookTable.getSelectedRow() == -1) {
			return -1;
		}
		lastSelectedRow = loanBookTable.getSelectedRow();
		return lastSelectedRow;
	}

	public int getLastSelectedRow() {
		return lastSelectedRow;
	}

	public void setBookCode(String bookCode) {
		this.bookCodeTextField.setText(bookCode);
	}

	public void setPayDate(Date payDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.dayPayFormattedTextField.setText(dateFormat.format(payDate));
	}

	public void setLoanDate(Date loanDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.dayLoanFormattedTextField.setText(dateFormat.format(loanDate));
	}

	public String getBookCode() {
		return this.bookCodeTextField.getText();
	}

	public Date getPayDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date payDate = null;
		try {
			payDate = dateFormat.parse(dayPayFormattedTextField.getText());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return payDate;
	}

	public Date getLoanDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date loanDate = null;
		try {
			loanDate = dateFormat.parse(dayLoanFormattedTextField.getText());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return loanDate;
	}

	public void addLoanBookInTable(String bookCode, Date loanDate, Date payDate) {
		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		Vector<Object> v = new Vector<Object>();

		v.add(bookCode);
		v.add(loanDate);
		v.add(payDate);

		tableModel.addRow(v);
	}

	public void setLoanBookInTableAtRow(String bookCode, Date loanDate, Date payDate, int row) {
		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		tableModel.setValueAt(bookCode, row, 0);
		tableModel.setValueAt(loanDate, row, 1);
		tableModel.setValueAt(payDate, row, 2);

	}

	public void deleteLoanBookInTable(int selectedRow) {
		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();

		tableModel.removeRow(selectedRow);
	}

	public SachMuon getValueAtRow(int selectedRow) {
		DefaultTableModel tableModel = (DefaultTableModel) loanBookTable.getModel();
		SachMuon loanBook = new SachMuon();
		loanBook.setMaSach((String) tableModel.getValueAt(selectedRow, 0));
		loanBook.setNgayMuon((Date) tableModel.getValueAt(selectedRow, 1));
		loanBook.setNgayTra((Date) tableModel.getValueAt(selectedRow, 2));
		return loanBook;
	}

	public void setAddButtonListener(ActionListener listener) {
		this.addButton.addActionListener(listener);
	}

	public void setEditButtonListener(ActionListener listener) {
		this.editButton.addActionListener(listener);
	}

	public void setDeleteButtonListener(ActionListener listener) {
		this.deleteButton.addActionListener(listener);
	}

	public void setAddCouponButtonListener(ActionListener listener) {
		this.addCouponButton.addActionListener(listener);
	}

	public void setCancelButtonListener(ActionListener listener) {
		this.cancelButton.addActionListener(listener);
	}

	// Variables declaration - do not modify
	private int lastSelectedRow;
	private javax.swing.JButton cancelButton;
	private javax.swing.JButton addButton;
	private javax.swing.JButton addCouponButton;
	private javax.swing.JButton editButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JFormattedTextField dayLoanFormattedTextField;
	private javax.swing.JFormattedTextField dayPayFormattedTextField;
	private javax.swing.JLabel memberCodeLabel;
	private javax.swing.JLabel couponCodeLabel;
	private javax.swing.JLabel bookCodeLabel;
	private javax.swing.JLabel dayLoanLabel;
	private javax.swing.JLabel dayPayLabel;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTable loanBookTable;
	private javax.swing.JTextField couponCodeTextField;
	private javax.swing.JTextField memberCodeTextField;
	private javax.swing.JTextField bookCodeTextField;
	private javax.swing.JToolBar ToolBar;
	// End of variables declaration
}
