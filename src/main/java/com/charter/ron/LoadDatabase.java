package com.charter.ron;

import com.charter.ron.model.Purchase;
import com.charter.ron.repository.PurchaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PurchaseRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Purchase(1L,LocalDate.now(),new BigDecimal("144.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(2L,LocalDate.now().minusMonths(1L),new BigDecimal("50.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(3L,LocalDate.now().minusMonths(2L),new BigDecimal("100.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(4L,LocalDate.now().minusMonths(3L),new BigDecimal("150.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(5L,LocalDate.now().minusMonths(4L),new BigDecimal("250.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(6L,LocalDate.now().minusMonths(5L),new BigDecimal("350.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(7L,LocalDate.now().minusMonths(6L),new BigDecimal("60.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(8L,LocalDate.now().minusMonths(7L),new BigDecimal("125.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(9L,LocalDate.now().minusMonths(8L),new BigDecimal("40.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(10L,LocalDate.now().minusMonths(9L),new BigDecimal("175.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(11L,LocalDate.now().minusMonths(10L),new BigDecimal("225.00"),10L)));
            log.info("Preloading " + repository.save(new Purchase(12L,LocalDate.now().minusMonths(11L),new BigDecimal("105.00"),10L)));

        };
    }
}
