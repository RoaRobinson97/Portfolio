#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main ()
{
	char pal[500];
	int i;
	char arch1[500],arch2[500];
	char copia[500];
	
	printf("Ingrese el archivo que desea copiar (recuerde que debe tener .txt al final):\n");
	scanf("%s",arch1);

	printf("\n");
	printf("Ingrese el nombre del archivo copia (debe tener .txt al final):\n");
	scanf("%s",arch2);

	FILE *f1 = fopen(arch1,"r");
	FILE *f2 = fopen(arch2,"w");
	
	do \
	{	
		fgets(copia,500,f1);
		fputs(copia,f2);	
	}
	while (!feof(f1));

	fclose(f1);
	fclose(f2);	
	
	printf("\n");
	printf("Ingrese una palabra:\n");
	scanf("%s",pal);
	
	printf("\n");
	printf("La palabra ingresada, en forma inversa es:\n");
	
	for (i=strlen(pal);i>=0;i--)
	{
		printf("%c", pal[i-1]);
	}
	printf ("\n");
	
	return 0;
}
