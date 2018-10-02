import java.util.*;
import java.io.*;

public class automata_romans {

public static class Automata {

   int cont;
   int canti;
   int cantx;
   int cantc;
   int cantm;
   char [] cadena;
   boolean aceptado;
   
   public void inicio(){
      cont =0;
      canti =0;
      cantx =0;
      cantc =0;
      cantm =0;
      q0();
   }
   public void q0(){
      aceptado=false;
      if(cont<cadena.length){
            if(cadena[cont]=='M'){
            cont++;
            cantm++;
            q16();
            }
            else 
            if(cadena[cont]=='D'){
            cont++;
            q14();
            }
            else 
            if(cadena[cont]=='C'){
            cont++;
            cantc++;
            q11();
            }
            if(cadena[cont]=='L'){
            cont++;
            q9();
            }
            else 
            if(cadena[cont]=='X'){
            cont++;
            cantx++;
            q6();
            }
            else 
            if(cadena[cont]=='V'){
            cont++;
            q4();
            }
            else 
            if(cadena[cont]=='I'){
            cont++;
            canti++;
            q1();
            }
      }       
   }
   
   public void q1(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='X'){
            cont++;
            cantx++;
            q3();
            }
            else 
            if(cadena[cont]=='V'){
            cont++;
            q3();
            }
            else 
            if(cadena[cont]=='I'){
            cont++;
            canti++;
            q2();
            }
            }
   }
   
   public void q2(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='I'){
            cont++;
            canti++;
            q2();
            }
}else{q3();}
   }
   
   public void q3(){
      aceptado=true;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
           qError();

}      
   } 
     
   public void q4(){
      aceptado=true;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='I'){
            cont++;
            canti++;
            q5();
            }
            else{ 
            qError();
            }
            
      }
   }
   
   public void q5(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='I'){
            cont++;
            canti++;
            q2();
            }
            }
   }
   
   public void q6(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='C'){
            cont++;
            cantc++;
            q8();
            }
            else 
            if(cadena[cont]=='L'){
            cont++;
            q8();
            }
            else 
            if(cadena[cont]=='X'){
            cont++;
            cantx++;
            q7();
            }
            else
            if(cadena[cont]=='V'){
            cont++;
            q8();
            }
            else
            if(cadena[cont]=='I'){
            cont++;
            canti++;
            q7();
            }
            }
   }
   
   public void q7(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='X'){
            cont++;
            cantx++;
            q8();
            }
            }
   }
   
   public void q8(){
     aceptado=true;
     if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='I'){
            cont++;
            canti++;
            q1();
            }
             else{ 
            qError();
            }      }
   }
   
   public void q9(){
      aceptado=true;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='X'){
            cont++;
            cantx++;
            q10();
            }
            if(cadena[cont]==0){
            cont++;
            q10();
            }
             else{ 
            qError();
            }
      }
   }
   
   public void q10(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='X'){
            cont++;
            cantx++;
            q7();
            }
            }
   }
   
   public void q11(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='M'){
            cont++;
            cantm++;
            q13();
            }
            if(cadena[cont]=='D'){
            cont++;
            q13();
            }
            if(cadena[cont]=='C'){
            cont++;
            cantc++;
            q12();
            }
            }
   }
   
   public void q12(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='C'){
            cont++;
            cantc++;
            q13();
            }
            }
   }
   
   public void q13(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='X'){
            cont++;
            cantx++;
            q6();
            }
            }
   }
   
   public void q14(){
       aceptado=true;
       if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

       if(cont<cadena.length){
            if(cadena[cont]=='C'){
            cont++;
            q15();
            }
            else{ 
            qError();
            }      }

   }
   
   public void q15(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='C'){
            cont++;
            cantc++;
            q12();
            }
            }
   }
   
   public void q16(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='M'){
            cont++;
            cantm++;
            q17();
            }
            }
   }
   
   public void q17(){
      aceptado=false;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='M'){
            cont++;
            cantm++;
            q18();
            }
            }
   }
   
   public void q18(){
      aceptado=true;
      if(cantm>3 || cantc>3 ||cantx>3 || canti>3){
   qError();}

      if(cont<cadena.length){
            if(cadena[cont]=='D'){
            cont++;
            q18();
            }
            if(cadena[cont]=='C'){
            cont++;
            cantc++;
            q11();
            }
             else{ 
            qError();
            }      }
   }
   public void qError(){
      aceptado = false; 
   }

   

}

/*-------------------------------------------------------------------------------------------*/

   public static void main(String[] args) throws IOException{
   
   Automata aut = new Automata();   
   String current = new java.io.File( "." ).getCanonicalPath();

   /*LECTURA DE ARCHIVO*/  
   FileInputStream inputStream = null;
   Scanner sc = null; 
   
   /*ESCRITURA DE ARCHIVO*/
   BufferedWriter bw = null;
 
    try {
            inputStream = new FileInputStream(current + "\\tarea3.in.txt");
            sc = new Scanner(inputStream, "UTF-8");
            File fileOUT = new File(current +"\\ROA_ROBINSON.out.txt");
            
	         if (!fileOUT.exists()) {
	            fileOUT.createNewFile();
	         }
            FileWriter fw = new FileWriter(fileOUT);
            bw = new BufferedWriter(fw);
            
            while (sc.hasNextLine()) {
               String line = sc.nextLine();
               aut.cadena = line.toCharArray();
               aut.inicio();
	            bw.append(line + " ");
               if(aut.aceptado==true){
                  bw.append("aceptada \n");
               }else{
                  bw.append("rechazada \n");
               }  
            }
            
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
               throw sc.ioException();
            }
    }
    catch (IOException ioe) {
	         ioe.printStackTrace();
	 }
    finally {
            try{
	             if(bw!=null)
		             bw.close();
	         }
            catch(Exception ex){
	             System.out.println("Error in closing the BufferedWriter"+ex);
	         }
            if (inputStream != null) {
                inputStream.close();
            }
             if (sc != null) {
                 sc.close();
            }
    }
    
    
  }            
}