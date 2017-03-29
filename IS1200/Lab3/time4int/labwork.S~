  # labwork.S
  # Written 2015 by F Lundevall
  # Skeleton file for IS1200/IS1500 lab 1 2015-2016.
  # The macros PUSH and POP are in the public domain.
.global delay
.global hexasc
.global time2string

.text

.data

.macro	PUSH reg
	addi	$sp,$sp,-4
	sw	\reg,0($sp)
.endm

.macro	POP reg
	lw	\reg,0($sp)
	addi	$sp,$sp,4
.endm

  # You can add your own code here
  #
  # timetemplate.asm
  # Written 2015 by F Lundevall
  # Copyright abandonded - this file is in the public domain.

	.data
	.align 2
mytime:	.word 0x5957
timstr:	.ascii "text more text lots of text\0"
	.text
main:	
	# print timstr
	la	$a0,timstr
	li	$v0,4
	syscall
	nop
	# wait a little
	li	$a0,50
	jal	delay
	nop
	# call tick
	la	$a0,mytime
	jal	tick
	nop
	# call your function time2string
	la	$a0,timstr
	la	$t0,mytime
	lw	$a1,0($t0)
	jal	time2string
	nop
	# print a newline
	li	$a0,10
	li	$v0,11
	syscall
	nop
	# go back and do it all again
	j	main
	nop
# tick: update time pointed to by $a0
tick:	lw	$t0,0($a0)	# get time
	addiu	$t0,$t0,1	# increase
	andi	$t1,$t0,0xf	# check lowest digit
	sltiu	$t2,$t1,0xa	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x6	# adjust lowest digit
	andi	$t1,$t0,0xf0	# check next digit
	sltiu	$t2,$t1,0x60	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa0	# adjust digit
	andi	$t1,$t0,0xf00	# check minute digit
	sltiu	$t2,$t1,0xa00	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x600	# adjust digit
	andi	$t1,$t0,0xf000	# check last digit
	sltiu	$t2,$t1,0x6000	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa000	# adjust last digit
tiend:	sw	$t0,0($a0)	# save updated result
	jr	$ra		# return
	nop

  # you can write your code for subroutine "hexasc" below this line
  #
hexasc: 
	andi	$t0,$t0, 15		 # extracts the LSB
    ble		$t0, 9, number   # if less or equal than 9, jump to cool2
    nop
	addi   	$t0, $t0, 0x37  # Adds the letter
    j	returner   
	nop
number:
        addi 	$t0, $t0, 0x30  # Adds the number
returner:
	move	$a3,$t0
    jr 	$ra
    nop

delay:	
	li	$t0,0
	slt	$t3,$a0,$0
	addi	$a0,$a0,-1
	bne	$t3,$0,stop
	nop
loop:
	li	$t1,15000
	addi	$t0,$t0,1
	bne	$t0,$t1,loop
	j	delay
	nop
stop:
	jr	$ra
	nop

time2string:

	PUSH $ra	#Push stack
	PUSH $s0
	PUSH $s1
	PUSH $s2
	PUSH $s3
	PUSH $s4
	PUSH $s5
	PUSH $s6

	andi	$s0, $a1,0xf000
	srl	$s0, $s0, 12
	andi	$s1, $a1,0x0f00
	srl	$s1, $s1, 8
	
	li	$s2, 0x3a
	
	andi	$s3, $a1,0x00f0
	srl	$s3, $s3, 4
	andi	$s4, $a1,0x000f
	
NoNine:
	li	$s6, 0x00
	bne	$s4, 0x9, PrintNorm
	nop
	
WriteNine:
	li	$t2,0x4e
	li	$t3,0x49
	li	$t4,0x4e
	li	$t5,0x45
	
	sb	$t2, 4($a0)
	sb	$t3, 5($a0)
	sb	$t4, 6($a0)
	sb	$t5, 7($a0)
	sb	$s6, 8($a0)

	j	Print9
	nop
	
PrintNorm:
	move 	$t0, $s4
	jal 	hexasc
	nop
	sb	$a3, 4($a0)
	
	sb	$s6, 5($a0)
	
Print9:		
	move 	$t0, $s3
	jal 	hexasc
	nop
	sb	$a3, 3($a0)

	sb	$s2, 2($a0)
	
	move 	$t0, $s1
	jal 	hexasc
	nop
	sb	$a3, 1($a0)
			
	move	$t0, $s0
	jal 	hexasc		#Calls hexasc which returns $a3 in ASCII number
	nop
	sb	$a3, 0($a0) 	#set $a3 to position 0 of the stack $a0
	
 	#POP stack
	POP $s6
	POP $s5 
	POP $s4
	POP $s3
	POP $s2
	POP $s1
	POP $s0
	POP $ra

	jr $ra
	nop

Print:		
	move 	$t0, $s3
	jal 	hexasc
	nop
	sb	$a3, 3($a0)
		
	sb	$s2, 2($a0)
	
	move 	$t0, $s1
	jal 	hexasc
	nop
	sb	$a3, 1($a0)
			
	move	$t0, $s0
	jal 	hexasc		#Calls hexasc which returns $a3 in ASCII number
	nop
	sb	$a3, 0($a0) 	#set $a3 to position 0 of the stack $a0

	POP $s6 
	POP $s5  #POP stack
	POP $s4
	POP $s3
	POP $s2
	POP $s1 
	POP $s0
	POP $ra

	jr $ra
	nop
