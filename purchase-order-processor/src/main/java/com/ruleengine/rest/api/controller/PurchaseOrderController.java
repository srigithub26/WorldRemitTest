package com.ruleengine.rest.api.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ruleengine.rest.api.model.PurchaseOrder;

@RestController
public class PurchaseOrderController {

	@Autowired
	private KieSession session;

	@PostMapping("/processPurchaseOrder")
	public PurchaseOrder process(@RequestBody PurchaseOrder purchaseOrder) {
		session.insert(purchaseOrder);
		session.fireAllRules();
		return purchaseOrder;
	}
}
