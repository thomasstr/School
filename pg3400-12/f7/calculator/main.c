/*
 * main.c
 *
 *  Created on: Oct 12, 2012
 *      Author: thomass
 */
#include <stdio.h>
#include "utility.h"
int main(int argc, char **argv) {

	float tall1, tall2;
	char operation;

	printf("Hva vil du regne ut? Eks. (5+5->Enter)\n\n");
	scanf("%f%c%f", &tall1, &operation, &tall2);

	switch (operation) {
		case '+':
			printf("%f\n",sum(tall1, tall2));
			break;
		case '-':
			printf("%f\n", minus(tall1, tall2));
			break;
		case '/':
			printf("%f\n", divide(tall1, tall2));
			break;
		case '*':
			printf("%f\n", multiplication(tall1, tall2));
			break;
	}

	return 0;
}


