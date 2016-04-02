package BookManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

				book.setTen(EditBookController.this.editBookView.getTenSach());
				book.setMaSach(EditBookController.this.editBookView.getMaSach());
				book.setTacGia(EditBookController.this.editBookView.getTacGia());
				book.setChuDe(EditBookController.this.editBookView.getChuDe());
				book.setGia(EditBookController.this.editBookView.getGia());
				book.setNhaXuatBan(EditBookController.this.editBookView.getNhaXuatBan());
				book.setNgayThem(EditBookController.this.editBookView.getNgayNhap());

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

		this.editBookView.setTenSach(book.getTen());
		this.editBookView.setMaSach(book.getMaSach());
		this.editBookView.setTacGia(book.getTacGia());
		this.editBookView.setNhaXuaBan(book.getNhaXuatBan());
		this.editBookView.setChuDeSach(book.getChuDe());
		this.editBookView.setGiaSach(book.getGia());
		this.editBookView.setNgayNhap(book.getNgayThem());
	}

}
