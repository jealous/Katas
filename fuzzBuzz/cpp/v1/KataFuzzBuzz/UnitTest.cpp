//
//  UnitTest.cpp
//  KataFuzzBuzz
//
//  Created by Cedric Zhuang on 4/17/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#include <iostream>

#include "gtest/gtest.h"
#include "FuzzBuzz.h"


int testMain(int argc, const char * argv[])
{
    testing::InitGoogleTest(&argc, const_cast<char **>(argv));
    return RUN_ALL_TESTS();
}