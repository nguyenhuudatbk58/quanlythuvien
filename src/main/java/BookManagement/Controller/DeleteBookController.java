package BookManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import BookManagement.View.DeleteBookView;
import DAO.SachDAO;
import Model.Sach;

public class DeleteBookController {

	private SachDAO sachDAO;

	private DeleteBookView deleteBookView;

	private BookManagementController bmc;

	public DeleteBookController(DeleteBookView deleteBookView, final Sach book, BookManagementController bmc) {
		this.deleteBookView = deleteBookView;

		this.bmc = bmc;

		displayBookInfo(book);

		this.deleteBookView.setDeleteButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sachDAO.delete(book);

				DeleteBookController.this.bmc.loadBooks();

				DeleteBookController.this.deleteBookView.setVisible(false);
				DeleteBookController.this.deleteBookView.dispose();

			}

		});

		this.deleteBookView.setCancelButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				DeleteBookController.this.deleteBookView.setVisible(false);
				DeleteBookController.this.deleteBookView.dispose();

			}

		});
	}

	private void displayBookInfo(Sach book) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		this.deleteBookView.setTenSach(book.getTen());
		this.deleteBookView.setMaSach(book.getMaSach());
		this.deleteBookView.setTacGia(book.getTacGia());
		this.deleteBookView.setNhaXuaBan(book.getNhaXuatBan());
		this.deleteBookView.setChuDeSach(book.getChuDe());
		this.deleteBookView.setGiaSach(book.getGia());
		this.deleteBookView.setNgayNhap(dateFormat.format(book.getNgayThem()));
	}
}
