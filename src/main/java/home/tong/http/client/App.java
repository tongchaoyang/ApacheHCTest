package home.tong.http.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 */
public final class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);
    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    private App() {
    }

    public static List<Coupon> getCoupons(String url) throws IOException {
        logger.info("Calling server");
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        List<Coupon> coupons = null;

        try {
            response = httpclient.execute(httpget);
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != 200) {
                logger.error("Service call failed. " + status.getReasonPhrase());
                throw new IOException(status.getReasonPhrase());
            }
            else {
                logger.info("Call finished sucessfully");
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(entity.getContent()));
                ObjectMapper om = new ObjectMapper();
                String line = "";
                if ((line = rd.readLine()) != null) {
                    line = line.substring(line.indexOf('['));
                    coupons = om.readValue(line, 
                            new TypeReference<List<Coupon>>(){});
                }
                else {
                    logger.error("There is no data in response");
                }
                rd.close();
                logger.info("It's done");
            }
            else {
                logger.error("No body in response");
            }
        } finally {
            if (response != null)
                response.close();
        }
        return coupons;
    }
    
    public static void saveCoupons(List<Coupon> coupons, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
            logger.info("Created new file: " + path);
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Coupon c : coupons) {
            logger.info("Processing coupone: " + c.toString());
            writer.write(c.getCouponId() + "," + c.getCategory());
            writer.newLine();
        }

        writer.close();
    }
}
