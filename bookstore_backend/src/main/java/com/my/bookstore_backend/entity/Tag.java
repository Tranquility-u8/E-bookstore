package com.my.bookstore_backend.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.repository.Neo4jRepository;

@Node
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}

