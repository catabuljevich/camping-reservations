package com.techelevator;

import javax.sql.DataSource;

import com.techelevator.controllers.CampgroundApplication;
import com.techelevator.models.dao.CampgroundDao;
import com.techelevator.models.dao.ParkDao;
import com.techelevator.models.dao.ReservationDao;
import com.techelevator.models.dao.SiteDao;
import org.apache.commons.dbcp2.BasicDataSource;

public class CampgroundCLI {


	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		CampgroundApplication application = new CampgroundApplication(dataSource);
		application.run();
	}

}
