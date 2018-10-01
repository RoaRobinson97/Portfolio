#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define tam 256

int main(){
    char basura[tam], ai[tam], bi[tam];
    char numero[tam];
    char aux='a';
    int cont = 0, a, b;
    float n1;
    FILE *archivo;
    
    
    archivo = fopen("entrada.txt","r"); 	
    
    if(archivo == NULL){
		printf ("No se pudo abrir el archivo \n");
		exit (1);
}
while (feof(archivo) ==0) {
	
	while( aux != ' '){              //Obtengo el real en forma de cadena de caracter
		numero[cont]= fgetc(archivo);
		 cont=cont+1;
		aux=numero[cont];
	 
		}
			
        n1= atof(numero);	         // Numero en real
        fgets (basura, tam,archivo);	
        aux= 'a';
        cont= 0;
        
        while( aux != ' '){ 
			 ai[cont]= fgetc(archivo);
			  cont=cont+1;
			 aux=ai[cont];
			
		}
		cont=0,
		aux= 'a';
		while( aux != ' '){               //Convierte en int los numeros recibidos en forma de cadena
			 bi[cont]= fgetc(archivo);
			 aux=bi[cont];
			 cont=cont+1;}
			 aux=0;
			 cont=0
			 a=atoi(ai);
			 b=atoi(bi);
			 
		
}
int binario=0,                      //Pasa a binario el n1
  position = 1;
 while(n1 > 0){
  binario = binario + (n1%2)*position;
  n1 /=2;
  position *= 10;
 }
 printf("%d",binario "\n");
 
 int g=0;                          // Operacion logica
 g= a&b;
 printf("%d", g " "); 
 position = 1;
 int dec=0, dec2=0;
 while(a > 0){                      
  dec = dec + (a%10)*position;
  a /=10;
  position *= 2;
 }
  position = 1;
 while(b > 0){
  dec2 = dec2 + (b%10)*position;
  b /=10;
  position *= 2;
 }
 int dec3=dec2 + dec;             //OPeracion aritmetica en decimal y luego se pasa a binario
 int dec4=0;
  position = 1;
 while(dec3 > 0){                         
  dec4 = dec4 + (dec3%2)*position;
dec3 /=2;
  position *= 10;
 }
 printf("%d",dec4 "\n");
 
 fclose(archivo);
}
