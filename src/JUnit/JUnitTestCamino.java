package JUnit;

import Java.Camino;
import Java.Nodo;
import org.junit.jupiter.api.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.fail;

public class JUnitTestCamino {

    static Camino camino;

    @BeforeAll
    static void InitClass() throws Exception {
        camino = new Camino();
        Nodo n1 = new Nodo(1, 100);
        Nodo n2 = new Nodo(2, 25);
        Nodo n3 = new Nodo(3, 40);
        Nodo n4 = new Nodo(4, 100);
        camino.agregarVertice(n1);
        camino.agregarVertice(n2);
        camino.agregarVertice(n3);
        camino.agregarVertice(n4);
        camino.agregarArco(n1,n2,50);
        camino.agregarArco(n2,n3,20);
        camino.agregarArco(n2,n4,80);
        camino.agregarArco(n3,n4,5);
        System.out.println("Test Grafo --> InitClass");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Test Grafo --> SetUp");
    }

    @Test
    @DisplayName(value = "Verifica que el grafo no es nulo")
    void test_grafoNotNull() {
        //grafo = null;
        Assertions.assertNotNull(camino);
    }

    @Test
    @DisplayName(value = "Agregar Vertice")
    void test_agregarVertice() {
        Nodo temp = new Nodo(5, 500);
        camino.agregarVertice(temp);
        Assertions.assertTrue(camino.contieneVertice(temp));
        camino.borrarVertice(temp);
    }

    @Test
    @DisplayName(value="Verifica contiene Vertice")
    void test_verificaContieneVertice() {
        boolean encontro = false;
        Nodo p = new Nodo(5,10);
        camino.agregarVertice(p);
        Iterator<Nodo> it = camino.obtenerVertices();
        while(it.hasNext() && !encontro){
            Nodo n = it.next();
            if(n.getId() == p.getId()) encontro=true;
        }
        if (!encontro) fail("No fue encontrado");
        camino.borrarVertice(p);
    }

    @Test
    @DisplayName(value="Verificar obtener vertices")
    void test_obtenerVertices() {
        int tamanioGrafo = camino.cantidadVertices();
        int tamanioMetodo = 0;
        Iterator<Nodo> it = camino.obtenerVertices();
        while(it.hasNext()){
            it.next();
            tamanioMetodo++;
        }
        Assertions.assertEquals(tamanioGrafo,tamanioMetodo);
    }

    @Test
    @DisplayName(value="Verificar cantidad de vertices")
    void test_cantidadVertices() {
        Assertions.assertEquals(camino.cantidadVertices(),4);
    }

/*  @TODO
    @Test
    @DisplayName(value="Verificar valor energia camino entre vertices")
    void test_valorDeCamino() {
        float valorCamino = grafo.(n1.energia) - energia + grafo.(n2.energia) - energia + grafo.(n3.energia)
        Assertions.assertEquals(valorCamino, 5);
    }*/

    @Test
    @DisplayName(value = "Camino con mayor energia resultante correcta")
    void test_mayorEnergiaCamino() {
        Nodo[] caminoResultante = camino.getEcoPath(1,4);
        //Nodo[] caminoResultante = {camino.getVertice(1), camino.getVertice(2), camino.getVertice(3), camino.getVertice(4)};
        Nodo[] caminoCorrecto = {camino.getVertice(1), camino.getVertice(2), camino.getVertice(3), camino.getVertice(4)};
        for (int i = 0; i < caminoCorrecto.length; i++) {
            Assertions.assertEquals(caminoCorrecto[i], caminoResultante[i]);
        }
    }

    @Test
    @DisplayName(value = "Camino que mayor energia consumio")
    void test_caminoMayorEnergiaConsumida(){
        Nodo[] caminoResultante = camino.getWorstPath(1, 4);
        Nodo[] caminoCorrecto = {camino.getVertice(1), camino.getVertice(2), camino.getVertice(4)};
        for (int i = 0; i < caminoCorrecto.length; i++){
            Assertions.assertEquals(caminoCorrecto[i], caminoResultante[i]);
        }
    }

    @Test
    @DisplayName(value = "Energia final")
    void test_valorEnergiaFinal() {
        Nodo[] caminoVerificar = {camino.getVertice(1), camino.getVertice(2), camino.getVertice(4)};
        Assertions.assertTrue(camino.getEnergy(caminoVerificar) == 95);
    }

    @AfterEach
    void tearDown(){
        System.out.println("Test Grafo --> tearDown");
    }

    @AfterAll
    static void CloseClass(){
        System.out.println("Test Grafo --> CloseClass");
    }

}
