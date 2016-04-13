package BookManagement.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BookManagement.View.KQThongKeTheoChuDe;
import BookManagement.View.StatisticBookView;
import DAO.SachDAO;

public class StatisticBookController {

	private SachDAO sachDAO;

	private StatisticBookView statisticBookView;

	private KQThongKeTheoChuDe kqThongKeTheoChuDe;

	public StatisticBookController(StatisticBookView statisticBookView, KQThongKeTheoChuDe kqThongKeTheoChuDe) {
		this.statisticBookView = statisticBookView;
		this.kqThongKeTheoChuDe = kqThongKeTheoChuDe;

		int nBook = sachDAO.findTotal(null, null, null, null);

		this.statisticBookView.setStatisticButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date toTime = null;
				Date fromTime = null;
				String time = null;
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				if (StatisticBookController.this.statisticBookView.isSelectedToTime()) {
					toTime = StatisticBookController.this.statisticBookView.getBeforeDate();
					time = new String("Trước ngày: " + dateFormat.format(toTime));
				}
				if (StatisticBookController.this.statisticBookView.isSelectedFromTime()) {
					fromTime = StatisticBookController.this.statisticBookView.getAfterDate();
					time = new String("Sau ngày: " + dateFormat.format(fromTime));
				}
				if (StatisticBookController.this.statisticBookView.isSelectedToAndFromTime()) {
					toTime = StatisticBookController.this.statisticBookView.getToDate();
					fromTime = StatisticBookController.this.statisticBookView.getFromDate();
					time = new String(
							"Từ ngày: " + dateFormat.format(fromTime) + " đến ngày: " + dateFormat.format(toTime));
				}

				if (StatisticBookController.this.statisticBookView.isCheckedChuDe()) {
					JTable resultTable = StatisticBookController.this.kqThongKeTheoChuDe.getResultTable();
					ArrayList<String> chuDes = sachDAO.getSubjectBooks();
					String[] cds = new String[chuDes.size()];
					for (int i = 0; i < cds.length; i++) {
						cds[i] = chuDes.get(i);
					}
					Vector<Object> c = new Vector<Object>();

					for (int i = 0; i < cds.length; i++) {
						c.addElement(sachDAO.findTotal(null, cds[i], toTime, fromTime));
					}

					DefaultTableModel tableModel = new DefaultTableModel(null, cds);
					tableModel.addRow(c);
					resultTable.setModel(tableModel);
					StatisticBookController.this.kqThongKeTheoChuDe.setSubjectStatistic("Thống kê theo chủ đề");
					StatisticBookController.this.kqThongKeTheoChuDe.setTimeStatistic(time);
					StatisticBookController.this.kqThongKeTheoChuDe.setVisible(true);

				}

			}

		});

		this.statisticBookView.setCancelButtonListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				StatisticBookController.this.statisticBookView.setVisible(false);
				StatisticBookController.this.statisticBookView.dispose();
			}
		});
	}

}
