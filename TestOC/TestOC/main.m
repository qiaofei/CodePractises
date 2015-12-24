//
//  main.m
//  TestOC
//
//  Created by Fei on 15/12/23.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

#import <Foundation/Foundation.h>

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        BOOL isTrrue = true;
        int i = 10 ;
        // insert code here...
        if (isTrrue) {
            NSLog(@"is ture %d" );
        }
        else{
            NSLog(@"is false");
        }
        NSLog(@"Hello, World!");
//        print("hello word");
    }
    return 0;
}

//双引号的前面的@表示这双引号中的字符串应该作为cocoa的NSString元素来处理
