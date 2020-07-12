package dev.indra.domain.service;

import dev.indra.domain.model.pricehistoric.PriceHistoric;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PriceHistoricService extends BaseService<PriceHistoric> {

	Page<PriceHistoric> listaPorSigla(String sigla, Pageable pageable);

	Double calcularMediaPrecoVenda(String municipio);

	Page<PriceHistoric> listGroupByRevendedor(Pageable pageSize);

	Page<PriceHistoric> listGroupByDataColeta(Pageable pageSize);

	Double calcularMediaPrecoCompra(String municipio);

	Double calcularMediaPrecoVendaBandeira(String bandeira);

	Double calcularMediaPrecoCompraBandeira(String bandeira);

}