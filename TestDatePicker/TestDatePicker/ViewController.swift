//
//  ViewController.swift
//  TestDatePicker
//
//  Created by Fei on 15/12/14.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var lable1: UILabel!
    
    @IBOutlet weak var datepicker1: UIDatePicker!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func onclick(sender:UIDatePicker){
        var theDate : NSDate = self.datepicker1.date
        let desc = theDate.descriptionWithLocale(NSLocale.currentLocale())
        var dateFormatter : NSDateFormatter = NSDateFormatter()
        dateFormatter.dateFormat = "YYYY-MM-dd HH:mm:ss"
        self.lable1.text = dateFormatter.stringFromDate(theDate)
        
    }

}

