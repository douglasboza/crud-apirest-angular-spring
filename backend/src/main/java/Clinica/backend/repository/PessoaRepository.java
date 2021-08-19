package Clinica.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Clinica.backend.model.Medico;
import Clinica.backend.model.Pessoa;



@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
