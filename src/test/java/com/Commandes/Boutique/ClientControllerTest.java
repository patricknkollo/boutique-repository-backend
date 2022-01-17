package com.Commandes.Boutique;

import com.Commandes.Boutique.controllers.ClientController;
import com.Commandes.Boutique.entities.Client;
import com.Commandes.Boutique.repositories.ClientRepository;
import com.Commandes.Boutique.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

//import org.junit.Test;

//@SpringJUnitConfig
//@SpringBootTest(classes = {ClientControllerTest.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@WebMvcTest(ClientController.class)
@AutoConfigureMockMvc
//@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();
	
	@MockBean
	ClientRepository clientRepository;
	
	@MockBean
	ClientService clientService;
	
	@InjectMocks
	private ClientController clientController;

	Client client1 = new Client(1L, "dauphine", "nkollo", "bepanda omnisport", "nkollomarguerite@yahoo.fr", "004915267895", "Douala", 74 ,"BP12",  "Kamerun");
	Client client2 = new Client(2L, "patrick", "nkollo", "fieldsieber", "nkollopatrick@yahoo.fr", "004915267895", "Bochum", 14 ,"47364",  "deutschland");
	Client client3 = new Client(3L, "gerard", "mabong", "cite cic", "gemabong@yahoo.fr", "004915677895", "Douala", 14 ,"BP47",  "Kamerun");

	@Test
	public void getAllClientTest() throws Exception {
		
	List<Client> clients = List.of(client1,client2,client3);
	ResponseEntity<List<Client>> responseEntity = new ResponseEntity<>(clients, HttpStatus.OK);
		when(clientService.getClients()).thenReturn((responseEntity) );
		
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/clientdata/allclients")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()" ,Matchers.is(3)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].nom", Matchers.is("mabong"))
				);
	}

	@Test
	public void getAllClientNormalTest() throws Exception {

		List<Client> clients = new ArrayList<>();
		clients.add(client1);
		clients.add(client2);
		clients.add(client3);
		when(clientService.getClientsNormal()).thenReturn((clients) );

		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/clientdata/allclients/normal"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$" ,Matchers.hasSize(3)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].nom", Matchers.is("mabong")))
		;
	}
	
	@Test
	public void getClientWithSpecificId() throws Exception {
		Optional< Client > client = Optional.of(this.client1);
		ResponseEntity<Optional<Client>> responseEntityExpected = new ResponseEntity<>(client, HttpStatus.OK);
		Long clientId = 1L;
		
		when(clientService.getClientsWithId(clientId)).thenReturn(responseEntityExpected);
		mockMvc.perform( MockMvcRequestBuilders
				.get("/api/clientdata/client/id/{id}", clientId)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.nom", Matchers.is("nkollo"))
				);
	}
}
