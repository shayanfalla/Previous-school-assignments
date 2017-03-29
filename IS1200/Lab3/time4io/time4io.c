#include <stdint.h>
#include <pic32mx.h>
#include "mipslab.h" 

int getsw(void){
	char SW1 = PORTD & 0x9;
	char SW2 = (PORTD >> 4) & 0x6
 	char SW3 = PORTD & 0xB;
	SW3 << 2;
	char SW4 = PORTD & 0xC;
	SW4 << 3;
	int switches;
	switches &= 0xf | SW1 | SW2 | SW3 | SW4; 
	return switches;
}

int getbtns(void){
	char BTN2 = TRISD & 0x6;
	char BTN3 = TRISD & 0x7;
	BTN3 << 1;
	char BTN4 = TRISD & 0x8;
	BTN4 << 2;
	char buttons;
	buttons &= 0xe | BTN2 | BTN3 | BTN4;
	return buttons;
}