package com.yeqiu.hydra.view.activity;

import android.view.View;
import android.widget.TextView;

import com.yeqiu.hydra.R;
import com.yeqiu.hydra.utils.UIHelper;
import com.yeqiu.hydra.view.dialog.BottomDialog;
import com.yeqiu.hydra.view.dialog.CommonDialog;
import com.yeqiu.hydra.view.dialog.DialogListener;
import com.yeqiu.hydra.view.dialog.EditDialog;
import com.yeqiu.hydra.view.dialog.ListDialog;
import com.yeqiu.hydra.view.dialog.SheetDialog;
import com.yeqiu.hydra.view.dialog.TipDialog;
import com.yeqiu.hydra.view.dialog.model.ListData;

import java.util.ArrayList;
import java.util.List;

/**
 * @project：HailHydra
 * @author：小卷子
 * @date 2019/7/10
 * @describe：
 * @fix：
 */
public class DialogActivity extends BaseActivity {

    TextView tvDialogCmmon1;
    TextView tvDialogCmmon2;
    TextView tvDialogEdit;
    TextView tvDialogSheet;
    TextView tvDialogLoading;
    TextView tvDialogTip;
    TextView tvDialogList;
    TextView tvDialogBottom;

    @Override
    protected Object getContentView() {
        return R.layout.activity_dialog;
    }

    @Override
    protected void initView() {
        setHeaderTitle("ios风格的dialog");

        tvDialogCmmon1 = (TextView) findViewById(R.id.tv_dialog_cmmon_1);
        tvDialogCmmon2 = (TextView) findViewById(R.id.tv_dialog_cmmon_2);
        tvDialogEdit = (TextView) findViewById(R.id.tv_dialog_edit);
        tvDialogSheet = (TextView) findViewById(R.id.tv_dialog_sheet);
        tvDialogLoading = (TextView) findViewById(R.id.tv_dialog_loading);
        tvDialogTip = (TextView) findViewById(R.id.tv_dialog_tip);
        tvDialogList = (TextView) findViewById(R.id.tv_dialog_list);
        tvDialogBottom = (TextView) findViewById(R.id.tv_dialog_bottom);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        tvDialogCmmon1.setOnClickListener(this);
        tvDialogCmmon2.setOnClickListener(this);
        tvDialogEdit.setOnClickListener(this);
        tvDialogSheet.setOnClickListener(this);
        tvDialogLoading.setOnClickListener(this);
        tvDialogTip.setOnClickListener(this);
        tvDialogList.setOnClickListener(this);
        tvDialogBottom.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_dialog_cmmon_1:

                new CommonDialog(DialogActivity.this)
                        .build()
                        .setTitleText("测试标题")
                        .setDescText("测试内容")
                        .setOnDialogListener(new DialogListener() {
                            @Override
                            public void onConfirmClick() {
                                super.onConfirmClick();
                                UIHelper.showToast("确定");
                            }

                            @Override
                            public void onCanceclClick() {
                                super.onCanceclClick();
                                UIHelper.showToast("取消");
                            }
                        })
                        .show();
                break;

            case R.id.tv_dialog_cmmon_2:

                new CommonDialog(DialogActivity.this)
                        .build()
                        .setTitleText("测试标题")
                        .setDescText("测试内容")
                        .setJustConfirm(true)
                        .setOnDialogListener(new DialogListener() {
                            @Override
                            public void onConfirmClick() {
                                super.onConfirmClick();
                                UIHelper.showToast("确定");
                            }

                        })
                        .show();
                break;

            case R.id.tv_dialog_edit:

                new EditDialog(DialogActivity.this)
                        .build()
                        .setCanceledOnTouchOutside(true)
                        .setTitleText("测试标题")
                        .setDescText("测试内容")
                        .setOnDialogListener(new DialogListener() {
                            @Override
                            public void onConfirmClick(String inputText) {
                                super.onConfirmClick();
                                UIHelper.showToast(inputText);
                            }

                            @Override
                            public void onCanceclClick(String inputText) {
                                super.onCanceclClick();
                                UIHelper.showToast(inputText);
                            }

                            @Override
                            public void onDialogDismiss() {
                                super.onDialogDismiss();

                            }
                        })
                        .show();

                break;

            case R.id.tv_dialog_sheet:

                List<String> items = new ArrayList<>();
                items.add("我走中路");
                items.add("我打野");
                items.add("我打ADC");

                new SheetDialog(DialogActivity.this)
                        .build()
                        .setSheetDatas(items)
                        .setTitleText("标题")
                        .setOnDialogListener(new DialogListener() {
                            @Override
                            public void onItemClick(int position, String text) {
                                UIHelper.showToast(text);
                            }
                        })
                        .show();

                break;

            case R.id.tv_dialog_loading:

                new TipDialog(DialogActivity.this)
                        .build()
                        .setTipText("正在加载")
                        .setIconId(R.drawable.icon_load)
                        .setOrientationHorizontal(false)
                        .setIsLoading(true)
                        .setDismissTime(3000)
                        .show();

                break;

            case R.id.tv_dialog_tip:

                new TipDialog(DialogActivity.this)
                        .build()
                        .setTipText("提示")
                        .setIconId(R.drawable.icon_done)
                        .setOrientationHorizontal(false)
                        .setIsLoading(false)
                        .show();

                break;

            case R.id.tv_dialog_list:

                List<ListData> data = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    ListData listData = new ListData("上单送人头 " + i,
                            "");
                    data.add(listData);
                }


                new ListDialog(DialogActivity.this)
                        .build()
                        .setTitleText("啦啦啦啦")
                        .setListDatas(data)
                        .setBackImg(R.drawable.head_back_gray)
                        .setListMaxHeightWhitItem(5)
                        .setOnDialogListener(new DialogListener() {
                            @Override
                            public void onItemClick(int position, String text) {
                                super.onItemClick(position, text);
                                UIHelper.showToast(text);
                            }
                        })
                        .show();

                break;

            case R.id.tv_dialog_bottom:

                List<String> items2 = new ArrayList<>();
                items2.add("我走中路");
                items2.add("我打野");
                items2.add("我打ADC");

                new BottomDialog(DialogActivity.this)
                        .build()
                        .setSheetDatas(items2)
                        .setTitleText("标题")
                        .setOnDialogListener(new DialogListener() {
                            @Override
                            public void onItemClick(int position, String text) {
                                UIHelper.showToast(text);
                            }
                        })
                        .show();
                break;

            default:
                break;
        }
    }
}