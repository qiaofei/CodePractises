//
//  ViewController.swift
//  TestStaticTable
//
//  Created by Fei on 15/12/15.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import UIKit

class ViewController: UITableViewController {
    @IBOutlet weak var tfName: UITextField!
    
    @IBOutlet weak var tfPassword: UITextField!
    
    @IBAction func login(sender: AnyObject) {
        if(self.tfName.text == "feiye") &&
            (self.tfPassword == "111"){
                NSLog("登录成功")
                self.tfName.resignFirstResponder()
                
                    self.tfPassword.resignFirstResponder()
        }
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

