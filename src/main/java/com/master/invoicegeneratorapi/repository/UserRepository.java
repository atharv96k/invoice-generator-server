package com.master.invoicegeneratorapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.master.invoicegeneratorapi.entity.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByClerkId(String clerkId);

    boolean existsByClerkId(String clerkId);
}
