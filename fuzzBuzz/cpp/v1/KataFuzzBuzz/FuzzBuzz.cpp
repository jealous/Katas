//
//  FuzzBuzz.cpp
//  KataFuzzBuzz
//
//  Created by Cedric Zhuang on 4/17/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include <string>
#include "boost/lexical_cast.hpp"
#include "FuzzBuzz.h"

std::string FuzzBuzz::getAnswer(int number)
{
    std::string retVal;
    bool isSpecial = false;
    GameRuler ruler;
    if (ruler.isFuzz(number)){
        retVal = "Fuzz";
        isSpecial = true;
    }
    if(ruler.isBuzz(number)){
        retVal += "Buzz";
        isSpecial = true;
    }
    if (!isSpecial){
        retVal = boost::lexical_cast<std::string>(number);
    }

    return retVal;
}

bool GameRuler::isFuzz(int number){
    bool retVal = false;
    if (number % 3 == 0){
        retVal = true;
    }else {
        retVal = isNumberContains(number, '3');
    }
    return retVal;
}

bool GameRuler::isBuzz(int number){
    bool retVal = false;
    if (number % 5 == 0){
        retVal = true;
    }else {
        retVal = isNumberContains(number, '5');
    }
    return retVal;
}

bool GameRuler::isNumberContains(int number,char c){
    bool retVal = false;
    std::string numberStr = boost::lexical_cast<std::string>(number);
    if (numberStr.find(c) != std::string::npos){
        retVal = true;
    }
    return retVal;
}
