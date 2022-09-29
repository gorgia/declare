/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function createGraph() {
    var graph = new neo4j.GraphDatabase("http://localhost:7474");

    var lisaPromise = graph.node({"name": "Lisa"});
    var bobPromise = graph.node({"name": "Bob"});

    var lovePromise = graph.rel(lisaPromise, "LOVES", bobPromise, {"reason": "All the bling he got."});

// Wait for the promise of a relationship to be fulfilled.
    lovePromise.then(function(relationship) {

        // Get the end node of the LOVES relationship
        relationship.getEndNode().then(function(bob) {

            // Once you have a node or relationship object, all properties are immediately available:
            var name = bob.getProperty("name");

            // Change a property like this
            bob.setProperty("name", "Steven");
            bob.save().then(function(steven) {
                // Bob is now saved.
            });

        });

    });
}
