package BookManagement.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.MaskFormatter;

public class StatisticBookView extends javax.swing.JFrame {

	/**
	 * Creates new form StatisticView
	 */
	public StatisticBookView() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Thống kê sách:");

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		chuDeRadioButton = new javax.swing.JRadioButton();
		nhaXuatBanRadioButton = new javax.swing.JRadioButton();
		chuDeRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isCheckedNhaXuatBan()) {
					nhaXuatBanRadioButton.setSelected(false);
				}
			}

		});

		nhaXuatBanRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isCheckedChuDe()) {
					chuDeRadioButton.setSelected(false);
				}

			}

		});
		jLabel3 = new javax.swing.JLabel();
		truocNgayCheckBox = new javax.swing.JCheckBox();
		truocNgayCheckBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sauNgayCheckBox.setSelected(false);
				tuNgayCheckBox.setSelected(false);
			}
		});
		sauNgayCheckBox = new javax.swing.JCheckBox();
		sauNgayCheckBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				truocNgayCheckBox.setSelected(false);
				tuNgayCheckBox.setSelected(false);
			}
		});
		try {
			truocNgayFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##--##--####"));
			sauNgayFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##--##--####"));
			tuNgayFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##--##--####"));
			denNgayFormattedTF = new javax.swing.JFormattedTextField(new MaskFormatter("##--##--####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tuNgayCheckBox = new javax.swing.JCheckBox();
		tuNgayCheckBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				truocNgayCheckBox.setSelected(false);
				sauNgayCheckBox.setSelected(false);
			}
		});
		denNgayLabel = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		statisticButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("Thống kê số lượng sách:");
		jLabel1.setToolTipText("");
		jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Tùy chọn:");

		chuDeRadioButton.setText("Theo chủ đề");
		chuDeRadioButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				chuDeRadioButtonActionPerformed(evt);
			}
		});

		nhaXuatBanRadioButton.setText("Theo nhà xuất bản");
		nhaXuatBanRadioButton.setActionCommand("Theo nhà xuất bản");
		nhaXuatBanRadioButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nhaXuatBanRadioButtonActionPerformed(evt);
			}
		});

		jLabel3.setText("Thời gian:");

		truocNgayCheckBox.setText("Trước ngày:");
		truocNgayCheckBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				truocNgayCheckBoxActionPerformed(evt);
			}
		});

		sauNgayCheckBox.setText("Sau ngày:");

		tuNgayCheckBox.setText("Từ ngày:");

		denNgayLabel.setText("Đến ngày:");

		jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		statisticButton.setText("Thống kê");
		statisticButton.setBorder(null);

		cancelButton.setText("Hủy");
		cancelButton.setBorder(null);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								layout.createSequentialGroup()
										.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0,
												Short.MAX_VALUE))
						.addComponent(jSeparator1)
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(90, 90, 90).addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(chuDeRadioButton)
										.addComponent(nhaXuatBanRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(layout.createSequentialGroup().addGap(133, 133, 133)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(truocNgayCheckBox).addComponent(sauNgayCheckBox)
												.addComponent(tuNgayCheckBox))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(sauNgayFormattedTF).addComponent(truocNgayFormattedTF)
												.addComponent(tuNgayFormattedTF, javax.swing.GroupLayout.DEFAULT_SIZE,
														143, Short.MAX_VALUE))
										.addGap(2, 2, 2)
										.addComponent(denNgayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(denNgayFormattedTF, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(211, 211, 211)
										.addComponent(statisticButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18).addComponent(cancelButton,
												javax.swing.GroupLayout.PREFERRED_SIZE, 56,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(37, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(34, 34, 34)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(6, 6, 6).addComponent(chuDeRadioButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(nhaXuatBanRadioButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(truocNgayCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(truocNgayFormattedTF, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(sauNgayCheckBox).addComponent(sauNgayFormattedTF,
										javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(tuNgayCheckBox)
								.addComponent(denNgayFormattedTF, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(tuNgayFormattedTF).addComponent(denNgayLabel,
										javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(51, 51, 51)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
								.addComponent(statisticButton, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		setLocation(350, 120);
		setVisible(true);
		pack();
	}// </editor-fold>

	public boolean isSelectedToTime() {
		return this.truocNgayCheckBox.isSelected();
	}

	public boolean isSelectedFromTime() {
		return this.sauNgayCheckBox.isSelected();
	}

	public boolean isSelectedToAndFromTime() {
		return this.tuNgayCheckBox.isSelected();
	}

	public Date getBeforeDate() {
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd--MM--yyyy");
		String s = truocNgayFormattedTF.getText();
		Date date = null;
		try {
			date = dateFormate.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

	public Date getAfterDate() {
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd--MM--yyyy");
		String s = sauNgayFormattedTF.getText();
		Date date = null;
		try {
			date = dateFormate.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

	public Date getToDate() {
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd--MM--yyyy");
		String s = tuNgayFormattedTF.getText();
		Date date = null;
		try {
			date = dateFormate.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

	public Date getFromDate() {
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd--MM--yyyy");
		String s = denNgayFormattedTF.getText();
		Date date = null;
		try {
			date = dateFormate.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

	public boolean isCheckedChuDe() {
		return this.chuDeRadioButton.isSelected();
	}

	public boolean isCheckedNhaXuatBan() {
		return this.nhaXuatBanRadioButton.isSelected();
	}

	private void chuDeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void nhaXuatBanRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void truocNgayCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public void setStatisticButtonListener(ActionListener listener) {
		this.statisticButton.addActionListener(listener);
	}

	public void setCancelButtonListener(ActionListener listener) {
		this.cancelButton.addActionListener(listener);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new StatisticBookView().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton cancelButton;
	private javax.swing.JRadioButton chuDeRadioButton;
	private javax.swing.JFormattedTextField denNgayFormattedTF;
	private javax.swing.JLabel denNgayLabel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JRadioButton nhaXuatBanRadioButton;
	private javax.swing.JCheckBox sauNgayCheckBox;
	private javax.swing.JFormattedTextField sauNgayFormattedTF;
	private javax.swing.JButton statisticButton;
	private javax.swing.JCheckBox truocNgayCheckBox;
	private javax.swing.JFormattedTextField truocNgayFormattedTF;
	private javax.swing.JCheckBox tuNgayCheckBox;
	private javax.swing.JFormattedTextField tuNgayFormattedTF;
	// End of variables declaration
}
