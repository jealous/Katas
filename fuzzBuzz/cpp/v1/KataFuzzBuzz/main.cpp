//
//  main.cpp
//  KataFuzzBuzz
//
//  Created by Cedric Zhuang on 4/14/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#include <iostream>

#include "boost/shared_ptr.hpp"
#include "gtest/gtest.h"
#include "FuzzBuzz.h"


int main(int argc, const char * argv[])
{
    using namespace std;
    FuzzBuzz fuzzBuzz;
    for (int i = 1 ; i < 101 ; i++){
        cout << fuzzBuzz.getAnswer(i) << "\t";
        if (i % 5 == 0){
            cout << endl;
        }
    }
    return 0;
}

