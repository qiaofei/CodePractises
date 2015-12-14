//
//  ViewController.swift
//  TestFirst
//
//  Created by Fei on 15/12/9.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    var clickTimes = 0 ;
    @IBOutlet weak var lable1: UILabel!
    
    @IBAction func onClick(sender: AnyObject) {
        clickTimes++
        self.lable1.text = "clicked \(clickTimes) times"
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

