//
//  ViewController.swift
//  TestSwitch
//
//  Created by Fei on 15/12/14.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var RightSwift: UISwitch!
    @IBOutlet weak var LeftSwift: UISwitch!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func switchValueChanged(sender: AnyObject){
    var witchSwitch = sender as! UISwitch
        var setting = witchSwitch.on
        self.LeftSwift.setOn(setting, animated:true)
        self.LeftSwift.setOn(setting, animated:true)
        
    }

}

