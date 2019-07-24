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

    private App() {
    }

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        logger.info("Calling server");
        HttpGet httpget = new HttpGet(
                "https://staging2.softcoin.com/p/ws/1/coupons/show.json?site_id=12420&retailer_family_id=1071&mac=gsbCKwLBbT0sifdoS4hUrf7NnE4%3D");
        CloseableHttpResponse response = null;
        BufferedWriter bw = null;

        try {
            response = httpclient.execute(httpget);
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != 200) {
                logger.error("Service call failed. " + status.getReasonPhrase());
                return;
            }
            else {
                logger.info("Call finished");
            }

            File file = new File("Coupons.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(file));

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(entity.getContent()));
                ObjectMapper om = new ObjectMapper();
                String line = "";
                while ((line = rd.readLine()) != null) {
                    line = line.substring(line.indexOf('['));
                    List<Coupon> coupons = om.readValue(line, 
                            new TypeReference<List<Coupon>>(){});
                    for (Coupon c : coupons) {
                        logger.info("Processing coupone: " + c.toString());
                        bw.write(c.getCouponId() + "," + c.getCategory());
                        bw.newLine();
                    }
                }
                rd.close();
                logger.info("It's done");
            }
            else {
                logger.error("No body in response");
            }
        } catch (UnsupportedOperationException e) {
            logger.error(e.getLocalizedMessage());
            ;
        } finally {
            if (response != null)
                response.close();
            if (bw != null)
                bw.close();
        }
    }
}
