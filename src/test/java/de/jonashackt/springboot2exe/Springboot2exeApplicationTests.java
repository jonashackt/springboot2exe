package de.jonashackt.springboot2exe;

import de.jonashackt.springboot2exe.controller.Controller;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = Springboot2exeApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
		properties = {"server.port=8080"}
)
public class Springboot2exeApplicationTests {

	@Test
	public void testWithSpringRestTemplate() {
		// Given
		RestTemplate restTemplate = new RestTemplate();

		// When
		String response = restTemplate.getForObject("http://localhost:8080/springboot2exe/hello", String.class);

		// Then
		assertEquals(Controller.RESPONSE, response);
	}

	/**
	 * Using Restassured for elegant REST-Testing, see https://github.com/jayway/rest-assured
	 */
	@Test
	public void testWithRestAssured() {

		given() // can be ommited when GET only
				.when() // can be ommited when GET only
				.get("http://localhost:8080/springboot2exe/hello")
				.then()
				.statusCode(HttpStatus.SC_OK)
				.assertThat()
				.equals(Controller.RESPONSE);
	}

	@Before
	public void setUp() {

	}

}
