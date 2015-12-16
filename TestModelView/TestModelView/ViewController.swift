//
//  ViewController.swift
//  TestModelView
//
//  Created by Fei on 15/12/16.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var asd: UITextField!
    @IBOutlet weak var txfUserName: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        NSNotificationCenter.defaultCenter().addObserver(self, selector: "registerCompletion", name: "RegistionCompletionNotification", object: nil)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    func registerCompletion(notification :NSNotification){
        let theData:NSDictionary = notification.userInfo!
        let username = theData.objectForKey("username") as! NSString
        NSLog("username = %@",username)
    }

}

