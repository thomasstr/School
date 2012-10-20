package no.nith.pg560.infrastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import no.nith.pg560.common.CommonInfrastructureIT;
import no.nith.pg560.domain.User;

import org.apache.log4j.Logger;
import org.junit.Test;

public class UserJpaRepositoryIntegrationTest extends CommonInfrastructureIT {

	private Logger logger = Logger.getLogger(UserJpaRepositoryIntegrationTest.class);
	
	@Test
	public void testGetUser() {
		UserJpaRepository userRepo = new UserJpaRepository(getEntityManager());
		User userResult = userRepo.getUser("tonnyg");
		assertEquals(userResult.getName(), "Tonny Gundersen");
		assertEquals(userResult.getCity(), "Oslo");
		assertEquals(userResult.getCountry(), "Norway");

		userResult = userRepo.getUser("Finnes ikke");
		assertNull(userResult);
	}
	
	@Test
	public void testPersistUser(){
		
		UserJpaRepository userRepo = new UserJpaRepository(getEntityManager());
		
		long numberOfUsersBefore = userRepo.getAllUsers().size();
		logger.debug("Number of users before persist: " + numberOfUsersBefore);
		
		User user = new User();
		long time = System.currentTimeMillis();
		user.setName("TestName" + time);
		user.setCountry("TestCountry" + time);
		user.setUsername("TestUser" + time);
		user.setCity("TestCity" + time);
		
		userRepo.persist(user);
		
		long numberOfUsersAfter = userRepo.getAllUsers().size();
		logger.debug("Number of users after first persist: " + numberOfUsersAfter);
		
		assertTrue(numberOfUsersAfter > numberOfUsersBefore);
		
		User user2 = new User();
		long time2 = System.currentTimeMillis();
		user2.setName("TestName" + time2);
		user2.setCountry("TestCountry" + time2);
		user2.setUsername("TestUser" + time2);
		user2.setCity("TestCity" + time2);
		
		userRepo.persist(user2);
		
		long numberOfUsersAfterSecondPersist = userRepo.getAllUsers().size();
		logger.debug("Number of users after second persist: " + numberOfUsersAfterSecondPersist);
		
		assertTrue(numberOfUsersAfterSecondPersist > numberOfUsersAfter);
	}
	
	@Test
	public void testDeleteUser(){
		
		UserJpaRepository userRepo = new UserJpaRepository(getEntityManager());
		
		User user1 = new User();
		long time = System.currentTimeMillis();
		user1.setName("TestName" + time);
		user1.setCountry("TestCountry" + time);
		user1.setUsername("TestUser" + time);
		user1.setCity("TestCity" + time);
		
		userRepo.persist(user1);
		
		User user2 = new User();
		long time2 = System.currentTimeMillis();
		user2.setName("TestName" + time2);
		user2.setCountry("TestCountry" + time2);
		user2.setUsername("TestUser" + time2);
		user2.setCity("TestCity" + time2);
		
		userRepo.persist(user2);
		
		List<User> users = userRepo.getAllUsers();
		
		long numberOfUsersAfterPersist = users.size();
		logger.debug("Number of users before delete: " + numberOfUsersAfterPersist);
		
		User lastUser = users.get(users.size()-1);
		userRepo.deleteUser(lastUser);

		long numberOfUsersAfterDelete = userRepo.getAllUsers().size();
		logger.debug("Number of users after delete: " + numberOfUsersAfterDelete);
		assertTrue(numberOfUsersAfterDelete < numberOfUsersAfterPersist);
		
		
		
	}

}
