//
//  Fraction.h
//  FractionTes
//
//  Created by Fei on 16/1/18.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Fraction : NSObject
@property int numberator, denominator;
-(void) print;
//-(void) setNumberator: (int) n;
//-(void) setDenominator: (int) d;
//-(int) numberator;
//-(int) denominator;
-(void) setTo: (int) n over: (int) d;
-(double) comverToNumber;
@end
