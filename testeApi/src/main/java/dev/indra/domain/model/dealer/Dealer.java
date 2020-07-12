package dev.indra.domain.model.dealer;

import dev.indra.domain.model.county.County;
import dev.indra.domain.model.state.State;

import javax.persistence.*;

@Entity
@Table
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @ManyToOne
    @JoinColumn(nullable = false)
    private County municipio;

    public Dealer() {
    }

    public Dealer(String nome, County municipio) {
        super();
        this.nome = nome;
        this.municipio = municipio;
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

    public County getMunicipio() {
        return municipio;
    }

    public void setMunicipio(County municipio) {
        this.municipio = municipio;
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
        Dealer other = (Dealer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", municipio=" + municipio +
                '}';
    }
}
