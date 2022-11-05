package com.nttdata.bootcamp.mscwtransaction.service;

import com.nttdata.bootcamp.mscwtransaction.model.Cwtransaction;

import reactor.core.publisher.Mono;

public interface CwtransactionService {
	Mono<Cwtransaction> saveTransaction(Mono<Cwtransaction> mobileWalletAccount);
}
