package br.edu.ifpr.paranavai.poswebsys.rh.controle;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifpr.paranavai.poswebsys.rh.dominio.Pessoa;
import br.edu.ifpr.paranavai.poswebsys.rh.dominio.PessoaRepositorio;

@Controller
public class PessoaControle {
	
	private PessoaRepositorio pessoaRepo;
		
	public PessoaControle(PessoaRepositorio pessoaRepo) {
		
		this.pessoaRepo = pessoaRepo;
	}

	//Metodo para listar os registros do banco de dados.
	@GetMapping("/rh/pessoas")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas",pessoaRepo.findAll());
		return "rh/pessoas/index";
	}
	
	//Metodo para alterar registro no banco de dados.
	@GetMapping("/rh/pessoas/{id}")
	public String alterarPessoa(@PathVariable("id") long id, Model model) {
		
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
		
		if(pessoaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa Invalida.");
		}
		
		model.addAttribute("pessoa", pessoaOpt.get());
		
		return "rh/pessoas/form";
	}
	
	

	//Metodo para excluir registro no banco de dados.
	@GetMapping("/rh/pessoas/excluir/{id}")
	public String excluirPessoa(@PathVariable("id") long id) {
		
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
		
		if(pessoaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa Invalida.");
		}
		
		pessoaRepo.delete(pessoaOpt.get());
		
		return "redirect:/rh/pessoas";
	}
		

	
	//Metodo para inserir os registros no banco de dados.
	@GetMapping("/rh/pessoas/nova")
	public String novaPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
		
		return "rh/pessoas/form";
	}
	
	//Metodo para salvar os registros no banco de dados.
	@PostMapping ("/rh/pessoas/salvar")
	public String salvarPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
		pessoaRepo.save(pessoa);
		return "redirect:/rh/pessoas";
	}
	
}
