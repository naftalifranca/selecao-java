package dev.indra.infrastructure.persistence.hibernate.repository;

import dev.indra.domain.model.pricehistoric.PriceHistoric;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceHistoricRepository extends JpaRepository<PriceHistoric, Long> {

	@Query("select AVG(h.valorVenda) from PriceHistoric h where h.municipio = UPPER(:municipio)")
	Double calcularMediaPrecoVenda(@Param("municipio") String municipio);

	Page<PriceHistoric> findByRegiaoSiglaIgnoreCase(String regiaoSigla, Pageable pageSize);

	@Query("select h from PriceHistoric h group by h.id, h.nomeRevenda")
	Page<PriceHistoric> listGroupByRevendedor(Pageable pageSize);

	@Query("select h from PriceHistoric h group by h.id, h.dataColeta")
	Page<PriceHistoric> listGroupByDataColeta(Pageable pageSize);

	@Query("select AVG(h.valorCompra) from PriceHistoric h where h.municipio = UPPER(:municipio)")
	Double calcularMediaPrecoCompra(@Param("municipio") String municipio);

	@Query("select AVG(h.valorVenda) from PriceHistoric h where h.bandeira = UPPER(:bandeira)")
	Double calcularMediaPrecoVendaBandeira(@Param("bandeira") String bandeira);

	@Query("select AVG(h.valorCompra) from PriceHistoric h where h.bandeira = UPPER(:bandeira)")
	Double calcularMediaPrecoCompraBandeira(@Param("bandeira") String bandeira);

}