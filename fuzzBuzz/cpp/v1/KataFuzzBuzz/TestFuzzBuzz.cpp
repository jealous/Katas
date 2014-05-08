//
//  TestFuzzBuzz.cpp
//  KataFuzzBuzz
//
//  Created by Cedric Zhuang on 4/17/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#include <iostream>
#include "gtest/gtest.h"
#include "FuzzBuzz.h"

class TestFuzzBuzz : public ::testing::Test {
protected:
    virtual void SetUp() {
    }
    
public:
    FuzzBuzz fuzzBuzz;
};

TEST_F(TestFuzzBuzz, NormalNumber) {
    EXPECT_STREQ("4", fuzzBuzz.getAnswer(4).c_str());
    EXPECT_STREQ("101", fuzzBuzz.getAnswer(101).c_str());
}

TEST_F(TestFuzzBuzz, FuzzNumber) {
    EXPECT_STREQ("Fuzz", fuzzBuzz.getAnswer(3).c_str());
    EXPECT_STREQ("Fuzz", fuzzBuzz.getAnswer(42).c_str());
}

TEST_F(TestFuzzBuzz, FuzzNumberSpecial) {
    EXPECT_STREQ("Fuzz", fuzzBuzz.getAnswer(31).c_str());
    EXPECT_STREQ("Fuzz", fuzzBuzz.getAnswer(131).c_str());
}

TEST_F(TestFuzzBuzz, BuzzNumber) {
    EXPECT_STREQ("Buzz", fuzzBuzz.getAnswer(5).c_str());
    EXPECT_STREQ("Buzz", fuzzBuzz.getAnswer(95).c_str());
}

TEST_F(TestFuzzBuzz, BuzzNumberSpecial) {
    EXPECT_STREQ("Buzz", fuzzBuzz.getAnswer(512).c_str());
    EXPECT_STREQ("Buzz", fuzzBuzz.getAnswer(52).c_str());
}

TEST_F(TestFuzzBuzz, FuzzBuzzNumber) {
    EXPECT_STREQ("FuzzBuzz", fuzzBuzz.getAnswer(513).c_str());
    EXPECT_STREQ("FuzzBuzz", fuzzBuzz.getAnswer(35).c_str());
    EXPECT_STREQ("FuzzBuzz", fuzzBuzz.getAnswer(60).c_str());
}
