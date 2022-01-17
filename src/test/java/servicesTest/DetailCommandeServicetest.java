package servicesTest;

import com.Commandes.Boutique.entities.DetailCommande;
import com.Commandes.Boutique.repositories.DetailCommandeRepository;
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
import java.util.Optional;

@SpringBootTest(classes={DetailCommandeServicetest.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DetailCommandeServicetest {

  @InjectMocks
  DetailsCommandeService service;

  @Mock
  DetailCommandeRepository repository;

  DetailCommande detailCommande1 = new DetailCommande(1L, 2L, 1L, 30000,
  25.99, 35.99);
  DetailCommande detailCommande2 = new DetailCommande(2L, 3L, 4L, 27000,
      15.99, 25.99);
  DetailCommande detailCommande3 = new DetailCommande(3L, 4L, 2L, 12000,
      19.99, 30.99);
  @Test
  @Order(1)
  public void test_saveDetailCommande(){
    ResponseEntity<DetailCommande> expectedResponseEntity = new ResponseEntity<>(detailCommande1, HttpStatus.OK);
    Mockito.when( repository.save(detailCommande1)).thenReturn(detailCommande1);
    Assert.assertEquals(expectedResponseEntity, service.saveDetailCommande(detailCommande1));

  }
  @Test
  @Order(1)
  public void test_getDetailCommandes(){
    List<DetailCommande> detailCommandes = List.of(detailCommande1,detailCommande2,detailCommande3);
    ResponseEntity<List<DetailCommande>> expectedResponseEntity = new ResponseEntity<>(detailCommandes, HttpStatus.OK);
    Mockito.when(repository.findAll()).thenReturn(detailCommandes);
    Assert.assertEquals(expectedResponseEntity, service.getDetailCommandes());
  }
  @Test
  @Order(1)
  public void test_getDetailCommandeWithId(){
    Long detailCommandeId = 2L;
    ResponseEntity<Optional<DetailCommande>> expectedResponseEntity = new ResponseEntity<>(Optional.of(detailCommande1), HttpStatus.OK);
    Mockito.when(repository.findById(detailCommandeId)).thenReturn(Optional.of(detailCommande1));
    Assert.assertEquals(expectedResponseEntity, service.getDetailCommandeWithId(detailCommandeId));
  }
  @Test
  @Order(1)
  public void test_removeDetailCommandeWithId(){
    Long detailCommnandeId = 2L;
    service.removeDetailCommandeWithId(detailCommnandeId);
    Mockito.verify(repository).deleteById(detailCommnandeId);
  }
}
