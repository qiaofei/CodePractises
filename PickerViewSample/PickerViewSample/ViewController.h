//
//  ViewController.h
//  PickerViewSample
//
//  Created by Fei on 16/1/20.
//  Copyright © 2016年 WangQiaoFei. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
<UIPickerViewDelegate,UIPickerViewDataSource>
@property (weak, nonatomic) IBOutlet UIPickerView *pickerView;
@property (nonatomic,strong)NSDictionary *pickerData;
@property (nonatomic,strong)NSArray *pickerProvincesData;
@property (nonatomic,strong)NSArray *pickerCitiesData;
@property (weak, nonatomic) IBOutlet UILabel *label;
- (IBAction)click:(id)sender;
@end

