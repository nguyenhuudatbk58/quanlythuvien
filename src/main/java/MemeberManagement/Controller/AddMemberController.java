package MemeberManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
