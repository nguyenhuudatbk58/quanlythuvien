package BookManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import BookManagement.View.EditBookView;
import DAO.SachDAO;
import Model.Sach;

public class EditBookController {
	private SachDAO sachDAO;

	private EditBookView editBookView;

	private BookManagementController bmc;

	public EditBookController(EditBookView editBookView, final Sach book, BookManagementController bmc) {

		this.editBookView = editBookView;

		this.bmc = bmc;

		displayBookInfo(book);

		this.editBookView.setEditButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String bookCode = EditBookController.this.editBookView.getMaSach();
				book.setTen(EditBookController.this.editBookView.getTenSach());
				book.setMaSach(EditBookController.this.editBookView.getMaSach());
				book.setTacGia(EditBookController.this.editBookView.getTacGia());
				book.setChuDe(EditBookController.this.editBookView.getChuDe());
				book.setGia(EditBookController.this.editBookView.getGia());
				book.setNhaXuatBan(EditBookController.this.editBookView.getNhaXuatBan());
				book.setId(sachDAO.getIdByBookCode(bookCode));
				try {
					book.setNgayThem(dateFormat.parse(EditBookController.this.editBookView.getNgayNhap()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (book.getTen() == null) {
					JOptionPane.showMessageDialog(null, "Nhập tên sách cần tạo");
					return;
				}
				if (book.getMaSach() == null) {
					JOptionPane.showMessageDialog(null, "Nhập mã sách cần tạo");
					return;
				}
				if (book.getTacGia() == null) {
					JOptionPane.showMessageDialog(null, "Nhập tác giả của sách");
					return;
				}
				if (book.getChuDe() == null) {
					JOptionPane.showMessageDialog(null, "Nhập chủ đề của sách");
					return;
				}
				if (book.getNhaXuatBan() == null) {
					JOptionPane.showMessageDialog(null, "Nhập nhà xuất bản");
					return;
				}

				if (book.getNgayThem() == null) {
					JOptionPane.showMessageDialog(null, "Nhập ngày nhập sách");
					return;
				}

				sachDAO.updateById(book);

				EditBookController.this.bmc.loadBooks();

				EditBookController.this.editBookView.setVisible(false);
				EditBookController.this.editBookView.dispose();

			}

		});

		this.editBookView.setCancelButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				EditBookController.this.editBookView.setVisible(false);
				EditBookController.this.editBookView.dispose();
			}

		});

	}

	private void displayBookInfo(Sach book) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		this.editBookView.setTenSach(book.getTen());
		this.editBookView.setMaSach(book.getMaSach());
		this.editBookView.setTacGia(book.getTacGia());
		this.editBookView.setNhaXuaBan(book.getNhaXuatBan());
		this.editBookView.setChuDeSach(book.getChuDe());
		this.editBookView.setGiaSach(book.getGia());
		this.editBookView.setNgayNhap(dateFormat.format(book.getNgayThem()));
	}

}
