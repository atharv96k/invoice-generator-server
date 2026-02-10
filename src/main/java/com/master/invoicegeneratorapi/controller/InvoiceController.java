package com.master.invoicegeneratorapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
		return ResponseEntity.ok(invoiceService.saveInvoice(invoice));
	}
	
	@GetMapping
	public ResponseEntity<List<Invoice>> fetchInvoice() {
		return ResponseEntity.ok(invoiceService.fetchInvoice());
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeInvoice(@PathVariable String id) {
		invoiceService.removeInvoice(id);
		return ResponseEntity.noContent().build();
	}
}
