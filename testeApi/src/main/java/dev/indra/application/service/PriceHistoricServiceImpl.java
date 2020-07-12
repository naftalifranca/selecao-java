package dev.indra.application.service;

import dev.indra.domain.model.pricehistoric.PriceHistoric;
import dev.indra.domain.service.BaseService;
import dev.indra.infrastructure.persistence.hibernate.repository.PriceHistoricRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceHistoricServiceImpl implements BaseService<PriceHistoric> {

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

}
