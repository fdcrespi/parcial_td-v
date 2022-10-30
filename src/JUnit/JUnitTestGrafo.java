package JUnit;

import Java.GrafoDirigido;
import Java.Nodo;
import org.junit.jupiter.api.*;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.fail;

public class JUnitTestGrafo {

    static GrafoDirigido grafo;

    @BeforeAll
    static void InitClass() throws Exception {
        grafo = new GrafoDirigido();
        Nodo n1 = new Nodo(1, 100);
        Nodo n2 = new Nodo(2, 25);
        Nodo n3 = new Nodo(3, 40);
        Nodo n4 = new Nodo(4, 100);
        grafo.agregarVertice(n1);
        grafo.agregarVertice(n2);
        grafo.agregarVertice(n3);
        grafo.agregarVertice(n4);
        grafo.agregarArco(n1,n2,50);
        grafo.agregarArco(n2,n3,20);
        grafo.agregarArco(n2,n4,80);
        grafo.agregarArco(n3,n4,5);
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
        Assertions.assertNotNull(grafo);
    }

    @Test
    @DisplayName(value = "Agregar Vertice")
    void test_agregarVertice() {
        Nodo temp = new Nodo(5, 500);
        grafo.agregarVertice(temp);
        Assertions.assertTrue(grafo.contieneVertice(temp));
        grafo.borrarVertice(temp);
    }

    @Test
    @DisplayName(value="Verifica contiene Vertice")
    void test_verificaContieneVertice() {
        boolean encontro = false;
        Nodo p = new Nodo(5,10);
        grafo.agregarVertice(p);
        Iterator<Nodo> it = grafo.obtenerVertices();
        while(it.hasNext() && !encontro){
            Nodo n = it.next();
            if(n.getId() == p.getId()) encontro=true;
        }
        if (!encontro) fail("No fue encontrado");
        grafo.borrarVertice(p);
    }

    @Test
    @DisplayName(value="Verificar obtener vertices")
    void test_obtenerVertices() {
        int tamanioGrafo = grafo.cantidadVertices();
        int tamanioMetodo = 0;
        Iterator<Nodo> it = grafo.obtenerVertices();
        while(it.hasNext()){
            it.next();
            tamanioMetodo++;
        }
        Assertions.assertEquals(tamanioGrafo,tamanioMetodo);
    }

    @Test
    @DisplayName(value="Verificar cantidad de vertices")
    void test_cantidadVertices() {
        Assertions.assertEquals(grafo.cantidadVertices(),4);
    }

/*  @TODO
    @Test
    @DisplayName(value="Verificar valor energia camino entre vertices")
    void test_valorDeCamino() {
        float valorCamino = grafo.(n1.energia) - energia + grafo.(n2.energia) - energia + grafo.(n3.energia)
        Assertions.assertEquals(valorCamino, 5);
    }*/

    @AfterEach
    void tearDown(){
        System.out.println("Test Grafo --> tearDown");
    }

    @AfterAll
    static void CloseClass(){
        System.out.println("Test Grafo --> CloseClass");
    }

}
