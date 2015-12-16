//
//  RegisterViewController.swift
//  TestModelView
//
//  Created by Fei on 15/12/16.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import UIKit

class RegisterViewController: UIViewController {

    @IBOutlet weak var txfUserName: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
       
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func save(sender :AnyObject){
    
        self.dismissViewControllerAnimated(true){
        () -> Void in
            NSLog("点击save按钮,关闭模态试图")
            let dataDict = NSDictionary(object: self.txfUserName, forKey: "username")
            
            NSNotificationCenter.defaultCenter().postNotificationName("RegisterCompleteNotification", object: nil,userInfo: dataDict as [NSObject : AnyObject])
        }
    }
    @IBAction func cancle(sender: AnyObject){
        self.dismissViewControllerAnimated(true, completion: {
        NSLog("点击cancle按钮,关闭模态视图")
        })
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
