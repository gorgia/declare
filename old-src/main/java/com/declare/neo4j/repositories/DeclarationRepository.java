/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.declare.neo4j.repositories;

import com.declare.neo4j.Declaration;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.CRUDRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;


public interface DeclarationRepository extends CRUDRepository<Declaration>, RelationshipOperationsRepository<Declaration>{
    @Query("start n=node({0}) return n")
    Declaration getDeclaration(Long idDeclaration); 
    @Query("start n=node(*) return n")
    Iterable<Object> getEveryThing();
}


/**
 *
 * @author andrea
 */


    
    
