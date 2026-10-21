package br.senac.tads.dsw.dados_pessoais.repositorio;

import br.senac.tads.dsw.dados_pessoais.entidade.ConhecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConhecimentoRepository extends JpaRepository<ConhecimentoEntity, Integer> {

	Optional<ConhecimentoEntity>findByNomeIgnoreCase(String nome);
}
