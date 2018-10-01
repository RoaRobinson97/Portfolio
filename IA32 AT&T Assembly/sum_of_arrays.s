#Robinson Roa CI:261042423 C2 Miercoles 11 a 1
#Postalaboratorio4


.data
	mensajeA: 	.asciz "Introduzca los 12 valores en el arreglo A: \n"
	mensajeB: 	.asciz "Introduzca los 12 valores en el arreglo B: \n"
	mensajeC: 	.asciz "Los valores almacenados en C, resultado de sumar las posiciones de A y B son: \n"
	cad3: .asciz "%d\n"
	form: .asciz "%d"
	n: .long 0
.bss
	.comm A , 12*4, 4
	.comm B , 12*4, 4
	.comm C , 12*4, 4
	.comm x,4,4
	
.text

.global main

main:
    
    leal mensajeA, %eax
    pushl %eax
    call printf
    addl $4, %esp
    
    leal A, %ebx
    
fora:                                #Llena el arreglo A (No tocar)

    cmpl $11, n
    jg endfora
     
    leal x, %eax                     #Lee el numero
    pushl %eax
    leal form, %eax
    pushl %eax
    call scanf
    addl $8, %esp
    
    movl n,%ecx
    movl x, %eax
    movl %eax, (%ebx,%ecx,4)
    
    incl n
    jmp fora
		
endfora: 

	leal mensajeB, %eax              #Mensaje
    pushl %eax
    call printf
    addl $4, %esp
	
	leal B, %ebx
	movl $0, n
	jmp forb
	
forb:                                #Llena el arreglo B (No tocar)

    cmpl $11, n
    jg endforb
     
    leal x, %eax                     #Lee el numero
    pushl %eax
    leal form, %eax
    pushl %eax
    call scanf
    addl $8, %esp
    
    movl n,%ecx
    movl x, %eax
    movl %eax, (%ebx,%ecx,4)
    
    incl n
    jmp forb
	
endforb:
	
	leal mensajeC, %eax             #Mensaje
    pushl %eax
    call printf
    addl $4, %esp
	
	movl $0, n
	jmp forc
	
forc:                                #Ciclo for para llenar e imprimir C

	cmpl $11, n
    jg endforc
    movl n, %ecx
    
    
    leal A, %ebx                     #Suma las posiciones de A y B, metiendolas en C
    movl (%ebx,%ecx,4), %eax
    leal B, %ebx
    addl (%ebx,%ecx,4), %eax
    leal C, %ebx
    movl %eax, (%ebx,%ecx,4)    
    
    pushl %eax
	leal cad3, %eax
	pushl %eax
	call printf
	addl $8, %esp
    
    incl n
    jmp forc
   

endforc:
 
fin:
	movl $1, %eax
	movl $0, %ebx 	
	int $0x80
