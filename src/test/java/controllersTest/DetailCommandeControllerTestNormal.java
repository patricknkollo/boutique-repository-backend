package controllersTest;

import com.Commandes.Boutique.controllers.DetailCommandeController;
import com.Commandes.Boutique.entities.DetailCommande;
import com.Commandes.Boutique.services.DetailsCommandeService;
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

@SpringBootTest(classes = {DetailCommandeControllerTestNormal.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DetailCommandeControllerTestNormal {

  @InjectMocks
  DetailCommandeController detailCommandeController;

  @Mock
  DetailsCommandeService service;

  DetailCommande detCmd1 = new DetailCommande(1L, 2L, 2L, 24000, 19.99, 27.99);
  DetailCommande detCmd2 = new DetailCommande(2L, 3L, 1L, 14200, 39.99, 45.99);
  DetailCommande detCmd3 = new DetailCommande(3L, 1L, 2L, 33000, 54.99, 75.99);

  @Test
  @Order(1)
  public void test_saveDetailCommande(){

  }

  @Test
  @Order(2)
  public void test_getDetailCommandes(){
    List<DetailCommande> detailCommandes = List.of(detCmd1,detCmd2,detCmd3);
    ResponseEntity<List<DetailCommande>> responseEntity = new ResponseEntity<List<DetailCommande>>(detailCommandes, HttpStatus.OK);
    Mockito.when(service.getDetailCommandes()).thenReturn(responseEntity);
    Assert.assertTrue(responseEntity.equals(detailCommandeController.getDetailCommandes()));
    Assert.assertEquals(HttpStatus.OK, detailCommandeController.getDetailCommandes().getStatusCode());
  }

  @Test
  @Order(3)
  public void test_getDetailCommandeWithId(){

  }

  @Test
  @Order(4)
  public void test_removeDetailCommandeWithId(){

  }
}
