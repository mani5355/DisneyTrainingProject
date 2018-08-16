package com.app.SpringBootProject.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.dao.IGuestDao;

@RunWith(SpringJUnit4ClassRunner.class)
public class GuestServiceImplTest {
	@Mock
	IGuestDao dao;

	@InjectMocks
	GuestServiceImpl service;

	Guest g = new Guest();
	Date date = new Date();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRegisterGuest() {
		g.setEmail("test@c.com");
		g.setFirstName("test");
		g.setLastName("test");
		g.setAddress("duummy");
		g.setPassword("123");
		g.setPhone("488455");

		when(dao.registerGuest(g)).thenReturn(g);
		Guest testGuest = service.registerGuest(g);
		assertNotNull(testGuest);
	}

	@Test
	public void testUpdateGuest() {
		g.setguestId(1);
		g.setEmail("updated@g.com");
		g.setFirstName("test");
		g.setLastName("test");
		g.setAddress("duummy");
		g.setPassword("123");
		g.setPhone("488455");

		when(dao.updateGuest(g, g.getguestId())).thenReturn(g.getguestId());
		Long testSuccess = service.updateGuest(g, g.getguestId());
		assertNotNull(testSuccess);
	}

	@Test
	public void testGetGuest() {
		g.setguestId(1);
		g.setEmail("updated@g.com");
		g.setFirstName("test");
		g.setLastName("test");
		g.setAddress("duummy");
		g.setPassword("123");
		g.setPhone("488455");

		when(dao.getGuest(g.getguestId())).thenReturn(g);
		Guest testGuest = service.getGuest(g.getguestId());
		assertNotNull(testGuest);
	}

	@Test
	public void testValidateGuest() {

		g.setEmail("updated@g.com");
		g.setPassword("123");

		when(dao.validate(g.getEmail(), g.getPassword())).thenReturn(g);
		Guest testGuest = service.validate(g.getEmail(), g.getPassword());
		assertNotNull(testGuest);
	}

}