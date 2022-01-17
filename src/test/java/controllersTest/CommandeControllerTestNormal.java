package controllersTest;

import com.Commandes.Boutique.controllers.CommandesController;
import com.Commandes.Boutique.entities.Commandes;
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
import org.springframework.web.bind.annotation.ResponseBody;
import projections.CommandeProjection;
import projections.CommandeProjectionClientAndDate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {CommandeControllerTestNormal.class})
public class CommandeControllerTestNormal {
  @InjectMocks
  CommandesController commandesController;

  @Mock
  CommandesService service;

  Commandes com1 = new Commandes(1L, 2L,  Timestamp.valueOf("2021-03-10 14:10:24"), "seconde main");
  Commandes com2 = new Commandes(2L, 3L, Timestamp.valueOf("2020-04-23 11:28:36"), "tout neuf");
  Commandes com3 = new Commandes(3L, 1L, Timestamp.valueOf("2017-07-30 16:11:02"), "bon etat");
  Commandes com4 = new Commandes(4L, 4L, Timestamp.valueOf("2014-08-17 15:36:09"), "etat defectueux");

  @Test
  @Order(1)
  public void test_getCommandes(){
    List<Commandes> cmdList = List.of(com1, com2, com3, com4);
    ResponseEntity<List<Commandes>> responseEntity = new ResponseEntity<List<Commandes>>(cmdList, HttpStatus.OK);
    Mockito.when(service.getCommandes()).thenReturn(responseEntity);
    Assert.assertEquals(responseEntity, commandesController.getCommandes());
    Assert.assertEquals("seconde main", commandesController.getCommandes().getBody().get(0).getEtatcmd());
    Assert.assertEquals(Timestamp.valueOf("2020-04-23 11:28:36"), commandesController.getCommandes().getBody().get(1).getDatecmd());
    Assert.assertEquals(com4.getCliendid(), commandesController.getCommandes().getBody().get(3).getCliendid());
    Assert.assertEquals("bon etat", commandesController.getCommandes().getBody().get(2).getEtatcmd());
    
  }
  
  @Test
  @Order(2)
  public void test_getCommandesWithId(){
    Long cmdID = 2L;
    ResponseEntity<Optional<Commandes>> responseEntity = new ResponseEntity<Optional<Commandes>>(Optional.of(com1), HttpStatus.OK);
    Mockito.when(service.getCommandesWithId(cmdID)).thenReturn(responseEntity);
    Assert.assertEquals(responseEntity,commandesController.getCommandesWithId(cmdID));
    Assert.assertEquals("seconde main",commandesController.getCommandesWithId(cmdID).getBody().get().getEtatcmd());
    Assert.assertEquals(Timestamp.valueOf("2021-03-10 14:10:24"),commandesController.getCommandesWithId(cmdID).getBody().get().getDatecmd());
    
  }

  @Test
  @Order(3)
  public void test_getProjectionClientAndCmd(){
    CommandeProjection cmdproj1 = new CommandeProjection() {
      @Override
      public String getCommandAndClientIds() {
        return com1.getNumCMDid()+ "   "+ com1.getCliendid();
      }
    } ;
    CommandeProjection cmdproj2 = new CommandeProjection() {
      @Override
      public String getCommandAndClientIds() {
        return com2.getNumCMDid()+ "   "+ com2.getCliendid();
      }
    } ;
    CommandeProjection cmdproj3 = new CommandeProjection() {
      @Override
      public String getCommandAndClientIds() {
        return com3.getNumCMDid()+ "   "+ com3.getCliendid();
      }
    } ;
    CommandeProjection cmdproj4 = new CommandeProjection() {
      @Override
      public String getCommandAndClientIds() {
        return com4.getNumCMDid()+ "   "+ com4.getCliendid();
      }
    } ;
    List<CommandeProjection> cmdProjections = List.of(cmdproj1,cmdproj2,cmdproj3,cmdproj4);
    ResponseEntity<List<CommandeProjection>> responseEntity = new ResponseEntity<List<CommandeProjection>>(cmdProjections, HttpStatus.OK);

    Mockito.when(service.getClientAndCmd()).thenReturn(cmdProjections);
    Assert.assertEquals(responseEntity, commandesController.getProjectionClientAndCmd());
    Assert.assertEquals("1   2", commandesController.getProjectionClientAndCmd().getBody().get(0).getCommandAndClientIds());
    Assert.assertEquals("2   3", commandesController.getProjectionClientAndCmd().getBody().get(1).getCommandAndClientIds());
    Assert.assertEquals("3   1", commandesController.getProjectionClientAndCmd().getBody().get(2).getCommandAndClientIds());
  }

  @Test
  @Order(4)
  public  void test_getCmdClientAndDateOfCommande(){
    CommandeProjectionClientAndDate cmdClientDate1 = new CommandeProjectionClientAndDate() {
      @Override
      public Long getClientid() {
        return com1.getCliendid();
      }

      @Override
      public Date getDatecmd() {
        return com1.getDatecmd();
      }
    };
    CommandeProjectionClientAndDate cmdClientDate2 = new CommandeProjectionClientAndDate() {
      @Override
      public Long getClientid() {
        return com2.getCliendid();
      }

      @Override
      public Date getDatecmd() {
        return com2.getDatecmd();
      }
    };
    List<CommandeProjectionClientAndDate> liste = List.of(cmdClientDate1,cmdClientDate2);
    ResponseEntity<List<CommandeProjectionClientAndDate>> responseEntity = new ResponseEntity<List<CommandeProjectionClientAndDate>>(liste, HttpStatus.OK);
    Mockito.when(service.getCmdClientDate()).thenReturn(responseEntity);
    Assert.assertEquals(responseEntity, commandesController.getCmdClientAndDateOfCommande());
    Assert.assertEquals(Timestamp.valueOf("2021-03-10 14:10:24"), commandesController.getCmdClientAndDateOfCommande().getBody().get(0).getDatecmd());
    Assert.assertEquals(Long.valueOf(3L), commandesController.getCmdClientAndDateOfCommande().getBody().get(1).getClientid());
  }

}
