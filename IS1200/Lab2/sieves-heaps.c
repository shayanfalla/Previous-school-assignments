#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define COLUMNS 6

int k = 0;

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

int print_sieves(int n){
    int i = 0;
    int j = 0;
    int x = 0;
    int y = 0;
    int z = 0;
	int *sieves = malloc(n*sizeof(int)); 	//***Allocate memory***
	
    for (i=0; i<n; i++){            		// Fills up all values in the array from 0 to n-1
        sieves[i]=i;
	}
    for(j = 2; j<sqrt(n); j++){				// Compute the algorithm 
        y = pow(j,2);						// y is equals j^2
        for(x=0; z<n; x++){	
            z=y+j*x;						// Basically j^2
            sieves[z] = 0;					// Non primes = 0
		}
		z = 0;								// Reseting the value z
	}
    for(i=0; i<n; i++){
        if(sieves[i] > 1){          		// Prints all numbers that are not less than 1 
            print_number(sieves[i]);		// Calls upon the printing function print_number 
		}
	}
	 free(sieves); 							//***Release memory***
}

int main(int argc, char *argv[]){
  if(argc == 2)
    print_sieves(atoi(argv[1]));
  else
    printf("Please state an interger number.\n");
  return 0;
}