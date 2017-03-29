/*
 print-prime.c
 By David Broman.
 Last modified: 2015-09-15
 This file is in the public domain.
*/


#include <stdio.h>
#include <stdlib.h>

#define COLUMNS 6

  // Should print out all prime numbers less than 'n'
  // with the following formatting. Note that
  // the number of columns is stated in the define
  // COLUMNS
  int k = 0;
void print_primes(int n){
int i;
	for(i=1; i<n; i++)
	{
		if (is_prime(i)==1){
			print_number(i);			
		} 
	}			
}

void print_number(int n){ 
	if (k == COLUMNS)
	{
		printf("\n");
		printf("%10d ", n);
		k = 0;
	} else 
		printf("%10d ", n);
		k = k + 1;
}

int is_prime(int n){
int j, remainder;
for(j=1; j<=n, j++;)
	{
	if(n%j==0)
		{
			break;
		}
	}
	if(j == n)
	{
		remainder = 1;
	} else remainder = 0;

  return remainder;
}

// 'argc' contains the number of program arguments, and
// 'argv' is an array of char pointers, where each
// char pointer points to a null-terminated string.
int main(int argc, char *argv[]){
  if(argc == 2)
    print_primes(atoi(argv[1]));
  else
    printf("Please state an interger number.\n");
  return 0;
}

 
