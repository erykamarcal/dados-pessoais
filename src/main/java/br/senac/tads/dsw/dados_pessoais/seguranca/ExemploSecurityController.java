package br.senac.tads.dsw.dados_pessoais.seguranca;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploSecurityController {
	private final UserDetailsService userDetailsService;

	public ExemploSecurityController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@GetMapping("/me")
	public UsuarioSistema obterDadosUsuarioLogado(Authentication auth){
		String username = (String) auth.getPrincipal();
		return (UsuarioSistema) userDetailsService.loadUserByUsername(username);
	}
}

