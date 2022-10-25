package com.example.servidorproyecto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Biblioteca {

    public void Lista() throws IOException {
        read_File lector = new read_File();

        String path = "C:\\Users\\luisg\\OneDrive\\Documentos\\TEC\\2022\\Segundo semestre 2022\\Datos I\\Proyectos\\ServidorProyecto\\Biblioteca";


        String[] files = getFiles( path );

        if ( files != null ) {

            int size = files.length;

            for ( int i = 0; i < size; i ++ ) {

                System.out.println( files[ i ].toString());
                lector.readUsingScanner(files[i]);

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
