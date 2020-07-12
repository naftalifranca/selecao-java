package dev.indra.presentation.assembler;

import dev.indra.domain.model.pricehistoric.PriceHistoric;
import dev.indra.presentation.dto.pricehistoric.PriceHistoricRequestTO;
import dev.indra.presentation.dto.pricehistoric.PriceHistoricResponseTO;

import java.util.List;
import java.util.stream.Collectors;

public final class PriceHistoricAssembler {

    private PriceHistoricAssembler() {
    }
    
    public static PriceHistoric from(PriceHistoricRequestTO requestTO) {
        return new PriceHistoric(requestTO.getRegiaoSigla(), requestTO.getUf(), requestTO.getMunicipio(), requestTO.getCnpj(), requestTO.getDataColeta(), requestTO.getValorVenda(), requestTO.getValorCompra(), requestTO.getUnidadeMedida(), requestTO.getBandeira(), requestTO.getProduto(), requestTO.getNomeRevenda());
    }
    
    public static PriceHistoricResponseTO from(PriceHistoric priceHistoric) {
        return new PriceHistoricResponseTO(priceHistoric.getId(), priceHistoric.getRegiaoSigla(), priceHistoric.getUf(), priceHistoric.getMunicipio(), priceHistoric.getCnpj(), priceHistoric.getDataColeta(), priceHistoric.getValorVenda(), priceHistoric.getValorCompra(), priceHistoric.getUnidadeMedida(), priceHistoric.getBandeira(), priceHistoric.getProduto(), priceHistoric.getNomeRevenda());
    }
    
    public static List<PriceHistoricResponseTO> from(List<PriceHistoric> priceHistorics) {
        return priceHistorics.stream().map(PriceHistoricAssembler::from).collect(Collectors.toList());
    }

}
