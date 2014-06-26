package com.naif.sima.recibos;

// java -jar simatool-1.0-SNAPSHOT.jar >1.txt

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.WriteConcern;

import com.naif.sima.dbfs.MaeBto;

import com.naif.tools.dbf.DbfUtils;

import com.naif.tools.dbffile.DBFFieldDescriptor;
import com.naif.tools.dbffile.DBFFile;
import com.naif.tools.dbffile.DBFReader;
import com.naif.tools.dbffile.DBFRecord;


public class App {

  static String sfile = "D:/sima/simacont/2014.diu/BTO/MAEBTO14.DAT";

  public static void main(String[] args) {

      MaeBto maebto = new MaeBto(sfile);

      ArrayList<DBFRecord> registros = maebto.getRegistros();
      ArrayList<String> codigos = maebto.getIds("CCODIGOEST");

      for (String codigo : codigos) {
          maebto.seek(codigo);

          System.out.println("CODIGO: " + codigo);
          System.out.println("cCodigoEst " + maebto.getCCodigoEst());
          System.out.println("lRetiroEst " + maebto.getLRetiroEst());
          System.out.println("nUltRecEst " + maebto.getNUltRecEst());
          System.out.println("nTotPagEst " + maebto.getNTotPagEst());
          System.out.println("dFecNacEst " + maebto.getDFecNacEst());

          System.out.println();
      }

      sfile = "D:/sima/simacart/2014.diu/RECIBOS/JUN/RECIJUN.DAT";
      DbfUtils.beanDbf(sfile,"Recibos");

      sfile = "D:/sima/simacont/2014.diu/BTO/MAEBTO14.DAT";
      DbfUtils.beanDbf(sfile,"MaeAlu");


/*
    File fichero = new File(sfile);
    if (fichero.exists())
       System.out.println("El ARCHIVO " + sfile + " existe");
    else
       System.out.println("El fichero " + sfile + " NO existe");

    DBFFile recibos = new DBFReader().readDBFFile(sfile);

    if (recibos == null){
       System.out.println( "No existen Registros" );
       return;
    }

    DBFRecord recibo = recibos.getRecord("CCODIGOEST","214185");
    if (recibo == null){
       System.out.println( "Registro no existe" );
       return;
    }

    if (!recibo.isActive()){
       System.out.println( "Registro Eliminado" );
       return;
    }



    String cNombreEst = (String)recibo.getField("CNOMBREEST");

    System.out.println( (String)recibo.getField("CCODIGOEST") );
    System.out.println( cNombreEst );




    System.out.println("Registros:" + recibos.getHeader().getRecordNum());

        for (DBFFieldDescriptor fd : recibos.getFieldDescs()) {
        	System.out.println("1 al 11: >" + fd.getField() + "<");
            System.out.println("12: " + fd.getFieldType());
            System.out.println("13 al 14: " + fd.getWhereFieldBegin());
            System.out.println("15 al 16: No usados");
            System.out.println("17 al 18: " + fd.getFieldLenght() + " y " + fd.getDecfieldLenght());
            System.out.println("------------------------");
        }
*/

/*
System.out.println("Información del Registro:");

        	System.out.println("Activo:"+recibo.isActive());

        	two: for (Entry<String, Object> entry : recibo.getValues().entrySet()) {
    			System.out.println("(" + entry.getKey() + "," + entry.getValue() + ")");
    		} // end : two
*/

/*
    Mongo conn;
    try {
      conn = new Mongo("localhost", 27017);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    WriteConcern w = new WriteConcern( 1, 2000 );
    conn.setWriteConcern( w );

    DB db = conn.getDB( "crawler" );
    DBCollection coll = db.getCollection( "sites" );

    DBObject doc = new BasicDBObject();
    String[] tags = { "database", "open-source" };

    doc.put("url", "org.mongodb");
    doc.put("tags", tags);

    DBObject attrs = new BasicDBObject();
    attrs.put( "lastAccess", new Date() );
    attrs.put( "pingtime", 20 );

    doc.put( "attrs", attrs );

    coll.insert(doc);

    System.out.println( "Initial document:\n" );
    System.out.println( doc.toString() );

    System.out.println( "Updating pingtime...\n" );
    coll.update( new BasicDBObject( "_id", doc.get("_id") ),
       new BasicDBObject( "$set", new BasicDBObject( "pingtime", 30 ) ) );

    DBCursor cursor = coll.find();

    System.out.println( "After update\n" );
    System.out.println( cursor.next().toString() );

    System.out.println( "Number of site documents: " + coll.count() );

    System.out.println( "Removing documents...\n" );
    coll.remove( new BasicDBObject() );

---
    public static boolean existFile(String path) {
        boolean exist = false;

        File fichero = new File(path);
        if (fichero.exists())
            exist = true;

        return exist;
    }
---

*/


}

}



