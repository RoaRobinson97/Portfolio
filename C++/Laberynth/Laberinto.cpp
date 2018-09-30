#include <windows.h>
#include <iostream>
#include <stdlib.h>
#include <conio.h>

#define TAM 20

int velocidad = 200;
bool mover = true;

using namespace std;


void gotoxy(int x, int y) { 				/**Funcion para interfaz grafica*/

    HANDLE hCon; 
    COORD dwPos; 
 
    dwPos.X = x; 
    dwPos.Y = y; 
    hCon = GetStdHandle(STD_OUTPUT_HANDLE); 
    SetConsoleCursorPosition(hCon,dwPos); 
    
}


class Casilla{								/**Representa coordenada del laberinto*/
	
	public:
	bool visitada;
	bool camino;
	bool bloqueada;
	int x;
	int y;
    Casilla(){};
    
};


class Laberinto{							/**Matriz de casillas*/
	
	public:
	Casilla laberinto[TAM][TAM];
	Casilla *entrada;
	Casilla *salida;
	Laberinto();
	void pintar();
	
};


Laberinto::Laberinto(){						/**Crea el terreno del laberinto*/
	
	for(int i=0;i<TAM;i++){
		for(int j=0;j<TAM;j++){
			laberinto[i][j].x = i;
			laberinto[i][j].y = j;
			laberinto[i][j].camino = false;
			laberinto[i][j].visitada = false;
			laberinto[i][j].bloqueada = false;	
		}
	}
	entrada = &laberinto[2][0];
	salida = &laberinto[TAM -3][TAM-1];
	
}


void Laberinto::pintar(){					/**Dibuja la matriz */
	
	gotoxy(9,1);cout << "Entrada";
	for(int i=0; i < TAM; i++){
		for(int j=0; j < TAM; j++){
			if (laberinto[i][j].camino == false){	
       	 		gotoxy(i+10,j+3 );printf ("%c",219);
    			}else{
    			gotoxy(i+10,j+3 );cout <<" ";
				}
    	}	
    }
    gotoxy(25,24);cout << "Salida";
    
}

/**------------------------------------BACKTRACKING·------------------------------------------------
Mueve el token que empieza en la entrada, evaluando sus movimientos posibles. Al pasar la primera
vez por una casilla la visita. Al pasar la segunda vez por una casilla, la bloquea. Prioriza pasar
por una casilla sin visitar antes que una visitada. Sus parametros son la casilla actual(la entrada
del laberinto) y la matriz que representa el laberinto
----------------------------------------------------------------------------------------------------*/

void Backtracking(Casilla *actual, Laberinto lab){

	while (mover==true){
	
	int x = actual->x;
	int y = actual->y;

	if ((actual->x == lab.salida->x) && (actual->y == lab.salida->y)){
	
	mover = false;
	gotoxy(actual->x + 10, actual->y + 3); printf("*");
	Sleep(velocidad);
	gotoxy(actual->x + 10, actual->y + 3); printf(" ");	
	gotoxy(0, TAM +5); cout <<"Llego a la meta!";
	
	}

	gotoxy(actual->x + 10, actual->y + 3); printf("*");
	Sleep(velocidad);
	gotoxy(actual->x + 10, actual->y + 3); printf(" ");	
	
	//Inicio movimiento IZQUIERDA
	if((x>0) && (lab.laberinto[x-1][y].camino == true) && (lab.laberinto[x-1][y].visitada == false) ){

		actual = &lab.laberinto[x-1][y];
		actual->visitada = true;

	}//Fin movimiento IZQUIERDA
	
	else //Inicio movimiento DERECHA	
	if ((x<TAM-1) && (lab.laberinto[x+1][y].camino == true) && (lab.laberinto[x+1][y].visitada == false) ){
		
		actual = &lab.laberinto[x+1][y];
		actual->visitada = true;

	}//Fin movimiento DERECHA
	
	else //Inicio movimiento ARRIBA
	if ((y>0) &&  (lab.laberinto[x][y-1].camino == true) && (lab.laberinto[x][y-1].visitada == false) ){
	
		actual = &lab.laberinto[x][y-1];
		actual->visitada = true;

	}//Fin movimiento ARRIBA
	
	else //Inicio movimiento ABAJO
	if ((y<TAM-1) && (lab.laberinto[x][y+1].camino == true) && (lab.laberinto[x][y+1].visitada == false) ){

		actual = &lab.laberinto[x][y+1];
		actual->visitada = true;
			
	}//Fin movimiento ABAJO


					/*################···············BLOQUEADO·················#####################*/

	else //Inicio moviento IZQUIERDA
	if((x>0)&& (lab.laberinto[x-1][y].camino == true)  &&  (lab.laberinto[x-1][y].bloqueada == false)) {
	
		actual->bloqueada = true;
		actual = &lab.laberinto[x-1][y];

	}//Fin movimiento IZQUIERDA

	else //Inicio movimiento DERECHA
	if ((x<TAM-1) && (lab.laberinto[x+1][y].camino == true)  && (lab.laberinto[x+1][y].bloqueada == false)){

		actual->bloqueada = true;
		actual = &lab.laberinto[x+1][y];

	}//Fin movimiento DERECHA

	else //Inicio movimiento ARRIBA
	if ((y>0) && (lab.laberinto[x][y-1].camino == true) && (lab.laberinto[x][y-1].bloqueada == false)){
	
		actual->bloqueada = true;
		actual = &lab.laberinto[x][y-1];

	}//Fin movimiento ARRIBA

	else //Inicio movimiento ABAJO
	if ((y<TAM-1) && (lab.laberinto[x][y+1].camino == true ) && (lab.laberinto[x][y+1].bloqueada == false)){
	
		actual->bloqueada = true;
		actual = &lab.laberinto[x][y+1];
	
	}//Fin movimiento ABAJO
	
	}

}//FinBacktracking


int main(){
	
system("mode con: cols=50 lines=35");
Casilla camino;
camino.camino=true;
camino.visitada=false;
camino.bloqueada=false;
Laberinto a;

/**-------------------------------------------------------------
Se introducen los valores  en la matriz para dibujar el camino 
--------------------------------------------------------------*/	
int x[]={2 ,2 ,2 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,2 ,3 ,4 ,4 ,4 ,17,16,15,14,13,13,13,13
			,14,15,16,16,16,16,17,18,18,18,17,16,15,14,13,13,13,13,14,15,16,16,16,17,18,18,18,18,18,17,16,15,14
			,14,14,14,13,12,11,10,9 ,9 ,9 ,9 ,9 ,9 ,9 ,9 ,9 ,9 ,8 ,7 ,6 ,6 ,6 ,6 ,6 ,5 ,4 ,3 ,2 ,2 ,3 ,4 ,5 ,6
			,15,16,17,18,11,11,11,17,3 ,3 ,8 ,7 ,6 ,4 ,4 ,4 ,5 ,6 ,7};
int y[]={0 ,1 ,2 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10,11,12,13,14,15,16,17,18,4 ,4 ,4 ,5 ,6 ,18,18,18,18,18,17,16,15
			,15,15,15,14,13,12,12,12,11,10,10,10,10,10,10,9 ,8 ,7 ,7 ,7 ,7 ,7 ,8 ,8 ,8 ,7 ,6 ,5 ,4 ,4 ,4 , 4, 4
			,3 ,2 ,1 ,1 ,1 ,1 ,1 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10,10,10,10,11,12,13,14,14,14,14,14,18,18,18,18,18
			,1 ,1 ,1 ,1 ,2 ,3 ,4 ,19,13,12,8 ,8 ,8 ,2 ,3 ,4 ,4 ,4 ,4};
			
for (int i=0;i<sizeof(x)/4;i++)	{
	a.laberinto[x[i]][y[i]] = camino;
	a.laberinto[x[i]][y[i]].x =x[i];
	a.laberinto[x[i]][y[i]].y =y[i];
}
	
a.entrada->visitada=true;
a.entrada->bloqueada=false;
a.pintar();
Backtracking(a.entrada,a);
gotoxy(0, TAM +6);
return 0;
	
}
