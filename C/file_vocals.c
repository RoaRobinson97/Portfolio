#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	FILE *archivo;
	FILE *nuevo;
	
	int caracter;
	int vocales=0,vocal=0;
	
	archivo = fopen(argv[1],"r");
	nuevo = fopen("REPORTE_VOCALES.txt","w");
	
	if (archivo == NULL)
        {
            printf("\nNo hay archivo. \n\n");
        }
        else
        
        
        {
            while((caracter = fgetc(archivo)) != EOF){
				
				if ((caracter=='a') || (caracter=='e')||(caracter=='i')||(caracter=='o')||
				(caracter=='u')||(caracter=='A')||(caracter=='E')||(caracter=='I')||(caracter=='O')||(caracter=='U')){
					
					vocales= vocales + 1;}
					
					
					
					    if(caracter == '\n'){
							vocal=vocales;
							vocales=0;
						    fprintf(nuevo, "%d",vocal );
						    fprintf(nuevo, "%s","\n");
					}
					}
        }
        fclose(archivo);
	return 0;
}

