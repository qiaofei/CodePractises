//
//  main.m
//  FirtOc
//
//  Created by Fei on 16/1/18.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Fraction.h"
//#import "Fraction.h"
int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // insert code here...
        Fraction *myFraction;
        myFraction = [Fraction alloc];
        myFraction = [myFraction init];
        [myFraction setNumberator:1];
        [myFraction setDenominator:3];
        [myFraction print];
//        NSLog(@"Hello, World!");
    }
    return 0;
}
