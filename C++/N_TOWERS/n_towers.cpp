#include <iostream>
#include <string>

class ficha{
  public:
	char tipo;
	int fila;
	int columna;
	
void getTipo( char x){
	tipo = x;
}
char setTipo(){
    return tipo;
}


};
 bool esSolucion(ficha x[15][15], int n){ 
	 char a,b;                          
	 int k,l, peones;
	 
	 for (int i = 0; i<n; i++){    
		for (int j =0; j<n;j++){
			a=  x[i][j].setTipo();
	
			if( a =='T'){
				
			if (j !=n ){
				peones =0;
				k=j+1;
			b=  x[i][k].setTipo();
			if ( b != 'T'){	
				while (k !=n){
			b= x[i][k].setTipo();
			if (b =='X'){
				peones = peones +1;
					}
			if ((b =='T') && (peones ==0)){
				return false;}
					k=k+1;
					}
			}else{return false;}
	 if (j !=0 ){
				peones =0;
				k=j-1;
			b=  x[i][k].setTipo();
			if ( b != 'T'){	
				while (k !=0){
			b= x[i][k].setTipo();
			if (b =='X'){
				peones = peones +1;
					}
			if ((b =='T') && (peones ==0)){
				return false;}
				k=k-1;
					
					}}else{	
			return false;}
			
			if (i !=n ){
				peones =0;
				l=i+1;
			b=  x[l][j].setTipo();
			if ( b != 'T'){	
				while (l !=n){
			b= x[l][j].setTipo();
			if (b =='X'){
				peones = peones +1;
					}
			if ((b =='T') && (peones ==0)){
				return false;}
					l=l+1;
					}
			}else{return false;}
	 if (i !=0 ){
		 
				peones =0;
				l=i-1;
			b=  x[l][j].setTipo();
			if ( b != 'T'){	
				while (l !=0){
			b= x[l][j].setTipo();
			if (b =='X'){
				peones = peones +1;
					}
			if ((b =='T') && (peones ==0)){
				return false;}
				l=l-1;
					
					}}else{	
			return false;}
			
			
           }}}}}}}
           
           for ( int i = 0; i<n;i++){
			  a= x[i][0].setTipo();
			  if (a =='T'){
				  peones =0;
		 for ( int j = i+1; j<n;j++){
				 b= x[j][0].setTipo();
				if (b =='X'){
				peones = peones +1;
					}
			if ((b =='T') && (peones ==0)){
				return false;};}
				  }			   
			   }
           return true;	

}
int vertorres( ficha x[15][15], int n){
	int torres=0;
	char a;
	for (int i = 0; i<n; i++){    
		for (int j =0; j<n;j++){
			a=  x[i][j].setTipo();
			if (a == 'T'){
				torres =torres+1;}}}return torres;}
				
	


bool esValido(ficha x[15][15], int y, int z, int n){
	char a,b;
	bool peon;
	a = x[y][z].setTipo();
	if (a =='T'){
		if (y <n){
	for ( int i = y+1; i<n; i++){
		b =x[i][z].setTipo();
		if (b == 'X'){
			peon = true; }
		if ( (b== 'T') && (peon != true)){
			return false;}}}
			if (y >0){
	for ( int j = y-1; j>-1; j--){
		b =x[j][z].setTipo();
		if (b == 'X'){
			peon = true; }
		if ( (b== 'T') && (peon != true)){
			return false;}}}
			if (z <n){
    for ( int k = z+1; k<n; k++){
		b =x[y][k].setTipo();
		if (b == 'X'){
			peon = true; }
		if ( (b== 'T') && (peon != true)){
			return false;}}}
			if (z >0){
    for ( int l = z-1; l>-1; l--){
		b =x[y][l].setTipo();
		if (b == 'X'){
			peon = true; }
		if ( (b== 'T') && (peon != true)){
			return false;}}return true;}
	}return true;}
	
void quitarTorre(ficha x[15][15], int i, int j){
	x[i][j].getTipo('.');}
	
	
void ponerTorre( ficha x[15][15], int i, int j,int n){ 
	char a;
	a = x[i][j].setTipo();
	if (a != 'X'){
     x[i][j].getTipo('T');
	 if (!esValido( x,i,j,n)){
		 quitarTorre( x,  i,  j);}
	} }

void backtracking(ficha x[15][15],int i, int j, int n){
	char a;
	bool v;
	a=x[i][j].setTipo();
	if (i<n && j<n){
	if (a != 'T'){
		ponerTorre(x,i,j,n);
		v= esSolucion(x,n);
		if (v == true){
		if (i<n){
		backtracking(x,i+1,j,n);};
			if (j<n){
			backtracking( x,i,j+1,n);};
	}}}}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
using namespace std;

int main (){
int z=0;
	
ficha matriz[15][15];
ficha solucion[15][15];
string a;
int t, n;
char b, p;

cin >> t;
solucion[15][15] = matriz[15][15];
    for (int k = 0; k<t; k++){
	

cin >> n;
	

      for (int i = 0; i<n; i ++){
cin >> a;

	    for (int j = 0; j<n; j ++){
			
		b=a[j];
		matriz[i][j].getTipo(b);
		}
	   }
	 
		          cout<<" "<< endl;
         
backtracking (solucion, 0,0,n);
z= vertorres(solucion,n);
 for (int i=0;i<n;i++){	
			  
	        for (int j= 0; j<n; j++){
				
			p= solucion[i][j].setTipo();
			cout << p;
			
            }
           cout<<endl;
          }
cout << z<<endl;}
return 0;
}
