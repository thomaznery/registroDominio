package br.com.registroDominio.modelo;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name = "tb_registro")
public class Registro extends PanacheEntityBase implements Serializable {

    @GeneratedValue(generator="tb_gen_registro_reg_seq")
    @SequenceGenerator(name = "registro_sequence", sequenceName = "reg_seq" ,allocationSize = 1, initialValue = 1000)
    @Id
    @Column(name = "reg_id")
    Long regId;

    @Column(name = "reg_cod_registro",nullable = false, unique = true)
    @KeywordField(name = "regCodigo_sort", sortable = Sortable.YES, normalizer = "sort")
    String regCodigo;

    @Column(name = "reg_descricao", nullable = false, unique = true)
    String regDescricao;

    @Column(name = "reg_complemento")
    String regComplemento;

    @Column(name = "reg_usuario")
    String regUsuario;

    @Version
    @Column(name = "reg_versao", nullable = false)
    Date regVersao;

    @Column(name = "reg_ativo", nullable = false)
    boolean ativo;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @JoinColumn(name = "reg_cod_dominio", nullable = false)
    Dominio dominio;

    public Registro() {
    }

}
