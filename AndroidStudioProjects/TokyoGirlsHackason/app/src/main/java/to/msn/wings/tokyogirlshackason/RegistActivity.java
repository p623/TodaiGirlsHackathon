package to.msn.wings.tokyogirlshackason;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Camera;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class RegistActivity extends AppCompatActivity {

    RadioGroup mRadioGroup_;
    String type_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        // 次のアイテム登録ボタンとメニューへ戻るボタンを押せなくする
        Button nextButton = (Button)findViewById(R.id.button4);
        nextButton.setEnabled(false);
        Button returnMenuButton = (Button)findViewById(R.id.button3);
        returnMenuButton.setEnabled(false);

        // RadioGroupをメンバ変数に保存しておく
        mRadioGroup_ = (RadioGroup)findViewById(R.id.RadioGroup1);
        mRadioGroup_.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                        // どれも選択されていなければidには-1が入ってくる
                        CharSequence checkText = ((RadioButton)findViewById(checkedId)).getText();
                        type_ = checkText.toString();
                    }
                }
        );
    }

    public void regist(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("temp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.RadioGroup1);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        String checkText = ((RadioButton)findViewById(checkedId)).getText().toString();

        //服の画像の取得
        Intent intent =getIntent();
        String Fuku=intent.getStringExtra("uri");

        // 登録件数を取得
        String registNumStr = sharedPreferences.getString("登録件数", "0");
        int registNum = Integer.parseInt(registNumStr);
        registNum++;
        editor.putString("登録件数", String.valueOf(registNum));
        editor.putString("服" + String.format("%05d", registNum) + "カテゴリ", checkText);
        editor.putString("服" + String.format("%05d", registNum) + "ファイルパス", Fuku);

        TextView textview = (TextView)findViewById(R.id.textView2);
        textview.setText(checkText + " を登録しました");

        // 登録ボタンを押せなくする
        Button registButton = (Button)findViewById(R.id.button2);
        registButton.setEnabled(false);

        // 次のアイテム登録ボタンとメニューへ戻るボタンを表示
        Button nextButton = (Button)findViewById(R.id.button4);
        nextButton.setEnabled(true);
        Button returnMenuButton = (Button)findViewById(R.id.button3);
        returnMenuButton.setEnabled(true);
     }

//     public void returnMenu(View view) {
//         Intent intent =  new Intent(getApplication(), SettingActivity.class);
//         startActivity(intent);
//     }


     public void nextRegist(View view) {
         Intent intent =  new Intent(getApplication(), CameraActivity.class);
         startActivity(intent);
     }

     public void goMenu(View view){
         Intent intent =  new Intent(RegistActivity.this, SettingActivity.class);
         startActivity(intent);
     }

}
