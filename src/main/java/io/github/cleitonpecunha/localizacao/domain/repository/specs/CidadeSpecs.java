package io.github.cleitonpecunha.localizacao.domain.repository.specs;

import io.github.cleitonpecunha.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> idEqual(Integer id) {
        return (root, query, cb) -> cb.equal(root.get("id"), id);
    }

    public static Specification<Cidade> nomeEqual(String nome) {
        return (root, query, cb) -> cb.equal(root.get("nome"), nome);
    }

    public static Specification<Cidade> nomeLike(String nome) {
        return (root, query, cb) -> cb.like( cb.upper(root.get("nome")), "%"+nome+"%".toUpperCase());
    }

    public static Specification<Cidade> ufEqual(String uf) {
        return (root, query, cb) -> cb.equal(root.get("uf"), uf);
    }

    public static Specification<Cidade> regiaoEqual(String regiao) {
        return (root, query, cb) -> cb.equal(root.get("regiao"), regiao);
    }

    public static Specification<Cidade> habitantesGreaterThan(Long value) {
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), value);
    }

    public static Specification<Cidade> habitantesBetwenn(Long mim, Long max) {
        return (root, query, cb) -> cb.between(root.get("habitantes"), mim, max);
    }



}
