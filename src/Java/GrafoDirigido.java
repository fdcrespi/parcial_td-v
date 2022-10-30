package Java;

import Exceptions.energiaNegativaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido {

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
		if (vertices.containsKey(arco.getI())){
			vertices.get(arco.getI()).add(arco);
		}
	}

	public void agregarArco(Nodo origen, Nodo destino, float energia) throws energiaNegativaException {
		if (vertices.containsKey(origen)){
			vertices.get(origen).add(new Arco(origen, destino, energia));
		}
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

}
