// https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
// http://www.oodlestechnologies.com/blogs/Sending-http-request-%7C-Post-String-data-%28-JSON-%29-%7C-with-authentication  // Look this
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
 
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
 
public class HttpPostReq
{
    public static void main(String args[])
    {
        String restUrl="https://myApp.com/api/v1/json";
        String username="myusername";
        String password="mypassword";
        JSONObject user=new JSONObject();
        user.put("name", "davy jones");
        user.put("email", "davy@gmail.com");
        String jsonData=user.toString();
        HttpPostReq httpPostReq=new HttpPostReq();
        HttpPost httpPost=httpPostReq.createConnectivity(restUrl , username, password);
        httpPostReq.executeReq( jsonData, httpPost);
    }
     
    HttpPost createConnectivity(String restUrl, String username, String password)
    {
        HttpPost post = new HttpPost(restUrl);
        String auth=new StringBuffer(username).append(":").append(password).toString();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        post.setHeader("AUTHORIZATION", authHeader);
        post.setHeader("Content-Type", "application/json");
            post.setHeader("Accept", "application/json");
            post.setHeader("X-Stream" , "true");
        return post;
    }
     
    void executeReq(String jsonData, HttpPost httpPost)
    {
        try{
            executeHttpRequest(jsonData, httpPost);
        }
        catch (UnsupportedEncodingException e){
            System.out.println("error while encoding api url : "+e);
        }
        catch (IOException e){
            System.out.println("ioException occured while sending http request : "+e);
        }
        catch(Exception e){
            System.out.println("exception occured while sending http request : "+e);
        }
        finally{
            httpPost.releaseConnection();
        }
    }
     
    void executeHttpRequest(String jsonData,  HttpPost httpPost)  throws UnsupportedEncodingException, IOException
    {
        HttpResponse response=null;
        String line = "";
        StringBuffer result = new StringBuffer();
        httpPost.setEntity(new StringEntity(jsonData));
        HttpClient client = HttpClientBuilder.create().build();
        response = client.execute(httpPost);
        System.out.println("Post parameters : " + jsonData );
        System.out.println("Response Code : " +response.getStatusLine().getStatusCode());
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        while ((line = reader.readLine()) != null){ result.append(line); }
        System.out.println(result.toString());
    }
}

// curl -H "Content-Type: application/json" -X POST  -u myusername:mypassword -d '{"name":"davy jones" , "email":"davy@gmail.com"}' https://myApp.com/api/v1/json
//****************************************************************
//*****************************************************************
package au.gov.tmr.TmrGisIntegration.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.json.simple.JSONObject;

@SlingServlet(paths = "/bin/carifyrestcall")
@Service(VarifyGis.class)


public class VarifyRestAPICall extends SlingAllMethodsServlet {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final String restUrl = "Enter the URL here";	
	private final String username = "UserName Here";
	private final String password = "Password Here";

	
	
	@Override
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {
		
		String inputpayload = null;
		if (req.getParameterMap().containsKey("inputpayload")) {
			inputpayload = req.getParameter("inputpayload");
			if(inputpayload.isEmpty() || inputpayload=="" ){
				inputpayload = getInputPayloadForSafetyNet();
			}
		}else {
			inputpayload = getInputPayloadForSafetyNet();
		}
		//String jsonData=user.toString();
       // HttpPostReq httpPostReq=new HttpPost();
		//JSONObject returnResults = null;
		
        HttpPost httpPost = createConnectivity(restUrl , username, password);
        String response = executeReq( inputpayload, httpPost);
		
        
        resp.getWriter().print(response);
	}
	
	
	HttpPost createConnectivity(String restUrl, String username, String password)
    {
        HttpPost post = new HttpPost(restUrl);
        String auth=new StringBuffer(username).append(":").append(password).toString();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        post.setHeader("AUTHORIZATION", authHeader);
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept", "application/json");
       // post.setHeader("X-Stream" , "true");
        return post;
    }
	
	String executeReq(String jsonData, HttpPost httpPost)
    {
		String result=null;
        try{
            result = executeHttpRequest(jsonData, httpPost);
        }
        catch (UnsupportedEncodingException e){
            logger.info("error while encoding api url : "+e);
            result = "{msg:error while encoding api url}";
        }
        catch (IOException e){
        	logger.info("ioException occured while sending http request : "+e);
        	result = "{msg:ioException occured while sending http request}";
        }
        catch(Exception e){
        	logger.info("exception occured while sending http request : "+e);
        	result = "{msg:exception occured while sending http request}";
        }
        finally{
            httpPost.releaseConnection();
            
        }
        return result;
    }
	
	 String executeHttpRequest(String jsonData,  HttpPost httpPost)  throws UnsupportedEncodingException, IOException
	    {
	        HttpResponse response=null;
	        String line = "";
	        StringBuffer result = new StringBuffer();
	        httpPost.setEntity(new StringEntity(jsonData));
	        HttpClient client = HttpClientBuilder.create().build();
	        response = client.execute(httpPost);
	        logger.info("Post parameters : " + jsonData );
	        logger.info("Response Code : " +response.getStatusLine().getStatusCode());
	        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	        while ((line = reader.readLine()) != null){ result.append(line); }
	        logger.info("Inside:executeHttpRequest:::result.toString is ::::"+ result.toString());
	        return result.toString();
	    }
	
	public String getInputPayloadForSafetyNet(){
		
		String inputpayload =	"{ \"inputRefId\": \"something\","					 
					+ "\"customerId\": \"something\","
					+ "\"orgType\": \"something\","
					+  "\"confirmationDate\": \"2012-09-08\","
					+  "\"postCodeMatch\": \"2075\","
					+  "\"surname\": \"something\","
					+  "\"firstName\": \"something\","
					+  "\"middleName\": \"something\","
					+  "\"dateOfBirth\": \"1970-10-23\","
					+  "\"addressLine1\": \"Level 1\","
					+  "\"addressLine2\": \"something\","
					+  "\"suburb\": \"something\","
					+  "\"state\": \"something\","
					+  "\"postCode\": \"2075\""
					+ "}"  ;
	
		return inputpayload;
	}

}


//*******************************************************************
//*******************************************************************
