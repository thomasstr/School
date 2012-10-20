#include <stdio.h>

int main()
{

vector<vector<int> > object = new vector<vector<int> >(500);
for(int i = 0; i < 500; ++i)
 {

   object[i] = new vector<int>(10000);
   for(int j = 0; j < 10000; ++j)
  {
     object[i][j] = rand();
  }
}

vector<vector<int> > object = new vector<vector<int> >(500);
for(int i = 0; i < 500; ++i)
{

  for(int j = 0; j < 10000; ++j)
  {
     object[i].push_back(rand());
   }
}

vector<vector<int> > object = new vector<vector<int> >();
for(int i = 0; i < 500; ++i)
{

  object.push_back(new vector<int>())

   for(int j = 0; j < 10000; ++j)
   {
     object[i].push_back(rand());
   }
}

	return 0;
}