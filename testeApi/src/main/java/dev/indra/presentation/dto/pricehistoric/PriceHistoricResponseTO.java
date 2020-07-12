package dev.indra.presentation.dto.pricehistoric;

import java.time.LocalDate;
import java.util.Objects;

public class PriceHistoricResponseTO {

    private Long id;

    private String regiaoSigla;

    private String uf;

    private String municipio;

    private String cnpj;

    private LocalDate dataColeta;

    private Double valorVenda;

    private Double valorCompra;

    private String unidadeMedida;

    private String bandeira;

    private String produto;

    private String nomeRevenda;

    public PriceHistoricResponseTO(Long id, String regiaoSigla, String uf, String municipio, String cnpj, LocalDate dataColeta, Double valorVenda, Double valorCompra, String unidadeMedida, String bandeira, String produto, String nomeRevenda) {
        this.id = id;
        this.regiaoSigla = regiaoSigla;
        this.uf = uf;
        this.municipio = municipio;
        this.cnpj = cnpj;
        this.dataColeta = dataColeta;
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
        this.unidadeMedida = unidadeMedida;
        this.bandeira = bandeira;
        this.produto = produto;
        this.nomeRevenda = nomeRevenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiaoSigla() {
        return regiaoSigla;
    }

    public void setRegiaoSigla(String regiaoSigla) {
        this.regiaoSigla = regiaoSigla;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getNomeRevenda() {
        return nomeRevenda;
    }

    public void setNomeRevenda(String nomeRevenda) {
        this.nomeRevenda = nomeRevenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceHistoricResponseTO that = (PriceHistoricResponseTO) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getRegiaoSigla(), that.getRegiaoSigla()) &&
                Objects.equals(getUf(), that.getUf()) &&
                Objects.equals(getMunicipio(), that.getMunicipio()) &&
                Objects.equals(getCnpj(), that.getCnpj()) &&
                Objects.equals(getDataColeta(), that.getDataColeta()) &&
                Objects.equals(getValorVenda(), that.getValorVenda()) &&
                Objects.equals(getValorCompra(), that.getValorCompra()) &&
                Objects.equals(getUnidadeMedida(), that.getUnidadeMedida()) &&
                Objects.equals(getBandeira(), that.getBandeira()) &&
                Objects.equals(getProduto(), that.getProduto()) &&
                Objects.equals(getNomeRevenda(), that.getNomeRevenda());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRegiaoSigla(), getUf(), getMunicipio(), getCnpj(), getDataColeta(), getValorVenda(), getValorCompra(), getUnidadeMedida(), getBandeira(), getProduto(), getNomeRevenda());
    }

    @Override
    public String toString() {
        return "PriceHistoricResponseTO{" +
                "id=" + id +
                ", regiaoSigla='" + regiaoSigla + '\'' +
                ", uf='" + uf + '\'' +
                ", municipio='" + municipio + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", dataColeta=" + dataColeta +
                ", valorVenda=" + valorVenda +
                ", valorCompra=" + valorCompra +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", bandeira='" + bandeira + '\'' +
                ", produto='" + produto + '\'' +
                ", nomeRevenda='" + nomeRevenda + '\'' +
                '}';
    }
}
