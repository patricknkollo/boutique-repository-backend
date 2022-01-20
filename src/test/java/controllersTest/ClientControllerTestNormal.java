package controllersTest;

import com.Commandes.Boutique.controllers.ClientController;
import com.Commandes.Boutique.entities.Client;
import com.Commandes.Boutique.services.ClientService;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import projections.ClientProjectionNameAndVorname;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = {ClientControllerTestNormal.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientControllerTestNormal {

  @Mock
  ClientService service;

  @InjectMocks
  ClientController clientController;

  Client client1 = new Client(1L, "dauphine", "nkollo", "bepanda omnisport", "nkollomarguerite@yahoo.fr", "004915267895", "Douala", 74 ,"BP12",  "Kamerun");
  Client client2 = new Client(2L, "patrick", "nkollo", "fieldsieber", "nkollopatrick@yahoo.fr", "004915267895", "Bochum", 14 ,"47364",  "deutschland");
  Client client3 = new Client(3L, "gerard", "mabong", "cite cic", "gemabong@yahoo.fr", "004915677895", "Douala", 14 ,"BP47",  "Kamerun");

  @Test
  @Order(1)
  public void test_save(){

    ResponseEntity<Client> responseEntity = new ResponseEntity<Client>(client1, HttpStatus.CREATED);
    Mockito.when(service.saveClient(client1)).thenReturn(responseEntity);
    Assert.assertEquals(HttpStatus.CREATED, clientController.saveClient(client1).getStatusCode());
    Assert.assertEquals("bepanda omnisport", clientController.saveClient(client1).getBody().getRue());
  }
  @Test
  @Order(2)
  public void test_saveClientNormal(){

    Mockito.when(service.saveClientNormal(client1)).thenReturn(client2);
    Assert.assertEquals("fieldsieber", clientController.saveClientNormal(client1).getRue());
  }
  @Test
  @Order(3)
  public void test_getClientsNormal(){
    List<Client> clients = List.of(client1,client2, client3);
    Mockito.when(service.getClientsNormal()).thenReturn(clients);

    Assert.assertEquals(3,clientController.getClientsNormal().size());
    Assert.assertEquals(client1,clientController.getClientsNormal().get(0));
    Assert.assertEquals("dauphine",clientController.getClientsNormal().get(0).getPrenom());
    Assert.assertTrue(clientController.getClientsNormal().contains(client1));
  }

  @Test
  @Order(4)
  public void test_getClients(){
    List<Client> clients = List.of(client1,client2, client3);
    ResponseEntity<List<Client>> responseEntity = new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    Mockito.when(service.getClients()).thenReturn(responseEntity);

    Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    Assert.assertEquals(clients, responseEntity.getBody());
    Assert.assertEquals(client1, responseEntity.getBody().get(0));
    Assert.assertEquals("mabong", responseEntity.getBody().get(2).getNom());

  }

  @Test
  @Order(5)
  public void test_getClientsWithId(){
    Long clientID = 2L;
    ResponseEntity<Optional<Client>> responseEntity = new ResponseEntity<Optional<Client>>(Optional.of(client2), HttpStatus.OK);
        Mockito.when(service.getClientsWithId(clientID)).thenReturn(responseEntity);
    Assert.assertEquals(HttpStatus.OK, clientController.getClientsWithId(clientID).getStatusCode());
    Assert.assertEquals(clientID,clientController.getClientsWithId(clientID).getBody().get().getClientid());
    Assert.assertEquals("nkollo",clientController.getClientsWithId(clientID).getBody().get().getNom());
    Assert.assertEquals("patrick",clientController.getClientsWithId(clientID).getBody().get().getPrenom());
    Assert.assertEquals("Bochum",clientController.getClientsWithId(clientID).getBody().get().getVille());

  }
  @Test
  @Order(6)
  public void test_getClientsWithName(){
    List<Client> clients = List.of(client1,client2, client3);
    String clientName = "nkollo";
    Mockito.when(service.getClientsWithName(clientName)).thenReturn(List.of(client1, client2));
    Assert.assertEquals(2,clientController.getClientsWithName(clientName).getBody().size());
    Assert.assertEquals("dauphine",clientController.getClientsWithName(clientName).getBody().get(0).getPrenom());
    Assert.assertEquals("patrick",clientController.getClientsWithName(clientName).getBody().get(1).getPrenom());
  }

  @Test
  @Order(7)
  public void test_getNameAndFirstnameClient(){
    ClientProjectionNameAndVorname cp1 = new ClientProjectionNameAndVorname() {
      @Override
      public String getNom() {
        return client1.getNom();
      }

      @Override
      public String getPrenom() {
        return client1.getPrenom();
      }
    };
    ClientProjectionNameAndVorname cp2 = new ClientProjectionNameAndVorname() {
      @Override
      public String getNom() {
        return client2.getNom();
      }

      @Override
      public String getPrenom() {
        return client2.getPrenom();
      }
    };
    List<ClientProjectionNameAndVorname> res = List.of(cp1, cp2);
    Mockito.when(service.getAllClientNameAndFirstname()).thenReturn(res);
    ResponseEntity<List<ClientProjectionNameAndVorname>> responseEntity = new ResponseEntity<List<ClientProjectionNameAndVorname>>(res, HttpStatus.OK);
    Assert.assertEquals(HttpStatus.OK, clientController.getNameAndFirstnameClient().getStatusCode());
    Assert.assertEquals("nkollo", clientController.getNameAndFirstnameClient().getBody().get(0).getNom());
    Assert.assertEquals("dauphine", clientController.getNameAndFirstnameClient().getBody().get(0).getPrenom());
    Assert.assertEquals("nkollo", clientController.getNameAndFirstnameClient().getBody().get(1).getNom());
    Assert.assertEquals("patrick", clientController.getNameAndFirstnameClient().getBody().get(1).getPrenom());

  }
}
