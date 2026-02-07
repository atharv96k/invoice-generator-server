package com.master.invoicegeneratorapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.master.invoicegeneratorapi.enitity.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice , String>{

}
