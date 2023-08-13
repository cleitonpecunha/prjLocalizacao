package io.github.cleitonpecunha.localizacao.service;

import ch.qos.logback.core.net.server.Client;
import io.github.cleitonpecunha.localizacao.domain.entity.Cidade;
import io.github.cleitonpecunha.localizacao.domain.repository.CidadeRepository;
import static io.github.cleitonpecunha.localizacao.domain.repository.specs.CidadeSpecs.*;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {

        this.repository = repository;
    }

    @Transactional
    /*public void salvarCidade(){
        var cidade1 = new Cidade(1,"São Paulo",14000000L);
        repository.save(cidade1);
        var cidade2 = new Cidade(2,"Rio de Janeiro",12000000L);
        repository.save(cidade2);
        var cidade3 = new Cidade(3,"Belo Horizonte",10000000L);
        repository.save(cidade3);
        var cidade4 = new Cidade(4,"Fortaleza",8000000L);
        repository.save(cidade4);
        var cidade5 = new Cidade(5,"Salvador",7000000L);
        repository.save(cidade5);
        var cidade6 = new Cidade(6,"Aracajú",6000000L);
        repository.save(cidade6);
        var cidade7 = new Cidade(7,"Recife",5000000L);
        repository.save(cidade7);
        var cidade8 = new Cidade(8,"Natal",4000000L);
        repository.save(cidade8);
        var cidade9 = new Cidade(9,"Porto Alegre",3000000L);
        repository.save(cidade9);
        var cidade10 = new Cidade(10,"São Luiz",2000000L);
        repository.save(cidade10);
        var cidade11 = new Cidade(11,"Piau",1000000L);
        repository.save(cidade11);
        var cidade12 = new Cidade(12,"Curitiba",null);
        repository.save(cidade12);
        var cidade13 = new Cidade(13,"Vitória",null);
        repository.save(cidade13);
    }*/

    public void ListarCidadeOrdenadaPorNome() {
        repository.findAll(Sort.by("nome")).forEach(System.out::println);
    }

    public void ListarCidadeOrdenadaPorHabitante() {
        repository.findAll(Sort.by("habitantes")).forEach(System.out::println);
    }

    public void ListarCidadeOrdenadaPorRegiao() {
        repository.findAll(Sort.by("regiao","nome")).forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase("nome","uf","regiao")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return repository.findAll(example);
    }

    public void listarCidadesPorNome(){
        repository.findByNome("São Paulo")
                .forEach(System.out::println);
    }

    public void listarCidadesPorNomeQueComeca(){
        repository.findByNomeStartingWith("S")
                .forEach(System.out::println);
    }

    public void listarCidadesPorNomeQueTermina(){
        repository.findByNomeEndingWith("a")
                .forEach(System.out::println);
    }

    public void listarCidadesPorNomeQueContem(){
        repository.findByNomeContaining("São")
                .forEach(System.out::println);
    }

    public void listarCidadesPorNomeLike(){
        repository.findByNomeLike("%são%")
                .forEach(System.out::println);
    }

    public void listarCidadesPorRegiaoLike(){
        repository.findByRegiaoLike("%su%")
                .forEach(System.out::println);
    }

    public void ListarCidadeHabitanteMenorQue() {
        repository.findByHabitantesLessThan(1000000L).forEach(System.out::println);
    }

    public void ListarCidadeHabitanteMenorIgualQue() {
        repository.findByHabitantesLessThanEqual(1000000L).forEach(System.out::println);
    }

    public void ListarCidadeHabitanteMaiorQue() {
        repository.findByHabitantesGreaterThan(1000000L).forEach(System.out::println);
    }

    public void ListarCidadeHabitanteMaiorIgualQue() {
        repository.findByHabitantesGreaterThanEqual(1000000L).forEach(System.out::println);
    }

    public void ListarCidadeHabitanteMenorQueNomeLikeSort() {
        repository.findByHabitantesLessThanAndNomeLike(8000000L,"%a%", Sort.by("habitantes")).forEach(System.out::println);
    }

    public void ListarCidadeHabitanteMenorQuePaginado() {
        Pageable pageable = PageRequest.of(0,10);
        repository.findByHabitantesLessThan(5000000L, pageable).forEach(System.out::println);
    }

    public void ListarCidadeHabitanteMaiorQuePaginado() {
        Pageable pageable = PageRequest.of(0,10);
        repository.findByHabitantesGreaterThan(5000000L, pageable).forEach(System.out::println);
    }

    public void ListarCidadeByNomeSpec() {
        Specification<Cidade> spec = nomeEqual("São Paulo").and(habitantesGreaterThan(5000000L));
        repository.findAll(spec).forEach(System.out::println);
    }

    public void ListarCidadeFiltroDinamicoSpec(Cidade filtro) {

        Specification<Cidade> specs = Specification.where(((root, query, cb) -> cb.conjunction()));

        if(filtro.getId() != null) {
            specs = specs.and( idEqual(filtro.getId()) );
        }

        if(StringUtils.hasText(filtro.getNome())) {
            specs = specs.and(nomeLike(filtro.getNome()));
        }

        if(StringUtils.hasText(filtro.getUf())) {
            specs = specs.and(ufEqual(filtro.getUf()));
        }

        if(StringUtils.hasText(filtro.getRegiao())) {
            specs = specs.and(regiaoEqual(filtro.getRegiao()));
        }

        if(filtro.getHabitantes() != null) {
            specs = specs.and( habitantesGreaterThan(filtro.getHabitantes()) );
        }

        repository.findAll(specs).forEach(System.out::println);
    }

    public void listarCidadesPorNomeSqlNativo(){
        repository.findByNomeSqlNativo("São Paulo")
                .stream().map(cidadeProjection ->
                        new Cidade(cidadeProjection.getId(), cidadeProjection.getNome(),null,null,null))
                .forEach(System.out::println);
    }

}
