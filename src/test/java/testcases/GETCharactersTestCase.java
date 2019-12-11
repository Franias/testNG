package testcases;

import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Timestamp;

import static io.restassured.RestAssured.given;
import static utils.HashUtil.getHash;

public class GETCharactersTestCase {
  @Parameters({"apiKey","privateApiKey"})

  @Test
  public void getCharactersWithSuccess(String apiKey, String privateApiKey){
    Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
    String timeStampStr = timeStamp.toString();

    String md5Str = timeStampStr + privateApiKey + apiKey;

    String hash = getHash(md5Str);

    Response response = given().
            baseUri("https://gateway.marvel.com/v1/public").
            basePath("characters").
            param("ts", timeStampStr).
            param("apikey", "").
            param("hash", "").
            param("name", "X-Men").
            when().
            get();

  }

}
