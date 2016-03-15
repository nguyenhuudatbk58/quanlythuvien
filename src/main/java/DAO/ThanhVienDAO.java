package DAO;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Sach;
import Model.ThanhVien;

public class ThanhVienDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction ts;

	ThanhVienDAO() {
		try {
			factory = new Configuration().configure().buildSessionFactory();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<ThanhVien> getAll() {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("FROM ThanhVien");
		ArrayList<ThanhVien> thanhVien = (ArrayList<ThanhVien>) query.list();

		ts.commit();
		session.close();

		return thanhVien;
	}

	public ThanhVien getByMemberCode(String maThanhVien) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("FROM ThanhVien where maThanhVien= :maThanhVien");
		query.setParameter("maThanhVien", maThanhVien);
		ThanhVien thanhVien = (ThanhVien) query.uniqueResult();

		ts.commit();
		session.close();

		return thanhVien;
	}

	public void save(ThanhVien thanhVien) {
		session = factory.openSession();
		ts = session.beginTransaction();

		session.save(thanhVien);

		ts.commit();
		session.close();
	}

	public void delete(ThanhVien thanhVien) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("delete from Sach where maThanhVien= :maThanhVien");
		query.setParameter("maThanhVien", thanhVien.getMaThanhVien());
		query.executeUpdate();

		ts.commit();
		session.close();
	}

	public void updateById(ThanhVien thanhVien) {
		session = factory.openSession();
		ts = session.beginTransaction();

		session.update(thanhVien);

		ts.commit();
		session.close();
	}

}
