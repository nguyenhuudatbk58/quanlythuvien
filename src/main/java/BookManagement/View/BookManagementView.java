package BookManagement.View;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class BookManagementView extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form BookManagementView
	 */
	public BookManagementView() {
		initComponents();
	}

	private void initComponents() {

		jToolBar1 = new javax.swing.JToolBar();
		addButton = new javax.swing.JButton();
		editButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();
		searchButton = new javax.swing.JButton();
		caculateButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		bookTable = new javax.swing.JTable();
		jSeparator1 = new javax.swing.JSeparator();
		keySearchFormattedTF = new javax.swing.JFormattedTextField();
		subjectSearchComboBox = new JComboBox<String>();
		subjectSearchComboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Tên sách", "Mã sách", "Chủ đề", "Nhà xuất bản", "Ngày nhập" }));
		refreshButton = new javax.swing.JButton("Refresh");

		jToolBar1.setBorder(new javax.swing.border.SoftBevelBorder(0));
		jToolBar1.setRollover(true);

		addButton.setText("Thêm");
		addButton.setFocusable(false);
		addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(addButton);

		editButton.setText("Chỉnh sửa");
		editButton.setFocusable(false);
		editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(editButton);

		deleteButton.setText("Xóa");
		deleteButton.setFocusable(false);
		deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(deleteButton);

		caculateButton.setText("Thống kê");
		caculateButton.setFocusable(false);
		caculateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		caculateButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(caculateButton);

		JLabel label = new JLabel();
		label.setMaximumSize(new Dimension(350, 28));
		jToolBar1.add(label);

		refreshButton.setFocusable(false);
		refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(refreshButton);

		searchButton.setText("Tìm kiếm");
		searchButton.setFocusable(false);
		searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		searchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(searchButton);

		keySearchFormattedTF.setMaximumSize(new Dimension(200, 28));
		jToolBar1.add(keySearchFormattedTF);

		JLabel subjectSearch = new JLabel("Chủ đề tìm kiếm: ");
		jToolBar1.add(subjectSearch);

		subjectSearchComboBox.setMaximumSize(new Dimension(150, 30));
		jToolBar1.add(subjectSearchComboBox);

		bookTable.setBorder(new javax.swing.border.SoftBevelBorder(0));
		bookTable.setModel(new javax.swing.table.DefaultTableModel(null, new String[] { "STT ", "Tên sách", "Mã sách",
				"Tác giả", "Nhà xuất bản", "Giá ", "Chủ đề", "Ngày thêm" }));
		setSizeColumn();
		jScrollPane1.setViewportView(bookTable);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
				.addComponent(jSeparator1));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
	}

	public void setSizeColumn() {
		TableColumn column;
		for (int i = 0; i < bookTable.getColumnCount(); i++) {
			System.out.println(bookTable.getColumnCount());
			column = bookTable.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setMinWidth(5);
				column.setPreferredWidth(5);
			} else if (i == 1)
				column.setPreferredWidth(150);
			else if (i == 2)
				column.setPreferredWidth(50);
			else if (i == 3)
				column.setPreferredWidth(150);
			else if (i == 4)
				column.setPreferredWidth(150);
			else if (i == 5)
				column.setPreferredWidth(50);
			else if (i == 6)
				column.setPreferredWidth(100);
			else if (i == 7) {
				column.setPreferredWidth(50);
			}
		}
	}

	public void setKeySearch(String keySearch) {
		keySearchFormattedTF.setText(keySearch);
	}

	public void setKeySearchFormater(DefaultFormatterFactory formater) {
		keySearchFormattedTF.setFormatterFactory(formater);

	}

	public String getKeySearch() {
		return keySearchFormattedTF.getText();
	}

	public String getSubjectSearch() {
		return (String) subjectSearchComboBox.getSelectedItem();
	}

	public void setRefreshButtonListener(ActionListener listener) {
		refreshButton.addActionListener(listener);
	}

	public void setSubjectSearchComboBoxListener(ActionListener listener) {
		subjectSearchComboBox.addActionListener(listener);
	}

	public void setAddButtonActionListener(ActionListener addButtonListener) {
		addButton.addActionListener(addButtonListener);

	}

	public void setEditButtonListener(ActionListener editButtonListener) {
		editButton.addActionListener(editButtonListener);
	}

	public void setDeleteButtonListener(ActionListener deleteButtonListener) {
		deleteButton.addActionListener(deleteButtonListener);
	}

	public void setSearchButtonListener(ActionListener searchButtonListener) {
		searchButton.addActionListener(searchButtonListener);
	}

	public void setCaculateButtonListener(ActionListener caculateButtonListener) {
		caculateButton.addActionListener(caculateButtonListener);
	}

	public javax.swing.JTable getBookTable() {
		return bookTable;
	}

	public static void main(String[] args) {
		new BookManagementView().setVisible(true);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton refreshButton;

	private javax.swing.JComboBox<String> subjectSearchComboBox;
	private javax.swing.JFormattedTextField keySearchFormattedTF;
	private javax.swing.JButton addButton;
	private javax.swing.JButton editButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton searchButton;
	private javax.swing.JButton caculateButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable bookTable;
	private javax.swing.JToolBar jToolBar1;
	// End of variables declaration
}