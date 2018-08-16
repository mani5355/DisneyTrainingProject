package com.app.SpringBootProject.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.dao.IDiningDao;

@RunWith(SpringRunner.class)
public class DiningServiceImplTest {

	@Mock
	IDiningDao dao;

	@InjectMocks
	DiningServiceImpl service;

	Guest guest = new Guest();
	Dining dining = new Dining();
	Date date = new Date();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRegisterDining() {

		guest.setguestId(1);
		dining.setGuestId(guest.getguestId());
		dining.setDiningType("test");
		dining.setArrivalDate(date);
		dining.setNoOfPeople(1);

		when(dao.registerDining(dining, guest.getguestId())).thenReturn(dining);
		Dining test = service.registerDining(dining, guest.getguestId());
		assertNotNull(test);

	}

	@Test
	public void testUpdateDining() {
		dining.setdReservationNumber(1);
		dining.setGuestId(guest.getguestId());
		dining.setDiningType("test");
		dining.setArrivalDate(date);
		dining.setNoOfPeople(1);

		when(dao.updateDining(dining, dining.getdReservationNumber())).thenReturn(dining.getdReservationNumber());
		Long test = service.updateDining(dining, dining.getdReservationNumber());
		assertNotNull(test);
	}

	@Test
	public void testGetDining() {
		dining.setdReservationNumber(1);
		dining.setGuestId(guest.getguestId());
		dining.setDiningType("test");
		dining.setArrivalDate(date);
		dining.setNoOfPeople(1);

		when(dao.getDining(dining.getdReservationNumber())).thenReturn(dining);
		Dining test = service.getDining(dining.getdReservationNumber());
		assertNotNull(test);
	}

	@Test
	public void testGetAllDining() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelDining() {
		fail("Not yet implemented");
	}

}
