//
//  DetailViewController.swift
//  TreeNavigation
//
//  Created by Fei on 15/12/17.
//  Copyright © 2015年 WangQiaoFei. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController,UIWebViewDelegate{

    @IBOutlet weak var showWebView: UIWebView!
    var url: NSString!
    
    override func viewDidLoad() {
        super.viewDidLoad()

//        let url = NSURL(string: self.url)
//        let request = NSURL (URL :url!)
//        self.showWebView.loadRequest(request)
//        self.showWebView.delegate = self
        
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func webViewDidFinishLoad(webView: UIWebView) {
        NSLog("finish")
    }
    func webView(webView: UIWebView, didFailLoadWithError error: NSError?) {
//        NSLog("error : %@", error)
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
