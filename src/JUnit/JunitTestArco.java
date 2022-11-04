package JUnit;

import Exceptions.energiaNegativaException;
import Java.Arco;
import Java.Camino;
import Java.Nodo;
import org.junit.jupiter.api.*;

public class JunitTestArco {
    static Arco arco_prueba;
    static Camino camino;

    @BeforeAll
    static void initClass() throws energiaNegativaException {
        System.out.println("TestArco --> init class");
        camino = new Camino();
        Nodo nodo_i = new Nodo(1,100);
        Nodo nodo_j = new Nodo (2,25);
        arco_prueba = new Arco(nodo_i, nodo_j, 50);
        camino.agregarVertice(nodo_i);
        camino.agregarVertice(nodo_j);
        camino.agregarArco(arco_prueba);
    }

    @BeforeEach
    void setUp() {
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
        Assertions.assertTrue(camino.existeArco(arco_prueba));
    }

    @Test
    @DisplayName(value="Existen vertices del arco")
    void test_existenVertices() {
        Assertions.assertTrue(camino.contieneVertice(arco_prueba.getI()));
        Assertions.assertTrue(camino.contieneVertice(arco_prueba.getJ()));
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

    @Test
    @DisplayName(value="Cambio de extremos")
    void test_CambioExtremos() {
        Nodo nodo_prueba = new Nodo(4, 85);
        Arco original = arco_prueba;
        camino.agregarVertice(nodo_prueba);
        camino.borrarArco(original);
        original.setExtremos(original.getI(), nodo_prueba, 80);
        camino.agregarArco(original);
        test_existenVertices();
        Assertions.assertTrue(camino.existeArco(original));
        Assertions.assertSame(original.getJ(), nodo_prueba);
        camino.borrarArco(original);
        camino.agregarArco(arco_prueba);
    }

    @AfterEach
    void tearDown() {
        System.out.println("TestArco --> tear down");
        //arco_prueba.setW(50);
    }

    @AfterAll
    static void closeClass() {
        System.out.println("TestArco --> close class");
    }

}
