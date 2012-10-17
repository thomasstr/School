#include <stdio.h>

void printargs(int arg1, ... )
{
	va_list ap;
	int i;
	
	va_start(ap, arg1);
	for(i = arg1;i >= 0; i = va_arg(ap, int))
		printf("%d", i);
	va_end(ap);
	putchar('\n');
}

int main (int argc, char* argv[])
{
	/* code */
	return 0;
}