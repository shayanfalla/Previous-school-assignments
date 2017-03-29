#include <stdio.h>
#include <stdlib.h>

#define COLUMNS 6
#define PRIMES 10000
int k=0;
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

void print_sieves(int n){
	int sieves[n]; 
	int primes[PRIMES];
	int p, a, b, c = 0;
	for (p=0; p < n; p++){						//Fill the array with natural numbers
		sieves[p] = p + 2;
	}
	for (a=0; a < n; a++){
		if (sieves[a]!=-1)
			for (b=2*sieves[a]-2; b<n; b+sieves[b])
				sieves[b]=-1;
	}
	for (a=0; a <n&&c<PRIMES; a++){
		if (sieves[a]!=-1)
			primes[c++] = sieves[a];
	}
	for (a=0; a<PRIMES; a++){
		print_number(primes[a]);
	}
}


int main(int argc, char *argv[]){
  if(argc == 2)
    print_sieves(atoi(argv[1]));
  else
    printf("Please state an interger number.\n");
  return 0;
}