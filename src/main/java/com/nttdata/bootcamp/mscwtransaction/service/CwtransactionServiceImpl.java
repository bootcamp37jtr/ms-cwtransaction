package com.nttdata.bootcamp.mscwtransaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.mscwtransaction.infraestructure.CwtransactionRepository;
import com.nttdata.bootcamp.mscwtransaction.model.Cwtransaction;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CwtransactionServiceImpl implements  CwtransactionService {
	
	@Autowired
	CwtransactionRepository mobileWalletOperationRepository;
	
	@Override
	public Mono<Cwtransaction> saveTransaction(Mono<Cwtransaction> MobileWalletOperation) {
		log.debug("dato",MobileWalletOperation);
		return MobileWalletOperation.flatMap(mwo ->{
			if(mwo.getAmount() == null) {
				mwo.setAmount(0d);
			}
			return mobileWalletOperationRepository.save(mwo);
		});
	}

}
