package br.com.registroDominio.modelo;

import com.google.gson.Gson;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_dominio")
public class Dominio extends PanacheEntityBase implements Serializable{

    @Id
    @Column(name = "dom_codigo", unique = true, nullable = false)
    Integer domCodigo;

    @Column(name = "dom_descricao", unique = true,nullable = false)
    String descricao;

    @Column(name = "dom_usuario")
    String usuario;

    @Column(name = "dom_versao",nullable = false)
    @Version
    Date versao;

    @OneToMany(mappedBy = "dominio", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @OrderBy("regIdRegistro")
    List<Registro> registros;

    public Dominio() {
    }

}
