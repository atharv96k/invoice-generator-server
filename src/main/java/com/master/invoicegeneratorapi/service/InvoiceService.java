package com.master.invoicegeneratorapi.service;

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
}
