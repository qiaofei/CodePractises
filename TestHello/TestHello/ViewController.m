//
//  ViewController.m
//  TestHello
//
//  Created by Fei on 16/1/20.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
- (IBAction)btnAdd:(id)sender;

- (IBAction)btnSave:(id)sender;
@property (weak, nonatomic) IBOutlet UILabel *lbShowMsg;

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

- (IBAction)btnAdd:(id)sender {
    self.lbShowMsg.text = @"点击add";
}

- (IBAction)btnSave:(id)sender {
    self.lbShowMsg.text = @"点击save";
}
@end
