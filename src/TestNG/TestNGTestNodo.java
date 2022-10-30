package TestNG;

import Java.GrafoDirigido;
import Java.Nodo;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGTestNodo {

    //@TODO Queda pendiente SUITE

    @BeforeTest
    public void beforeTest(){
        System.out.println("TestNodo ==> Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("TestNodo ==> Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("TestNodo ==> Before Method");
    }

    @DataProvider()
    public Object[][] nodoPrueba() {
        return new Object[][] {
                new Object[] { new Nodo(1,100) },
        };
    }

    @Test(description = "Carga mayor a cero", dataProvider = "nodoPrueba", invocationCount = 5 )
    void test_cargaPositiva(Nodo n) {
        int valor = 0;
        n.setG((float) Math.random()*100);
        Assert.assertTrue(n.getG()> valor,"Valor mayor al esperado: "+valor);
        //El mensaje de error se muestra en caso de que el AssertTrue no se cumpla
        // System.out.println("Valores Random ==> " + nodo_prueba.getG());
        n.setG(100);
    }

 /*   @Test(description ="Nodo repetido", dataProvider = "nodoPrueba")
    void test_nodoRepetido(Nodo n){
        grafo.agregarVertice(n);
        if (grafo.contieneVertice(n)){

        }
    }

    @Test(description ="Nodo es igual a otro")
    void test_getNodo() {
        // tiene en cuenta solo el id
        Nodo nodo_tmp = new Nodo(1, 100);
        Assertions.assertEquals(nodo_tmp, nodo_prueba);
    }

    @Test(description ="Valores del nodo")
    void test_ValoresNodo(){
        //nodo_prueba.setG(100.1f);
        Assertions.assertEquals(nodo_prueba.getId(), 1);
        Assertions.assertEquals(nodo_prueba.getG(), 100);
    }*/

    @AfterMethod
    public void afterMethod() {
        System.out.println("TestNodo ==> After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("TestNodo ==> After Class");
    }

   @AfterTest
   public void afterTest() {
       System.out.println("TestNodo ==> After Test");
   }
}
