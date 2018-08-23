package com.app.SpringBootProject.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.dao.GuestDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class GuestServiceImplTest {
	@Mock
	GuestDaoImpl dao;

	@InjectMocks
	GuestServiceImpl service;

	Guest g = new Guest();
	

	
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
		Guest g2 = new Guest();
		g2.setEmail("updated@g.com");
		g2.setFirstName("test");
		g2.setLastName("test");
		g2.setAddress("duummy");
		g2.setPassword("123");
		g2.setPhone("488455");

	/*	g.setEmail("updated@g.com");
		g.setPassword("123");*/

		when(dao.validate("updated@g.com", "123")).thenReturn(g2);
		Guest testGuest = service.validate("updated@g.com", "123");
		System.out.println(testGuest+".......................................");
		System.out.println(g2+"...................................................");
		
		assertEquals(g2, testGuest);
		//assertNotNull(testGuest);
	}

}