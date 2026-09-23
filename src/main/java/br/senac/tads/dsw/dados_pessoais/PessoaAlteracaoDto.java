package br.senac.tads.dsw.dados_pessoais;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public class PessoaAlteracaoDto {

	@NotBlank(message = "O nome completo é obrigatório!")
	@Size(max = 100)
	private String nome;

	@NotBlank
	@Size(max = 100)
	@Email
	private String email;

	@Size(max = 20)
	private String telefone;

	@NotNull
	@PastOrPresent
	private LocalDate dataNascimento;

	private List<String> conhecimentos;

	public @NotBlank(message = "O nome completo é obrigatório!") @Size(max = 100) String getNome() {
		return nome;
	}

	public void setNome(@NotBlank(message = "O nome completo é obrigatório!") @Size(max = 100) String nome) {
		this.nome = nome;
	}

	public @NotBlank @Size(max = 100) @Email String getEmail() {
		return email;
	}

	public void setEmail(@NotBlank @Size(max = 100) @Email String email) {
		this.email = email;
	}

	public @NotBlank @Size(max = 20) String getTelefone() {
		return telefone;
	}

	public void setTelefone(@NotBlank @Size(max = 20) String telefone) {
		this.telefone = telefone;
	}

	public @NotNull @PastOrPresent LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(@NotNull @PastOrPresent LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<String> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<String> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}
}
