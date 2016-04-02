package MemeberManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.ThanhVienDAO;
import MemeberManagement.View.DeleteMemberView;
import Model.ThanhVien;

public class DeleteMemberController {

	private ThanhVienDAO thanhVienDAO;

	private DeleteMemberView deleteMemberView;

	private MemeberManagementController mmc;

	public DeleteMemberController(DeleteMemberView deleteMemberView, final ThanhVien thanhVien,
			MemeberManagementController mmc) {

		this.deleteMemberView = deleteMemberView;
		this.mmc = mmc;

		displayMemberInfo(thanhVien);

		this.deleteMemberView.setDeleteButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				thanhVienDAO.delete(thanhVien);

				DeleteMemberController.this.deleteMemberView.setVisible(false);
				DeleteMemberController.this.deleteMemberView.dispose();

			}

		});
		this.deleteMemberView.setCancelButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteMemberController.this.deleteMemberView.setVisible(false);
				DeleteMemberController.this.deleteMemberView.dispose();
			}

		});

	}

	private void displayMemberInfo(ThanhVien thanhVien) {
		this.deleteMemberView.setTen(thanhVien.getTen());
		this.deleteMemberView.setMaThanhVien(thanhVien.getMaThanhVien());
		this.deleteMemberView.setEmail(thanhVien.getEmail());
		this.deleteMemberView.setDiaChi(thanhVien.getDiaChi());
	}

}
