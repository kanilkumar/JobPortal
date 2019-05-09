package com.heavenhr.jobportal.dao;

import java.text.ParseException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.heavenhr.jobportal.entity.JobApplicationEntity;
import com.heavenhr.jobportal.entity.JobOfferEntity;
import com.heavenhr.jobportal.entity.UserEntity;

/**
 * 
 * @author AnilKumar
 *
 */
@Repository
public class JobPortalDaoImpl implements JobPortalDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void createJobOffer(JobOfferEntity jobOfferEntity) throws ParseException, HibernateException {
		Session session = sessionFactory.getCurrentSession();
		session.save(jobOfferEntity);
	}

	@Override
	@Transactional
	public List<JobOfferEntity> getJobOffers() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaQuery<JobOfferEntity> cq = session.getCriteriaBuilder().createQuery(JobOfferEntity.class);
		Root<JobOfferEntity> root = cq.from(JobOfferEntity.class);
		cq.select(root);
		TypedQuery<JobOfferEntity> q = session.createQuery(cq);
		return  q.getResultList();
	}

	@Override
	@Transactional
	public void applyJobOffer(JobApplicationEntity jobApplicationEntity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(jobApplicationEntity.getJobOffer());
		session.save(jobApplicationEntity);
	}

	@Override
	@Transactional
	public void createUser(UserEntity userEntity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userEntity);
	}

	@Override
	@Transactional
	public UserEntity getUser(String emailId) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = session.getCriteriaBuilder().createQuery(UserEntity.class);
		Root<UserEntity> from = cq.from(UserEntity.class);
		cq.select(from);
		cq.where(builder.equal(from.get("emailId"), emailId));
		Query<UserEntity> q = session.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	@Transactional
	public JobOfferEntity getJobOfferByJobTitle(String jobTitle) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<JobOfferEntity> cq = session.getCriteriaBuilder().createQuery(JobOfferEntity.class);
		Root<JobOfferEntity> from = cq.from(JobOfferEntity.class);
		cq.select(from);
		cq.where(builder.equal(from.get("jobTitle"), jobTitle));
		Query<JobOfferEntity> q = session.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	@Transactional
	public List<JobApplicationEntity> getApplications(long jobOfferId) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<JobApplicationEntity> cq = session.getCriteriaBuilder().createQuery(JobApplicationEntity.class);
		Root<JobApplicationEntity> from = cq.from(JobApplicationEntity.class);
		cq.select(from);
		cq.where(builder.equal(from.get("jobOffer"), jobOfferId));
		Query<JobApplicationEntity> q = session.createQuery(cq);
		return q.getResultList();
	}

	@Override
	@Transactional
	public JobApplicationEntity getApplicationByUserAndJobTitle(long jobOfferId, long userId) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<JobApplicationEntity> cq = session.getCriteriaBuilder().createQuery(JobApplicationEntity.class);
		Root<JobApplicationEntity> from = cq.from(JobApplicationEntity.class);
		cq.select(from);
		cq.where(builder.equal(from.get("jobOffer"), jobOfferId));
		cq.where(builder.equal(from.get("user"), userId));
		Query<JobApplicationEntity> q = session.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	@Transactional
	public List<JobApplicationEntity> getApplicationsByUser(long userId) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<JobApplicationEntity> cq = session.getCriteriaBuilder().createQuery(JobApplicationEntity.class);
		Root<JobApplicationEntity> from = cq.from(JobApplicationEntity.class);
		cq.select(from);
		cq.where(builder.equal(from.get("user"), userId));
		Query<JobApplicationEntity> q = session.createQuery(cq);
		return q.getResultList();
	}

	@Override
	@Transactional
	public void updateApplicationStatus(JobApplicationEntity jobApplication) {
		Session session = sessionFactory.getCurrentSession();
		session.update(jobApplication);
	}

}
