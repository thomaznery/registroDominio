package br.com.registroDominio.modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_gen_dominio")
public class Dominio {

    @Id
    @Column(name = "dom_codigo", unique = true, nullable = false)
    private Integer domCodigo;

    @Column(name = "dom_descricao", unique = true,nullable = false)
    public String descricao;

    @Column(name = "dom_usuario")
    private String domUsuario;

    @Column(name = "dom_versao",nullable = false)
    @Version
    private Date versao;

    @OneToMany(mappedBy = "dominio", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @OrderBy("regIdRegistro")
    private List<Registro> registros;

    public Dominio() {
    }

    public Dominio(String descricao, Date versao) {
        this.descricao = descricao;
        this.versao = versao;
    }

    public Integer getDomCodigo() {
        return domCodigo;
    }

    public void setDomCodigo(Integer domCodigo) {
        this.domCodigo = domCodigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDomUsuario() {
        return domUsuario;
    }

    public void setDomUsuario(String domUsuario) {
        this.domUsuario = domUsuario;
    }

    public Date getVersao() {
        return versao;
    }

    public void setVersao(Date versao) {
        this.versao = versao;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}