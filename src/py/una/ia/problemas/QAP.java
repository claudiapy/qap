/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.ia.problemas;

import py.una.ia.util.Solucion;

/**
 *
 * @author mbaez
 */
public class QAP {

    private int localidades;
    private Double[][] distancia;
    private Double[][] flujoIda;
    private Double[][] flujoVuelta;

    public QAP() {
        this.setLocalidades(0);
    }

    /**
     * Este método establece la cantidad de localidades
     *
     * @param localidades número de localidades definidas para el problema
     */
    public void setLocalidades(int localidades) {
        this.localidades = localidades;
    }

    /**
     * Este método retorna la cantidad de localidades
     *
     * @return el número de localidades
     */
    public int getLocalidades() {
        return localidades;
    }

    /**
     * Este método establece la matriz de adyacencia para establecer las
     * distancias entre las localidades.
     *
     * @param distancia matriz de adyacencia para el objetivo de distancia
     */
    public void setDistancia(Double[][] distancia) {
        this.distancia = distancia;
    }

    /**
     * Este método retorna la matriz de adyacencia de la distancias entre las
     * localidades.
     *
     * @return la matriz de adyacencia para las distancias
     */
    public Double[][] getDistancia() {
        return distancia;
    }

    /**
     * Este método establece la matriz de adyacencia para establecer las
     * flujo de ida entre las localidades.
     *
     * @param flujoIda matriz de adyacencia para el objetivo de flujoIda
     */
    public void setFlujoIda(Double[][] flujoIda) {
        this.flujoIda = flujoIda;
    }

    /**
     * Este método retorna la matriz de adyacencia para el objetivo de flujo de
     * ida entre las localidades.
     *
     * @return la matriz de adyacencia para el objetivo de flujoIda
     */
    public Double[][] getFlujoIda() {
        return flujoIda;
    }

    /**
     * Este método establece la matriz de adyacencia para establecer las
     * flujo de vuelta entre las localidades.
     *
     * @param flujoVuelta matriz de adyacencia para el objetivo de flujoVuelta
     */
    public void setFlujoVuelta(Double[][] flujoVuelta) {
        this.flujoVuelta = flujoVuelta;
    }

    /**
     * Este método retorna la matriz de adyacencia para el objetivo de flujo de
     * vuelta entre las localidades.
     *
     * @return la matriz de adyacencia para el objetivo de flujoVuelta
     */
    public Double[][] getFlujoVuelta() {
        return flujoVuelta;
    }

    /**
     * Este método evalua la solución segun los objetivos de flujos entre las
     * localidades definidos par ael problema del QAP.
     *
     * @param solucion solución a evaluar.
     */
    public void evaluar(Solucion solucion) {

        Double ida = 0.0;
        Double vuelta = 0.0;
        Double len = 0.0;
        Double valueIda = 0.0;
        Double valueVuelta = 0.0;
        //se obtine el conjuto de nodos visitados
        Integer[] path = solucion.getPath();

        for (int i = 0; i < localidades - 1; i++) {
            int localCity = path[i];
            int nextCity = path[i + 1];

            if (i < localidades - 1) {
                //si es la ultima ciudad se debe conservar el como la siguiente
                //ciudad la ciudad de origen, esto es devido a la definicion del
                //problema en si.
                nextCity = path[i + 1];
            }
            //se obtienen los flujos entre las ciudades
            ida = flujoIda[localCity][nextCity];
            vuelta = flujoVuelta[localCity][nextCity];
            //se obtiene la distancia entre las ciudades
            len = distancia[localCity][nextCity];
            //Se evalua la solución par ambos objetivos
            valueIda += ida * len;
            valueIda += vuelta * len;
        }
        //se establecen las evaluaciones para la solucion acorde a los objetivos
        solucion.setEvaluacion(new Double[]{valueIda, valueVuelta});
    }
}
