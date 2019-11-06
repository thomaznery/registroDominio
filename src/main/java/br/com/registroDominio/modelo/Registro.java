package br.com.registroDominio.modelo;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name = "tb_gen_registro")
public class Registro extends PanacheEntityBase implements Serializable {

    @GeneratedValue(generator="tb_gen_registro_reg_seq")
    @SequenceGenerator(name = "registro_sequence", sequenceName = "reg_seq" ,allocationSize = 1, initialValue = 1000)
    @Id
    @Column(name = "reg_id")
    public Long regIdRegistro;

    @Column(name = "reg_cod_registro",nullable = false, unique = true)
    private String regCodRegistro;

    @Column(name = "reg_descricao", nullable = false, unique = true)
    public String regDescricao;

    @Column(name = "reg_complemento")
    private String regComplemento;

    @Column(name = "reg_usuario")
    private String regUsuario;

    @Version
    @Column(name = "reg_versao", nullable = false)
    private Date regVersao;

    @Column(name = "reg_ativo", nullable = false)
    private boolean ativo;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @JoinColumn(name = "reg_cod_dominio", nullable = false)
    private Dominio dominio;


    public Registro() {
    }

    public Long getRegIdRegistro() { return regIdRegistro; }

    public void setRegIdRegistro(Long regIdRegistro) {
        this.regIdRegistro = regIdRegistro;
    }

    public String getRegCodRegistro() { return regCodRegistro; }

    public void setRegCodRegistro(String regCodRegistro) {
        this.regCodRegistro = regCodRegistro;
    }

    public String getRegDescricao() { return regDescricao; }

    public void setRegDescricao(String regDescricao) {
        this.regDescricao = regDescricao;
    }

    public String getRegComplemento() { return regComplemento; }

    public void setRegComplemento(String regComplemento) {
        this.regComplemento = regComplemento;
    }

    public String getRegUsuario() { return regUsuario; }

    public void setRegUsuario(String regUsuario) {
        this.regUsuario = regUsuario;
    }

    public Date getRegVersao() { return regVersao; }

    public void setRegVersao(Date regVersao) {
        this.regVersao = regVersao;
    }

    public Dominio getDominio() { return dominio; }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}