package com.thejoa703;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
<<<<<<< HEAD:fullstack_youngmin/fullstack_youngmin/track007_spring/boot002/src/main/java/com/thejoa703/Boot002Application.java
public class Boot002Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot002Application.class, args);
=======
@EnableScheduling
public class Boot001Application {

	public static void main(String[] args) {
		System.setProperty("https.protocols", "TLSv1.2,TLSv1.3");
		SpringApplication.run(Boot001Application.class, args);
>>>>>>> 773fcb54929969658b5d30cb92f113e22c9f6b65:fullstack_youngmin/track007_spring/boot001/src/main/java/com/thejoa703/Boot001Application.java
	}

}
