package Clinica.backend.services;

import Clinica.backend.model.Consulta;
import Clinica.backend.model.Consultorio;
import Clinica.backend.model.Medico;
import Clinica.backend.model.Paciente;
import net.bytebuddy.asm.Advice.Return;

public class ConsultaService {
	
	
	/** Método que gera um consulta com base nos parâmetros
	 * 
	 * @Return Consulta
	*/ 
	public Consulta gerarConsulta(Paciente paciente, Medico medico, Consultorio consultorio) {
		
		return null;
	}
	
	
	
//	O intervalo das consultas no mesmo consultório, deve respeitar um tempo mínimo de 15
//	minutos.
//	● O mesmo paciente não pode marcar duas consultas no mesmo dia.
//	● Um médico deve atender todas as consultas do dia, no mesmo consultório.
//	● Para evitar problemas, as consultas devem se limitar a no máximo 12 por dia num mesmo
//	consultório
//	● O fluxo de cadastro deve permitir que se forneça o mesmo consultório, para 2 médicos
//	diferentes, apenas se a consulta for da especialidade "Cirurgião". Para as demais consultas,
//	não se deve permitir a utilização do consultório por dois médicos, no mesmo horário
//	● Para situações de erro, é necessário que a resposta da requisição seja coerente em exibir
//	uma mensagem condizente com o erro
	
	
//	Nome do Paciente
//	● Especialidade Médica
//	● Nome do Médico
//	● CRM do Médico
//	● Data/Hora
//	● Nº Consultório
//	
//	
	
}
