# AccessibilityService upgrade does not reload AccessibilityServiceInfo

TL/DR.
The upgraded accessibility service does not take new values in the xml configuration file.
The canPerformGestures capability is added to the upgraded xml however the upgraded
service has the same capabilities (i.e. no gestures) as the original service.
 
## Actors
Android 10 running on a Pixel XL
This repo's APK sample code

## Severity / Impact
High commercial impact: We currently have our APK deployed to over 10,000 devices globally; if the service cannot be reliably upgraded this means we need to support the entire customer base! The application itself will cease functioning and potential loss of earning is significant.

## Sample apk
https://github.com/pnovapps/TestService2

## Steps to Reproduce:
Edit the signingConfig, versionCode and accessibilityservice.xml to build the two apks below
Build the version 1 apk without android:canPerformGestures="true" in the accessibililityservice.xml file
Build the version 2 apk with android:canPerformGestures="true" in the accessibililityservice.xml file
Clean install and activate apk 1, check the logcat to verify that canPerformGestures=false
Clean install and activate apk 2, check the logcat to verify that canPerformGestures=true
Clean install and activate apk1, upgrade to apk 2, check the logcat to verify that canPerformGestures=false

## Expected output
After upgrading the gesture flag and service capability should be  canPerformGestures=true

## Current output
After upgrading the gesture flag and service capability remains canPerformGestures=false

## Android bug report, apks and logcats 
https://drive.google.com/drive/folders/1xQPmSv4J2J6tEzPoAhK1liIDa0DHGM9C?usp=sharing

## Screen Record of the Issue
N/A There is no user interface, all relevant information can be found in the logcat output
