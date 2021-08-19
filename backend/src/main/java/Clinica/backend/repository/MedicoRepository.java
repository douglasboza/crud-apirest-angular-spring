package Clinica.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Clinica.backend.model.Medico;



@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
