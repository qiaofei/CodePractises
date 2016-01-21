//
//  ViewController.m
//  PageControlTest
//
//  Created by Fei on 16/1/21.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import "ViewController.h"

@interface ViewController () <UIScrollViewDelegate>
@property (weak, nonatomic) IBOutlet UIScrollView *scrollView;
@property (weak, nonatomic) IBOutlet UIPageControl *pageControl;
- (IBAction)changePage:(id)sender;
@property (strong,nonatomic) UIView *page1;
@property (strong,nonatomic) UIView *page2;
@property (strong,nonatomic) UIView *page3;
@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    self.scrollView.delegate = self;
    
    self.scrollView.contentSize = CGSizeMake(self.view.frame.size.width*3, self.scrollView.frame.size.height);
    self.scrollView.frame = self.view.frame;
    UIStoryboard *mainStoryboard = self.storyboard;
    
    UIViewController* page1ViewController = [mainStoryboard instantiateViewControllerWithIdentifier:@"page1"];
    self.page1 = page1ViewController.view;
    self.page1.frame = CGRectMake(0.0f, 0.0f, 320.0f, 420.0f);
    
    UIViewController* page2ViewController = [mainStoryboard instantiateViewControllerWithIdentifier:@"page2"];
    self.page2 = page1ViewController.view;
    self.page2.frame = CGRectMake(320.0f, 0.0f, 320.0f, 420.0f);
    
    UIViewController* page3ViewController = [mainStoryboard instantiateViewControllerWithIdentifier:@"page3"];
    self.page3 = page1ViewController.view;
    self.page3.frame = CGRectMake(2*320.0f, 0.0f, 320.0f, 420.0f);
    
    self.scrollView.delegate = self;
    [self.scrollView addSubview:self.page1];
    [self.scrollView addSubview:self.page2];
    [self.scrollView addSubview:self.page3];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)changePage:(id)sender {
}
@end
