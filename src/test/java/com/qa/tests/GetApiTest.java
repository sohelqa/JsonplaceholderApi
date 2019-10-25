package com.qa.tests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;


public class GetApiTest extends TestBase{


	
	TestBase testBase;
	
	String Serviceurl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	
	
	@BeforeMethod
	
	public void setup() throws ClientProtocolException, IOException {
		
		testBase = new TestBase();
		
		Serviceurl=prop.getProperty("URL");
		apiUrl=prop.getProperty("serviceURL");
		
		
		
		url=Serviceurl + apiUrl;
		
		
		
	}
		
	@Test
	
		public void getAPITest()throws ClientProtocolException, IOException {
			
			restClient =new RestClient();
			
		closeableHttpResponse=restClient.get(url);
		
		
			
		
		
		//a. Status Code
				int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
				System.out.println("StatusCode------>"+statusCode);
				
				Assert.assertEquals(statusCode,REST_STATUS_CODE_200,"Status Code is not 2000");
				
				
				//return closeableHttpResponse;
				
				//b.JSON String
				
				
				String  responseString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
				
				//c. All Headers
				
				JSONObject responsejson = new JSONObject(responseString);
				System.out.println("Response JSON From API"+responsejson);
				
				
				
				//String s =TestUtil.getValueByjpath("/userID");
				//System.out.println(s);
				
				
				Header[] headersArray=closeableHttpResponse.getAllHeaders();
				
				
				HashMap<String, String > allHeaders=new HashMap<String, String>();
				
				
				for(Header header : headersArray) {
					
					allHeaders.put(header.getName(),header.getValue());
					}
				System.out.println("Headers Array---->"+allHeaders);
				
				
				
				
				
				
	}
		
}

		
		
		
		
		
		
		
		
		
		
	
	
	
	


