package BookManagement.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

public class AddBookView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddBookView() {
		initComponents();
	}

	private void initComponents() {

		bookNameLabel = new javax.swing.JLabel();
		bookNameSP = new javax.swing.JScrollPane();
		bookNameTA = new javax.swing.JTextArea();
		AnsALabel = new javax.swing.JLabel();
		ansASP = new javax.swing.JScrollPane();
		ansATA = new javax.swing.JTextArea();
		AnsBLabel = new javax.swing.JLabel();
		ansBSP = new javax.swing.JScrollPane();
		ansBTA = new javax.swing.JTextArea();
		AnsCLabel = new javax.swing.JLabel();
		ansCSP = new javax.swing.JScrollPane();
		ansCTA = new javax.swing.JTextArea();
		AnsDLabel = new javax.swing.JLabel();
		ansDSP = new javax.swing.JScrollPane();
		ansDTA = new javax.swing.JTextArea();
		rightAnsLabel = new javax.swing.JLabel();
		rightAnsTF = new javax.swing.JTextField();
		levelLabel = new javax.swing.JLabel();
		levelComboBox = new javax.swing.JTextArea();
		addBtn = new javax.swing.JButton();
		titleLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		bookNameLabel.setText("Tên sách:");
		bookNameTA.setColumns(20);
		bookNameTA.setLineWrap(true);
		bookNameTA.setRows(5);
		bookNameTA.setWrapStyleWord(true);
		bookNameSP.setViewportView(bookNameTA);

		AnsALabel.setText("Mã sách:");
		ansATA.setColumns(20);
		ansATA.setLineWrap(true);
		ansATA.setRows(5);
		ansATA.setWrapStyleWord(true);
		ansASP.setViewportView(ansATA);

		AnsBLabel.setText("Tác giả:");
		ansBTA.setColumns(20);
		ansBTA.setLineWrap(true);
		ansBTA.setRows(5);
		ansBTA.setWrapStyleWord(true);
		ansBSP.setViewportView(ansBTA);

		AnsCLabel.setText("Nhà xuất bản:");
		ansCTA.setColumns(20);
		ansCTA.setLineWrap(true);
		ansCTA.setRows(5);
		ansCTA.setWrapStyleWord(true);
		ansCSP.setViewportView(ansCTA);

		AnsDLabel.setText("Chủ đề:");
		ansDTA.setColumns(20);
		ansDTA.setLineWrap(true);
		ansDTA.setRows(5);
		ansDTA.setWrapStyleWord(true);
		ansDSP.setViewportView(ansDTA);

		rightAnsLabel.setText("Giá:");
		levelLabel.setText("Ngày thêm:");
		levelComboBox.setText("");

		addBtn.setText("Thêm");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}

		});

		titleLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
		titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titleLabel.setText("Thêm sách");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
								.addGroup(layout.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(addBtn)
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(rightAnsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 126,
														Short.MAX_VALUE)
												.addComponent(bookNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(AnsALabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(AnsBLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(AnsCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(AnsDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
												javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(32, 32, 32)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(bookNameSP, javax.swing.GroupLayout.DEFAULT_SIZE,
																280, Short.MAX_VALUE)
														.addComponent(ansASP).addComponent(ansBSP).addComponent(ansCSP)
														.addComponent(ansDSP))
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(levelComboBox,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE, 102,
																Short.MAX_VALUE)
														.addComponent(rightAnsTF,
																javax.swing.GroupLayout.Alignment.LEADING))))))
						.addGroup(layout.createSequentialGroup().addGap(153, 153, 153).addComponent(titleLabel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(59, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addComponent(titleLabel).addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(bookNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(bookNameSP, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(AnsALabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(ansASP, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(AnsBLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(ansBSP, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(AnsCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(ansCSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(AnsDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(ansDSP, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(rightAnsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(rightAnsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(29, 29, 29)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(levelLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(levelComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(addBtn)
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}

	public static void main(String[] args) {
		new AddBookView().setVisible(true);
	}

	private javax.swing.JTextArea levelComboBox;
	private javax.swing.JLabel AnsALabel;
	private javax.swing.JLabel AnsBLabel;
	private javax.swing.JLabel AnsCLabel;
	private javax.swing.JLabel AnsDLabel;
	private javax.swing.JButton addBtn;
	private javax.swing.JScrollPane ansASP;
	private javax.swing.JTextArea ansATA;
	private javax.swing.JScrollPane ansBSP;
	private javax.swing.JTextArea ansBTA;
	private javax.swing.JScrollPane ansCSP;
	private javax.swing.JTextArea ansCTA;
	private javax.swing.JScrollPane ansDSP;
	private javax.swing.JTextArea ansDTA;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JLabel bookNameLabel;
	private javax.swing.JScrollPane bookNameSP;
	private javax.swing.JTextArea bookNameTA;
	private javax.swing.JLabel rightAnsLabel;
	private javax.swing.JTextField rightAnsTF;
	private javax.swing.JLabel levelLabel;

}
