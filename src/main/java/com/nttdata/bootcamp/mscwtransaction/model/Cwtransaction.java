package com.nttdata.bootcamp.mscwtransaction.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cwtransaction {
	
	@Id
	private String id;
	private String idaccountbuyer;
	private String paymentType;  // tipo de operacion ABONO, RETIRO
	private Double amount;
	private String idaccountseller;
	
}
