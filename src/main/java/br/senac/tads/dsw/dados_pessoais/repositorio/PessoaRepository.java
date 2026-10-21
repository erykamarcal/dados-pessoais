package br.senac.tads.dsw.dados_pessoais.repositorio;


import br.senac.tads.dsw.dados_pessoais.entidade.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

	Optional<PessoaEntity> findByUsername(String username);

	boolean existsByUsername(String username);



}
