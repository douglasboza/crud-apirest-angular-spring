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
import Clinica.backend.model.Medico;
import Clinica.backend.repository.MedicoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class MedicoController {

	@Autowired
	private MedicoRepository medicoRepository;
	
	// get all employees
	@GetMapping("/medicos")
	public List<Medico> getAllEmployees(){
		return medicoRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/medicos")
	public Medico createEmployee(@RequestBody Medico medico) {
		return medicoRepository.save(medico);
	}
	
	// get employee by id rest api
	@GetMapping("/medicos/{id}")
	public ResponseEntity<Medico> getEmployeeById(@PathVariable Long id) {
		Medico medico = medicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Medico not exist with id :" + id));
		return ResponseEntity.ok(medico);
	}
	
	// update employee rest api
	
	@PutMapping("/medicos/{id}")
	public ResponseEntity<Medico> updateEmployee(@PathVariable Long id, @RequestBody Medico employeeDetails){
		Medico medico = medicoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medico not exist with id :" + id));
		
		medico.setPessoa(employeeDetails.getPessoa());
		medico.setCrm(employeeDetails.getCrm());
		medico.setIdade(employeeDetails.getIdade());
		
		Medico updatedEmployee = medicoRepository.save(medico);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/medicos/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Medico medico = medicoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medico not exist with id :" + id));
		
		medicoRepository.delete(medico);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
