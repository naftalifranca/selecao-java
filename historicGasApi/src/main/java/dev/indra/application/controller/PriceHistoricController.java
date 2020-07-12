package dev.indra.application.controller;

import dev.indra.domain.model.pricehistoric.PriceHistoric;
import dev.indra.domain.service.PriceHistoricService;
import dev.indra.infrastructure.service.ResponseService;
import dev.indra.presentation.assembler.PriceHistoricAssembler;
import dev.indra.presentation.dto.pricehistoric.PriceHistoricRequestTO;
import dev.indra.presentation.dto.pricehistoric.PriceHistoricResponseTO;
import dev.indra.presentation.dto.shared.ResponseTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/pricehistorics")
public class PriceHistoricController {

    private final PriceHistoricService service;

    private final ResponseService responseService;

    public PriceHistoricController(final PriceHistoricService service, final ResponseService responseService) {
        this.service = service;
        this.responseService = responseService;
    }

    @ApiOperation(value = "Busca um histórico de preço pelo id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTO<PriceHistoricResponseTO>> find(@PathVariable Long id) {
        return responseService.ok(PriceHistoricAssembler.from(service.findBy(id)));
    }

    @ApiOperation(value = "Busca todo os históricos de preço")
    @GetMapping
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
    @PutMapping("/{id}")
    public ResponseEntity<ResponseTO<PriceHistoricResponseTO>> update(@PathVariable Long id,
            @RequestBody PriceHistoricRequestTO requestTO) {
        PriceHistoric priceHistoric = PriceHistoricAssembler.from(requestTO);
        return responseService.ok(PriceHistoricAssembler.from(service.update(id, priceHistoric)));
    }

    @ApiOperation(value = "Remove histórico de preço pelo id")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @ApiOperation(value = "Calcula média de preço de venda de combustível por município")
    @GetMapping("mediaPrecoVendaByMunicipio/{municipio}")
    public ResponseEntity<ResponseTO<Double>> calcularMediaPrecoVenda(@RequestParam(value="municipio") String municipio) {
        return responseService.ok(service.calcularMediaPrecoVenda(municipio));
    }

    @ApiOperation(value = "Traz os históricos de preço de combustível por sigla da região")
    @GetMapping(value = "regiaoSigla/{regiaoSigla}")
    public Page<PriceHistoric> listByRegiaoSigla(
            @RequestParam("regiaoSigla") String regiaoSigla,
            Pageable pageable) {
        return service.listaPorSigla(regiaoSigla, pageable);
    }

    @ApiOperation(value = "Traz os históricos de preço de combustível agrupado por revendedor")
    @GetMapping(value = "nomeRevenda")
    public Page<PriceHistoric> listGroupByRevendedor(Pageable pageable) {
        return service.listGroupByRevendedor(pageable);
    }

    @ApiOperation(value = "Traz os históricos de preço de combustível agrupado por data de coleta")
    @GetMapping(value = "dataColeta")
    public Page<PriceHistoric> listGroupByDataColeta(Pageable pageable) {
        return service.listGroupByDataColeta(pageable);
    }

    @ApiOperation(value = "Calcula média de preço de venda e compra de combustível por município")
    @GetMapping("mediaPrecoCompraVendaMunicipio/{municipio}")
    public ResponseEntity<ResponseTO<HashMap<String, Double>>> calcularMediaPrecoCompraVenda(@RequestParam(value="municipio") String municipio) {
        HashMap<String, Double> map = new HashMap<>();
        map.put("MediaVenda", service.calcularMediaPrecoVenda(municipio));
        map.put("MediaCompra", service.calcularMediaPrecoCompra(municipio));
        return responseService.ok(map);
    }

    @ApiOperation(value = "Calcula média de preço de venda e compra de combustível por bandeira")
    @GetMapping("mediaPrecoCompraVendaBandeira/{bandeira}")
    public ResponseEntity<ResponseTO<HashMap<String, Double>>> calcularMediaPrecoCompraVendaBandeira(@RequestParam(value="bandeira") String bandeira) {
        HashMap<String, Double> map = new HashMap<>();
        map.put("MediaVenda", service.calcularMediaPrecoVendaBandeira(bandeira));
        map.put("MediaCompra", service.calcularMediaPrecoCompraBandeira(bandeira));
        return responseService.ok(map);
    }

}