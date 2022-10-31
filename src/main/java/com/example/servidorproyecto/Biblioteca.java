package com.example.servidorproyecto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Biblioteca {

    //codigo tomado de: https://es.stackoverflow.com/questions/17354/leer-todos-los-ficheros-de-una-carpeta

    public String msg;
    public void Lista() throws Exception {
        read_File lector = new read_File();
        ArbolBinario arbol = new ArbolBinario();
        Conexion conexion = new Conexion();

        String path = "C:\\Users\\Gabriel\\IdeaProjects\\ServidorProyecto\\Biblioteca";


        String[] files = getFiles( path );

        if ( files != null ) {

            int size = files.length;

            for ( int i = 0; i < size; i ++ ) {

                System.out.println( files[ i ].toString());
                conexion.iniciar();
                msg= conexion.message;
                lector.readUsingScanner(files[i].toString(), conexion.message);
                //System.out.println(msg);

                //arbol.inorden();

            }
        }
    }


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
