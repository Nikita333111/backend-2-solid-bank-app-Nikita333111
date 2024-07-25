package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class Customer {
    private @Id Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    @MappedCollection(keyColumn = "CUSTOMER_ID", idColumn = "CUSTOMER_ID")
    private Set<Invoice> students;
}
