package BookManagement.View;

import java.awt.Dimension;

import javax.swing.JTable;

public class KQThongKeTheoChuDe extends javax.swing.JFrame {

	/**
	 * Creates new form StatisticResultView
	 */
	public KQThongKeTheoChuDe() {
		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		resultTable = new javax.swing.JTable();
		titleLabel = new javax.swing.JLabel();
		subjectStatisticLabel = new javax.swing.JLabel();
		timeLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		resultTable
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(resultTable);

		titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titleLabel.setText("Kết quả thống kê sách");

		subjectStatisticLabel.setText("Thống kê theo chủ đề:");

		timeLabel.setText("Thời gian:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
						.addGroup(layout
								.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(185, 185, 185)
												.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(subjectStatisticLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE, 130,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
																122, javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(21, 21, 21)
						.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(10, 10, 10)
						.addComponent(subjectStatisticLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		timeLabel.setMaximumSize(new Dimension(100, 28));

		pack();
	}// </editor-fold>

	public JTable getResultTable() {
		return this.resultTable;
	}

	public void setSubjectStatistic(String ss) {
		this.subjectStatisticLabel.setText(ss);
	}

	public void setTimeStatistic(String ts) {
		this.timeLabel.setText(ts);
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new KQThongKeTheoChuDe().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable resultTable;
	private javax.swing.JLabel subjectStatisticLabel;
	private javax.swing.JLabel timeLabel;
	private javax.swing.JLabel titleLabel;
	// End of variables declaration
}
