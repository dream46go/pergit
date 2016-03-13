package prova;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.html.HTML;

import org.apache.http.client.ClientProtocolException;
import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
//import org.apache.http.util.EntityUtils;



public class Hquileggefile {

		
		 public static void main(String [] args) throws ClientProtocolException, IOException {
		 
			 
		 //
			 System.out.println("xxxxxxxxxxxxxxxxxxxxx Inizio "); 
			 
			 /// inizio vero
		     DataOutputStream flog = new DataOutputStream(new FileOutputStream("hfilelog.txt",true));
		     flog.writeBytes("INIZIO------------------ \r\n");
		     //file di input
			 DataInputStream f01 = new DataInputStream(new FileInputStream("hfile01-web-test.txt"));
             //file di output
             DataOutputStream f02 = new DataOutputStream(new FileOutputStream("hfile02-url.txt"));

             int letti = 0;
             int trovati = 0;
             int verificati = 0;
             
             
             String lariga01;
             String lariga02;
             String loappo1;
             String loappo2;
             String losalvo01;
             
             loappo1= "<!DOCTYPE html";
             flog.writeBytes("xxloappo1: "+loappo1);
             
             Hilcsv xxcsv = new Hilcsv();
             xxcsv.lasocieta = "";
             
       
       while((lariga01 = f01.readLine()) != null){
           
           letti = letti +1;
    	   
           
           //System.out.println("xxlariga : "+lariga01);
          
           flog.writeBytes("xxlariga : "+lariga01);
           
            //Document xxdocumento = Jsoup.parse(lariga01);Elements xxelementi = xxdocumento.se
           
            //if (lariga01.startsWith(loappo1,0)) 
            //    {
            	if (xxcsv.lasocieta.equals("")) 
                     {
            	      
            		 verificati = verificati +1;
            	      ///if (xxcsv.Cercasoci(lariga01)>0) 
            	      losalvo01=xxcsv.Cercaperid(lariga01, "Societa");
            	      
            	      if (losalvo01 != "")
            	      {
            	      trovati = trovati +1;
            	      xxcsv.lasocieta = losalvo01;
                      lariga02 = "Prova:--"+xxcsv.lasocieta+"--";
                      //System.out.println("lariga02: "+lariga02);
                      f02.writeBytes(lariga02+"\r\n");
            	      }
                     }
              //  }
       }
       
       f01.close();
       f02.close();
         flog.writeBytes("FINE------------------ \r\n");
		 
	     flog.close();
	     
	     System.out.println("Letti: "+letti);
	     System.out.println("verificati: "+verificati);	
	     System.out.println("Trovati: "+trovati);	
	     System.out.println("xxxxxxxxxxxxxxxxxxxxx Fine ");
			 
	     }	 
}	
		 
			 
		