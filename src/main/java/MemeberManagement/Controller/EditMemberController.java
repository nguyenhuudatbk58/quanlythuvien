package MemeberManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.ThanhVienDAO;
import MemeberManagement.View.EditMemberView;
import Model.ThanhVien;

public class EditMemberController {

	private ThanhVienDAO thanhVienDAO;

	private EditMemberView editMemberView;

	private MemeberManagementController mmc;

	public EditMemberController(EditMemberView editMemberView, final ThanhVien thanhVien,
			MemeberManagementController mmc) {
		this.editMemberView = editMemberView;
		this.mmc = mmc;

		displayMemberInfo(thanhVien);

		this.editMemberView.setEditButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thanhVien.setTen(EditMemberController.this.editMemberView.getTen());
				thanhVien.setMaThanhVien(EditMemberController.this.editMemberView.getMaThanhVien());
				thanhVien.setEmail(EditMemberController.this.editMemberView.getEmail());
				thanhVien.setDiaChi(EditMemberController.this.editMemberView.getDiaChi());

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

				thanhVienDAO.updateById(thanhVien);

				EditMemberController.this.mmc.loadMembers();

				EditMemberController.this.editMemberView.setVisible(false);
				EditMemberController.this.editMemberView.dispose();
			}

		});

		this.editMemberView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditMemberController.this.editMemberView.setVisible(false);
				EditMemberController.this.editMemberView.dispose();
			}

		});

	}

	private void displayMemberInfo(ThanhVien thanhVien) {
		this.editMemberView.setTen(thanhVien.getTen());
		this.editMemberView.setMaThanhVien(thanhVien.getMaThanhVien());
		this.editMemberView.setEmail(thanhVien.getEmail());
		this.editMemberView.setDiaChi(thanhVien.getDiaChi());
	}

}
