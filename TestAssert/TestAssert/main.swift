//
//  main.swift
//  TestAssert
//
//  Created by Fei on 15/12/24.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import Foundation
//assert 当条件为false的时候后面的表达式会被触发
//print("Hello, World!")
let a = 3
assert(a >= 0 , "wrong value")
//断言信息不能使用字符串插值,断言信息可以忽略
assert(a <= 0)
//只有当断言的条件为TRUE时,代码才会继续运行下去

