/*
 prime.c
 By David Broman.
 Last modified: 2015-09-15
 This file is in the public domain.
*/


#include <stdio.h>

int is_prime(int n){
int j, remainder;
for(j=2; j<=n, j++;)
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

int main(void){
  printf("%d\n", is_prime(11));  // 11 is a prime.      Should print 1.
  printf("%d\n", is_prime(383)); // 383 is a prime.     Should print 1.
  printf("%d\n", is_prime(987)); // 987 is not a prime. Should print 0.
}
