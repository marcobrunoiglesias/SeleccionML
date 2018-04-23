/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seleccionml;

import excepciones.ExcepcionInputADN;
import excepciones.ExcepcionDeChequeo;
import mutantes.DetectorDeMutantes;
import mutantes.SecuenciaDeADN;

/**
 *
 * @author Marco Iglesias
 */
public class SeleccionML {

    /**Para ingresar la matriz, tipear en la consola las distintas secuencias de ADN
     * Ejemplo
     * java -jar SeleccionML.jar ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("");
        try{
            //String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
            //String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
            String[] dna = args;
            if (isMutant(dna)){
                System.out.println("Mutante!");
            }
            else{
                System.out.println("No mutante!");
            }
        }
        catch(ExcepcionInputADN excepcionInputADN){
            System.out.println("Error procesando los datos de entrada. "+excepcionInputADN.getMensajeParaUsuario());
            System.out.println("Ingresar cada secuencia de ADN como parametro.");
            System.out.println("Ejemplo correcto: java -jar SeleccionML.jar ATGCGA CAGTGC TTATGT AGAAGG CCCCTA TCACTG");
        }
        catch(ExcepcionDeChequeo excepcionDeChequeo){
            System.out.println("Error chequeando las secuencias de ADN. "+excepcionDeChequeo.getMensajeParaUsuario());
        }
        catch(Exception e){
            System.out.println("Error desconocido. "+e.getMessage());
        }
        System.out.println("");
        
    }
    
    /**
     * Verifica si un ADN pertenece o no a un mutante
     * @param dna
     * @return
     * @throws ExcepcionDeChequeo
     * @throws ExcepcionInputADN 
     */
    private static boolean isMutant(String[] dna)throws ExcepcionDeChequeo,ExcepcionInputADN{
        boolean respuesta = false;
        SecuenciaDeADN secuenciaDeADN = new SecuenciaDeADN(dna);
        DetectorDeMutantes detectorDeMutantes = new DetectorDeMutantes(secuenciaDeADN);
            
        if (detectorDeMutantes.esMutante()){
            respuesta = true;
        }
        
        return respuesta;
    }
    
    
    
}
