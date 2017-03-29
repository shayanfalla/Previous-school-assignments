/*
Written by Alexander Windahl
No copyright sought.
*/

#include <stdint.h>   
#include <pic32mx.h>  
#include "mipslab.h"  

int getsw (void){

    int Switches;
    Switches = (PORTD & (0xf << 8)) >> 8;
    return Switches;

}

int getbtns (void){

    int Buttons;
    Buttons = (PORTD & (0x7 << 5)) >>5;
    return Buttons; 
    
}
