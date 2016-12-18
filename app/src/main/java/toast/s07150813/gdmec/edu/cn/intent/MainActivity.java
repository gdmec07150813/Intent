package toast.s07150813.gdmec.edu.cn.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText edt1,edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
    }
    public void one(View v){
        Intent intent = new Intent(this,IntentDemo1.class);
        startActivity(intent);
    }
    public void two(View v){
        String action = "com.edu.gdmec";
        Intent intent = new Intent();
        intent.setAction(action);
        startActivity(intent);
    }
    public void openNet(View v){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(edt1.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }
    public void call(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:"+edt2.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }
    public void cf(View v){
        Bundle bundle = new Bundle();
        bundle.putString("dcf",edt1.getText().toString());
        Intent intent = new Intent(MainActivity.this,IntentDemo1.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
           Bundle bundle = data.getExtras();
            textView.setText(bundle.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
