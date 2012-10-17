#include <stdio.h>
#define MAX 5

int main(int argc, char* argv[])
{
	/*printf("%s\n", argv[0]); */
	char hei[] = "hei!";
	printf("Stringen sier: \"%s\".\n", hei);
	
	for(int i = 0; i < MAX; ++i)
	{
		printf("   %c ", hei[i]);

	}
	
	printf("\n");
	
	for(int i = 0; i < MAX; ++i)
	{
		printf("0x%02x ", hei[i]);

	}
	
	printf("\n");
	
	return 0;
	
}