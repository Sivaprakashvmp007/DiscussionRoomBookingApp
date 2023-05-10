package com.exterro.discussionRoomBookingApp;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscussionRoomBookingAppApplication {
	
	//creating logger object
	private static Logger logger = Logger.getLogger("DiscussionRoomBookingAppApplication");

	public static void main(String[] args) {
		//adding try and catch block
		try {
			SpringApplication.run(DiscussionRoomBookingAppApplication.class, args);
		}

		catch (Exception e) {
			logger.info("error");
		}
	}
}