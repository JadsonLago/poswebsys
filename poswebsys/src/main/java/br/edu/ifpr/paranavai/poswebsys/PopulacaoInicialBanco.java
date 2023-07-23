package br.edu.ifpr.paranavai.poswebsys;

import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import br.edu.ifpr.paranavai.poswebsys.rh.dominio.Pessoa;
import br.edu.ifpr.paranavai.poswebsys.rh.dominio.PessoaRepositorio;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner{
	
	@Autowired
	private PessoaRepositorio pessoaRepo;
	
	@Override
	public void run (String... args) throws Exception {
		
		Pessoa p1 = new Pessoa("João");
		p1.setDataNascimento(LocalDate.of(1990, 1, 1));
		p1.setTelefone("7198657412");
		p1.setEmail("joao@gmail.com");
		p1.setCpf("95175398745");
		
		Pessoa p2 = new Pessoa("Murilo");
		p2.setDataNascimento(LocalDate.of(1993, 9, 7));
		p2.setTelefone("7198128965");
		p2.setEmail("murilo@gmail.com");
		p2.setCpf("95198745753");
		
		Pessoa p3 = new Pessoa("Antonia");
		p3.setDataNascimento(LocalDate.of(1987, 12, 10));
		p3.setTelefone("7196589812");
		p3.setEmail("a.totonha@gmail.com");
		p3.setCpf("53995178745");
		
		Pessoa p4 = new Pessoa("Araujo");
		p4.setDataNascimento(LocalDate.of(1987, 12, 10));
		p4.setTelefone("7199865812");
		p4.setEmail("ojuara@gmail.com");
		p4.setCpf("95153978745");
		
		pessoaRepo.save(p1);
		pessoaRepo.save(p2);
		pessoaRepo.save(p3);
		pessoaRepo.save(p4);

	}

}
