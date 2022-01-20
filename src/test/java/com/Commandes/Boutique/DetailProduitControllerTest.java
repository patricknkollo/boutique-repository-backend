package com.Commandes.Boutique;

import com.Commandes.Boutique.controllers.DetailsProduitController;
import com.Commandes.Boutique.entities.DetailsProduits;
import com.Commandes.Boutique.services.DetailsProduitService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@WebMvcTest(DetailsProduitController.class)
@AutoConfigureMockMvc
public class DetailProduitControllerTest {
  @Autowired
  private MockMvc mockMvc;


 /* @Spy
  private JavaMailSenderImpl javaMailSender;

  @Captor
  private ArgumentCaptor<MimeMessage> messageCaptor;*/

  ObjectMapper objectMapper = new ObjectMapper();
  ObjectWriter objectWriter = objectMapper.writer();


 /* ***************************
  APPLICATION FAILED TO START
***************************

  Description:

  Field service in com.Commandes.Boutique.controllers.DetailsProduitController required a bean of type
  'com.Commandes.Boutique.services.DetailsProduitService' that could not be found.
  est le type d'erreur que l'obtient lorsqu'on utilise @Mock aulieu de @MockBean dans un test de controller avec MockMvc
  !!!!!!!!!!!!!!UTILISER @MockBean dans ce cas svp*/
  @MockBean
  DetailsProduitService service;

  DetailsProduits produit1 = new DetailsProduits(1L, 2L, Timestamp.valueOf("2021-12-25 11:00:00") , 25000, 13000);
  DetailsProduits produit2 = new DetailsProduits(2L, 1L, Timestamp.valueOf("2021-10-14 11:00:00") , 17000, 5000);
  DetailsProduits produit3 = new DetailsProduits(3L, 4L, Timestamp.valueOf("2021-06-12 11:00:00") , 4000, 1700);

  @Test
  @Order(1)
  public void test_saveDetailProduit() throws Exception {
    ResponseEntity<DetailsProduits> responseEntity = new ResponseEntity<>(produit1, HttpStatus.OK);
    Mockito.when(service.saveDetailProduit(produit1)).thenReturn(responseEntity);

    mockMvc.perform(MockMvcRequestBuilders.post("/api/detailsProduitController/save")
        .content("{\n"
            + "\t\"detailProduitId\":\"15\",\n"
            + "\t\"produitid\":\"1\",\n"
            + "\t\"dateEntree\":\"2022-01-01\",\n"
            + "\t\"qte_entree\":\"15000\",\n"
            + "\t\"qte_sortie\":\"11000\"\n"
            + "}")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    Mockito.verify(service).saveDetailProduit(Mockito.any(DetailsProduits.class));
    ;

  }
  @Test@Order(2)
  public void test_getDetailProduit()throws Exception{
    List<DetailsProduits>detailsProduits = List.of(produit1,produit2,produit3);
    ResponseEntity<List<DetailsProduits>> responseEntity = new ResponseEntity<>(detailsProduits, HttpStatus.OK);
    Mockito.when(service.getDetailProduit()).thenReturn(responseEntity);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/detailsProduitController/all"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)))
        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].qte_entree", Matchers.is(25000) ))
    ;
  }
  @Test@Order(3)
  public void test_getDetailProduitWithId()throws Exception{
    Long id = 1L;
    ResponseEntity<Optional<DetailsProduits>> responseEntity = new ResponseEntity<>(Optional.of(produit1), HttpStatus.OK);
    Mockito.when(service.getDetailProduitWithId(id)).thenReturn(responseEntity);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/detailsProduitController/{id}", id))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.qte_entree", Matchers.is(25000) ))
    ;
  }
  @Test@Order(4)
  public void test_removeDetailsProduitsWithId()throws Exception{
    Long id = 1L;
    mockMvc.perform(MockMvcRequestBuilders.delete("/api/detailsProduitController/delete/{id}", id))
        .andReturn();
    Mockito.verify(service).removeDetailsProduitsWithId(id);
  }
}
