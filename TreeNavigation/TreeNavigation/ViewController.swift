//
//  ViewController.swift
//  TreeNavigation
//
//  Created by Fei on 15/12/17.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import UIKit

class ViewController: UITableViewController {

    var dictData: NSDictionary!
    var listData: NSArray!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        self.tableView.delegate = self
        self.tableView.dataSource = self
        let plistPath = NSBundle.mainBundle()
            .pathForResource("provinces_cities", ofType: "plist")
        self.dictData = NSDictionary(contentsOfFile: plistPath!)
        self.listData = self.dictData.allKeys as NSArray
        self.title = "省份信息"
    }
    
    override func tableView(tableView: UITableView, indentationLevelForRowAtIndexPath indexPath: NSIndexPath) -> Int {
        return self.listData.count
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cellIdentifier = "CellIdentifier"
        
        var cell:UITableViewCell! = tableView.dequeueReusableCellWithIdentifier(cellIdentifier,forIndexPath: indexPath) as? UITableViewCell
        
        let row = indexPath.row
        cell.textLabel?.text = self.listData[row] as! NSString as String
        
        return cell
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if(segue.identifier == "ShowSelectedProvince"){
        let citiesViewController = segue.destinationViewController as! CitiesTableViewController
        
        let indexPath = self.tableView.indexPathForSelectedRow as NSIndexPath?
        let selectedIndex = indexPath!.row
            let selectName = self.listData[selectedIndex] as! String
            citiesViewController.listData = self.dictData[selectName] as! NSArray
            citiesViewController.title = selectName
        }
    }

}

