package BookManagement.View;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import BookManagement.Controller.BookManagementController;
import MemeberManagement.Controller.MemeberManagementController;
import MemeberManagement.View.MemeberManagementView;

/**
 *
 * @author aiemdat
 */
public class MainForm extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private BookManagementView QuanLySachTab = null;
	private MemeberManagementView QuanLyThanhVienTab = null;
	private JPanel QuanLyPhieuMuonTab = null;
	private JPanel MuonSachTab = null;
	private JPanel TraSachTab = null;

	public MainForm() {
		initComponents();
	}

	private void initComponents() {

		SplitPane = new javax.swing.JSplitPane();
		jPanel1 = new javax.swing.JPanel();
		jToolBar2 = new javax.swing.JToolBar();
		menuLabel = new javax.swing.JLabel();
		QuanLyThanhVienButton = new javax.swing.JButton();
		QuanLyPhieuMuonButton = new javax.swing.JButton();
		QuanLySachButton = new javax.swing.JButton();
		MuonSachButton = new javax.swing.JButton();
		TraSachButton = new javax.swing.JButton();
		jTabbedPane1 = new javax.swing.JTabbedPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		SplitPane.setDividerLocation(200);

		jToolBar2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jToolBar2.setFloatable(false);
		jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
		jToolBar2.setSize(200, 500);
		jToolBar2.setVerifyInputWhenFocusTarget(false);

		menuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		menuLabel.setText("Menu");
		menuLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		menuLabel.setMaximumSize(new java.awt.Dimension(200, 100));
		menuLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
		jToolBar2.add(menuLabel);

		QuanLyThanhVienButton.setText("Quản lý thành viên");
		QuanLyThanhVienButton.setFocusable(false);
		QuanLyThanhVienButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		QuanLyThanhVienButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		QuanLyThanhVienButton.setMaximumSize(new java.awt.Dimension(200, 40));
		QuanLyThanhVienButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				QuanLyThanhVienButtonActionPerformed(evt);
			}
		});
		jToolBar2.add(QuanLyThanhVienButton);

		QuanLyPhieuMuonButton.setText("Quản ký phiếu mượn");
		QuanLyPhieuMuonButton.setAutoscrolls(true);
		QuanLyPhieuMuonButton.setFocusable(false);
		QuanLyPhieuMuonButton.setHideActionText(true);
		QuanLyPhieuMuonButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		QuanLyPhieuMuonButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		QuanLyPhieuMuonButton.setMaximumSize(new java.awt.Dimension(200, 40));
		QuanLyPhieuMuonButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
		QuanLyPhieuMuonButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				QuanLyPhieuMuonButtonActionPerformed(evt);
			}
		});
		jToolBar2.add(QuanLyPhieuMuonButton);

		QuanLySachButton.setText("Quản lý sách");
		QuanLySachButton.setFocusable(false);
		QuanLySachButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		QuanLySachButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		QuanLySachButton.setMaximumSize(new java.awt.Dimension(200, 40));
		QuanLySachButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				QuanLySachButtonActionPerformed(evt);
			}
		});
		jToolBar2.add(QuanLySachButton);

		MuonSachButton.setText("Mượn sách");
		MuonSachButton.setFocusable(false);
		MuonSachButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		MuonSachButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		MuonSachButton.setMaximumSize(new java.awt.Dimension(200, 40));
		MuonSachButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		MuonSachButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				MuonSachButtonActionPerformed(evt);
			}
		});
		jToolBar2.add(MuonSachButton);

		TraSachButton.setText("Trả sách");
		TraSachButton.setFocusable(false);
		TraSachButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		TraSachButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		TraSachButton.setMaximumSize(new java.awt.Dimension(200, 40));
		TraSachButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		TraSachButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TraSachButtonActionPerformed(evt);
			}

		});
		jToolBar2.add(TraSachButton);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jToolBar2,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE));

		SplitPane.setLeftComponent(jPanel1);
		SplitPane.setRightComponent(jTabbedPane1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(SplitPane,
								javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(SplitPane));

		setSize(1220, 700);
	}

	private void QuanLyThanhVienButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (QuanLyThanhVienTab == null) {
			QuanLyThanhVienTab = new MemeberManagementView();
			new MemeberManagementController(QuanLyThanhVienTab);
			jTabbedPane1.add(QuanLyThanhVienTab, "Quản lý thành viên");
			jTabbedPane1.setSelectedComponent(QuanLyThanhVienTab);
		} else {
			jTabbedPane1.setSelectedComponent(QuanLyThanhVienTab);

		}
	}

	private void QuanLyPhieuMuonButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (QuanLyPhieuMuonTab == null) {
			QuanLyPhieuMuonTab = new JPanel();
			jTabbedPane1.add(QuanLyPhieuMuonTab, "Quản lý phiếu mượn");
			jTabbedPane1.setSelectedComponent(QuanLyPhieuMuonTab);

		} else {
			jTabbedPane1.setSelectedComponent(QuanLyPhieuMuonTab);

		}
	}

	private void QuanLySachButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (QuanLySachTab == null) {
			QuanLySachTab = new BookManagementView();
			new BookManagementController(QuanLySachTab);
			jTabbedPane1.add(QuanLySachTab, "Quản lý sách");
			jTabbedPane1.setSelectedComponent(QuanLySachTab);

		} else {
			jTabbedPane1.setSelectedComponent(QuanLySachTab);

		}
	}

	private void MuonSachButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (MuonSachTab == null) {
			MuonSachTab = new JPanel();
			jTabbedPane1.add(MuonSachTab, "Mượn Sách");
			jTabbedPane1.setSelectedComponent(MuonSachTab);
		} else {
			jTabbedPane1.setSelectedComponent(MuonSachTab);

		}
	}

	private void TraSachButtonActionPerformed(ActionEvent evt) {
		if (TraSachTab == null) {
			TraSachTab = new JPanel();
			jTabbedPane1.add(TraSachTab, "Trả Sách ");
			jTabbedPane1.setSelectedComponent(TraSachTab);
		} else {
			jTabbedPane1.setSelectedComponent(TraSachTab);

		}

	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainForm().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton QuanLyThanhVienButton;
	private javax.swing.JButton QuanLyPhieuMuonButton;
	private javax.swing.JButton QuanLySachButton;
	private javax.swing.JButton MuonSachButton;
	private javax.swing.JButton TraSachButton;
	private javax.swing.JLabel menuLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JSplitPane SplitPane;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JToolBar jToolBar2;
	// End of variables declaration
}
