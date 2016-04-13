package MemeberManagement.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import DAO.ThanhVienDAO;
import MemeberManagement.Controller.MemeberManagementController;

public class SearchMemberView {

	private TableRowSorter<TableModel> sorter;

	public SearchMemberView(TableRowSorter<TableModel> sorter) {
		this.sorter = sorter;
	}

	public void displaySearchByTenView() {
		new SearchByTenView(sorter);
	}

	public void displaySearchByMaThanhVienView() {
		new SearchByMaThanhVienView(sorter);
	}

	public void displaySearchByEmailView() {
		new SearchByEmailView(sorter);
	}

	public void displaySearchByNgayThamGiaView(MemeberManagementController mmc, DefaultTableModel tableModel) {
		new SearchByNgayThamGiaView(mmc, tableModel, sorter);
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

		jLabel1.setText("Tên thành viên");

		jLabel2.setText("Tìm kiếm Thành viên theo tên:");

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

class SearchByMaThanhVienView extends javax.swing.JFrame {

	public SearchByMaThanhVienView(TableRowSorter<TableModel> sorter) {
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
				sorter.setRowFilter(RowFilter.regexFilter(expr, 2));
			}
		});

		jLabel1.setText("Mã thành viên:");

		jLabel2.setText("Tìm kiếm Thành viên theo mã thành viên:");

		endButton.setText("Kết thúc");
		endButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sorter.setRowFilter(null);
				SearchByMaThanhVienView.this.setVisible(false);
				SearchByMaThanhVienView.this.dispose();
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

class SearchByEmailView extends javax.swing.JFrame {

	public SearchByEmailView(TableRowSorter<TableModel> sorter) {
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
				sorter.setRowFilter(RowFilter.regexFilter(expr, 3));
			}
		});

		jLabel1.setText("Email:");

		jLabel2.setText("Tìm kiếm Thành viên theo email:");

		endButton.setText("Kết thúc");
		endButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sorter.setRowFilter(null);
				SearchByEmailView.this.setVisible(false);
				SearchByEmailView.this.dispose();
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

class SearchByNgayThamGiaView extends javax.swing.JFrame {
	private ThanhVienDAO thanhVienDAO;

	public SearchByNgayThamGiaView(MemeberManagementController mmc, DefaultTableModel tableModel,
			TableRowSorter<TableModel> sorter) {
		initComponents(mmc, tableModel, sorter);
	}

	private void initComponents(final MemeberManagementController mmc, final DefaultTableModel tableModel,
			final TableRowSorter<TableModel> sorter) {

		searchButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		try {
			jTextField1 = new javax.swing.JFormattedTextField(new MaskFormatter("##-##-####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jLabel2 = new javax.swing.JLabel();
		endButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		searchButton.setText("Tìm kiếm");
		searchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String expr = jTextField1.getText();
				SimpleDateFormat dateFormate = new SimpleDateFormat("dd-MM-yyyy");
				Date date = null;
				try {
					date = dateFormate.parse(expr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println(date.getTime());

				sorter.setRowFilter(RowFilter.dateFilter(RowFilter.ComparisonType.EQUAL, date, 5));

				// ArrayList<ThanhVien> members = thanhVienDAO.getAll();
				//
				// Vector<Object> v;
				// for (int i = 0; i < members.size(); i++) {
				// ThanhVien member = members.get(i);
				// v = new Vector<Object>();
				// if (member.getNgay_tham_gia().equals(date)) {
				// v.add(i + 1);
				// v.add(member.getTen());
				// v.add(member.getMaThanhVien());
				// v.add(member.getEmail());
				// v.add(member.getDiaChi());
				// v.add(member.getNgay_tham_gia());
				// tableModel.addRow(v);
				// }
				// }

			}
		});

		jLabel1.setText("Ngày tham gia:");

		jLabel2.setText("Tìm kiếm Thành viên theo ngày tham gia:");

		endButton.setText("Kết thúc");
		endButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mmc.loadMembers();
				SearchByNgayThamGiaView.this.setVisible(false);
				SearchByNgayThamGiaView.this.dispose();
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
	private javax.swing.JFormattedTextField jTextField1;
}
