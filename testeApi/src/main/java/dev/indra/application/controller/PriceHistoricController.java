package dev.indra.application.controller;

import dev.indra.domain.model.pricehistoric.PriceHistoric;
import dev.indra.domain.service.BaseService;
import dev.indra.infrastructure.persistence.hibernate.repository.PriceHistoricRepository;
import dev.indra.infrastructure.service.ResponseService;
import dev.indra.presentation.assembler.PriceHistoricAssembler;
import dev.indra.presentation.dto.pricehistoric.PriceHistoricRequestTO;
import dev.indra.presentation.dto.pricehistoric.PriceHistoricResponseTO;
import dev.indra.presentation.dto.shared.ResponseTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/pricehistorics")
public class PriceHistoricController {

    private final BaseService<PriceHistoric> service;

    private final ResponseService responseService;

    @Autowired
    private final PriceHistoricRepository priceHistoricRepository;

    public PriceHistoricController(final BaseService<PriceHistoric> service, final ResponseService responseService, PriceHistoricRepository priceHistoricRepository) {
        this.service = service;
        this.responseService = responseService;
        this.priceHistoricRepository = priceHistoricRepository;
    }

    @ApiOperation(value = "Busca um histórico de preço pelo id")
    @GetMapping("find/{id}")
    public ResponseEntity<ResponseTO<PriceHistoricResponseTO>> find(@PathVariable Long id) {
        return responseService.ok(PriceHistoricAssembler.from(service.findBy(id)));
    }

    @ApiOperation(value = "Busca todo os históricos de preço")
    @GetMapping(value = "findAll")
    public ResponseEntity<ResponseTO<List<PriceHistoricResponseTO>>> findAll() {
        return responseService.ok(PriceHistoricAssembler.from(service.findAll()));
    }

    @ApiOperation(value = "Cria histórico de preço")
    @PostMapping(value = "save")
    public ResponseEntity<ResponseTO<PriceHistoricResponseTO>> save(@RequestBody PriceHistoricRequestTO requestTO) {
        PriceHistoric priceHistoric = PriceHistoricAssembler.from(requestTO);
        return responseService.ok(PriceHistoricAssembler.from(service.save(priceHistoric)));
    }

    @ApiOperation(value = "Atualiza histórico de preço passando o id e o objeto")
    @PutMapping("update/{id}")
    public ResponseEntity<ResponseTO<PriceHistoricResponseTO>> update(@PathVariable Long id,
            @RequestBody PriceHistoricRequestTO requestTO) {
        PriceHistoric priceHistoric = PriceHistoricAssembler.from(requestTO);
        return responseService.ok(PriceHistoricAssembler.from(service.update(id, priceHistoric)));
    }

    @ApiOperation(value = "Remove histórico de preço pelo id")
    @DeleteMapping("delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @ApiOperation(value = "Calcula média de preço de venda de combustível por município")
    @GetMapping("mediaPrecoVendaByMunicipio/{municipio}")
    public ResponseEntity<ResponseTO<Double>> calcularMediaPrecoVenda(@RequestParam(value="municipio") String municipio) {
        return responseService.ok(priceHistoricRepository.calcularMediaPrecoVenda(municipio));
    }

    @ApiOperation(value = "Traz os históricos de preço de combustível por sigla da região")
    @GetMapping(value = "findByRegiaoSigla/{regiaoSigla}")
    public Page<PriceHistoric> listByRegiaoSigla(
            @RequestParam("regiaoSigla") String regiaoSigla,
            @RequestParam(
                    value = "page",
                    required = true,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = true,
                    defaultValue = "20") int size) {
            PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "regiaoSigla");
        return priceHistoricRepository.listByRegiaoSigla(regiaoSigla, pageRequest);
    }

    @ApiOperation(value = "Traz os históricos de preço de combustível agrupado por revendedor")
    @GetMapping(value = "findGroupByRevendedor")
    public Page<PriceHistoric> listGroupByRevendedor(
            @RequestParam(
                    value = "page",
                    required = true,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = true,
                    defaultValue = "20") int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "nomeRevenda");
        return priceHistoricRepository.listGroupByRevendedor(pageRequest);
    }

    @ApiOperation(value = "Traz os históricos de preço de combustível agrupado por data de coleta")
    @GetMapping(value = "findGroupByDataColeta")
    public Page<PriceHistoric> listGroupByDataColeta(
            @RequestParam(
                    value = "page",
                    required = true,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = true,
                    defaultValue = "20") int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size);
        return priceHistoricRepository.listGroupByDataColeta(pageRequest);
    }

    @ApiOperation(value = "Calcula média de preço de venda e compra de combustível por município")
    @GetMapping("mediaPrecoCompraVendaByMunicipio/{municipio}")
    public ResponseEntity<ResponseTO<HashMap<String, Double>>> calcularMediaPrecosCompraVenda(@RequestParam(value="municipio") String municipio) {
        HashMap<String, Double> map = new HashMap<>();
        map.put("MediaVenda", priceHistoricRepository.calcularMediaPrecoVenda(municipio));
        map.put("MediaCompra", priceHistoricRepository.calcularMediaPrecoCompra(municipio));
        return responseService.ok(map);
    }

    @ApiOperation(value = "Calcula média de preço de venda e compra de combustível por bandeira")
    @GetMapping("mediaPrecoCompraVendaByBandeira/{bandeira}")
    public ResponseEntity<ResponseTO<HashMap<String, Double>>> calcularMediaPrecosCompraVendaBandeira(@RequestParam(value="bandeira") String bandeira) {
        HashMap<String, Double> map = new HashMap<>();
        map.put("MediaVenda", priceHistoricRepository.calcularMediaPrecoVendaBandeira(bandeira));
        map.put("MediaCompra", priceHistoricRepository.calcularMediaPrecoCompraBandeira(bandeira));
        return responseService.ok(map);
    }

}
