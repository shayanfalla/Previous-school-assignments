#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define COLUMNS 6

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
	int j = 0;
	int i = 0;
	for (i=0; i < n; i++){
		sieves[i] = i;
	}
	for (i=0; i < sqrt(n); i++){
		j = pow(i,2);
		for(j ; j < n; j+=i){
			sieves[j] = 0;
		}
	}
	for (i=0; i < n; i++){
		if(sieves[i] != 0){
			print_number(sieves[i]);
		}
	}
}

int main(int argc, char *argv[]){
  if(argc == 2)
    print_sieves(atoi(argv[1]));
  else
    printf("Please state an interger number.\n");
  return 0;
}