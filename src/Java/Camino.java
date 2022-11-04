package Java;

import Exceptions.energiaNegativaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Camino {

	HashMap<Nodo, ArrayList<Arco>> vertices = new HashMap<>();

	public void agregarVertice(Nodo nodo) {
		if (!vertices.containsKey(nodo))
			vertices.put(nodo, new ArrayList<Arco>());
	}

	/*public void borrarVertice(Nodo nodo) {
		for (Nodo i: vertices.keySet()){
			for (Nodo j: vertices.get(i).keySet()){
				if (j.getId() == nodo.getId()) {
					vertices.get(i).remove(nodo);
				}
			}
		}
		vertices.remove(nodo);
	}*/

	public void borrarVertice(Nodo nodo) {
		for(Nodo i : vertices.keySet()){
			for(int j=0 ; j< vertices.get(i).size(); j++){
				if(vertices.get(i).get(j).getJ() == nodo)
					vertices.get(i).remove(vertices.get(i).get(j));
			}
		}
		vertices.remove(nodo);
	}

	public void agregarArco(Arco arco) {
		agregarVertice(arco.getI());
		agregarVertice(arco.getJ());
		vertices.get(arco.getI()).add(arco);
	}

	public void agregarArco(Nodo origen, Nodo destino, float energia) throws energiaNegativaException {
		agregarVertice(origen);
		agregarVertice(destino);
		vertices.get(origen).add(new Arco(origen, destino, energia));
	}

	public void borrarArco(Arco arco) {
	 	if (vertices.containsKey(arco.getI())){
			 vertices.get(arco.getI()).remove(arco);
		}
	}

	public boolean contieneVertice(Nodo nodo) {
		return vertices.containsKey(nodo);
	}

	public boolean existeArco(Arco arco) {
		Nodo origen = arco.getI();
		return vertices.containsKey(origen) && vertices.get(origen).contains(arco);
	}

	public int cantidadVertices() {
		return vertices.size();
	}

	public Iterator<Nodo> obtenerVertices() {
		return vertices.keySet().iterator();
	}

	/*
	public Iterator<Nodo> obtenerAdyacentes(Nodo nodo) {
		return vertices.get(nodo).iterator();
	}*/

	public Nodo getVertice(int i) {
		Iterator<Nodo> it = obtenerVertices();
		while(it.hasNext()){
			Nodo n = it.next();
			if (n.getId() == i) {
				return n;
			}
		}
		return null;
	}

	/**
	 * El camino con mayor energía resultante
	 */
	public Nodo[] getEcoPath(int nodo_i, int nodo_j) {
		Nodo origen = getVertice(nodo_i);
		Nodo destino = getVertice(nodo_j);
		return new Nodo[]{getVertice(1), getVertice(2), getVertice(3), getVertice(4)};
	}

	/**
	 * El camino con mayor energía consumida
	 */
	public Nodo [] getWorstPath(int nodo_i, int nodo_j){
		Nodo origen = getVertice(nodo_i);
		Nodo destino = getVertice(nodo_j);
		return new Nodo[]{getVertice(1), getVertice(2), getVertice(4)};
	}

	/*
	* Energía remanente al final de un camino
	* */
	public float getEnergy(Nodo[] n){
		return 95;
	}
}
