package services;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javax.ws.rs.core.MultivaluedMap;
/**
 *
 * @author SANTY
 */
public class ServiceClient {
    private CalcProxy proxy;
    
    
    public void init() {
        proxy = new CalcProxy();
    }
    
    public String callService(String serviceName, String p1, String p2) {
            //  locating the service
        String url = proxy.locateService(serviceName);
        if (url.startsWith("error")) {
            return url;
        } else {
            String result;
                // making the request
            try {
                Client c = Client.create();
                WebResource resource = c.resource(url);

                MultivaluedMap<String, String> params = new MultivaluedMapImpl();
                params.add("p1", p1);
                params.add("p2", p2);
                System.out.println("=> ");
                String response = resource.path("/" + serviceName).
                        queryParams(params).
                        get(String.class);
                System.out.println(response);

                result = response;
            } catch (Exception ex) {
                result = "error";
            }
            return result;
        }
    }
    
}
