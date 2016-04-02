package BookManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BookManagement.View.AddBookView;
import DAO.SachDAO;
import Model.Sach;

public class AddBookController {

	private SachDAO sachDAO;

	private AddBookView addBookView;

	private BookManagementController bmc;

	public AddBookController(AddBookView addBookView, BookManagementController bmc) {
		this.addBookView = addBookView;

		this.bmc = bmc;

		this.addBookView.setAddButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Sach sach = new Sach();
				sach.setTen(AddBookController.this.addBookView.getTenSach());
				sach.setMaSach(AddBookController.this.addBookView.getMaSach());
				sach.setTacGia(AddBookController.this.addBookView.getTacGia());
				sach.setChuDe(AddBookController.this.addBookView.getChuDe());
				sach.setGia(AddBookController.this.addBookView.getGia());
				sach.setNhaXuatBan(AddBookController.this.addBookView.getNhaXuatBan());
				sach.setNgayThem(AddBookController.this.addBookView.getNgayNhap());

				sachDAO.save(sach);

				AddBookController.this.bmc.loadBooks();

				AddBookController.this.addBookView.clearAllField();

			}

		});

		this.addBookView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookController.this.addBookView.setVisible(false);
				AddBookController.this.addBookView.dispose();
			}

		});
	}

}
