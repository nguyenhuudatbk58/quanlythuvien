package TraSach;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class TraSachView extends javax.swing.JFrame {

	public TraSachView() {
		initComponents();
	}

	private void initComponents() {

		couponCodeTitle = new javax.swing.JLabel();
		memberCodeTitle = new javax.swing.JLabel();
		memberNameTitle = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		bookTable = new javax.swing.JTable() {
			public Class getColumnClass(int column) {
				if (column == 5) {
					return Boolean.class;
				} else if (column == 1 || column == 2) {
					return Date.class;
				} else {
					return String.class;
				}
			}

			public boolean isCellEditable(int row, int col) {
				if (col != 5) {
					return false;
				} else {
					return true;
				}
			}
		};
		prepayMoneyTitle = new javax.swing.JLabel();
		mulctTitle = new javax.swing.JLabel();
		payBookButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();
		couponCodeComboBox = new javax.swing.JComboBox();
		AutoCompleteDecorator.decorate(couponCodeComboBox);
		memberCode = new javax.swing.JLabel();
		memberName = new javax.swing.JLabel();
		prepayMoney = new javax.swing.JLabel();
		mulct = new javax.swing.JLabel();
		title = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		couponCodeTitle.setText("Mã phiếu");

		memberCodeTitle.setText("Mã thành viên");

		memberNameTitle.setText("Tên thành viên");

		bookTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } },
				new String[] { "Mã sách", "Ngày mượn", "Ngày trả", "Trạng thái", "Tiền phạt", "Chọn sách" }));
		jScrollPane1.setViewportView(bookTable);

		prepayMoneyTitle.setText("Tiền cọc");

		mulctTitle.setText("Tiền phạt:");

		payBookButton.setText("Trả sách");

		cancelButton.setText("Hủy");

		couponCodeComboBox.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		memberCode.setText(" 2013 0837");

		memberName.setText("Nguyễn Hữu Đạt");

		prepayMoney.setText("0 (dong)");

		mulct.setText("0 (dong)");

		title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		title.setText("Chọn sách cần trả");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
														false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(couponCodeTitle,
																javax.swing.GroupLayout.PREFERRED_SIZE, 115,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18).addComponent(couponCodeComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE, 159,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(memberCodeTitle,
																javax.swing.GroupLayout.PREFERRED_SIZE, 115,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(memberNameTitle,
																javax.swing.GroupLayout.PREFERRED_SIZE, 91,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(prepayMoneyTitle,
																javax.swing.GroupLayout.PREFERRED_SIZE, 91,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(mulctTitle,
																javax.swing.GroupLayout.PREFERRED_SIZE, 91,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(memberCode,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(memberName,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(prepayMoney,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(mulct,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))))
										.addGroup(layout.createSequentialGroup().addGap(133, 133, 133).addComponent(
												title, javax.swing.GroupLayout.PREFERRED_SIZE, 271,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(layout.createSequentialGroup().addGap(262, 262, 262)
										.addComponent(payBookButton).addGap(18, 18, 18).addComponent(cancelButton)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(22, 22, 22)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(couponCodeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(couponCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(memberCodeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(memberCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(memberNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(prepayMoneyTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(prepayMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(mulctTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(mulct, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 21,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(payBookButton).addComponent(cancelButton))
						.addContainerGap()));

		mulct.setMaximumSize(new Dimension(100, 28));
		setVisible(true);
		pack();
	}

	public String getCouponCode() {
		return (String) this.couponCodeComboBox.getSelectedItem();
	}

	public JTable getBookTable() {
		return this.bookTable;
	}

	public void setCouponCodes(String[] couponCode) {
		this.couponCodeComboBox.setModel(new DefaultComboBoxModel<String>(couponCode));
	}

	public void setMemberName(String memberName) {
		this.memberName.setText(memberName);
	}

	public void setMemberCode(String memberCode) {
		this.memberCode.setText(memberCode);
	}

	public void setPrePayMoney(String prepayMoney) {
		this.prepayMoney.setText(prepayMoney);
	}

	public void setMulct(String muclt) {
		this.mulct.setText(muclt + " (5000 dong/ngay)");
	}

	public void setCouponCodeComboBoxListener(ActionListener listener) {
		this.couponCodeComboBox.addActionListener(listener);
	}

	public void setPayBookButtonListener(ActionListener listener) {
		this.payBookButton.addActionListener(listener);
	}

	public void setCancelButtonListener(ActionListener listener) {
		this.cancelButton.addActionListener(listener);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TraSachView().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton cancelButton;
	private javax.swing.JButton payBookButton;
	private javax.swing.JComboBox couponCodeComboBox;
	private javax.swing.JLabel couponCodeTitle;
	private javax.swing.JLabel title;
	private javax.swing.JLabel memberCodeTitle;
	private javax.swing.JLabel memberNameTitle;
	private javax.swing.JLabel prepayMoneyTitle;
	private javax.swing.JLabel mulctTitle;
	private javax.swing.JLabel memberCode;
	private javax.swing.JLabel memberName;
	private javax.swing.JLabel prepayMoney;
	private javax.swing.JLabel mulct;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable bookTable;
	// End of variables declaration
}
