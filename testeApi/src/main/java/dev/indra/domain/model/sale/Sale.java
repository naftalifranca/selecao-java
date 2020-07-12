package dev.indra.domain.model.sale;

import dev.indra.domain.enumaration.UnidadeMedidaEnum;
import dev.indra.domain.model.dealer.Dealer;
import dev.indra.domain.model.flag.Flag;
import dev.indra.domain.model.product.Product;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column(nullable = false)
    private LocalDate dataColeta;

    @Column(nullable = false, length = 6, precision = 3)
    private Double valorVenda;

    @Column(length = 6, precision = 3)
    private Double valorCompra;

    @ManyToOne
    @JoinColumn
    private Product produto;

    @ManyToOne
    @JoinColumn
    private Dealer revendedor;

    public Sale() {
    }

    public Sale(String nome, LocalDate dataColeta, Double valorCompra, Double valorVenda, Product produto, Dealer revendedor) {
        super();
        this.nome = nome;
        this.dataColeta = dataColeta;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.produto = produto;
        this.revendedor = revendedor;
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

    public Dealer getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Dealer revendedor) {
        this.revendedor = revendedor;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
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
        Sale other = (Sale) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataColeta=" + dataColeta +
                ", valorVenda=" + valorVenda +
                ", valorCompra=" + valorCompra +
                ", produto=" + produto +
                ", revendedor=" + revendedor +
                '}';
    }
}
