/* mipslabwork.c

   This file written 2015 by F Lundevall

   This file should be changed by YOU! So add something here:

   This file modified 2015-12-24 by Ture Teknolog 

   Latest update 2015-08-28 by F Lundevall

   For copyright and licensing, see file COPYING */

#include <stdint.h>   /* Declarations of uint_32 and the like */
#include <pic32mx.h>  /* Declarations of system-specific addresses etc */
#include "mipslab.h"  /* Declatations for these labs */

int mytime = 0x5957;
int count = 0;

char textstring[] = "text, more text, and even more text!";

/* Interrupt Service Routine */
void user_isr( void )
{
  return;
}

/* Lab-specific initialization goes here */
void labinit( void )
{
	volatile int* TRISE = (volatile int*) 0xbf886100;
	TRISD |= 0xfe0; 
  return;
}

/* This function is called repetitively from the main program */
void labwork( void )
{
  int switches = getsw();
  int button = getbtns();
  if(button){
	  if(button == 0b001){
		switches << 4;
		mytime &= 0xff0f | switches;
	  }
	  if(button == 0b010){
		mytime = ((mytime  & 0xf0ff) | (switches << 8));
	  }
	  if(button == 0b100){
		switches << 12;
		mytime &= 0x0fff | switches;
	  }
  }
  delay( 1000 );
  time2string( textstring, mytime );
  display_string( 3, textstring );
  display_update();  
  while(1){
	tick( &mytime );
	count++;
	volatile int* lights = (volatile int*) 0xbf886110;
	*lights = count;
	break;
  }
  display_image(96, icon);
}
