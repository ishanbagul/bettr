package com.jstyle.test2025.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.jstyle.blesdk2301x6.Util.BleSDK;
import com.jstyle.blesdk2301x6.callback.DataListener2301;
import com.jstyle.blesdk2301x6.constant.DeviceKey;
import com.jstyle.test2025.R;
import com.jstyle.test2025.Util.BleData;
import com.jstyle.test2025.Util.RxBus;
import com.jstyle.test2025.ble.BleManager;
import com.jstyle.test2025.ble.BleService;


import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/26.
 */

public  class BaseActivity extends AppCompatActivity implements DataListener2301 {

    private Disposable subscription;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribe();
    }

    protected void subscribe(){
        subscription = RxBus.getInstance().toObservable(BleData.class).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<BleData>() {
            @Override
            public void accept(BleData bleData) throws Exception {
                String action = bleData.getAction();
                if (action.equals(BleService.ACTION_DATA_AVAILABLE)) {
                    byte[]value=bleData.getValue();
                    BleSDK.DataParsingWithData(value,BaseActivity.this);
                }

            }
        });
    }
    protected void unSubscribe(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unSubscribe(subscription);
    }

    protected void Baseunsubscribe(){
        unSubscribe(subscription);
    }
    protected void Gateaus(int count) { }
    @Override
    public void dataCallback(Map<String, Object> maps) {
        Log.e("info",maps.toString());
    }

    @Override
    public void dataCallback(byte[] value) {

    }


    /**
     * 当蓝牙设备是连接的状态，发送指令给设备
     * When the Bluetooth device is connected, send instructions to the device
     * @param value
     */
    protected void sendValue(byte[]value){
        if(!BleManager.getInstance().isConnected()){
            showToast(getString(R.string.pair_device));
            return;
        }
        if(value==null)return;
       BleManager.getInstance().writeValue(value);
    }
    protected void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    AlertDialog alertDialog=null;
    protected void showDialogInfo(String message){
        if(null==alertDialog){
            alertDialog=  new AlertDialog.Builder(this)
                    .setMessage(message).setPositiveButton("Ok",null).create();
            alertDialog.show();
        }else{
            alertDialog.dismiss();
            alertDialog=null;
            alertDialog=  new AlertDialog.Builder(this)
                    .setMessage(message).setPositiveButton("Ok",null).create();
            alertDialog.show();
        }

    }
    protected void showSetSuccessfulDialogInfo(String message){
        new AlertDialog.Builder(this)
                .setMessage(message+" Successful").setPositiveButton("Ok",null).create().show();
    }

    protected static String getDataType(Map<String, Object> maps){
        if(null==maps){
            return "";
        }
        return (String) maps.get(DeviceKey.DataType);
    }
    protected boolean getEnd(Map<String, Object> maps){
        return (boolean) maps.get(DeviceKey.End);
    }
    protected static Map<String, String> getData(Map<String, Object> maps){
        return (Map<String, String>) maps.get(DeviceKey.Data);
    }


    protected void offerData(byte[]value){
        BleManager.getInstance().offerValue(value);
    }
    protected void offerData(){

        BleManager.getInstance().writeValue();
    }
    protected void showProgressDialog(String message){
        if(progressDialog==null){
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage(message);
        }
        if(!progressDialog.isShowing())progressDialog.show();
    }
    protected void disMissProgressDialog(){
        if(progressDialog!=null&&progressDialog.isShowing())progressDialog.dismiss();
    }
}
