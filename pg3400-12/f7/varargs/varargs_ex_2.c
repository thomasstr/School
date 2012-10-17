#include <stdio.h>
#include <stdarg.h>

double average(int num, ...)
{
	va_list arguments;
	double sum = 0;
	
	/* Initializing arguments to store all values after num */
	va_start(arguments, num);
	/* Sum all the inputs; we still rely on the function caller to tell us how many there are*/
	for(int i = 0; i < num; ++i)
	{
		sum += va_arg(arguments, double);
	}
	va_end(arguments); // Cleans up the list
	
	return sum / num;
}

int main ()
{
	/* this computes the average of 12.2, 22.3 and 4.5 (3 indicates the number of values to average */
	printf("%f\n", average(3, 12.2, 22.3, 4.5));
	/* here it computes the average of the 5 values 3.3, 2.2, 1.1, 5.5 and 3.3 */
	printf("%f\n", average(5, 3.3, 2.2, 1.1, 5.5, 3.3));
	return 0;
}