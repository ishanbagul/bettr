package com.jstyle.test2025.activity;

import android.os.Bundle;
import android.view.View;


import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jstyle.blesdk2301x6.Util.BleSDK;
import com.jstyle.blesdk2301x6.constant.BleConst;
import com.jstyle.test2025.R;
import com.jstyle.test2025.adapter.OxyAdapter;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 自动测试血氧数据 (Automatically test blood oxygen data)
 */
public class Automatically_test_blood_oxygen_dataActivity extends BaseActivity {
    @BindView(R.id.RecyclerView_heartData)
    RecyclerView RecyclerViewHeartData;
    private OxyAdapter heartRateDataAdapter; ;
    byte ModeStart=0x00;       //开始获取数据 start getting data
    byte ModeContinue=0x02;    //继续读取数据 continue reading data
    byte ModeDelete=(byte) 0x99;//删除数据  delete data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autooxy_info);
        ButterKnife.bind(this);
        init();
    }
    private void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerViewHeartData.setLayoutManager(linearLayoutManager);
        heartRateDataAdapter = new OxyAdapter();
        RecyclerViewHeartData.setAdapter(heartRateDataAdapter);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        RecyclerViewHeartData.addItemDecoration(dividerItemDecoration);

    }

    @OnClick({R.id.GetAutomaticSpo2Monitoring, R.id.bt_DeleteDataGetAutomaticSpo2Monitoring})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.GetAutomaticSpo2Monitoring://获取自动测试血氧数据 Get automatic test blood oxygen data
                heartRateDataAdapter.Clear();
                sendValue(BleSDK.Oxygen_data(ModeStart,""));
                break;
            case R.id.bt_DeleteDataGetAutomaticSpo2Monitoring://删除自动测试血氧数据 Delete automatic test blood oxygen data
                heartRateDataAdapter.Clear();
                sendValue(BleSDK.Oxygen_data(ModeDelete,""));
                break;
        }
    }


    int dataCount=0;
    @Override
    public void dataCallback(Map<String, Object> maps) {
        super.dataCallback(maps);
        String dataType= getDataType(maps);
        boolean finish=getEnd(maps);
        switch (dataType){
            case BleConst.GetAutomaticSpo2Monitoring:
                heartRateDataAdapter.ADDData(maps.toString());
                dataCount++;
                if(finish){
                    dataCount=0;
                }
                if(dataCount==50){
                    dataCount=0;
                    if(finish){
                        disMissProgressDialog();
                    }else{
                        sendValue(BleSDK.Oxygen_data(ModeContinue,""));
                    }
                }
                break;
            case BleConst.Delete_Obtain_The_data_of_manual_blood_oxygen_test:
                heartRateDataAdapter.ADDData(maps.toString());
                break;

        }
    }


}
