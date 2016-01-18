//
//  main.m
//  FractionTes
//
//  Created by Fei on 16/1/18.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Fraction.h"
int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // insert code here...
//        NSLog(@"Hello, World!");
        Fraction *myFraction = [Fraction new];
        [myFraction setNumberator:1];
        [myFraction setDenominator:3];
        [myFraction print];
    }
    return 0;
}
