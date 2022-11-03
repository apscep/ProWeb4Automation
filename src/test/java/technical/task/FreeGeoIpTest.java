package technical.task;

import ActionsRepository.GetProperty;
import io.restassured.path.json.JsonPath;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FreeGeoIpTest {

    String ip = GetProperty.getIp();
    String apiKey = GetProperty.getApiKey();
    String requestUrl = StringUtils.join("http://api.ipstack.com/",ip,apiKey);

    @Test
    @DisplayName("Check Latitude")
    void checkLatitudeTest(){
    var response =
                    given()
                    .when()
                    .post(requestUrl);

    JsonPath jsonpathResponse = response.jsonPath();
    float latitude = jsonpathResponse.getFloat("latitude");
    float longitude = jsonpathResponse.getFloat("longitude");

    response.then()
            .log()
            .all()
            .statusCode(200);
    Assertions.assertEquals(latitude,32.06,0.01);
    Assertions.assertEquals(longitude,34.77,0.01);
        }

    }

