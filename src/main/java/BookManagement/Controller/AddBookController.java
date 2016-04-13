package BookManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

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
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Sach sach = new Sach();
				sach.setTen(AddBookController.this.addBookView.getTenSach());
				sach.setMaSach(AddBookController.this.addBookView.getMaSach());
				sach.setTacGia(AddBookController.this.addBookView.getTacGia());
				sach.setChuDe(AddBookController.this.addBookView.getChuDe());
				sach.setGia(AddBookController.this.addBookView.getGia());
				sach.setNhaXuatBan(AddBookController.this.addBookView.getNhaXuatBan());

				if (sach.getTen() == null) {
					JOptionPane.showMessageDialog(null, "Nhập tên sách cần tạo");
					return;
				}
				if (sach.getMaSach() == null) {
					JOptionPane.showMessageDialog(null, "Nhập mã sách cần tạo");
					return;
				}
				if (sach.getTacGia() == null) {
					JOptionPane.showMessageDialog(null, "Nhập tác giả của sách");
					return;
				}
				if (sach.getChuDe() == null) {
					JOptionPane.showMessageDialog(null, "Nhập chủ đề của sách");
					return;
				}
				if (sach.getNhaXuatBan() == null) {
					JOptionPane.showMessageDialog(null, "Nhập nhà xuất bản");
					return;
				}
				try {
					sach.setNgayThem(dateFormat.parse(AddBookController.this.addBookView.getNgayNhap()));
				} catch (ParseException e1) {

					System.out.println("Exception when parse String to Date in AddBookController ");
					e1.printStackTrace();
				}

				if (sach.getNgayThem() == null) {
					JOptionPane.showMessageDialog(null, "Nhập ngày nhập sách");
					return;
				}

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
