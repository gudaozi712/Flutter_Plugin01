
import 'dart:async';

import 'package:flutter/services.dart';

class FlutterPlugin01 {
  static const MethodChannel _channel =
      const MethodChannel('flutter_plugin01');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }



  static Future<String> get sdkInt async {

    final String version = await _channel.invokeMethod('getSDKINT');

    return version;

  }



  static Future<String> get board async {

    final String version = await _channel.invokeMethod('getBoard');

    return version;

  }



  static Future<String> get brand async {

    final String version = await _channel.invokeMethod('getBrand');

    return version;

  }



  static Future<String> get model async {

    final String version = await _channel.invokeMethod('getModel');

    return version;

  }



  static Future<String> get cpuABI async {

    final String version = await _channel.invokeMethod('getCPUABI');

    return version;

  }





}
