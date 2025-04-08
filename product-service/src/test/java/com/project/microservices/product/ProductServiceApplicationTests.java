package com.project.microservices.product;


import static org.hamcrest.Matchers.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
								{
				    "name" : "samsung s24",
				    "description" : "samsung's best plus model",
				    "price" : 100000
				}
								""";

		RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.when()
				.post("/api/products") 
				.then()
				.statusCode(201) 
				.body("id", notNullValue())
				.body("name", equalTo("samsung s24"))
				.body("description", equalTo("samsung's best plus model"))
				.body("price", equalTo(100000));
	}

}
