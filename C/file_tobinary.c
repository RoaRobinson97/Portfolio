#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main (int argc, char *argv[]){

FILE *archivo;
FILE *nuevo;
int caracter, a=0,b=0,c=0,aa=20,bb=20;
char aux1[20];
char aux2[20];
char aux3[5];
char op1[20];
char op2[20];
int x=0;
int i=0;
int d=0;
int opaux=0;
char bin1[24],bin2[24];

void tobinary1(char oct[],int octi, int bin){
					char ex;
					ex = oct[octi];
					if (ex=='0'){
					bin1[23-(bin*3)]='0';
					bin1[23-(bin*3)-1]='0';
					bin1[23-(bin*3)-2]='0';
					}
					if (ex=='1'){
					bin1[23-(bin*3)]='1';
					bin1[23-(bin*3)-1]='0';
					bin1[23-(bin*3)-2]='0';
					}
					if (ex=='2'){
					bin1[23-(bin*3)]='0';
					bin1[23-(bin*3)-1]='1';
					bin1[23-(bin*3)-2]='0';
					}
					if (ex=='3'){
					bin1[23-(bin*3)]='1';
					bin1[23-(bin*3)-1]='1';
					bin1[bin-2]='0';						
					}
					if (ex=='4'){					
					bin1[23-(bin*3)]='0';
					bin1[23-(bin*3)-1]='0';
					bin1[23-(bin*3)-2]='1';
					}
					if (ex=='5'){
					bin1[23-(bin*3)]='1';
					bin1[23-(bin*3)-1]='0';
					bin1[23-(bin*3)-2]='1';						
					}
					if (ex=='6'){
					bin1[23-(bin*3)]='1';
					bin1[23-(bin*3)-1]='0';
					bin1[23-(bin*3)-2]='1';						
					}
					if (ex=='7'){
					bin1[23-(bin*3)]='1';
					bin1[23-(bin*3)-1]='1';
					bin1[23-(bin*3)-2]='1';
					}
					}
void tobinary2(char oct[],int octi, int bin){
					char ex;
					ex = oct[octi];
					if (ex=='0'){
					bin2[23-(bin*3)]='0';
					bin2[23-(bin*3)-1]='0';
					bin2[23-(bin*3)-2]='0';
					}
					if (ex=='1'){
					bin2[23-(bin*3)]='1';
					bin2[23-(bin*3)-1]='0';
					bin2[23-(bin*3)-2]='0';
					}
					if (ex=='2'){
					bin2[23-(bin*3)]='0';
					bin2[23-(bin*3)-1]='1';
					bin2[23-(bin*3)-2]='0';
					}
					if (ex=='3'){
					bin2[23-(bin*3)]='1';
					bin2[23-(bin*3)-1]='1';
					bin2[23-(bin*3)-2]='0';						
					}
					if (ex=='4'){					
					bin2[23-(bin*3)]='0';
					bin2[23-(bin*3)-1]='0';
					bin2[23-(bin*3)-2]='1';
					}
					if (ex=='5'){
					bin2[23-(bin*3)]='1';
					bin2[23-(bin*3)-1]='0';
					bin2[23-(bin*3)-2]='1';						
					}
					if (ex=='6'){
					bin2[23-(bin*3)]='1';
					bin2[23-(bin*3)-1]='0';
					bin2[23-(bin*3)-2]='1';						
					}
					if (ex=='7'){
					bin2[23-(bin*3)]='1';
					bin2[23-(bin*3)-1]='1';
					bin2[23-(bin*3)-2]='1';
					}
					}
					


    archivo = fopen(argv[1],"r");
	nuevo = fopen("RESULTADOS.txt","w");
	
	
	if (archivo == NULL)
        {
            printf("\nNo hay archivo. \n\n");
        }
        else{
			while((caracter = fgetc(archivo)) != EOF){
				
				
				/////////////////////////////////////////////////////////////////
				if(caracter=='\n'){
				////////////////////////////TRABAJAR CON 2 OPERANDOS//////////////	
				if(x==2){
				for (i=0;i<a;i++){
					op1[19-i]=aux1[a-1-i];
				}
				for (i=0;i<a;i++){
                tobinary1(op1,19-i,i);
			}
			for (i=0;i<24-(a*3);i++){
                bin1[i]='0';
			}
			
				for (i=0;i<b;i++){
					op2[19-i]=aux2[b-1-i];
				}
				
				for (i=0;i<b;i++){
                tobinary2(op2,19-i,i);
			}
			for (i=0;i<24-(b*3);i++){
                bin2[i]='0';
			}
			if (aux3[0] == '+' ){
			    for (i=0; i<a*3;i++){
			    fprintf(nuevo, "%c",bin1[(24-a*3)+i]);}
			    
					d=0;
					opaux=0;
					a=0;
					b=0;
					c=0;
					x=0;
					i=0;
								    fprintf(nuevo, "%c",'\n');
					}
				if (aux3[0] == 'O' && aux3[1] == 'R' ){
				int may;
				if (a>=b){
					may = a;}
					else{
					may = b;}
					for (i=0; i<may*3;i++){
						if(bin1[(24-a*3)+i] == '1' || bin2[(24-a*3)+i]=='1') {
							bin1[(24-a*3)+i]='1';}else{
							bin1[(24-a*3)+i]='0';}
						}
			    for (i=0; i<a*3;i++){
			    fprintf(nuevo, "%c",bin1[(24-a*3)+i]);}

			    
					d=0;
					opaux=0;
					a=0;
					b=0;
					c=0;
					x=0;
					i=0;
								    fprintf(nuevo, "%c",'\n');
					}
					if (aux3[0] == '+'){
						int acar=0;
				int may;
				if (a>=b){
					may = a;}
					else{
					may = b;}
					for (i=0; i<may*3;i++){
						if((bin1[(24-a*3)+i] == '1' && bin2[(24-a*3)+i]=='0') || (bin1[(24-a*3)+i] == '0' || bin2[(24-a*3)+i]=='1')) {
							if(acar==0){
							bin1[(24-a*3)+i]='1';}else{
								bin1[(24-a*3)+i]='0';
								acar=1;}}
						if(bin1[(24-a*3)+i] == '0' && bin2[(24-a*3)+i]=='0') {
							if(acar==0){
							bin1[(24-a*3)+i]='0';}else{
								bin1[(24-a*3)+i]='1';
								acar=0;}}
							if(bin1[(24-a*3)+i] == '1' && bin2[(24-a*3)+i]=='1' && acar==0) {
								if(acar==0){
							bin1[(24-a*3)+i]='0';
							acar=1;}else{
								bin1[(24-a*3)+i]='1';}
								acar=0;
						}}
			    for (i=0; i<a*3;i++){
			    fprintf(nuevo, "%c",bin1[(24-a*3)+i]);}

			    
					d=0;
					opaux=0;
					a=0;
					b=0;
					c=0;
					x=0;
					i=0;
								    fprintf(nuevo, "%c",'\n');
					}
						
				
			    }
				//////////////////////////////////////////////////////////////////  
				////////////////////TRABAJAR CON 1 OPERANDO///////////////////////
				//////////////////////////////////////////////////////////////////
				if(x==1){
				for (i=0;i<a;i++){
					op1[19-i]=aux1[a-1-i];
				}
				for (i=0;i<a;i++){
                tobinary1(op1,19-i,i);
			}
			for (i=0;i<24-(a*3);i++){
                bin1[i]='0';
			}
			
			//////////////////////////OPERACIONES///////////////////////////////
			    if (aux2[0] == 'B' ){
			    for (i=0; i<a*3;i++){
			    fprintf(nuevo, "%c",bin1[(24-a*3)+i]);}
			    
					d=0;
					opaux=0;
					a=0;
					b=0;
					c=0;
					x=0;
					i=0;
								    fprintf(nuevo, "%c",'\n');
					}
			     if (aux2[0] == 'B' ){
			    for (i=0; i<a*3;i++){
			    fprintf(nuevo, "%c",bin1[(24-a*3)+i]);}
			    
					d=0;
					opaux=0;
					a=0;
					b=0;
					c=0;
					x=0;
					i=0;
								    fprintf(nuevo, "%c",'\n');
					}
					
					if (aux2[0] == 'C' && aux2[1] == 'A' && aux2[0] == '1'){
				for (i=0; i<a*3;i++){
			    if(op1[(24-a*3)+i]=='1'){
					op1[(24-a*3)+i]='0';}
			    else
			    {op1[(24-a*3)+i]='1';}}
			    for (i=0; i<a*3;i++){
			    fprintf(nuevo, "%c",bin1[(24-a*3)+i]);}
			    
					d=0;
					opaux=0;
					a=0;
					b=0;
					c=0;
					x=0;
					i=0;
								    fprintf(nuevo, "%c",'\n');
					}
					
					if (aux2[0] == 'C' && aux2[1] == 'A' && aux2[0] == '2'){
				fprintf(nuevo, "%c",'\n');
				for (i=0; i<a*3;i++){
			    if(op1[(24-a*3)+i]=='1'){
					op1[(24-a*3)+i]='0';}
			    else
			    {op1[(24-a*3)+i]='1';}}
			    op1[23]='1';
			    for (i=0; i<a*3;i++){
			    fprintf(nuevo, "%c",bin1[(24-a*3)+i]);}
			    
					d=0;
					opaux=0;
					a=0;
					b=0;
					c=0;
					x=0;
					i=0;
								    fprintf(nuevo, "%c",'\n');
					}
			
			
				
				
				
				
			    }
				/////////////////////////////////////////////////////////////////   
				}
				/////////////////////////////////////////////////////////////////
				
				if(caracter==' '){
					 fprintf(nuevo, "%c",' ');
					x=x+1;
				}
				
				if(x==0 && caracter!=' ' && caracter!='\n'){
				aux1[a]=caracter;
				a=a+1;
				aa=a;
				 if(caracter != '\n'){
				// fprintf(nuevo, "%c",caracter);
			    }}
			    
			    if(x==1 && caracter!=' '  && caracter!='\n'){
				aux2[b]=caracter;
				b=b+1;
				bb=b;
				 if(caracter != '\n'){
				 //fprintf(nuevo, "%c",caracter);
			    }}
			    
			    if(x==2 && caracter!=' ' && caracter!='\n'){
				aux3[c]=caracter;
				c=c+1;
			     if(caracter != '\n'){
			     //fprintf(nuevo, "%c",caracter);
			    }}
			    }
			fclose(archivo);
			fclose(nuevo);}
return 0;

}
