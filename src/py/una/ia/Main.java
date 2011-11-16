/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */
package py.una.ia;

import py.una.ia.moaco.MOACS;

import py.una.ia.problemas.QAP;
import py.una.ia.problemas.TSP;
import py.una.ia.util.FileManager;

/**
 * 
 * @author Maximiliano Báez <mxbg.py@gmail.com>
 */
public class Main {

    public static void main(String args[]) {
        String name = "instancias/qapUni.75.0.1.qap.txt";
        name = "instancias/kroac100.tsp.txt";
        QAP qap = new QAP();
        TSP tsp = new TSP();
        
        FileManager file = new FileManager(name);
        file = new FileManager(name);
        //file.parse(qap);
        file.parse(tsp);
        
        MOACS moacs = new MOACS(tsp);
        moacs.start();
        
        System.out.println(moacs.getConjuntoPareto());
    }

    public static void print(Object[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
