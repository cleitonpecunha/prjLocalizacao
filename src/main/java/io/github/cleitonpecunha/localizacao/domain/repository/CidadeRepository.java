package io.github.cleitonpecunha.localizacao.domain.repository;

import io.github.cleitonpecunha.localizacao.domain.entity.Cidade;
import io.github.cleitonpecunha.localizacao.domain.repository.projections.CidadeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>, JpaSpecificationExecutor<Cidade> {

    List<Cidade> findAll(Sort sort);

    List<Cidade> findByNome(String nome);

    List<Cidade> findByNomeStartingWith(String nome);

    List<Cidade> findByNomeEndingWith(String nome);

    List<Cidade> findByNomeContaining(String nome);

    @Query("select c from Cidade c where lower(c.nome) like lower(?1)")
    List<Cidade> findByNomeLike(String nome);

    @Query("select c from Cidade c where lower(c.regiao) like lower(?1)")
    List<Cidade> findByRegiaoLike(String regiao);


    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes);


    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome, Sort sort);


    Page<Cidade> findByHabitantesLessThan(Long habitantes, Pageable pageable);


    Page<Cidade> findByHabitantesGreaterThan(Long habitantes, Pageable pageable);


    @Query(nativeQuery = true, value = "select id_cidade as id, ds_municipio as nome from tb_cidade as c where c.ds_municipio =:nome")
    List<CidadeProjection> findByNomeSqlNativo(@Param("nome") String nome);

}
