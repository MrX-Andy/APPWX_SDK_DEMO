
package com.appwx.sdk.demo.appmsg;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.actionbarsherlock.app.SherlockActivity;
import com.appwx.sdk.appmsg.AppMsg;
import com.appwx.sdk.demo.R;


public class AppMsgActivity extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appmsg_main);
    }

    /**
     * Button onClick listener.
     * 
     * @param v
     */
    public void showAppMsg(View v) {
        final CharSequence msg = ((Button) v).getText();
        final AppMsg.Style style;
        switch (v.getId()) {
            case R.id.alert:
                style = AppMsg.STYLE_ALERT;
                break;
            case R.id.confirm:
                style = AppMsg.STYLE_CONFIRM;
                break;
            case R.id.info:
                style = AppMsg.STYLE_INFO;
                break;
            case R.id.custom:
                style = new AppMsg.Style(AppMsg.LENGTH_SHORT, R.color.custom);
                break;

            default:
                return;
        }

        // create {@link AppMsg} with specify type
        AppMsg appMsg = AppMsg.makeText(this, msg, style);
        if (((CheckBox) (findViewById(R.id.bottom))).isChecked()) {
            appMsg.setLayoutGravity(Gravity.BOTTOM);
        }
        appMsg.show();
    }

}
