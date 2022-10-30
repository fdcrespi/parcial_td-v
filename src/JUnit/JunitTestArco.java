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
    @DisplayName(value="Valor de energia mayor a cero")
    void test_energiaPositiva() {
        //arco_prueba.setW(-5);
        Assertions.assertTrue(arco_prueba.getW() > 0);
    }
    @Test
    @DisplayName(value="Existe arco en grafo")
    void test_arcoEnGrafo() {
        //grafo.borrarArco(arco_prueba);
        //grafo.borrarVertice(arco_prueba.getI());
        Assertions.assertTrue(grafo.existeArco(arco_prueba));
    }

    @Test
    @DisplayName(value="Existen vertices del arco")
    void test_existenVertices() {
        Assertions.assertTrue(grafo.contieneVertice(arco_prueba.getI()));
        Assertions.assertTrue(grafo.contieneVertice(arco_prueba.getJ()));
    }

    @Test
    @DisplayName(value="Energia resultante igual a 75")
    void test_energiaResultante() {
        //arco_prueba.setW(51);
        Assertions.assertEquals(arco_prueba.getI().getG() - arco_prueba.getW() + arco_prueba.getJ().getG(), 75);
        //arco_prueba.setW(50);
    }

    @Test
    @DisplayName(value = "Energia resultante mayor a cero")
    void test_energiaResultanteMayorCero() {
        //arco_prueba.setW(125);
        Assertions.assertTrue(arco_prueba.getI().getG() - arco_prueba.getW() + arco_prueba.getJ().getG() > 0);
    }

    @Test
    @DisplayName(value="Origen y destino Distintos")
    void test_origenydestinoDiferentes() {
        //arco_prueba.setJ(arco_prueba.getI());
        Assertions.assertNotSame(arco_prueba.getI(), arco_prueba.getJ());
    }

    /*@Test
    @DisplayName(value="Cambio de extremos")
    void test_CambioExtremos() throws energiaNegativaException {
        Nodo nodo_prueba = new Nodo(4, 85);
        Arco nuevo_arco = new Arco(arco_prueba.getI(), nodo_prueba, 60);
        grafo.agregarVertice(nodo_prueba);
        grafo.agregarArco(nuevo_arco);
        grafo.borrarArco(arco_prueba);
        arco_prueba.setExtremos(arco_prueba.getI(), nodo_prueba, 80);
        test_existenVertices();
        Assertions.assertTrue(grafo.existeArco(arco_prueba));
    }*/

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("TestArco --> tear down");
        //arco_prueba.setW(50);
    }

    @AfterAll
    static void closeClass() {
        System.out.println("TestArco --> close class");
    }

}
