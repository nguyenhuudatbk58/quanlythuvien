package BookManagement.View;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchBookView {

	private TableRowSorter<TableModel> sorter;

	public SearchBookView(TableRowSorter<TableModel> sorter) {
		this.sorter = sorter;
	}

	public void displaySearchByTenView() {
		new SearchByTenView(sorter);
	}

	public void displaySearchByChuDeView() {
		new SearchByChuDeView(sorter);
	}

}

class SearchByTenView extends javax.swing.JFrame {

	public SearchByTenView(TableRowSorter<TableModel> sorter) {
		initComponents(sorter);
	}

	private void initComponents(final TableRowSorter<TableModel> sorter) {

		searchButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		endButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		searchButton.setText("Tìm kiếm");
		searchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String expr = jTextField1.getText();
				sorter.setRowFilter(RowFilter.regexFilter(expr, 1));
			}
		});

		jLabel1.setText("Tên sách");

		jLabel2.setText("Tìm kiếm Sách theo tên:");

		endButton.setText("Kết thúc");
		endButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sorter.setRowFilter(null);
				SearchByTenView.this.setVisible(false);
				SearchByTenView.this.dispose();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(jLabel1).addGap(18, 18, 18)
						.addComponent(jTextField1).addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(59, Short.MAX_VALUE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(56, 56, 56))
				.addGroup(layout.createSequentialGroup().addGap(89, 89, 89).addComponent(searchButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(endButton)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap()
										.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26,
												Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(40, 40, 40)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(searchButton).addComponent(endButton))
										.addGap(30, 30, 30)));

		setLocation(450, 0);
		setVisible(true);
		pack();
	}

	private javax.swing.JButton searchButton;
	private javax.swing.JButton endButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField jTextField1;
}

class SearchByChuDeView extends javax.swing.JFrame {

	public SearchByChuDeView(TableRowSorter<TableModel> sorter) {
		initComponents(sorter);
	}

	private void initComponents(final TableRowSorter<TableModel> sorter) {

		searchButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		endButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		searchButton.setText("Tìm kiếm");
		searchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String expr = jTextField1.getText();
				sorter.setRowFilter(RowFilter.regexFilter(expr, 6));
			}
		});

		jLabel1.setText("Chủ đề:");

		jLabel2.setText("Tìm kiếm Sách theo chủ đề:");

		endButton.setText("Kết thúc");
		endButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sorter.setRowFilter(null);
				SearchByChuDeView.this.setVisible(false);
				SearchByChuDeView.this.dispose();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(jLabel1).addGap(18, 18, 18)
						.addComponent(jTextField1).addContainerGap())
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(59, Short.MAX_VALUE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(56, 56, 56))
				.addGroup(layout.createSequentialGroup().addGap(89, 89, 89).addComponent(searchButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(endButton)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap()
										.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26,
												Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(40, 40, 40)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(searchButton).addComponent(endButton))
										.addGap(30, 30, 30)));

		setLocation(450, 0);
		setVisible(true);
		pack();
	}

	private javax.swing.JButton searchButton;
	private javax.swing.JButton endButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField jTextField1;
}
