package com.nttdata.bootcamp.mscwtransaction.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.mscwtransaction.model.Cwtransaction;
import com.nttdata.bootcamp.mscwtransaction.producer.BalanceProducer;
import com.nttdata.bootcamp.mscwtransaction.service.CwtransactionService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/cwtransaction")
@RefreshScope
public class CwtransactionController {
	
	@Autowired
	CwtransactionService mobileWalletOperationService;
	
	@Autowired
	private BalanceProducer balanceProducer;
	
	@Value("${message.demo}")
	private String demoString;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Cwtransaction> crear(@RequestBody Cwtransaction mobileWalletOperation) {
		log.info(demoString);
		return mobileWalletOperationService.saveTransaction(Mono.just(mobileWalletOperation))
					.map(this::sendOperation)
		.map(pro->mobileWalletOperation);
	}
	
	
	private Cwtransaction sendOperation(Cwtransaction operation) {
		log.debug("sendOperation executed {}", operation);
		if (operation != null) {
			balanceProducer.sendMessage(operation);
		}
		return operation;
	}
	
	
	
	
}
