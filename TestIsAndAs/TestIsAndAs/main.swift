//
//  main.swift
//  TestIsAndAs
//
//  Created by Fei on 15/12/19.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import Foundation

//print("Hello, World!")
//类型检查符 is 用于检查一个实例是否属于特定类型
//定义一个
//let Data = [
    let dataString: String = "asd"
    let dataInt: Int = 10
    let dataFloat: Float = 11
//]
if dataInt is Int{
    print("dataInt is Integer")
}
else{
print("dataInt is not Integer")
}
//as表示向下转型
var things = [Any]()
things.append(0)
things.append(0.0)
things.append(42)
things.append(3.14159)
things.append("hello")
things.append((3.0, 5.0))
//things.append(Movie(name: "Ghostbusters", director: "Ivan Reitman"))

for thing in things {
    switch thing {
    case 0 as Int:
        print("zero as an Int")
    case 0 as Double:
        print("zero as a Double")
    case let someInt as Int:
        print("an integer value of \(someInt)")
    case let someDouble as Double where someDouble > 0:
        print("a positive double value of \(someDouble)")
    case is Double:
        print("some other double value that I don't want to print")
    case let someString as String:
        print("a string value of \"\(someString)\"")
    case let (x, y) as (Double, Double):
        print("an (x, y) point at \(x), \(y)")
//    case let movie as Movie:
//        println("a movie called '\(movie.name)', dir. \(movie.director)")
    default:
        print("something else")
    }
}
