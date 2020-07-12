package dev.indra.domain.model.product;

import dev.indra.domain.enumaration.UnidadeMedidaEnum;
import dev.indra.domain.model.flag.Flag;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnidadeMedidaEnum unidadeMedida;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Flag bandeira;

    public Product() {
    }

    public Product(String nome, UnidadeMedidaEnum unidadeMedida, Flag bandeira) {
        super();
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.bandeira = bandeira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UnidadeMedidaEnum getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedidaEnum unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Flag getBandeira() {
        return bandeira;
    }

    public void setBandeira(Flag bandeira) {
        this.bandeira = bandeira;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", unidadeMedida=" + unidadeMedida +
                ", bandeira=" + bandeira +
                '}';
    }
}
