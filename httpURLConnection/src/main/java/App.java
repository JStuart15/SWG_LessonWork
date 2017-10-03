
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jstuart15
 */
public class App {
    public static void main(String[] args) throws Exception {
        URL hp = new URL("http://www.google.com");
        String urlParameters = "the software guild";
        byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();
        //hp.openStream();
        hpCon.setDoOutput(true);
        hpCon.setInstanceFollowRedirects(false);
        hpCon.setRequestMethod("POST");
        hpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        hpCon.setRequestProperty("charset", "utf-8");
        hpCon.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        hpCon.setUseCaches(false);
        
        try ( DataOutputStream wr = new DataOutputStream(hpCon.getOutputStream())){
            wr.write (postData);
        }
        
        System.out.println("Request method is " + hpCon.getRequestMethod());
//        
        System.out.println("Response code is " + hpCon.getResponseCode());
//        
        System.out.println("Response message is " + hpCon.getResponseMessage());
//        
        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();
//        
        System.out.println("\nHere is the header: ");
        for (String k : hdrField){
            System.out.println("Key: " + k + " Value: " + hdrMap.get(k));
        }
        
    }
}
