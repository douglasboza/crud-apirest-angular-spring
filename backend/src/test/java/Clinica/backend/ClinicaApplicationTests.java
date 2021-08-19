package Clinica.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import Clinica.backend.model.Medico;
import Clinica.backend.model.Pessoa;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClinicaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ClinicaApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllMedicos() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/medicos",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetMedicoById() {
		Medico medico = restTemplate.getForObject(getRootUrl() + "/medicos/1", Medico.class);
		assertNotNull(medico);
	}

	@Test
	public void testCreateMedico() {
		Medico medico = new Medico();
		medico.setPessoa(new Pessoa("Nome"));
		medico.setCrm("crm4482814");
		medico.setIdade(20);
		medico.setId(1);

		ResponseEntity<Medico> postResponse = restTemplate.postForEntity(getRootUrl() + "/medicos", medico, Medico.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
		
//		Medico medico2 = restTemplate.getForObject(getRootUrl() + "/medicos/1", Medico.class);
//		assertEquals(medico.getPessoa().getNome(), medico2.getPessoa().getNome());
//		assertEquals(medico.getCrm(), medico2.getCrm());		
//		assertEquals(medico.getIdade(), medico2.getIdade());
	}

	@Test
	public void testUpdateMedico() {
		int id = 1;
		Medico medico = restTemplate.getForObject(getRootUrl() + "/medicos/" + id, Medico.class);
		medico.setPessoa(new Pessoa("Nome"));
		medico.setCrm("crm4482814");
		medico.setIdade(20);

		restTemplate.put(getRootUrl() + "/medicos/" + id, medico);

		Medico updatedMedico = restTemplate.getForObject(getRootUrl() + "/medicos/" + id, Medico.class);
		assertNotNull(updatedMedico);
		assertEquals(medico.getId(), updatedMedico.getId());
		assertNotEquals(medico.getPessoa().getNome(), updatedMedico.getPessoa().getNome());
	}

	@Test
	public void testDeleteMedico() {
		int id = 2;
		Medico medico = restTemplate.getForObject(getRootUrl() + "/medicos/" + id, Medico.class);
		assertNotNull(medico);

		restTemplate.delete(getRootUrl() + "/medicos/" + id);

		try {
			medico = restTemplate.getForObject(getRootUrl() + "/medicos/" + id, Medico.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}