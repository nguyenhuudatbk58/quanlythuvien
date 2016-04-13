package MemeberManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

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
					member.setNgay_tham_gia((Date) memberTable.getValueAt(selectedRow, 5));
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
					member.setNgay_tham_gia((Date) memberTable.getValueAt(selectedRow, 5));
					member.setId(members.get(selectedRow).getId());
					new DeleteMemberController(new DeleteMemberView(), member, MemeberManagementController.this);
				}
			}
		});

		this.memberManagementView.setSubjectSearchComboBoxListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String subjectSearch = MemeberManagementController.this.memberManagementView.getSubjectSearch();
				if (subjectSearch.equals("Ngày tham gia")) {
					DefaultFormatterFactory formatter = null;
					try {
						formatter = new DefaultFormatterFactory(new MaskFormatter("##--##--####"));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					MemeberManagementController.this.memberManagementView.setKeySearchFormater(formatter);
				} else {
					DefaultFormatterFactory formatter = null;
					try {
						formatter = new DefaultFormatterFactory(
								new MaskFormatter("**************************************"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MemeberManagementController.this.memberManagementView.setKeySearchFormater(formatter);
				}
			}

		});

		this.memberManagementView.setCaculateButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new CaculateController(new CaculateView());
			}
		});
	}

	public void loadMembers() {
		JTable memberTable = memberManagementView.getMemberTable();
		final javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(null,
				new String[] { "STT ", "Tên thành viên", "Mã thành viên", "Email", "Địa chỉ", "Ngày tham gia" }) {
			public Class getColumnClass(int column) {
				if (column == 0) {
					return Integer.class;
				}
				if (column == 5) {
					return Date.class;
				} else {
					return String.class;
				}
			}

			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		memberTable.setModel(tableModel);
		this.memberManagementView.setSizeColumn();
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
		memberTable.setRowSorter(sorter);
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
			v.add(member.getNgay_tham_gia());
			tableModel.addRow(v);
		}

		this.memberManagementView.setSearchButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String keySearch = MemeberManagementController.this.memberManagementView.getKeySearch();
				String subjectSearch = MemeberManagementController.this.memberManagementView.getSubjectSearch();
				new SearchMemeberController(sorter, keySearch.trim(), subjectSearch);
			}

		});

		this.memberManagementView.setRefreshButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sorter.setRowFilter(null);
				MemeberManagementController.this.memberManagementView.setKeySearch(null);
			}

		});

	}

}
