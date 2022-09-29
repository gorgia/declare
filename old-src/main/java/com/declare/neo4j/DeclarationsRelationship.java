/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.declare.neo4j;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.RelationshipType;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 *
 * @author andrea
 */



@RelationshipEntity
public class DeclarationsRelationship {
    @RelationshipType private String connection;
    @StartNode private Declaration previousdeclaration;
    @EndNode private Declaration followingdeclaration;

    public DeclarationsRelationship(Declaration previousdeclaration, Declaration followingdeclaration, String connection) {
        this.connection = connection;
        this.previousdeclaration = previousdeclaration;
        this.followingdeclaration = followingdeclaration;
    }
    
    
}
