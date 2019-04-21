package to.msn.wings.tokyogirlshackason;

import android.content.Intent;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
    public void selectAtsugariOrSamugari(View view) {
        android.content.Intent intent = new Intent(SettingActivity.this, AtsugariActivity.class);

        startActivity(intent);
    }

    public void selectClothes(View view){
        android.content.Intent intent = new Intent(SettingActivity.this, EnterActivity.class);

        startActivity(intent);
    }

    public void selectHansei(View view){
        android.content.Intent intent = new Intent(SettingActivity.this, HanseiActivity.class);

        startActivity(intent);
    }

    public void selectRegist(View view){
        android.content.Intent intent = new Intent(SettingActivity.this, CameraActivity.class);

        startActivity(intent);
    }
}
