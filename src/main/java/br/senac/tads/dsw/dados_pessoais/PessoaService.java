package br.senac.tads.dsw.dados_pessoais;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

	List<PessoaDto> obterPessoas();
	Optional<PessoaDto> obterPessoa (String username);
	PessoaDto incluirNovaPessoa(PessoaDto pessoa);
	PessoaDto alterarPessoa(String username, PessoaAlteracaoDto pessoaAlteracao);

	void removerPessoa(String username);

	@Transactional(readOnly = true)
	List<PessoaDto> buscarPessoas(String termo);
}
