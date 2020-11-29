package numbers.dao;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class NumberDao {
    private static final String url = "http://numbersapi.com/";
    private static final CloseableHttpClient client = HttpClients.createMinimal();
    
    
    public String getRandomFact(int number) throws IOException {
        HttpUriRequest httpGet = new HttpGet(url + number);
        
        try (CloseableHttpResponse response = client.execute(httpGet)) {
            return EntityUtils.toString(response.getEntity());
        }
    }
}
