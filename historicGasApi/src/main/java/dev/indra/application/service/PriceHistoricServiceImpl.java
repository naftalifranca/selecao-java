package dev.indra.application.service;

import dev.indra.domain.model.pricehistoric.PriceHistoric;
import dev.indra.domain.service.PriceHistoricService;
import dev.indra.infrastructure.persistence.hibernate.repository.PriceHistoricRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceHistoricServiceImpl implements PriceHistoricService {

    private final PriceHistoricRepository repository;

    public PriceHistoricServiceImpl(final PriceHistoricRepository repository) {
        this.repository = repository;
    }

    @Override
    public PriceHistoric save(PriceHistoric entity) {

        return repository.save(entity);
    }

    @Override
    public PriceHistoric update(Long id, PriceHistoric entity) {
        PriceHistoric savedPriceHistoric = findBy(id);
        savedPriceHistoric.setRegiaoSigla(entity.getRegiaoSigla());
        savedPriceHistoric.setUf(entity.getUf());
        savedPriceHistoric.setCnpj(entity.getCnpj());
        savedPriceHistoric.setMunicipio(entity.getMunicipio());
        savedPriceHistoric.setDataColeta(entity.getDataColeta());
        savedPriceHistoric.setValorCompra(entity.getValorCompra());
        savedPriceHistoric.setValorVenda(entity.getValorVenda());
        savedPriceHistoric.setUnidadeMedida(entity.getUnidadeMedida());
        savedPriceHistoric.setBandeira(entity.getBandeira());
        savedPriceHistoric.setNomeRevenda(entity.getNomeRevenda());
        savedPriceHistoric.setProduto(entity.getProduto());
        return repository.save(savedPriceHistoric);
    }

    @Override
    public PriceHistoric findBy(Long id) {
        Optional<PriceHistoric> optUser = repository.findById(id);
        if(!optUser.isPresent()) {
            throw new RuntimeException("Histórico de preço inexistente");
        }
        return optUser.get();
    }

    @Override
    public List<PriceHistoric> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    public Page<PriceHistoric> listaPorSigla(String sigla, Pageable pageable){
    	return repository.findByRegiaoSiglaIgnoreCase(sigla, pageable);
    }

    @Override
    public Double calcularMediaPrecoVenda(String municipio) {
        return repository.calcularMediaPrecoVenda(municipio);
    }

    @Override
    public Page<PriceHistoric> listGroupByRevendedor(Pageable pageSize) {
        return repository.listGroupByRevendedor(pageSize);
    }

    @Override
    public Page<PriceHistoric> listGroupByDataColeta(Pageable pageSize) {
        return repository.listGroupByDataColeta(pageSize);
    }

    @Override
    public Double calcularMediaPrecoCompra(String municipio) {
        return repository.calcularMediaPrecoCompra(municipio);
    }

    @Override
    public Double calcularMediaPrecoVendaBandeira(String bandeira) {
        return repository.calcularMediaPrecoVendaBandeira(bandeira);
    }

    @Override
    public Double calcularMediaPrecoCompraBandeira(String bandeira) {
        return repository.calcularMediaPrecoCompraBandeira(bandeira);
    }

}