package com.nttdata.bootcamp.mscwtransaction;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.nttdata.bootcamp.mscwtransaction.application.CwtransactionController;
import com.nttdata.bootcamp.mscwtransaction.model.Cwtransaction;
import com.nttdata.bootcamp.mscwtransaction.producer.BalanceProducer;
import com.nttdata.bootcamp.mscwtransaction.service.CwtransactionService;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@WebFluxTest(CwtransactionController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
class MsCwtransactionApplicationTests {
	
	
	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	CwtransactionService cwtransactionService;
	
	@MockBean
	private BalanceProducer balanceProducer;

	//@Test
	void saveTransactionTest() {
		/**
		Mono<Cwtransaction> cwtransaction = Mono.just(new Cwtransaction("4444", "4565456", "JUAN",10.0,"E"));
		when(cwtransactionService.saveTransaction(cwtransaction)).thenReturn(mockReturn());
		doNothing().when(balanceProducer).sendMessage(new Cwtransaction("4444", "4565456", "JUAN",10.0,"E"));
		webTestClient.post().uri("/cwtransaction")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)
		.body(Mono.just(cwtransaction), Cwtransaction.class)
		.exchange()
		.expectStatus().isCreated();
		*/
	}
	
	private static Mono<Cwtransaction>  mockReturn() {
	    return Mono.just(new Cwtransaction("4444", "4565456", "JUAN",10.0,"E"));
	}

}
