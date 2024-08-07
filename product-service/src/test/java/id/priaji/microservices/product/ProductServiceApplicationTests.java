package id.priaji.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

//	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
//
//	@LocalServerPort
//	private Integer port;
//
//	@BeforeEach
//	void setup(){
//		RestAssured.baseURI = "http://localhost";
//		RestAssured.port = port;
//	}
//
//	static {
//		mongoDBContainer.start();
//	}
//
//	@Test
//	void shouldCreateProduct() {
//		String requestBody = """
//				{
//				    "name": "Iphone 17",
//				    "description": "New Iphone 17",
//				    "price": 1300
//				}
//				""";
//		RestAssured.given()
//				.contentType("application/json")
//				.body(requestBody)
//				.when()
//				.post("/api/product")
//				.then()
//				.statusCode(201)
//				.body("id", Matchers.notNullValue())
//				.body("name", Matchers.equalTo("Iphone 17"))
//				.body("description", Matchers.equalTo("New Iphone 17"))
//				.body("price", Matchers.equalTo(1300));
//	}

}
