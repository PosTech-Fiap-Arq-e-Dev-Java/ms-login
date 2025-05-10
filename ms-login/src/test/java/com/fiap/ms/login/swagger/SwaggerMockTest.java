package com.fiap.ms.login.swagger;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SwaggerMockTest {

    @Test
    public void testSwagger200() throws Exception {
        MockWebServer mockWebServer = new MockWebServer();

        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("<html>Swagger UI</html>"));

        mockWebServer.start();

        RestAssured
                .given()
                .baseUri(mockWebServer.url("/ms-login/swagger-ui/index.html").toString())
                .when()
                .get()
                .then()
                .statusCode(200);

        mockWebServer.shutdown();
    }

    @Test
    public void testSwagger404() throws Exception {
        MockWebServer mockWebServer = new MockWebServer();

        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(404)
                .setBody("Not Found"));

        mockWebServer.start();

        RestAssured
                .given()
                .baseUri(mockWebServer.url("/ms-login/swagger-ui/index.html").toString())
                .when()
                .get()
                .then()
                .statusCode(404);

        mockWebServer.shutdown();
    }

    @Test
    public void testBadRequest400() throws Exception {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(400).setBody("Bad Request"));
        server.start();

        RestAssured
                .given()
                .baseUri(server.url("/ms-login/erro400").toString())
                .when()
                .get()
                .then()
                .statusCode(400);

        server.shutdown();
    }

    @Test
    public void testUnauthorized401() throws Exception {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(401).setBody("Unauthorized"));
        server.start();

        RestAssured
                .given()
                .baseUri(server.url("/ms-login/protegido").toString())
                .when()
                .get()
                .then()
                .statusCode(401);

        server.shutdown();
    }

    @Test
    public void testForbidden403() throws Exception {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(403).setBody("Forbidden"));
        server.start();

        RestAssured
                .given()
                .baseUri(server.url("/ms-login/restrito").toString())
                .when()
                .get()
                .then()
                .statusCode(403);

        server.shutdown();
    }

    @Test
    public void testInternalServerError500() throws Exception {
        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(500).setBody("Internal Error"));
        server.start();

        RestAssured
                .given()
                .baseUri(server.url("/ms-login/erro500").toString())
                .when()
                .get()
                .then()
                .statusCode(500);

        server.shutdown();
    }

    @Test
    public void testTimeoutException() throws Exception {
        MockWebServer server = new MockWebServer();

        server.enqueue(new MockResponse()
                .setBody("Resposta demorada")
                .setBodyDelay(5, TimeUnit.SECONDS));

        server.start();

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(1000)
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();

        RestAssuredConfig config = RestAssured.config().httpClient(
                HttpClientConfig.httpClientConfig().httpClientFactory(() -> httpClient)
        );

        assertThrows(Exception.class, () -> {
            RestAssured
                    .given()
                    .config(config)
                    .baseUri(server.url("/ms-login/lento").toString())
                    .when()
                    .get()
                    .then()
                    .statusCode(200);
        });

        server.shutdown();
    }
}
