package com.example.servidorproyecto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * se utiliza para cargar rutas y pasar archivos a los arboles.
 */
class Biblioteca {

    //codigo tomado de: https://es.stackoverflow.com/questions/17354/leer-todos-los-ficheros-de-una-carpeta

    public String msg;

    /**
     * me brinda la ruta de biblioteca, recorre el array de archivos y me llama a las otras implicadas con el arbol.
     * @throws Exception
     */
    public void Lista() throws Exception {
        read_File lector = new read_File();
        ArbolBinario arbol = new ArbolBinario();
        Conexion conexion = new Conexion();
        StringQuickSort quick= new StringQuickSort();

        List<String> peter
                = new ArrayList<String>();

        List<Integer> pepe = new ArrayList<>();

        String path = "C:\\Users\\Gabriel\\IdeaProjects\\ServidorProyecto\\Biblioteca";


        String[] files = getFiles( path );

        if ( files != null ) {

            int size = files.length;

            for ( int i = 0; i < size; i ++ ) {

                System.out.println( files[ i ].toString());
                conexion.iniciar();
                msg= conexion.message;
                lector.readUsingScanner(files[i].toString(), conexion.message);
                peter.add(lector.readUsingScanner(files[i].toString(), conexion.message));
                System.out.println(peter);
                //quick.sort(peter);






                //System.out.println(msg);

                //arbol.inorden();

            }
        }
    }

    /**
     * Se encarga de hacer un array de los archivos en la carpeta biblioteca.
     * @param dir_path se usa para argumento que hay mandarle un path
     * @return un array de los archivos
     */

    public static String[] getFiles( String dir_path ) {

        String[] arr_res = null;

        File f = new File( dir_path );

        if ( f.isDirectory( )) {

            List<String> res   = new ArrayList<>();
            File[] arr_content = f.listFiles();

            int size = arr_content.length;

            for ( int i = 0; i < size; i ++ ) {

                if ( arr_content[ i ].isFile( ))
                    res.add( arr_content[ i ].toString( ));
            }


            arr_res = res.toArray( new String[ 0 ] );

        } else
            System.err.println( "¡ Path NO válido !" );


        return arr_res;
    }

}
