package controllersTest;

import com.Commandes.Boutique.controllers.FamillesController;
import com.Commandes.Boutique.entities.Famille;
import com.Commandes.Boutique.services.FamilleService;
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

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = {FamilleControllerTestNormal.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FamilleControllerTestNormal {

   @Mock
  FamilleService service;

   @InjectMocks
  FamillesController famillesController;

   Famille famille1 = new Famille(1L, "famille 1");
  Famille famille2 = new Famille(2L, "famille 2");
  Famille famille3 = new Famille(3L, "famille 3");

  @Test
  @Order(1)
  public void test_saveFamilles(){
    ResponseEntity<Famille> responseEntity = new ResponseEntity<Famille>(famille1, HttpStatus.OK);
    Mockito.when(service.saveFamilles(famille1)).thenReturn(responseEntity);
    Assert.assertEquals(responseEntity,famillesController.saveFamilles(famille1));
    Assert.assertEquals("famille 1",famillesController.saveFamilles(famille1).getBody().getIntitule());
    Assert.assertEquals(Long.valueOf(1L),famillesController.saveFamilles(famille1).getBody().getFamilleProduitid());
   }

  @Test
  @Order(2)
  public void test_getFamilles(){
    List<Famille> familles = List.of(famille1, famille2, famille3);
    ResponseEntity<List<Famille>> responseEntity = new ResponseEntity<>(familles, HttpStatus.OK);
    Mockito.when(service.getFamilles()).thenReturn(responseEntity);
    Assert.assertEquals(famille1, famillesController.getFamilles().getBody().get(0));
    Assert.assertEquals(Long.valueOf(2L), famillesController.getFamilles().getBody().get(1).getFamilleProduitid());
    Assert.assertEquals("famille 3", famillesController.getFamilles().getBody().get(2).getIntitule());
  }

  @Test
  @Order(3)
  public void test_getFamillesWithId(){
    Long myID = 1L;
    ResponseEntity<Optional<Famille>> responseEntity = new ResponseEntity<>(Optional.of(famille2), HttpStatus.OK);
    Mockito.when(service.getFamillesWithId(myID)).thenReturn(responseEntity);
    Assert.assertEquals(responseEntity, famillesController.getFamillesWithId(myID));
    Assert.assertEquals(Long.valueOf(2L), famillesController.getFamillesWithId(myID).getBody().get().getFamilleProduitid());
    Assert.assertEquals("famille 2", famillesController.getFamillesWithId(myID).getBody().get().getIntitule());
    Assert.assertEquals(Optional.of(famille2), famillesController.getFamillesWithId(myID).getBody());
  }

  @Test
  @Order(4)
  public void test_removeFamillesWithId(){
    Long myID = 1L;
    famillesController.removeFamillesWithId(myID);
    Mockito.verify(service).removeFamillesWithId(myID);
  }

}
