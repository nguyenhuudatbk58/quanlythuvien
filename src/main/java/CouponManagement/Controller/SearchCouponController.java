package CouponManagement.Controller;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchCouponController {

	public SearchCouponController(TableRowSorter<TableModel> sorter, Object keySearch, String subjectSearch) {
		if (subjectSearch.equals("Mã phiếu mượn")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 1));
		} else if (subjectSearch.equals("Mã thành viên")) {
			sorter.setRowFilter(RowFilter.regexFilter((String) keySearch, 2));

		}
	}

}
