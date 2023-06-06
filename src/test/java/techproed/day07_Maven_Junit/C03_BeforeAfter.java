package techproed.day07_Maven_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C03_BeforeAfter {
    @Before
    public void setUp() throws Exception{
        System.out.println("Her test metodu oncesi bir kez calisir");
    }

    @After
    public void tearDown() throws Exception{
        System.out.println("Her test metodu sonrasi bir kez calisir");
    }
    @Test
    public void test01() {
        System.out.println("ilk Test");
    }

    @Test
    public void ikinciTest() {
        System.out.println("ikinci Test");
    }
}
