package com.my.bookstore_backend.repository;

import com.my.bookstore_backend.entity.Tag;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public interface TagRepository extends Neo4jRepository<Tag, Long> {

    @Query("MATCH (t:Tag {name: $tagName})-[:relative*1..2]->(related:Tag) " + "RETURN collect(related.name) AS names")
    List<Object> findRelatedTags(String tagName);
}
