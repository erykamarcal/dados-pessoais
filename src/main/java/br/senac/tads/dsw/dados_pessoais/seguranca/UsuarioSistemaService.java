package br.senac.tads.dsw.dados_pessoais.seguranca;

import br.senac.tads.dsw.dados_pessoais.entidade.RoleEntity;
import br.senac.tads.dsw.dados_pessoais.entidade.UsuarioSistemaEntity;
import br.senac.tads.dsw.dados_pessoais.repositorio.UsuarioSistemaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioSistemaService implements UserDetailsService {

	private final UsuarioSistemaRepository usuarioSistemaRepository;

	public UsuarioSistemaService(UsuarioSistemaRepository usuarioSistemaRepository) {
		this.usuarioSistemaRepository = usuarioSistemaRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException {

		UsuarioSistemaEntity entidade = usuarioSistemaRepository.findByUsername(username)
			.orElseThrow(() -> new UsernameNotFoundException(
				"Usuário não encontrado: " + username));

		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role : entidade.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getNome()));
		}

		return new UsuarioSistema(
			entidade.getUsername(),
			entidade.getSenha(),
			authorities
		);
	}
}
