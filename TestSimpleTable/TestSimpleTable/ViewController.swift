//
//  ViewController.swift
//  TestSimpleTable
//
//  Created by Fei on 15/12/15.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import UIKit

class ViewController: UITableViewController {
    
    var listTeams :NSArray!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        let plistPath = NSBundle.mainBundle().pathForResource("team", ofType: "plist")
        self.listTeams = NSArray(contentsOfFile: plistPath!)
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    //重写tableview方法
    override func tableView(tableView: UITableView, indentationLevelForRowAtIndexPath indexPath: NSIndexPath) -> Int {
        return self.listTeams.count
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cellIdentifier = "CellIdentifier"
        
       var cell:UITableViewCell! = tableView.dequeueReusableCellWithIdentifier(cellIdentifier, forIndexPath:indexPath) as? UITableViewCell
//       
//        if(cell == nil){
//            cell = UITableViewCell(style: UITableViewCellStyle.Default, reuseIdentifier: cellIdentifier))
//        }
        let row = indexPath.row
        let rowDict = self.listTeams[row] as! NSDictionary
        
        cell.textLabel?.text = rowDict["name"] as? String
        
        let imagePath = NSString(format: "%@.png", rowDict["image"] as! String)
//        cell.imageView?.image = UIIMage(named: imagePath as String)
        cell.imageView?.image = UIImage(named:imagePath as String)
        cell.accessoryType = UITableViewCellAccessoryType.DisclosureIndicator
        
        return cell
    }
    
}

