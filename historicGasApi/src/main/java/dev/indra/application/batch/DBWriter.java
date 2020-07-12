package dev.indra.application.batch;

import dev.indra.domain.model.pricehistoric.PriceHistoric;
import dev.indra.infrastructure.persistence.hibernate.repository.PriceHistoricRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<PriceHistoric> {

    @Autowired
    private PriceHistoricRepository priceHistoricRepository;

    @Override
    public void write(List<? extends PriceHistoric> priceHistorics) throws Exception {
        priceHistoricRepository.saveAll(priceHistorics);
    }
}