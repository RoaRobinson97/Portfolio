#Robinson Roa CI:261042423 C2 Miercoles 11 a 1
#Ejercicio 1 del laboratorio 4

.data
		form_s: .asciz "%s"
		form_si: .asciz "%s\n"
		form_c: .asciz "%c"
		form_ci: .asciz "%c\n"
		igual: .asciz "1\n"
		nigual: .asciz "0\n"
		y: .long 1
.bss
		.comm palabra,20,1
		.comm x,4,4

.text

.global main

main:
	
	leal palabra, %eax                     #Lee la cadena
    pushl %eax
    leal form_s, %eax
    pushl %eax
    call scanf
    addl $8, %esp
    
    movl $0, %ecx

    
    
fora:                                      #Cuenta el tamaño de la palabra guarda el tamaño en %ecx
 
    leal palabra, %ebx
    movl (%ebx,%ecx), %eax                    

    cmpb $0, %al
    je contado
     
    incl %ecx
    
    
    jmp fora
		
 
contado:
      
    movl $0, %eax
    decl %ecx
     
comparar:    
    
    leal palabra, %ebx                          #Compara caracter por caracter, si no es igual salta a la etiqueta noesigual
    movl (%ebx,%eax), %edx
    movl (%ebx,%ecx), %ebx
    incl %eax
    decl %ecx
    
    cmpb %dl, %bl
    jne  nesigual 
    
    cmpl %ecx, %eax                             #Compara la posicion de los caracteres comparados, si es igual, es porque han sido todos iguales y te manta a la etiqueta esigual
    jle  esigual
    
    jmp comparar


esigual:
    leal igual, %ebx
    pushl %ebx
    call printf
    addl $4, %esp
    jmp fin
    
nesigual:
    leal nigual, %ebx
    pushl %ebx
    call printf
    addl $4, %esp
    jmp fin
    

 
fin:
	movl $1, %eax
	movl $0, %ebx 	
	int $0x80
