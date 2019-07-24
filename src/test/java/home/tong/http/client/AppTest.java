package home.tong.http.client;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     * @throws IOException 
     */
    @Test
    public void testApp() throws IOException {
        Assertions.assertThrows(ClientProtocolException.class, ()->{
            App.getCoupons("/fakeURL");
        });
        
        String url = "https://staging2.softcoin.com/p/ws/1/coupons/show.json?site_id=12420&retailer_family_id=1071&mac=gsbCKwLBbT0sifdoS4hUrf7NnE4%3D";
        List<Coupon> coupons = App.getCoupons(url);
        Assertions.assertNotNull(coupons);
        Assertions.assertTrue(coupons.size() > 0);
        
        File file = File.createTempFile("Coupons-", "tmp");
        Assertions.assertTrue(file.length() == 0);
        App.saveCoupons(coupons, file.getAbsolutePath());
        Assertions.assertTrue(file.length() > 0);
        file.delete();
    }
}
