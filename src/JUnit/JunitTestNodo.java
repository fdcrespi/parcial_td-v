package JUnit;

import Java.GrafoDirigido;
import Java.Nodo;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

public class JunitTestNodo {

    static Nodo nodo_prueba;
    static GrafoDirigido grafo_prueba;

    @BeforeAll
    static void initClass() throws Exception {
        System.out.println("TestNodo --> init Class");
        nodo_prueba = new Nodo(1, 100);
        grafo_prueba = new GrafoDirigido();
    }

    @BeforeEach
    void setUp() {
        System.out.println("TestNodo --> set up");
    }

    @Test
    @RepeatedTest(value=5)
    @DisplayName(value = "Carga mayor a cero")
    void test_cargaPositiva() {
        nodo_prueba.setG((float) Math.random()*100);
        Assertions.assertTrue(nodo_prueba.getG() > 0);
       // System.out.println("Valores Random ==> " + nodo_prueba.getG());
        nodo_prueba.setG(100);
    }

    @Test
    @DisplayName(value = "Nodo repetido")
    void test_nodoRepetido(){
        //grafo_prueba.agregarVertice(nodo_prueba);
        if (grafo_prueba.contieneVertice(nodo_prueba)){
            fail("El nodo esta repetido");
        }
    }

    @Test
    @DisplayName(value= "Nodo es igual a otro")
    void test_getNodo() {
        // tiene en cuenta solo el id
        Nodo nodo_tmp = new Nodo(1, 100);
        Assertions.assertEquals(nodo_tmp, nodo_prueba);
    }

    @Test
    @DisplayName(value = "Valores del nodo")
    void test_ValoresNodo(){
        //nodo_prueba.setG(100.1f);
        Assertions.assertEquals(nodo_prueba.getId(), 1);
        Assertions.assertEquals(nodo_prueba.getG(), 100);
    }

    @AfterEach
    void tearDown() {
        System.out.println("TestNodo --> tear down");
    }

    @AfterAll
    static void closeClass() throws Exception {
        System.out.println("TestNodo --> close Class");
    }
}
