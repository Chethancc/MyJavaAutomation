import common.TestDataProvider;
import org.testng.annotations.Test;

/**
 * Created by chethanc on 24/2/20.
 */
public class BaseTest extends TestDataProvider{

    @Test
    public void setUp(){
        System.out.println("Test");
    }
}
