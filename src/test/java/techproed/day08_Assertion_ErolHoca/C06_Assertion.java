package techproed.day08_Assertion_ErolHoca;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {
    /*
    Assertionlarda esitlik icin expected,actual olarak kullanilir
     */
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test02() {
        Assert.assertEquals(3,2);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test03() {
        Assert.assertNotEquals(5,4);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test04() {
        String actualName="zeynep";
        String expectedName="Zeynep";
        Assert.assertEquals(expectedName,actualName);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test05() {
        int yas=50;
        int emeklilikYas=65;
        Assert.assertTrue(emeklilikYas<yas);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test06() {
        int yas=50;
        int emeklilikYas=65;
        Assert.assertTrue(emeklilikYas>yas);
        System.out.println("Test basarili bir sekilde calisti");
    }

    @Test
    public void test07() {
        int yas=50;
        int emeklilikYas=65;
        Assert.assertFalse(emeklilikYas<yas);
        System.out.println("Test basarili bir sekilde calisti");
    }
}
