/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.declare.neo4j;

import com.declare.neo4j.repositories.DeclarationRepository;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author andrea
 */

@Configuration
@ComponentScan
@ImportResource("classpath:src/main/resources/conf/spring-data-content.xml")
@EnableTransactionManagement
public class Neo4j {

    GraphDatabaseService graphDatabaseService;
    String storeDir = System.getProperty("user.dir") + "/neo4jData";
    String pathToConfig = "src/main/resources/conf/neo4j.properties";

    @Autowired DeclarationRepository declarationRepository;

    public Neo4j() {
        /*this.graphDatabaseService = new GraphDatabaseFactory()
         .newEmbeddedDatabaseBuilder(storeDir)
         .loadPropertiesFromFile(pathToConfig)
         .newGraphDatabase();     */
    }

    public DeclarationsRelationship insertDeclaration(long idPreviousDeclaration, Declaration declarationToInsert) {
        Declaration previousDeclaration = declarationRepository.findOne(idPreviousDeclaration);

        Declaration savedDeclaration = declarationRepository.save(declarationToInsert);
        DeclarationsRelationship dr = declarationRepository
                .createRelationshipBetween(previousDeclaration, savedDeclaration, DeclarationsRelationship.class, "optional");
        return dr;
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService getGraphDatabaseService() {
        return new GraphDatabaseFactory()
                .newEmbeddedDatabaseBuilder(storeDir)
                .loadPropertiesFromFile(pathToConfig)
                .newGraphDatabase();
    }

    public DeclarationRepository getDeclarationRepository() {
        return declarationRepository;
    }
}
