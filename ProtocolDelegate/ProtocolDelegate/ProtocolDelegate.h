//
//  ProtocolDelegate.h
//  ProtocolDelegate
//
//  Created by Fei on 16/1/20.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol ProtocolDelegate <NSObject>
@required
-(void)error;
@optional
-(void)other;
-(void)other2;
-(void)other3;
@end
