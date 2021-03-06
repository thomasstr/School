package no.nith.pg560.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import no.nith.pg560.common.CommonRepository;
import no.nith.pg560.domain.User;

import org.apache.log4j.Logger;

/**
 * Repository class handling integration with the PG560_User database.
 */
public class UserJpaRepository extends CommonRepository<User> {
	private Logger logger = Logger.getLogger(UserJpaRepository.class);

	public UserJpaRepository() {
		super(User.class);
	}

	public UserJpaRepository(EntityManager em) {
		super(User.class, em);
	}
	
	
	
	
	public User getUser(long id) {
		return getEntityManager().find(User.class, id);
	}
	
	
	

	public User getUser(String username) {
		TypedQuery<User> query = getEntityManager().createQuery(
				"select u from User u where u.username=:username", User.class);
		query.setParameter("username", username);

		User user = null;
		try {
			user = query.getSingleResult();
		} catch (NoResultException e) {
			logger.info("Fikk ingen treff");
		}

		return user;
	}
	
	
	
	public List<User> getAllUsers() {

		TypedQuery<User> query = getEntityManager().createQuery(
				"select u from User u", User.class);
		return query.getResultList();
	}


	
	
	

	public void persist(User user) {
		getEntityManager().persist(user);
	}

	
	
	
	
	
	
	public void deleteUser(User user) {
		getEntityManager().remove(
				getEntityManager().find(User.class, user.getId()));
	}

	

}