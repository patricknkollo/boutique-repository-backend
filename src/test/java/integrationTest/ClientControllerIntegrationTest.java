package integrationTest;

import com.Commandes.Boutique.entities.Client;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.net.URI;

@SpringBootTest(classes = {ClientControllerIntegrationTest.class})
public class ClientControllerIntegrationTest {

  @Test
  @Order(1)
  public void test_integration_haveAllClient() throws JSONException {

    String firstElement =  "\t{\n"
        + "\t\t\"clientid\": 1,\n"
        + "\t\t\"prenom\": \"georges\",\n"
        + "\t\t\"nom\": \"patrick nkollo\",\n"
        + "\t\t\"rue\": \"beckerskamp\",\n"
        + "\t\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"essen\",\n"
        + "\t\t\"numero\": 17,\n"
        + "\t\t\"postCode\": \"45266\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t},\n";

    String expected = "[\n"
        + "\t{\n"
        + "\t\t\"clientid\": 1,\n"
        + "\t\t\"prenom\": \"georges\",\n"
        + "\t\t\"nom\": \"patrick nkollo\",\n"
        + "\t\t\"rue\": \"beckerskamp\",\n"
        + "\t\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"essen\",\n"
        + "\t\t\"numero\": 17,\n"
        + "\t\t\"postCode\": \"45266\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t},\n"
        + "\t{\n"
        + "\t\t\"clientid\": 2,\n"
        + "\t\t\"prenom\": \"dauphine\",\n"
        + "\t\t\"nom\": \"nkollo\",\n"
        + "\t\t\"rue\": \"fieldsieber\",\n"
        + "\t\t\"email\": \"nkollomarguerite@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"Bochum\",\n"
        + "\t\t\"numero\": 14,\n"
        + "\t\t\"postCode\": \"47364\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t},\n"
        + "\t{\n"
        + "\t\t\"clientid\": 3,\n"
        + "\t\t\"prenom\": \"thomas\",\n"
        + "\t\t\"nom\": \"müller\",\n"
        + "\t\t\"rue\": \"theodor-julius-Straße\",\n"
        + "\t\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"duisburg\",\n"
        + "\t\t\"numero\": 54,\n"
        + "\t\t\"postCode\": \"49235\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t},\n"
        + "\t{\n"
        + "\t\t\"clientid\": 4,\n"
        + "\t\t\"prenom\": \"georges\",\n"
        + "\t\t\"nom\": \"washington\",\n"
        + "\t\t\"rue\": \"theodor-julius-Straße\",\n"
        + "\t\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"duisburg\",\n"
        + "\t\t\"numero\": 54,\n"
        + "\t\t\"postCode\": \"49235\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t},\n"
        + "\t{\n"
        + "\t\t\"clientid\": 5,\n"
        + "\t\t\"prenom\": \"mateo\",\n"
        + "\t\t\"nom\": \" schneider\",\n"
        + "\t\t\"rue\": \"theodor-julius-Straße\",\n"
        + "\t\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"duisburg\",\n"
        + "\t\t\"numero\": 54,\n"
        + "\t\t\"postCode\": \"49235\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t},\n"
        + "\t{\n"
        + "\t\t\"clientid\": 6,\n"
        + "\t\t\"prenom\": \"bastian\",\n"
        + "\t\t\"nom\": \"kloss\",\n"
        + "\t\t\"rue\": \"theodor-julius-Straße\",\n"
        + "\t\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"duisburg\",\n"
        + "\t\t\"numero\": 54,\n"
        + "\t\t\"postCode\": \"49235\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t},\n"
        + "\t{\n"
        + "\t\t\"clientid\": 7,\n"
        + "\t\t\"prenom\": \"michael\",\n"
        + "\t\t\"nom\": \"hellebrandt\",\n"
        + "\t\t\"rue\": \"theodor-julius-Straße\",\n"
        + "\t\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"duisburg\",\n"
        + "\t\t\"numero\": 54,\n"
        + "\t\t\"postCode\": \"49235\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t},\n"
        + "\t{\n"
        + "\t\t\"clientid\": 8,\n"
        + "\t\t\"prenom\": \"harry\",\n"
        + "\t\t\"nom\": \"brandt\",\n"
        + "\t\t\"rue\": \"theodor-julius-Straße\",\n"
        + "\t\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"duisburg\",\n"
        + "\t\t\"numero\": 54,\n"
        + "\t\t\"postCode\": \"49235\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t},\n"
        + "\t{\n"
        + "\t\t\"clientid\": 9,\n"
        + "\t\t\"prenom\": \"klaus\",\n"
        + "\t\t\"nom\": \"wegner\",\n"
        + "\t\t\"rue\": \"theodor-julius-Straße\",\n"
        + "\t\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\t\"phone\": \"004915267895\",\n"
        + "\t\t\"ville\": \"duisburg\",\n"
        + "\t\t\"numero\": 54,\n"
        + "\t\t\"postCode\": \"49235\",\n"
        + "\t\t\"pays\": \"deutschland\"\n"
        + "\t}\n"
        + "]";
    TestRestTemplate restTemplate = new TestRestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(URI.create("http://localhost:8080/api/clientdata/allclients"), String.class);
    JSONAssert.assertEquals(expected, responseEntity.getBody(), true);
    Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


  }

  @Test
  @Order(2)
  public void test_integration_haveClientWithid() throws JSONException {

    String expected =  "{\n"
        + "\t\"clientid\": 1,\n"
        + "\t\"prenom\": \"georges\",\n"
        + "\t\"nom\": \"patrick nkollo\",\n"
        + "\t\"rue\": \"beckerskamp\",\n"
        + "\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\"phone\": \"004915267895\",\n"
        + "\t\"ville\": \"essen\",\n"
        + "\t\"numero\": 17,\n"
        + "\t\"postCode\": \"45266\",\n"
        + "\t\"pays\": \"deutschland\"\n"
        + "}";


    TestRestTemplate restTemplate = new TestRestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(URI.create("http://localhost:8080/api/clientdata/client/id/1"), String.class);
    JSONAssert.assertEquals(expected, responseEntity.getBody(), true);
    Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


  }

  @Test
  @Order(3)
  public void test_integration_saveClient() throws JSONException {
    Client client = new Client(1L, "georges", "patrick nkollo", "beckerskamp", "nkollopatrick@yahoo.fr", "004915267895","essen",17,"45266", "deutschland");

    String expected =  "{\n"
        + "\t\"clientid\": 1,\n"
        + "\t\"prenom\": \"georges\",\n"
        + "\t\"nom\": \"patrick nkollo\",\n"
        + "\t\"rue\": \"beckerskamp\",\n"
        + "\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\"phone\": \"004915267895\",\n"
        + "\t\"ville\": \"essen\",\n"
        + "\t\"numero\": 17,\n"
        + "\t\"postCode\": \"45266\",\n"
        + "\t\"pays\": \"deutschland\"\n"
        + "}";

    HttpHeaders headers= new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Client> clientHttpEntity = new HttpEntity<Client>(client, headers);

    TestRestTemplate restTemplate = new TestRestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(URI.create("http://localhost:8080/api/clientdata/save"), clientHttpEntity, String.class);
    JSONAssert.assertEquals(expected, responseEntity.getBody(), true);
    Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


  }

  @Test
  @Order(4)
  public void test_integration_UpdateClient() throws JSONException {
    Client client = new Client(1L, "georges", "patrick nkollo", "beckerskamp", "nkollopatrick@yahoo.fr", "004915267895","essen",17,"45276", "deutschland");

    String expected =  "{\n"
        + "\t\"clientid\": 1,\n"
        + "\t\"prenom\": \"georges\",\n"
        + "\t\"nom\": \"patrick nkollo\",\n"
        + "\t\"rue\": \"beckerskamp\",\n"
        + "\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\"phone\": \"004915267895\",\n"
        + "\t\"ville\": \"essen\",\n"
        + "\t\"numero\": 17,\n"
        + "\t\"postCode\": \"45276\",\n"
        + "\t\"pays\": \"deutschland\"\n"
        + "}";

    HttpHeaders headers= new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Client> clientHttpEntity = new HttpEntity<Client>(client, headers);

    TestRestTemplate restTemplate = new TestRestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(URI.create("http://localhost:8080/api/clientdata/save"), clientHttpEntity, String.class);
    JSONAssert.assertEquals(expected, responseEntity.getBody(), true);
    Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


  }

  @Test
  @Order(5)
  public void test_integration_DeleteClient() throws JSONException {
    Client client = new Client(1L, "georges", "patrick nkollo", "beckerskamp", "nkollopatrick@yahoo.fr", "004915267895","essen",17,"45276", "deutschland");

    String expected =  "{\n"
        + "\t\"clientid\": 1,\n"
        + "\t\"prenom\": \"georges\",\n"
        + "\t\"nom\": \"patrick nkollo\",\n"
        + "\t\"rue\": \"beckerskamp\",\n"
        + "\t\"email\": \"nkollopatrick@yahoo.fr\",\n"
        + "\t\"phone\": \"004915267895\",\n"
        + "\t\"ville\": \"essen\",\n"
        + "\t\"numero\": 17,\n"
        + "\t\"postCode\": \"45276\",\n"
        + "\t\"pays\": \"deutschland\"\n"
        + "}";

    HttpHeaders headers= new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Client> clientHttpEntity = new HttpEntity<Client>(client, headers);

    TestRestTemplate restTemplate = new TestRestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.exchange(URI.create("http://localhost:8080/api/clientdata//delete/1"), HttpMethod.DELETE,clientHttpEntity, String.class);
    JSONAssert.assertEquals(expected, responseEntity.getBody(), true);
    Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


  }
}
