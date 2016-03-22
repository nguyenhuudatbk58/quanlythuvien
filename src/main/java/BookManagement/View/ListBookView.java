package BookManagement.View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.hibernate.mapping.Table;

import DAO.SachDAO;
import Model.Sach;

public class ListBookView extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListBookView() {
		initComponents();
	}

	public static javax.swing.JComboBox<String> getComboBox() {
		return keySearch_ComboBox;
	}

	private void initComponents() {

		// displayBook();

		ImageIcon addBtnIcon;
		Image image;
		image = this.getToolkit().getImage("lib/add.png");
		addBtnIcon = new ImageIcon(image);
		addButton = new javax.swing.JButton("Thêm", addBtnIcon);
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				new AddBookView().setVisible(true);
			}
		});

		keySearch_ComboBox = new javax.swing.JComboBox<String>();
		String[] keySearchs = new String[] { "Tên", "Mã sách", "Tác giả", "Nhà xuất bản", "Chủ đề" };
		keySearch_ComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(keySearchs));
		keySearch_ComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}

		});

		bookTable = new javax.swing.JTable();
		bookTable.setModel(new javax.swing.table.DefaultTableModel(null, new String[] { "STT ", "Tên sách", "Mã sách",
				"Tác giả", "Nhà xuất bản", "Giá ", "Chủ đề", "Ngày thêm" }));
		setSizeColumn();
		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane2.setViewportView(bookTable);

		ImageIcon updateBtnIcon;
		image = this.getToolkit().getImage("lib/updateic.png");
		updateBtnIcon = new ImageIcon(image);
		updateButton = new javax.swing.JButton("Sửa", updateBtnIcon);
		updateButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int selectedRow = bookTable.getSelectedRow();
				System.out.println(selectedRow);
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(null, "Chọn sách cần chỉnh sửa.");
				else {
					Sach sach = new Sach();
					sach.setTen((String) bookTable.getValueAt(selectedRow, 1));
					sach.setMaSach((String) bookTable.getValueAt(selectedRow, 2));
					sach.setTacGia((String) bookTable.getValueAt(selectedRow, 3));
					sach.setNhaXuatBan((String) bookTable.getValueAt(selectedRow, 4));
					sach.setGia((String) bookTable.getValueAt(selectedRow, 5));
					sach.setChuDe((String) bookTable.getValueAt(selectedRow, 6));
					sach.setNgayThem((String) bookTable.getValueAt(selectedRow, 6));

				}
			}
		});

		ImageIcon deleteBtnIcon;
		image = this.getToolkit().getImage("lib/delete.png");
		deleteBtnIcon = new ImageIcon(image);
		deleteButton = new javax.swing.JButton("Xóa", deleteBtnIcon);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = bookTable.getSelectedRow();
				System.out.println(selectedRow);
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(null, "Chọn sách cần xóa.");
				else {

				}
			}
		});

		selectionKeySearch_Label = new javax.swing.JLabel();
		selectionKeySearch_Label.setText("Chọn khóa tìm kiếm:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(selectionKeySearch_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(keySearch_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(43, 43, 43).addComponent(addButton).addGap(18, 18, 18).addComponent(updateButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(deleteButton).addContainerGap(367, Short.MAX_VALUE))
				.addComponent(jScrollPane2));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(31, 31, 31)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(keySearch_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(selectionKeySearch_Label).addComponent(addButton)
								.addComponent(updateButton).addComponent(deleteButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
	}

	private void displayBook() {
		sachDAO = new SachDAO();
		DefaultTableModel tableModel = (DefaultTableModel) bookTable.getModel();
		ArrayList<Sach> sachs = sachDAO.getAll();

		Vector<Object> v;
		for (int i = 0; i < sachs.size(); i++) {
			Sach sach = sachs.get(i);
			v = new Vector<Object>();
			v.add(i + 1);
			v.add(sach.getTen());
			v.add(sach.getMaSach());
			v.add(sach.getTacGia());
			v.add(sach.getNhaXuatBan());
			v.add(sach.getGia());
			v.add(sach.getChuDe());
			v.add(sach.getNgayThem());
			tableModel.addRow(v);
		}
	}

	private void setSizeColumn() {
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

	private Sach convertTableInfoToBook(Table table) {
		Sach sach = new Sach();

		return sach;
	}

	private SachDAO sachDAO;
	private javax.swing.JButton addButton;
	private javax.swing.JButton updateButton;
	private javax.swing.JButton deleteButton;
	private static javax.swing.JComboBox<String> keySearch_ComboBox;
	private javax.swing.JLabel selectionKeySearch_Label;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable bookTable;
}
