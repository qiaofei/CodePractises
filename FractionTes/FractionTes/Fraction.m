//
//  Fraction.m
//  FractionTes
//
//  Created by Fei on 16/1/18.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import "Fraction.h"

@implementation Fraction
//{
//    int numberator;
//    int denominator;
//}
@synthesize numberator,denominator;
-(void) print{
    NSLog(@"%i/%i",numberator,denominator);
}
//-(void) setDenominator:(int)d{
//    denominator = d;
//}
//-(void) setNumberator:(int)n{
//    numberator = n;
//}
//-(int) denominator{
//    return denominator;
//}
//-(int) numberator{
//    return numberator;
//}
-(void) setTo:(int)n over:(int)d{
    numberator = n;
    denominator = d;
}
-(double) comverToNumber{
    if (denominator != 0) {
        return (double) numberator / denominator ;
    }
    else{
        return NAN;
    }
}
@end
