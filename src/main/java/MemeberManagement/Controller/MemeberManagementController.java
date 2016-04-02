package MemeberManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BookManagement.Controller.CaculateController;
import BookManagement.Controller.SearchBookController;
import BookManagement.View.CaculateView;
import BookManagement.View.SearchBookView;
import DAO.ThanhVienDAO;
import MemeberManagement.View.AddMemberView;
import MemeberManagement.View.DeleteMemberView;
import MemeberManagement.View.EditMemberView;
import MemeberManagement.View.MemeberManagementView;
import Model.ThanhVien;

public class MemeberManagementController {

	private ThanhVienDAO thanhVienDAO;

	private MemeberManagementView memberManagementView;

	private ArrayList<ThanhVien> members;

	public MemeberManagementController(MemeberManagementView memberManagementView) {
		this.memberManagementView = memberManagementView;

		loadMembers();

		this.memberManagementView.setAddButtonActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddMemberController(new AddMemberView(), MemeberManagementController.this);
			}
		});

		this.memberManagementView.setEditButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable memberTable = MemeberManagementController.this.memberManagementView.getMemberTable();
				int selectedRow = memberTable.getSelectedRow();
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(null, "Chọn thành viên cần chỉnh sửa.");
				else {

					ThanhVien member = new ThanhVien();

					member.setTen((String) memberTable.getValueAt(selectedRow, 1));
					member.setMaThanhVien((String) memberTable.getValueAt(selectedRow, 2));
					member.setEmail((String) memberTable.getValueAt(selectedRow, 3));
					member.setDiaChi((String) memberTable.getValueAt(selectedRow, 4));
					member.setId(members.get(selectedRow).getId());

					new EditMemberController(new EditMemberView(), member, MemeberManagementController.this);
				}
			}
		});

		this.memberManagementView.setDeleteButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable memberTable = MemeberManagementController.this.memberManagementView.getMemberTable();
				int selectedRow = memberTable.getSelectedRow();
				if (selectedRow == -1)
					JOptionPane.showMessageDialog(null, "Chọn thành viên cần xóa.");
				else {

					ThanhVien member = new ThanhVien();

					member.setTen((String) memberTable.getValueAt(selectedRow, 1));
					member.setMaThanhVien((String) memberTable.getValueAt(selectedRow, 2));
					member.setEmail((String) memberTable.getValueAt(selectedRow, 3));
					member.setDiaChi((String) memberTable.getValueAt(selectedRow, 4));
					member.setId(members.get(selectedRow).getId());
					new DeleteMemberController(new DeleteMemberView(), member, MemeberManagementController.this);
				}
			}
		});

		this.memberManagementView.setSearchButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new SearchBookController(new SearchBookView());
			}
		});

		this.memberManagementView.setCaculateButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CaculateController(new CaculateView());
			}
		});
	}

	public void loadMembers() {
		JTable memberTable = memberManagementView.getMemberTable();
		memberTable.setModel(new javax.swing.table.DefaultTableModel(null,
				new String[] { "STT ", "Tên thành viên", "Mã thành viên", "Email", "Địa chỉ" }));
		this.memberManagementView.setSizeColumn();
		DefaultTableModel tableModel = (DefaultTableModel) memberTable.getModel();
		members = thanhVienDAO.getAll();

		Vector<Object> v;
		for (int i = 0; i < members.size(); i++) {
			ThanhVien member = members.get(i);
			v = new Vector<Object>();
			v.add(i + 1);
			v.add(member.getTen());
			v.add(member.getMaThanhVien());
			v.add(member.getEmail());
			v.add(member.getDiaChi());
			tableModel.addRow(v);
		}

	}

}
