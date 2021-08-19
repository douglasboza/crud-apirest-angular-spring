package Clinica.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

	@Column(name = "crm")
}


Nome do Paciente
● Especialidade Médica
● Nome do Médico
● CRM do Médico
● Data/Hora
● Nº Consultório