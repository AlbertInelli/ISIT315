import java.io.File;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.apache.jena.rdfconnection.RDFConnectionRemoteBuilder;

public class Queries {
	public static void main(String ...args) {
		String PATH_QUERY = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "query.sparql";

        String ENDPOINT = "http://localhost:3030/ValuesMapOntology/query";
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create()
            .destination(ENDPOINT);
        
        Query query = QueryFactory.create(QueryFactory.read(PATH_QUERY).toString());

        // In this variation, a connection is built each time. 
        try ( RDFConnectionFuseki conn = (RDFConnectionFuseki)builder.build() ) { 
            conn.queryResultSet(query, ResultSetFormatter::out);
        }
        catch(Exception e)
        {
        	
        }
    }

}
