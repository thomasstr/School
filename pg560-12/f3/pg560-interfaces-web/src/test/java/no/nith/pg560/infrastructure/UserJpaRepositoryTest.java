package no.nith.pg560.infrastructure;

import javax.persistence.EntityManager;

import no.nith.pg560.domain.User;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UserJpaRepositoryTest {
	
	@Mock
	private EntityManager em;
	
	private UserJpaRepository repository;
	
	private User testUser;
	
	private long testId = 1;
	
	@Before
	public void setup(){
		
		testUser = new User();
		testUser.setId(testId);
		testUser.setName("TestUser");
		testUser.setUsername("TestUserName");
		testUser.setCity("TestCity");
		testUser.setCountry("testCountry");
		
		MockitoAnnotations.initMocks(this);
		repository = new UserJpaRepository(em);
		
	}
	
	@Test
	public void shouldFindUser(){
		
		Mockito.when(em.find(User.class, testId)).thenReturn(testUser);
		User returnedUser = repository.getUser(testId);
		
		Mockito.verify(em).find(User.class, testId);
		Mockito.verifyNoMoreInteractions(em);
		
		Assert.assertEquals(testUser.getName(), returnedUser.getName());
		Assert.assertEquals(testUser.getUsername(), returnedUser.getUsername());
		Assert.assertEquals(testUser.getCity(), returnedUser.getCity());
		Assert.assertEquals(testUser.getCountry(), returnedUser.getCountry());		
	}
	
	@Test
	public void shouldDeleteUser(){
		
		Mockito.when(em.find(User.class, testUser.getId())).thenReturn(testUser);
		repository.deleteUser(testUser);
		
		Mockito.verify(em).find(User.class, testUser.getId());
		Mockito.verify(em).remove(testUser);
		Mockito.verifyNoMoreInteractions(em);
	}
	
	@Test
	public void shouldPersistUser(){
		
		repository.persist(testUser);
		
		Mockito.verify(em).persist(testUser);
		Mockito.verifyNoMoreInteractions(em);
	}

}
