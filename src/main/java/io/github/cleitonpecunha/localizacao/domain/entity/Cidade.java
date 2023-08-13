package io.github.cleitonpecunha.localizacao.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="tb_cidade")
public class Cidade {

    @Id
    @Column(name = "id_cidade")
    private Integer id;

    @Column(name = "ds_municipio", length = 100)
    private String nome;

    @Column(name = "ds_uf", length = 2)
    private String uf;

    @Column(name = "ds_regiao", length = 15)
    private String regiao;

    @Column(name = "qtd_habitantes")
    private Long habitantes;

}
