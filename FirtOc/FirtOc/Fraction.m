//
//  Fraction.m
//  FirtOc
//
//  Created by Fei on 16/1/18.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Fraction.h"

@implementation Fraction{
int numberator;
int denominate;
}
-(void) print{
    NSLog(@"%i/%i",numberator,denominate);
}
-(void) setNumberator: (int) n{
    numberator = n;
}
-(void) setDenominator: (int) d{
    denominate = d;
}
@end