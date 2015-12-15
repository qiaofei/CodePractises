//
//  main.swift
//  TestYuanZu
//
//  Created by Fei on 15/12/15.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import Foundation

//print("Hello, World!")
//带参数为int数组的函数
func SumOf(numbers: Int...) ->Int{
    //遍历参数数组,将其叠加
    var sum = 0
    for number in numbers {
    sum += number
    }
 return sum
}

//打印
print(SumOf(1,2,3,4,5))
