.text
	addi	$a0,$0,8
	beq	$a0, 1, zero	# If 1, branch to zero
	add	$0, $0, $0
	beq	$a0,$0, zero	# If 0, branch to zero
	add	$0,$0,$0	# No Operation
	add	$v0,$0,$a0
	addi	$a2,$v0,-1
loop:
	add	$a0, $v0, $0
	beq	$a2,1,done	# a2 is the first counter
	add	$0,$0,$0	# No Operation
	add	$a1,$a2,$0
multip:	
	beq	$a1, 1, multdone # a1 is the second counter
	add  	$0, $0, $0	 # No Operation
	add	$v0, $v0, $a0
	addi	$a1, $a1, -1	# decrements a1
	beq	$0, $0, multip  
	add  	$0, $0, $0	# No Operation
	
multdone:
	addi	$a2, $a2, -1	# decrements a2
        beq  	$0, $0, loop   	
        add  	$0, $0, $0	# No Operation
	
zero:
	addi	$v0, $0, 1	# zero factorial is 1
done:
	beq	$0, $0, done
	add	$0, $0, $0	# No Operation
