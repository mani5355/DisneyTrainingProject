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
import org.springframework.test.context.junit4.SpringRunner;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.dao.IResortDao;

@RunWith(SpringRunner.class)
public class ResortServiceImplTest {

	@Mock
	IResortDao rDao;

	@InjectMocks
	ResortServiceImpl rservice;

	Guest guest = new Guest();
	Date date = new Date();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRegisterResort() {
		guest.setguestId(1);
		long guestId = guest.getguestId();

		Resort resort = new Resort();
		resort.setRoomType("deluxtest");
		resort.setNoOfPeople(2);
		resort.setArrivalDate(date);
		resort.setDepartureDate(date);
		resort.setGuestId(guestId);

		when(rDao.registerResort(resort, guestId)).thenReturn(resort);
		Resort test = rservice.registerResort(resort, guestId);
		assertNotNull(test);

	}

}
