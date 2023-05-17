package com.devmtn30.TDD_Hexagonal.product;

import com.devmtn30.TDD_Hexagonal.AddProductRequest;
import com.devmtn30.TDD_Hexagonal.DiscountPilicy;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductSteps {
    public static ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .post("/products")
                .then()
                .log().all().extract();
    }

    public static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 1000;
        DiscountPilicy discountPilicy = DiscountPilicy.NONE;
        return new AddProductRequest(name, price, discountPilicy);
    }
}
