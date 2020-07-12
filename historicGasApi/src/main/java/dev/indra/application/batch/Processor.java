package dev.indra.application.batch;

import dev.indra.domain.model.pricehistoric.PriceHistoric;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<PriceHistoric, PriceHistoric> {


    public Processor() {

    }

    @Override
    public PriceHistoric process(PriceHistoric priceHistoric) throws Exception {
        return priceHistoric;
    }
}