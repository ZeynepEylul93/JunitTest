package techproed.day07_MavenJunit_Erol;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class C02_BeforeAfter {


    /*
                   Notasyonlara sahip metodlar olusturabilmek icin sagtik+generate veya kisayol( alt+insert)yaparak
                   after metodu icin tearDown'u seceriz.
                   before methodu icin setup'i seceriz.
                   test methodu icin de test'i seceriz
                    JUnit frameworkunde testlerimizi siralama yapabilmek icin ekstra bir notasyon yoktur.
        Eger belli bir siralamada calistirmak istersek
         method isimlerini alfabetik ve sayisal olarak belirtmemiz gerekir


                    */
    @After
    public void tearDown() throws Exception {
        System.out.println("Her test metodundan sonra bir kez calisir");
    }

    @Before
    public void setUp() {
        System.out.println("Her test methodundan önce bir kez çalışır");
    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu çalıştı");
    }

    @Test
    public void test2() {
        System.out.println("Test2 methodu çalıştı");
    }

    @Test
    public void test3() {
        System.out.println("Test3 methodu çalıştı");


    }
}
