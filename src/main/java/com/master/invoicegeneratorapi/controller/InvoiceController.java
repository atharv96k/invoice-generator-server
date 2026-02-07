package com.master.invoicegeneratorapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.master.invoicegeneratorapi.enitity.Invoice;
import com.master.invoicegeneratorapi.service.InvoiceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoices")
@CrossOrigin("*")
public class InvoiceController {

	public final InvoiceService invoiceService;
	
	@PostMapping
	public ResponseEntity<Invoice> saveInvoice(Invoice invoice) {
		return ResponseEntity.ok(invoiceService.saveInvoice(invoice));
	}
}
