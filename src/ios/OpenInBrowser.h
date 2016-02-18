/********* OpenInBrowser.h Cordova Plugin Header *******/

#import <Cordova/CDV.h>

@interface OpenInBrowser : CDVPlugin

- (void)openUrl:(CDVInvokedUrlCommand*)command;

@end