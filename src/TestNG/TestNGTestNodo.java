package TestNG;

import Java.Camino;
import Java.Nodo;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGTestNodo {

    //@TODO Queda pendiente SUITE
    static Camino grafo_prueba;

    @BeforeTest
    public void beforeTest(){
        System.out.println("TestNodo ==> Before Test");
        grafo_prueba = new Camino();
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

    @DataProvider()
    public Object[][] grafoPrueba(){
        return new Object[][] {
                new Object[] { new Camino() }
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

   @Test(description ="Nodo repetido", dataProvider = "nodoPrueba")
    void test_nodoRepetido(Nodo n){
        //grafo_prueba.agregarVertice(n);
        if (grafo_prueba.contieneVertice(n)){
            Assert.fail("nodo repetido");
        }
    }

    @Test(description ="Nodo es igual a otro", dataProvider = "nodoPrueba")
    void test_getNodo(Nodo n) {
        // tiene en cuenta solo el id
        Nodo nodo_tmp = new Nodo(1, 100);
        Assert.assertEquals(nodo_tmp, n);
    }

    @Test(description ="Valores del nodo", dataProvider = "nodoPrueba")
    void test_ValoresNodo(Nodo n){
        //n.setG(100.1f);
        Assert.assertEquals(n.getId(), 1);
        Assert.assertEquals(n.getG(), 100);
    }

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
