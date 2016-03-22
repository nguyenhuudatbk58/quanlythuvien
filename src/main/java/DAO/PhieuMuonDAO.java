package DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.PhieuMuon;
import Model.SachMuon;

public class PhieuMuonDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction ts;

	PhieuMuonDAO() {
		try {
			factory = new Configuration().configure().buildSessionFactory();

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	}

	public void save(PhieuMuon phieuMuon) {
		session = factory.openSession();
		ts = session.beginTransaction();

		session.save(phieuMuon);

		ts.commit();
		session.close();
	}

	public void delete(String maPhieu) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("Delete from PhieuMuon where maPhieu= :maPhieu");
		query.setParameter("maPhieu", maPhieu);
		query.executeUpdate();
		ts.commit();

	}

	public ArrayList<PhieuMuon> getAll() {
		session = factory.openSession();
		ts = session.beginTransaction();

		ArrayList<PhieuMuon> pm = (ArrayList<PhieuMuon>) session.createQuery("FROM PhieuMuon").list();
		ts.commit();

		return pm;
	}

	public PhieuMuon getByItemCode(String maPhieu) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("FROM PhieuMuon where maPhieu= :maPhieu");
		query.setParameter("maPhieu", maPhieu);

		PhieuMuon pm = (PhieuMuon) query.list().get(0);

		ts.commit();
		session.close();

		return pm;
	}

	public void update(PhieuMuon phieuMuon) {
		session = factory.openSession();
		ts = session.beginTransaction();

		Query query = session.createQuery("select id from PhieuMuon where maPhieu= :maPhieu");
		query.setParameter("maPhieu", phieuMuon.getMaPhieu());
		int id = (Integer) query.uniqueResult();
		phieuMuon.setId(id);

		session.update(phieuMuon);

		ts.commit();
	}

}
