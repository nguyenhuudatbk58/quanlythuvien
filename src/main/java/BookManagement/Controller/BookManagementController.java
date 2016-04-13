package BookManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import BookManagement.View.AddBookView;
import BookManagement.View.BookManagementView;
import BookManagement.View.DeleteBookView;
import BookManagement.View.EditBookView;
import BookManagement.View.KQThongKeTheoChuDe;
import BookManagement.View.StatisticBookView;
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

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

					Sach book = new Sach();

					book.setTen((String) bookTable.getValueAt(selectedRow, 1));
					book.setMaSach((String) bookTable.getValueAt(selectedRow, 2));
					book.setTacGia((String) bookTable.getValueAt(selectedRow, 3));
					book.setNhaXuatBan((String) bookTable.getValueAt(selectedRow, 4));
					book.setGia((String) bookTable.getValueAt(selectedRow, 5));
					book.setChuDe((String) bookTable.getValueAt(selectedRow, 6));
					book.setNgayThem((Date) bookTable.getValueAt(selectedRow, 7));
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
					book.setNgayThem((Date) bookTable.getValueAt(selectedRow, 7));
					book.setId(books.get(selectedRow).getId());

					new DeleteBookController(new DeleteBookView(), book, BookManagementController.this);
				}
			}
		});

		this.bookManagementView.setCaculateButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StatisticBookController(new StatisticBookView(), new KQThongKeTheoChuDe());
			}
		});

		this.bookManagementView.setSubjectSearchComboBoxListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String subjectSearch = BookManagementController.this.bookManagementView.getSubjectSearch();
				if (subjectSearch.equals("Ngày nhập")) {
					DefaultFormatterFactory formatter = null;
					try {
						formatter = new DefaultFormatterFactory(new MaskFormatter("##--##--####"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					BookManagementController.this.bookManagementView.setKeySearchFormater(formatter);
				} else {
					DefaultFormatterFactory formatter = null;
					try {
						formatter = new DefaultFormatterFactory(
								new MaskFormatter("**************************************"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BookManagementController.this.bookManagementView.setKeySearchFormater(formatter);
					System.out.println("Reset formatted text field");
				}
			}

		});
	}

	@SuppressWarnings("static-access")
	public void loadBooks() {
		JTable bookTable = bookManagementView.getBookTable();
		javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(null, new String[] {
				"STT ", "Tên sách", "Mã sách", "Tác giả", "Nhà xuất bản", "Giá ", "Chủ đề", "Ngày nhập" }) {
			public Class getColumnClass(int column) {
				if (column == 0) {
					return Integer.class;
				} else if (column == 7) {
					return Date.class;
				} else {
					return String.class;
				}
			}

			public boolean isCellEditable(int row, int col) {
				return false;
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

		this.bookManagementView.setSearchButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String keySearch = BookManagementController.this.bookManagementView.getKeySearch();
				String subjectSearch = BookManagementController.this.bookManagementView.getSubjectSearch();
				new SearchBookController(sorter, keySearch.trim(), subjectSearch);
			}

		});

		this.bookManagementView.setRefreshButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sorter.setRowFilter(null);
				BookManagementController.this.bookManagementView.setKeySearch(null);
			}

		});

	}

}
