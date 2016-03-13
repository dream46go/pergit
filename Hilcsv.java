package prova;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import org.apache.http.client.ClientProtocolException;
//import org.apache.http.util.EntityUtils;

 

public class Hilcsv  implements Serializable{

	   public String lasocieta;
       public String lamail;
       public String ilvalore;
       public String ilid;
       public String loappo01;
       public String loappo02;
       public String loappo03;
       public String loappo04;
       public String loapporisulta;
       public String loappo99 ="\"";
       public int ilnume;
       public int ilnume01;
       public int ilnume02;
       public int ilnume03;
       public int Cercasoci(String ilvalore)
       {
    	   ilnume = ilvalore.indexOf("xhtml1");
    	   return ilnume;   
       }
       public String Cercaperid(String ilvalore,String ilid)
       {
    	   //id="Societa" size="32" maxlength="128" value="GENIAL SRL"
    	   loapporisulta="";
    	   loappo01="id="+loappo99+ilid+loappo99;
    	   ilnume01 = ilvalore.indexOf(loappo01);
    	   if (ilnume01>0) 
 	       {
    	       loappo02="value=";
    	       ilnume02 = ilvalore.indexOf(loappo02,ilnume01);
    	       if (ilnume02>0) 
     	       {
    	    	   loappo03=ilvalore.substring(ilnume02+7);
    	    	   ilnume03 = loappo03.indexOf(loappo99);
    	    	   
    	    	   if (ilnume03>0) 
         	       {
    	    		   loapporisulta=loappo03.substring(0,ilnume03);
         	       }
     	       }
 	       }
    	   return loapporisulta;   
       }
       
       
}	
		 
			 
		