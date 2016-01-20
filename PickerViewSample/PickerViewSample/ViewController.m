//
//  ViewController.m
//  PickerViewSample
//
//  Created by Fei on 16/1/20.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    NSBundle *bundle = [NSBundle mainBundle];
    NSString *plistPath = [bundle pathForResource:@"provinces_cities" ofType:@"plist"];
    NSDictionary *dict = [[NSDictionary alloc]initWithContentsOfFile:plistPath];
    self.pickerData = dict;
    //获取省份名数据
    self.pickerProvincesData = [self.pickerData allKeys];
    //默认取出第一个省的所有市数据
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)click:(id)sender {
}
@end
