package dev.indra.presentation.dto.pricehistoric;

import java.time.LocalDate;

public class PriceHistoricRequestTO {

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

    public PriceHistoricRequestTO() {
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
    public String toString() {
        return "PriceHistoricRequestTO{" +
                "regiaoSigla='" + regiaoSigla + '\'' +
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
