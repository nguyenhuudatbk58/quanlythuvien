package BookManagement.View;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.TableColumn;

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

		searchButton.setText("Tìm kiêm");
		searchButton.setFocusable(false);
		searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		searchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(searchButton);

		final JPopupMenu popupMenu = new JPopupMenu();
		searchByTenMenuItem = new JMenuItem("Tìm kiếm theo tên");
		searchByChuDeMenuItem = new JMenuItem("Tìm kiếm theo chủ đề");
		searchByMaSachMenuItem = new JMenuItem("Tìm kiếm theo mã sách");

		JMenu menu = new JMenu("Tìm kiếm theo ngày nhập ");
		JMenuItem menuItem4 = new JMenuItem("Từ ngày...đến ngày...");
		JMenuItem menuItem5 = new JMenuItem("Trước ngày...");
		JMenuItem menuItem6 = new JMenuItem("Sau ngày...");
		JMenuItem menuItem7 = new JMenuItem("Ngày...");

		menu.add(menuItem4);
		menu.add(menuItem5);
		menu.add(menuItem6);
		menu.add(menuItem7);

		popupMenu.add(searchByTenMenuItem);
		popupMenu.add(searchByChuDeMenuItem);
		popupMenu.add(searchByMaSachMenuItem);
		popupMenu.add(menu);
		searchButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				popupMenu.show(searchButton, e.getX(), e.getY());
			}

		});

		caculateButton.setText("Thống kê");
		caculateButton.setFocusable(false);
		caculateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		caculateButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(caculateButton);

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

	public void setSearchByTenMenuItemListener(ActionListener listener) {
		searchByTenMenuItem.addActionListener(listener);
	}

	public void setSearchByChuDeMenuItemListener(ActionListener listener) {
		searchByChuDeMenuItem.addActionListener(listener);
	}

	public void setSearchByMaSachMenuItemListener(ActionListener listener) {
		searchByMaSachMenuItem.addActionListener(listener);
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
	private JMenuItem searchByMaSachMenuItem;
	private JMenuItem searchByChuDeMenuItem;
	private JMenuItem searchByTenMenuItem;
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