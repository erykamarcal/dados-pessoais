package br.senac.tads.dsw.dados_pessoais;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")

public class PessoaController {

	private final PessoaService pessoaService;


	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@GetMapping
	public List<Pessoa> obterPessoas(){
		return pessoaService.obterPessoas();
	}

	@GetMapping ("/{username}")

	public Pessoa obterPessoa(@PathVariable ("username") String usernane) {
		Optional<Pessoa> optPessoa = pessoaService.obterPessoa(usernane);
		if (optPessoa.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optPessoa.get();
	}

}
