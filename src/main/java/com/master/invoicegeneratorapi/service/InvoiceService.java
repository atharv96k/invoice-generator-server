package com.master.invoicegeneratorapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.master.invoicegeneratorapi.enitity.Invoice;
import com.master.invoicegeneratorapi.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceService {

	private final InvoiceRepository invoiceRepository;
	
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	public List<Invoice> fetchInvoice(){
		return invoiceRepository.findAll();
	}
	
	public void removeInvoice(String invoiceId) {
		Invoice existingInvoice =invoiceRepository.findById(invoiceId)
		.orElseThrow(() -> new RuntimeException("Invoice not found with id: " + invoiceId));
		invoiceRepository.delete(existingInvoice);
	}
}
