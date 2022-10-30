package JUnit;

import Exceptions.energiaNegativaException;
import Java.Arco;
import Java.GrafoDirigido;
import Java.Nodo;
import org.junit.jupiter.api.*;

import java.util.List;

public class JunitTestArco {
    static Arco arco_prueba;
    static GrafoDirigido grafo;

    @BeforeAll
    static void initClass() throws energiaNegativaException {
        System.out.println("TestArco --> init class");
        grafo = new GrafoDirigido();
        Nodo nodo_i = new Nodo(1,100);
        Nodo nodo_j = new Nodo (5,25);
        arco_prueba = new Arco(nodo_i, nodo_j, 50);
        grafo.agregarVertice(nodo_i);
        grafo.agregarVertice(nodo_j);
        grafo.agregarArco(arco_prueba);
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("TestArco --> set up");
    }

    @Test
    void test_energiaPositiva() {
        //arco_prueba.setW(-5);
        Assertions.assertTrue(arco_prueba.getW() > 0);
    }

    /**
     * metodo que testea si un arco esta en un grafo
     * */
    @Test
    void test_arcoEnGrafo() {
        //grafo.borrarArco(arco_prueba);
        //grafo.borrarVertice(arco_prueba.getI());
        Assertions.assertTrue(grafo.existeArco(arco_prueba));
    }

    @Test
    void test_energiaResultante() {
        //arco_prueba.setW(51);
        Assertions.assertEquals(arco_prueba.getI().getG() - arco_prueba.getW() + arco_prueba.getJ().getG(), 75);
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("TestArco --> tear down");
        arco_prueba.setW(50);
    }

    @AfterAll
    static void closeClass() {
        System.out.println("TestArco --> close class");
    }

}
