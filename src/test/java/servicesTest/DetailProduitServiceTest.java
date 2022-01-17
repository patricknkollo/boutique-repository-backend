package servicesTest;

import com.Commandes.Boutique.entities.DetailsProduits;
import com.Commandes.Boutique.repositories.DetailsProduitsRepository;
import com.Commandes.Boutique.services.DetailsProduitService;
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

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = {DetailProduitServiceTest.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DetailProduitServiceTest {

  @InjectMocks
  DetailsProduitService service;

  @Mock
  DetailsProduitsRepository repository;

  DetailsProduits detailsProduits1 = new DetailsProduits(1L, 1L, Timestamp.valueOf("2022-01-08 11:24:27"), 12000, 9000);
  DetailsProduits detailsProduits2 = new DetailsProduits(2L, 4L, Timestamp.valueOf("2022-01-08 11:25:43"), 7000, 4500);
  DetailsProduits detailsProduits3 = new DetailsProduits(3L, 6L, Timestamp.valueOf("2022-01-08 11:26:36"), 22000, 17000);

  @Test
  @Order(1)
  public void test_saveDetailProduit(){
    ResponseEntity<DetailsProduits> expectedResponseEntity = new ResponseEntity<>(detailsProduits1, HttpStatus.OK);
    Mockito.when(repository.save(detailsProduits1)).thenReturn(detailsProduits1);
    Assert.assertEquals(expectedResponseEntity, service.saveDetailProduit(detailsProduits1));
  }
  @Test
  @Order(2)
  public void test_getDetailProduit(){
    List<DetailsProduits> list = List.of(detailsProduits1,detailsProduits2, detailsProduits3);
    ResponseEntity<List<DetailsProduits>> expectedResponseEntity = new ResponseEntity<>(list, HttpStatus.OK);
    Mockito.when(repository.findAll()).thenReturn(list);
    Assert.assertEquals(expectedResponseEntity, service.getDetailProduit());
  }
  @Test
  @Order(3)
  public void test_getDetailProduitWithId(){
    Long detailProduitId = 2L;
    ResponseEntity<Optional<DetailsProduits>> expectedResponseEntity = new ResponseEntity<>(Optional.of(detailsProduits1), HttpStatus.OK);
    Mockito.when(repository.findById(detailProduitId)).thenReturn(Optional.of(detailsProduits1));
    Assert.assertEquals(expectedResponseEntity,service.getDetailProduitWithId(detailProduitId));
  }
  @Test
  @Order(4)
  public void test_removeDetailsProduitsWithId(){
    Long id = 2L;
    service.removeDetailsProduitsWithId(id);
    Mockito.verify(repository).deleteById(id);
  }
}
