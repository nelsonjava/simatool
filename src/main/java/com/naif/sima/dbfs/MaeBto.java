package com.naif.sima.dbfs;

import java.util.*;

import com.naif.tools.dbffile.DBFFieldDescriptor;
import com.naif.tools.dbffile.DBFFile;
import com.naif.tools.dbffile.DBFReader;
import com.naif.tools.dbffile.DBFRecord;

public class MaeBto implements java.io.Serializable {

    private String cCodigoEst;
    private boolean lRetiroEst;
    private int nUltRecEst;
    private float nTotPagEst;
    private Date dFecNacEst;
    
    private DBFFile dbf;
    private ArrayList<DBFRecord> registros;
    private DBFRecord registro;

    public MaeBto(String sFile) {
        dbf = new DBFReader().readDBFFile(sFile);
        registros = dbf.getRecords();
    }

    public String getCCodigoEst() {
        return cCodigoEst;
    }
    
    public boolean getLRetiroEst() {
        return lRetiroEst;
    }

    public int getNUltRecEst() {
        return nUltRecEst;
    }
    
    public float getNTotPagEst() {
        return nTotPagEst;
    }
    
    public Date getDFecNacEst() {
        return dFecNacEst;
    }
    
    public ArrayList<DBFRecord> getRegistros() {
        return registros;
    }

    public void seek(String cCodigoEst) {
        registro = dbf.getRecord("CCODIGOEST",cCodigoEst);

        this.cCodigoEst = (String)registro.getField("CCODIGOEST");
        this.lRetiroEst = ((Boolean)registro.getField("LRETIROEST")).booleanValue();
        this.nUltRecEst = ((Integer)registro.getField("NULTRECEST")).intValue();
        this.nTotPagEst = ((Float)registro.getField("NTOTPAGEST")).floatValue();
        this.dFecNacEst = (Date)registro.getField("DFECNACEST");
    }
    
    public ArrayList<String> getIds(String id) {
      
        ArrayList<String> ids = new ArrayList<String>();
      
        for (DBFRecord registro : registros) {
            ids.add((String)registro.getField(id));
        }
        
        return ids;
    }

} // Fin de la clase