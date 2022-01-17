package servicesTest;

import com.Commandes.Boutique.entities.Client;
import com.Commandes.Boutique.repositories.ClientRepository;
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

@SpringBootTest(classes = {ClientServiceTest.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceTest {

  @Mock
  ClientRepository repository;

  @InjectMocks
  ClientService service;

  Client client1 = new Client(1L, "dauphine", "nkollo", "bepanda omnisport", "nkollomarguerite@yahoo.fr", "004915267895", "Douala", 74 ,"BP12",  "Kamerun");
  Client client2 = new Client(2L, "patrick", "nkollo", "fieldsieber", "nkollopatrick@yahoo.fr", "004915267895", "Bochum", 14 ,"47364",  "deutschland");
  Client client3 = new Client(3L, "gerard", "mabong", "cite cic", "gemabong@yahoo.fr", "004915677895", "Douala", 14 ,"BP47",  "Kamerun");

  @Mock
  Client clientMock1;
  @Mock
  Client clientMock2;
  @Mock
  Client clientMock3;

  ClientProjectionNameAndVorname clientPro1 = new ClientProjectionNameAndVorname() {
    @Override
    public String getNom() {
      return "mabong";
    }

    @Override
    public String getPrenom() {
      return "gerard";
    }
  };

  ClientProjectionNameAndVorname clientPro2 = new ClientProjectionNameAndVorname() {
    @Override
    public String getNom() {
      return "bona";
    }

    @Override
    public String getPrenom() {
      return "richard";
    }
  };
  ClientProjectionNameAndVorname clientPro3 = new ClientProjectionNameAndVorname() {
    @Override
    public String getNom() {
      return "mbella";
    }

    @Override
    public String getPrenom() {
      return "yohann";
    }
  };


  @Test
  @Order(1)
  public void test_saveClient(){
    ResponseEntity<Client> responseEntity = new ResponseEntity<>(client2, HttpStatus.OK);
    Mockito.when(repository.save(client1)).thenReturn(client2);
    Assert.assertEquals(responseEntity, service.saveClient(client1));
    Assert.assertEquals(HttpStatus.OK, service.saveClient(client1).getStatusCode());
    Assert.assertEquals("patrick", service.saveClient(client1).getBody().getPrenom());
    Assert.assertEquals("nkollopatrick@yahoo.fr", service.saveClient(client1).getBody().getEmail());
  }

  @Test
  @Order(2)
  public void test_saveClientNormal(){
    Mockito.when(repository.save(client1)).thenReturn(client2);
    Assert.assertEquals(client2, service.saveClientNormal(client1));
    Assert.assertEquals("fieldsieber", service.saveClientNormal(client1).getRue());
    Assert.assertEquals("patrick", service.saveClientNormal(client1).getPrenom());
    Assert.assertEquals("nkollopatrick@yahoo.fr", service.saveClientNormal(client1).getEmail());
  }

  @Test
  @Order(3)
  public void test_getClients(){
    List<Client> clients = List.of(client1,client2, client3);
    ResponseEntity<List<Client>> responseEntity = new ResponseEntity<>(clients, HttpStatus.OK);
    Mockito.when(repository.findAll()).thenReturn(clients);
    Assert.assertEquals(responseEntity, service.getClients());
    Assert.assertEquals("nkollopatrick@yahoo.fr", service.getClients().getBody().get(1).getEmail());
    Assert.assertEquals("dauphine", service.getClients().getBody().get(0).getPrenom());
    Assert.assertEquals("BP47", service.getClients().getBody().get(2).getPostCode());
  }

  @Test
  @Order(4)
  public void test_getClientsNormal(){
    List<Client> clients = List.of(client1,client2, client3);
    Mockito.when(repository.findAll()).thenReturn(clients);
    Assert.assertEquals(clients, service.getClientsNormal());
    Assert.assertEquals("nkollopatrick@yahoo.fr", service.getClientsNormal().get(1).getEmail());
    Assert.assertEquals("dauphine", service.getClientsNormal().get(0).getPrenom());
    Assert.assertEquals("BP47", service.getClientsNormal().get(2).getPostCode());
  }

  @Test
  @Order(5)
  public void test_getClientsWithId(){

    ResponseEntity<Optional<Client>> expectedResponseEntity = new ResponseEntity<>(Optional.of(client1), HttpStatus.OK);
    Long clientID = 1L;
    Mockito.when(repository.findById(clientID)).thenReturn(Optional.of(client1));
    Assert.assertEquals("dauphine",service.getClientsWithId(clientID).getBody().get().getPrenom());
    Assert.assertEquals("nkollo",service.getClientsWithId(clientID).getBody().get().getNom());
    Assert.assertEquals("bepanda omnisport",service.getClientsWithId(clientID).getBody().get().getRue());

  }

  @Test
  @Order(6)
  public void test_getClientsWithName(){
    List<Client> clients = List.of(client1,client2,client3);
    String clientName = "nkollo";
    Mockito.when(repository.getAllClientMitName(clientName)).thenReturn(clients);
    Assert.assertEquals("dauphine",service.getClientsWithName(clientName).get(0).getPrenom());
    Assert.assertEquals("nkollo",service.getClientsWithName(clientName).get(1).getNom());
    Assert.assertEquals("bepanda omnisport",service.getClientsWithName(clientName).get(0).getRue());
  }
  @Test
  @Order(7)
  public void test_getAllClientNameAndFirstname(){
    List<ClientProjectionNameAndVorname> clientsPros = List.of(clientPro1, clientPro2, clientPro3);
    Mockito.when(repository.getAllPersonNameAndFirstName()).thenReturn(clientsPros);
    Assert.assertEquals(clientsPros, service.getAllClientNameAndFirstname());
    Assert.assertEquals(clientPro1, service.getAllClientNameAndFirstname().get(0));
    Assert.assertEquals("mbella", service.getAllClientNameAndFirstname().get(2).getNom());
    Assert.assertEquals("yohann", service.getAllClientNameAndFirstname().get(2).getPrenom());
  }
  @Test
  @Order(8)
  public void test_updateClient(){
    Client newClient = new Client(3L, "alexandre", "ndoumbe", "si ndobo", "andoumbe@yahoo.fr", "0049157493895", "Douala", 69 ,"BP52",  "Kamerun");
    Long clientID = 2L;
    Mockito.when(repository.findById(clientID)).thenReturn(Optional.of(client1));
    Assert.assertEquals(Optional.of(client1),service.updateClient(newClient, clientID));
    Assert.assertEquals(Long.valueOf(1L),service.updateClient(newClient, clientID).get().getClientid());
    Assert.assertEquals("ndoumbe",service.updateClient(newClient, clientID).get().getNom());
  }
  @Test
  @Order(9)
  public void test_getAllClientFromStadt(){
    String ville = "douala";
    List<Client> clients = List.of(clientMock1,clientMock2,clientMock3);
    List<String> expected = List.of("nkollo","mabong");
    Mockito.when(repository.findAll()).thenReturn(clients);
    Mockito.when(clientMock1.getVille()).thenReturn(ville);
    Mockito.when(clientMock2.getVille()).thenReturn("yaounde");
    Mockito.when(clientMock3.getVille()).thenReturn(ville);
    Mockito.when(clientMock1.getNom()).thenReturn("nkollo");
    Mockito.when(clientMock3.getNom()).thenReturn("mabong");

    Assert.assertEquals("nkollo", service.getAllClientFromStadt(ville).get(0));
    Assert.assertEquals("mabong", service.getAllClientFromStadt(ville).get(1));
    Assert.assertEquals(2, service.getAllClientFromStadt(ville).size());
    Assert.assertEquals(expected, service.getAllClientFromStadt(ville));

  }

}
