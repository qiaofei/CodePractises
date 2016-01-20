//
//  ViewController.m
//  ToolBarSample
//
//  Created by Fei on 16/1/20.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
@property (weak, nonatomic) IBOutlet UILabel *lbShow;
- (IBAction)save:(id)sender;
- (IBAction)open:(id)sender;
- (IBAction)done:(id)sender;
- (IBAction)edit:(id)sender;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)save:(id)sender {
    self.lbShow.text = @"save";
}

- (IBAction)open:(id)sender {
    self.lbShow.text = @"open";
}

- (IBAction)done:(id)sender {
    self.lbShow.text = @"done";
}

- (IBAction)edit:(id)sender {
    self.lbShow.text = @"edit";
}

@end
