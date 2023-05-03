package com.mycompany.pronosticosdeportivos1;

import java.io.File;  // operaciones con archivos. Version mas moderna java.nio
//java.io.readLine() visto en teoría con Carlos está deprecado en Java 11
import java.io.FileNotFoundException;
import java.util.Scanner; // lectura de archivos de texto
import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class LectorArchivos {
    
    public LectorArchivos(){        
    }

    //Supone que todos los renglones de un archivo (luego del primero), hasta el final del archivo, son útiles.
    //Omite primer renglon
    public ArrayList<String[]> leerArchivo(String ruta){
        
        ArrayList<String[]> renglonesParseados = new ArrayList();
        
        try {
            //  Al instanciar o crear el objeto, abrimos el archivo.
            File objetoMiArchivo = new File( ruta );
            Scanner miLector = new Scanner(objetoMiArchivo);

            String renglon;
            int nroRenglon = 0;
            
            while (miLector.hasNextLine()) {
                renglon = miLector.nextLine();
                //omite renglon inicial de titulos
                if (nroRenglon > 0){
                    //parsea los campos de un renglon y los guarda
                    renglonesParseados.add(renglon.split(";"));
                }
                nroRenglon++;
            }

            //  Cerramos el archivo.
            miLector.close();
            
            return renglonesParseados;
            
          } //end try

          catch ( FileNotFoundException e ) {
            System.out.println( "Archivo inexistente."
                              + "\nEl programa se cancela." );
          }

          //todo otro tipo de error
          catch ( Exception e ) {
            System.out.println( "Error: " + e
                              + "\nEl programa se cancela." );
          }
        return renglonesParseados;
        
    } //end leerArchivo   
}
