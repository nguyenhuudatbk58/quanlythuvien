package MemeberManagement.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NewFilterTable extends JFrame {
	public NewFilterTable() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		String[] columns = { "ID", "Des", "Date", "Fixed" };
		Object[][] rows = { { 1, "Dat", new Date(), new Date() }, { 2, "Duong", new Date(), new Date() },
				{ 5, "Khanh", new Date(), new Date() }, { 3, "Trung", new Date(), new Date() } };

		TableModel model = new DefaultTableModel(rows, columns);
		JTable table = new JTable(model);
		final TableRowSorter<TableModel> sorter;
		sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		getContentPane().add(new JScrollPane(table));

		JPanel pnl = new JPanel();
		pnl.add(new JLabel("Filter expression:"));
		final JTextField txtFE = new JTextField(25);
		pnl.add(txtFE);
		JButton btnSetFE = new JButton("Set Filter Expression");
		ActionListener al;
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expr = txtFE.getText();
				sorter.setRowFilter(RowFilter.regexFilter(expr, 1));
				// sorter.setSortKeys(null);
			}
		};
		btnSetFE.addActionListener(al);
		pnl.add(btnSetFE);
		getContentPane().add(pnl, BorderLayout.SOUTH);

		setSize(750, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NewFilterTable();
	}
}