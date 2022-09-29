/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.declare.neo4j;

import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;



@NodeEntity
public class Declaration {
    @GraphId Long id;
    
    Integer level;
    String suit;
    
    
    
    String notes;
        
    Integer numberOfSpades;
    Integer numberOfDiamonds;
    Integer numberOfHearts;
    Integer numberOfClubs;
    
    Integer HCPoints;
    Integer distributionPoints;
    
    
    @RelatedToVia (direction = Direction.INCOMING)
    private Set<NodeSystem> systems;
    
    @RelatedToVia(direction = Direction.INCOMING)
    private Set<Declaration> previousDeclarations;
    
    @RelatedToVia(direction = Direction.OUTGOING)
    private Set<Declaration> followingDeclarations;
       
    
    
}
