package TestNG;

import Exceptions.energiaNegativaException;
import Java.Arco;
import Java.Camino;
import Java.Nodo;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGTestArco {

    static Camino camino;
    static Arco arco_prueba;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Test Arco ==> Before Suite");
    }

    //TODO esta bien inicializar todo aca? -> Seria como el beforeAll de junit?
    @BeforeTest
    public void beforeTest() throws energiaNegativaException {
        System.out.println("Test Arco ==> Before Test");
        camino = new Camino();
        arco_prueba = new Arco(new Nodo(3, 40), new Nodo(4,100), 5);
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Test Arco ==> Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Test Arco ==> Before Method");
        camino.agregarArco(arco_prueba);
    }

    //TODO se puede tener objetos distintos?
    @DataProvider
    public Object[][] arco_prueba() throws energiaNegativaException {
        return new Object[][] {
            new Object[] {
                new Arco(new Nodo(1, 100), new Nodo(2,25),50),
            },
        };
    }

    @Test(description = "Comprueba si el valor de la energia es positiva", dataProvider = "arco_prueba")
    void test_energiaPositiva(Arco arco){
        Assert.assertTrue(arco.getW() > 0);
    }

    @Test(description = "Comprueba si el arco se cuentra en el grafo")
    void test_arcoEnGrafo(){
        Assert.assertTrue(camino.existeArco(arco_prueba));
    }

    @Test(description = "Existen vertices del arco")
    void test_existenVertices(){
        Assert.assertTrue(camino.contieneVertice(arco_prueba.getI()));
        Assert.assertTrue(camino.contieneVertice(arco_prueba.getJ()));
    }

    @Test(description = "Energia resultante igual a 75")
    void test_energiaResultante() {
        Assert.assertEquals(arco_prueba.getI().getG() - arco_prueba.getW() + arco_prueba.getJ().getG(), 75);
    }

    @Test(description = "Energia resultante mayor a 0")
    void test_energiaResultanteMayorCero(){
        Assert.assertTrue(arco_prueba.getI().getG() - arco_prueba.getW() + arco_prueba.getJ().getG() > 0);
    }

    //TODO preguntar a Juan porque no funciona
    @Test(description = "Origen y destinos distintos")
    void test_origenyDestinoDiferentes(){
        //arco_prueba.setJ(arco_prueba.getI());
        Assert.assertNotSame(arco_prueba.getI(), arco_prueba.getJ());
    }

    @Test(description = "Cambio de extremos")
    void test_cambioExtremos() throws energiaNegativaException {
        Arco original = new Arco(arco_prueba.getI(), arco_prueba.getJ(), arco_prueba.getW());
        Nodo nodo1 = new Nodo(1,100);
        Nodo nodo2 = new Nodo(2,25);
        camino.borrarArco(arco_prueba);
        arco_prueba.setExtremos(nodo1, nodo2, 50);
        camino.agregarArco(arco_prueba);
        test_arcoEnGrafo();
        test_existenVertices();
        Assert.assertEquals(arco_prueba.getI(), nodo1);
        Assert.assertEquals(arco_prueba.getJ(), nodo2);
        camino.borrarArco(arco_prueba);
        camino.agregarArco(original);
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Test Arco ==> After Method");
        camino.borrarArco(arco_prueba);
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Test Arco ==> After Class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Test Arco ==> After Test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Test Arco ==> After Suite");
    }
}
