package CouponManagement.View;

import java.awt.event.ActionListener;

import javax.swing.JTable;

public class PrintCouponView extends javax.swing.JFrame {

	public PrintCouponView() {
		initComponents();
	}

	private void initComponents() {

		setTitle("Phiếu mượn:");

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		memberCodelabel = new javax.swing.JLabel();
		couponCodeLable = new javax.swing.JLabel();
		couponCodeTF = new javax.swing.JTextField();
		couponCodeTF.setEditable(false);
		memberCodeTF = new javax.swing.JTextField();
		memberCodeTF.setEditable(false);
		jScrollPane3 = new javax.swing.JScrollPane();
		loanBookTable = new javax.swing.JTable();
		printButton = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		memberCodelabel.setText("Mã thành viên");

		couponCodeLable.setText("Mã phiếu mượn");

		loanBookTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		loanBookTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Mã sách", "Ngày mượn", "Ngày trả" }));
		jScrollPane3.setViewportView(loanBookTable);

		printButton.setText("  In   ");

		jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE).addGroup(layout
						.createSequentialGroup().addGroup(layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout
										.createSequentialGroup().addGap(45, 45, 45).addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(couponCodeLable, javax.swing.GroupLayout.DEFAULT_SIZE,
														102, Short.MAX_VALUE)
												.addComponent(memberCodelabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(40, 40, 40)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(couponCodeTF, javax.swing.GroupLayout.DEFAULT_SIZE, 198,
														Short.MAX_VALUE)
												.addComponent(memberCodeTF)))
								.addGroup(
										layout.createSequentialGroup().addGap(305, 305, 305).addComponent(printButton)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(jSeparator1));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(37, 37, 37)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(couponCodeLable, javax.swing.GroupLayout.PREFERRED_SIZE,
												34, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(couponCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(
										memberCodelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(memberCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 18, 18)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(72, 72, 72)
						.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
						.addComponent(printButton)));

		setVisible(true);
		pack();
	}

	public void setPrintButtonListener(ActionListener listener) {
		this.printButton.addActionListener(listener);
	}

	public void setCouponCode(String coponCode) {
		this.couponCodeTF.setText(coponCode);
	}

	public void setMemberCode(String memberCode) {
		this.memberCodeTF.setText(memberCode);
	}

	public JTable getLoanBookTable() {
		return this.loanBookTable;
	}

	public void setExitButtonListener(ActionListener listener) {
		printButton.addActionListener(listener);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DisplayCouponView().setVisible(true);
			}
		});
	}

	private javax.swing.JButton printButton;
	private javax.swing.JLabel couponCodeLable;
	private javax.swing.JTextField couponCodeTF;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTable loanBookTable;
	private javax.swing.JTextField memberCodeTF;
	private javax.swing.JLabel memberCodelabel;
}
