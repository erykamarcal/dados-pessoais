package br.senac.tads.dsw.dados_pessoais;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;

import java.net.URI;
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
	public List<Pessoa> obterPessoas() {
		return pessoaService.obterPessoas();
	}

	@GetMapping("/{username}")

	public Pessoa obterPessoa(@PathVariable("username") String usernane) {
		Optional<Pessoa> optPessoa = pessoaService.obterPessoa(usernane);
		if (optPessoa.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optPessoa.get();
	}

	@PostMapping("/sem-validacao")
	public ResponseEntity<?> incluirNovo(@RequestBody Pessoa pessoa) {
		pessoaService.incluirNovaPessoa(pessoa);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/pessoas/{username}").buildAndExpand(pessoa.getUsername()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping
	public ResponseEntity<?> incluirNovoComValidacao(@RequestBody @Valid Pessoa pessoa) {
		pessoaService.incluirNovaPessoa(pessoa);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/pessoas/{username}").buildAndExpand(pessoa.getUsername()).toUri();

		return ResponseEntity.created(location).build();

	}
}
