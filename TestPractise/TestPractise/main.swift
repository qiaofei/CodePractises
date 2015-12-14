//
//  main.swift
//  TestPractise
//
//  Created by Fei on 15/12/3.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import Foundation

let a = 90
var b = 120
let c: Float = 70
let str = "seventy is "
let str2 = str + String(c)

//print (a + b)
//print (str2)
//print("i have \(b) apples")
//数字与循环
let test = [1,2,3,4,5,6,7,8,9]
for num in test{
    //    print(num > 5 ? "yes" : "no")
    if num > 5 {
        //    print ("\(num) > 5")
    }
    else {
        //    print ("\(num) <= 5")
    }
}
//字典
let testDic = [
    "1" :[1,11,111,1111],
    "2" :[2,22,222,2222],
    "3" :[3,33,333,3333]
]
for (key , numbers) in testDic
{
    //print(key + " :" )
    for number in numbers{
        //    print(number)
    }
}
//test ..
for i in 0...3{
    //    print(i)
}
//函数
func greet(name:String , day:String) -> String {
    return "hello \(name), today is \(day)"
}
//greet("qiaofei", day: "monday")
//print(greet("FeiYe" , day: "Monday"))
//返回元组的函数
func getGasPrice() -> (Double,Double,Double){
    return (3.21,1.23,4.67)
}
//多参数
func sumOf(numbers: Int...) -> Int{
    var sum = 0
    for number in numbers{
        print(number)
        sum += number
    }
    return sum
}
//print(sumOf(1,2,3,4,5,6,7,8,9))
//嵌套函数
func returnFifteen() -> Int{
    var y = 10
    func add(){
        y += 5
    }
    add()
    return y
}
//print(returnFifteen())
//函数作为返回值,作为另一个函数的参数
//类的写法
class AppleShaped{
    var numberOfSides = 1
    var name : String
    init(name:String){
        self.name = name
    }
    func simpleDes(){
//        print("\(name) has \(numberOfSides) sides")
    }
}
var shape = AppleShaped(name:"Apple")
shape.numberOfSides = 2
shape.simpleDes()
//class getter and setter的用法

class Triagle :AppleShaped{
    var slideLength = 0.0
    
    init(name: String,slideLength:Double) {
        self.slideLength = slideLength
        //        self.name = name
        super.init(name: name)
        numberOfSides = 3
    }
    var perimeter: Double{
        get{
            return 3.0 * slideLength
        }
        set{
            slideLength = newValue/3.0
        }
    }
    override func simpleDes() {
//        print("an triagle has \(numberOfSides) slides and length is \(slideLength)")
    }
}

var triagle = Triagle(name: "triagle",slideLength: 4.0)
triagle.simpleDes()
//print(triagle.perimeter)
triagle.perimeter = 9.9
//print()
//print(triagle.slideLength)

//接口

protocol ExampleProtocol{
    var simpleDescription:String{get}
    mutating func adjust()->String
}

class TestProtocol :ExampleProtocol{
    var simpleDescription :String  = "a very simple class"
    var anotherProperty :Int = 1920
    func adjust() ->String{
        return simpleDescription + "now 100% adjusted."
    }
}
var testProtocol = TestProtocol()
print(testProtocol.adjust())

//泛型
