//
//  FuzzBuzz.h
//  KataFuzzBuzz
//
//  Created by Cedric Zhuang on 4/14/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#ifndef KataFuzzBuzz_FuzzBuzz_h
#define KataFuzzBuzz_FuzzBuzz_h

#include <string>
#include "boost/numeric/conversion/cast.hpp"
#include "boost/lexical_cast.hpp"

class FuzzBuzz
{
public:
    std::string getAnswer(int number);
};

class GameRuler
{
public:
    bool isFuzz(int number);
    bool isBuzz(int number);
private:
    bool isNumberContains(int number, char c);
};



#endif
