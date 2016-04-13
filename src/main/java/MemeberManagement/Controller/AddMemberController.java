package MemeberManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.ThanhVienDAO;
import MemeberManagement.View.AddMemberView;
import Model.ThanhVien;

public class AddMemberController {

	private ThanhVienDAO thanhVienDAO;

	private MemeberManagementController mmc;

	private AddMemberView addMemberView;

	public AddMemberController(AddMemberView addMemberView, MemeberManagementController mmc) {
		this.mmc = mmc;
		this.addMemberView = addMemberView;

		this.addMemberView.setAddButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ThanhVien thanhVien = new ThanhVien();

				thanhVien.setTen(AddMemberController.this.addMemberView.getTen());
				thanhVien.setMaThanhVien(AddMemberController.this.addMemberView.getMaThanhVien());
				thanhVien.setEmail(AddMemberController.this.addMemberView.getEmail());
				thanhVien.setDiaChi(AddMemberController.this.addMemberView.getDiaChi());
				thanhVien.setNgay_tham_gia(new Date());

				if (thanhVien.getTen() == null) {
					JOptionPane.showMessageDialog(null, "Nhập tên thành viên");
					return;
				}
				if (thanhVien.getMaThanhVien() == null) {
					JOptionPane.showMessageDialog(null, "Nhập mã số của thành viên");
					return;
				}
				if (thanhVien.getEmail() == null) {
					JOptionPane.showMessageDialog(null, "Nhập email của thành viên");
					return;
				}
				if (thanhVien.getDiaChi() == null) {
					JOptionPane.showMessageDialog(null, "Nhập địa chỉ của thành viên");
					return;
				}
				thanhVienDAO.save(thanhVien);

				AddMemberController.this.mmc.loadMembers();

				AddMemberController.this.addMemberView.clearAllField();

			}

		});

		this.addMemberView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddMemberController.this.addMemberView.setVisible(false);
				AddMemberController.this.addMemberView.dispose();

			}

		});

	}

}
