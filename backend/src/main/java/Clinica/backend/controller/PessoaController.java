package Clinica.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Clinica.backend.exception.ResourceNotFoundException;
import Clinica.backend.model.Pessoa;
import Clinica.backend.repository.PessoaRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	// get all employees
	@GetMapping("/pessoas")
	public List<Pessoa> getAllEmployees(){
		return pessoaRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/pessoas")
	public Pessoa createEmployee(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	// get employee by id rest api
	@GetMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> getEmployeeById(@PathVariable Long id) {
		Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pessoa not exist with id :" + id));
		return ResponseEntity.ok(pessoa);
	}
	
	// update employee rest api
	
	@PutMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> updateEmployee(@PathVariable Long id, @RequestBody Pessoa pessoaDetails){
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pessoa not exist with id :" + id));
		
		pessoa.setNome(pessoaDetails.getNome());
		
		Pessoa updatedPessoa = pessoaRepository.save(pessoa);
		return ResponseEntity.ok(updatedPessoa);
	}
	
	// delete employee rest api
	@DeleteMapping("/pessoas/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pessoa not exist with id :" + id));
		
		pessoaRepository.delete(pessoa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
