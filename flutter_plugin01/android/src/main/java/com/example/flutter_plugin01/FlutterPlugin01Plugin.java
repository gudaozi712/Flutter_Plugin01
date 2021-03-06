package com.example.flutter_plugin01;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterPlugin01Plugin */
public class FlutterPlugin01Plugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_plugin01");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else if(call.method.equals("getSDKINT")){

      result.success("Android API版本（int类型）：" + android.os.Build.VERSION.SDK_INT);

    } else if(call.method.equals("getBoard")){

      result.success("主板型号：" + android.os.Build.BOARD);

    } else if(call.method.equals("getBrand")){

      result.success("产品品牌（or系统制造商）：" + android.os.Build.BRAND);

    } else if(call.method.equals("getModel")){

      result.success("手机的型号/设备名称：" + android.os.Build.MODEL);

    } else if(call.method.equals("getCPUABI")){

      result.success("设备指令集名称（CPU的类型）：" + android.os.Build.CPU_ABI);

    } else {

      result.notImplemented();

    }


  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
