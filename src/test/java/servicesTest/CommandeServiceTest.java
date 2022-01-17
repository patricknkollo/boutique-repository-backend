package servicesTest;

import com.Commandes.Boutique.entities.Commandes;
import com.Commandes.Boutique.repositories.CommandesRepository;
import com.Commandes.Boutique.services.CommandesService;
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
import projections.CommandeProjection;
import projections.CommandeProjectionClientAndDate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = {CommandeServiceTest.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommandeServiceTest {

  @Mock
  CommandesRepository repository;
  @InjectMocks
  CommandesService service;

  Commandes commande1 = new Commandes(1L, 4L, Timestamp.valueOf("2021-03-12 17:25:43"), "bon etat");
  Commandes commande2 = new Commandes(2L, 1L, Timestamp.valueOf("2021-11-01 09:35:46"), "bon etat");
  Commandes commande3 = new Commandes(3L, 2L, Timestamp.valueOf("2021-07-22 11:24:19"), "mauvais etat");
  @Test
  @Order(1)
  public  void test_saveCommandes(){
    ResponseEntity<Commandes> responseEntity = new ResponseEntity<>(commande2, HttpStatus.OK);
    Mockito.when(repository.save(commande1)).thenReturn(commande2);
    Assert.assertEquals(responseEntity, service.saveCommandes(commande1));
    Assert.assertEquals("bon etat", service.saveCommandes(commande1).getBody().getEtatcmd());
    Assert.assertEquals(Timestamp.valueOf("2021-11-01 09:35:46"), service.saveCommandes(commande1).getBody().getDatecmd());
  }
  @Test
  @Order(2)
  public  void test_getCommandes(){
    List<Commandes> list = List.of(commande1,commande2,commande3);
    ResponseEntity<List<Commandes>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
    Mockito.when(repository.findAll()).thenReturn(list);
    Assert.assertEquals(responseEntity,service.getCommandes());
    Assert.assertEquals(commande1,service.getCommandes().getBody().get(0));
    Assert.assertEquals(Long.valueOf(4L),service.getCommandes().getBody().get(0).getCliendid());

  }
  @Test
  @Order(3)
  public  void test_getCommandesWithId(){
    Long commandeId = 2L;
    ResponseEntity<Optional<Commandes>> responseEntity = new ResponseEntity<>(Optional.of(commande1), HttpStatus.OK);
    Mockito.when(repository.findById(commandeId)).thenReturn(Optional.of(commande1));
    Assert.assertEquals(responseEntity, service.getCommandesWithId(commandeId));
    Assert.assertEquals(Long.valueOf(4L), service.getCommandesWithId(commandeId).getBody().get().getCliendid());
    Assert.assertEquals("bon etat", service.getCommandesWithId(commandeId).getBody().get().getEtatcmd());

  }
  @Test
  @Order(4)
  public  void test_removeCommandesWithId(){
    Long commandeId = 2L;
    service.removeCommandesWithId(commandeId);

    Mockito.verify(repository).deleteById(commandeId);
  }
  @Test
  @Order(5)
  public  void test_getClientAndCmd(){
    CommandeProjection commandeProjection1 = new CommandeProjection() {
      @Override
      public String getCommandAndClientIds() {
        return "1  2";
      }
    };
    CommandeProjection commandeProjection2 = new CommandeProjection() {
      @Override
      public String getCommandAndClientIds() {
        return "3  4";
      }
    };
    CommandeProjection commandeProjection3 = new CommandeProjection() {
      @Override
      public String getCommandAndClientIds() {
        return "2  3";
      }
    };
    List<CommandeProjection> commandesProj = List.of(commandeProjection1,commandeProjection2,commandeProjection3);
    Mockito.when(repository.getCommandAndClientIdsFromDB()).thenReturn(commandesProj);
    Assert.assertEquals(commandesProj, service.getClientAndCmd());
    Assert.assertEquals(commandeProjection1, service.getClientAndCmd().get(0));
    Assert.assertEquals("3  4", service.getClientAndCmd().get(1).getCommandAndClientIds());
  }
  @Test
  @Order(6)
  public  void test_getCmdClientDate(){
    CommandeProjectionClientAndDate cm1 = new CommandeProjectionClientAndDate() {
      @Override
      public Long getClientid() {
        return 1L;
      }

      @Override
      public Date getDatecmd() {
        return Timestamp.valueOf("2012-02-14 14:25:03");
      }
    };
    CommandeProjectionClientAndDate cm2 = new CommandeProjectionClientAndDate() {
      @Override
      public Long getClientid() {
        return 2L;
      }

      @Override
      public Date getDatecmd() {
        return Timestamp.valueOf("2017-11-27 17:42:14");
      }
    };
    CommandeProjectionClientAndDate cm3 = new CommandeProjectionClientAndDate() {
      @Override
      public Long getClientid() {
        return 3L;
      }

      @Override
      public Date getDatecmd() {
        return Timestamp.valueOf("2019-07-28 07:14:34");
      }
    };
    List<CommandeProjectionClientAndDate> commandes = List.of(cm1, cm2, cm3);
    ResponseEntity<List<CommandeProjectionClientAndDate>> responseEntity = new ResponseEntity<List<CommandeProjectionClientAndDate>>(commandes, HttpStatus.OK);
    Mockito.when(repository.getAllCmdWithClientAndDate()).thenReturn(commandes);
    Assert.assertEquals(responseEntity, service.getCmdClientDate());
    Assert.assertEquals(Long.valueOf(2L), service.getCmdClientDate().getBody().get(1).getClientid());
    Assert.assertEquals(Timestamp.valueOf("2019-07-28 07:14:34"), service.getCmdClientDate().getBody().get(2).getDatecmd());

  }


}
