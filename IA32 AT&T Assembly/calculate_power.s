#Robinson Roa CI:261042423 C2 Miercoles 11 a 1
#Ejercicio 2 del laboratorio 4

.data
		form: .asciz "%d"
		formi: .asciz "%d\n"
		mensajea: .asciz "Introduzca un numero:\n"
		mensajeb: .asciz "Introduzca el numero a que lo quiere elevar:\n"
		mensajec: .asciz "El resultado es:\n"
		i: .long 1
		
.bss
		.comm x,4,4
		.comm a,4,4
		.comm r,4,4

.text

.global main

main:
	
	leal mensajea, %eax                  #Imprime primer mensaje
    pushl %eax
    call printf
    addl $4, %esp
    
    leal a, %eax                         #Lee el numero a
    pushl %eax
    leal form, %eax
    pushl %eax
    call scanf
    addl $8, %esp
    
    leal mensajeb, %eax                  #Imprime segundo mensaje
    pushl %eax
    call printf
    addl $4, %esp
    
    leal x, %eax                         #Lee el numero x
    pushl %eax
    leal form, %eax
    pushl %eax
    call scanf
    addl $8, %esp
    
    movl a, %eax
    movl x, %ebx
    
fora:                                     #Hace la potencia

    cmpl i, %ebx
    je endfora
    
    imull a,%eax
    incl i

    jmp fora
		
endfora: 

    movl %eax, r
    
    leal mensajea, %eax                  #Imprime tercer mensaje
    pushl %eax
    call printf
    addl $4, %esp
    
    movl r, %eax
    pushl %eax                         #Imprime el resultado
    leal formi, %eax
    pushl %eax
    call printf
    addl $8, %esp
	
 
fin:
	movl $1, %eax
	movl $0, %ebx 	
	int $0x80
