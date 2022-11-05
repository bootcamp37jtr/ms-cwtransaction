package com.nttdata.bootcamp.mscwtransaction.infraestructure;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bootcamp.mscwtransaction.model.Cwtransaction;

@Repository
public interface CwtransactionRepository extends ReactiveMongoRepository<Cwtransaction, String> {

}
