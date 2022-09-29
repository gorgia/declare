/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.declare.neo4j;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;


/**
 *
 * @author andrea
 */
@Node
public class NodeConvention {
     @Id @GeneratedValue Long id;
     String name;
     
     @Relationship(direction = Relationship.Direction.OUTGOING)
     private Set<Declaration> declarations;
}
