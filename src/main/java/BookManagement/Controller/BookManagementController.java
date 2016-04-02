package BookManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BookManagement.View.AddBookView;
import BookManagement.View.BookManagementView;
import BookManagement.View.CaculateView;
import BookManagement.View.DeleteBookView;
import BookManagement.View.EditBookView;
import BookManagement.View.SearchBookView;
import DAO.SachDAO;
import Model.Sach;

public class BookManagementController {

	private SachDAO sachDAO;

	private BookManagementView bookManagementView;

	private ArrayList<Sach> books;

	public BookManagementController(BookManagementView bookManagementView) {
		this.bookManagementView = bookManagementView;

		loadBooks();

		this.bookManagementView.setAddButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBookController(new AddBookView(), BookManagementController.this);
			}
		});

		this.bookManagementView.setEditButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable bookTable = BookManagementController.this.bookManagementView.getBookTable();
				int selectedRow = bookTable.getSelectedRow();
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(null, "Chọn sách cần chỉnh sửa.");
				else {

					Sach book = new Sach();

					book.setTen((String) bookTable.getValueAt(selectedRow, 1));
					book.setMaSach((String) bookTable.getValueAt(selectedRow, 2));
					book.setTacGia((String) bookTable.getValueAt(selectedRow, 3));
					book.setNhaXuatBan((String) bookTable.getValueAt(selectedRow, 4));
					book.setGia((String) bookTable.getValueAt(selectedRow, 5));
					book.setChuDe((String) bookTable.getValueAt(selectedRow, 6));
					book.setNgayThem((String) bookTable.getValueAt(selectedRow, 7));
					book.setId(books.get(selectedRow).getId());

					new EditBookController(new EditBookView(), book, BookManagementController.this);
				}
			}
		});

		this.bookManagementView.setDeleteButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable bookTable = BookManagementController.this.bookManagementView.getBookTable();
				int selectedRow = bookTable.getSelectedRow();
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(null, "Chọn sách cần xóa.");
				else {

					Sach book = new Sach();

					book.setTen((String) bookTable.getValueAt(selectedRow, 1));
					book.setMaSach((String) bookTable.getValueAt(selectedRow, 2));
					book.setTacGia((String) bookTable.getValueAt(selectedRow, 3));
					book.setNhaXuatBan((String) bookTable.getValueAt(selectedRow, 4));
					book.setGia((String) bookTable.getValueAt(selectedRow, 5));
					book.setChuDe((String) bookTable.getValueAt(selectedRow, 6));
					book.setNgayThem((String) bookTable.getValueAt(selectedRow, 7));
					book.setId(books.get(selectedRow).getId());

					new DeleteBookController(new DeleteBookView(), book, BookManagementController.this);
				}
			}
		});

		this.bookManagementView.setCaculateButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CaculateController(new CaculateView());
			}
		});
	}

	public void loadBooks() {
		JTable bookTable = bookManagementView.getBookTable();
		javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(null, new String[] {
				"STT ", "Tên sách", "Mã sách", "Tác giả", "Nhà xuất bản", "Giá ", "Chủ đề", "Ngày thêm" }) {
			public Class getColumnClass(int column) {
				if (column == 0) {
					return Integer.class;
				} else {
					return String.class;
				}
			}
		};
		bookTable.setModel(tableModel);
		this.bookManagementView.setSizeColumn();
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
		bookTable.setRowSorter(sorter);
		books = sachDAO.getAll();

		Vector<Object> v;
		for (int i = 0; i < books.size(); i++) {
			Sach sach = books.get(i);
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
		this.bookManagementView.setSearchByTenMenuItemListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				(new SearchBookView(sorter)).displaySearchByTenView();
			}

		});

		this.bookManagementView.setSearchByChuDeMenuItemListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				(new SearchBookView(sorter)).displaySearchByChuDeView();
			}
		});

	}

}
