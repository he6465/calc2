package myapplication.calc2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    EditText edit1, edit2;
    Button BtnAdd, BtnSub, BtnMul, BtnDiv, BtnElse;
    TextView TextResult;
    String num1, num2;
    Double Result;
    Button [] numBtns = new Button[10];
    Integer [] numBtnIDs = {R.id.num0, R.id.num1, R.id.num2, R.id.num3, R.id.num4,
            R.id.num5, R.id.num6, R.id.num7, R.id.num8, R.id.num9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("그리드 레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        BtnAdd = (Button) findViewById(R.id.BtnAdd);
        BtnSub = (Button) findViewById(R.id.BtnSub);
        BtnMul = (Button) findViewById(R.id.BtnMul);
        BtnDiv = (Button) findViewById(R.id.BtnDiv);
        BtnElse = (Button) findViewById(R.id.BtnElse);

        TextResult = (TextView) findViewById(R.id.TextResult);


        BtnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                Result = Double.parseDouble(num1) + Double.parseDouble(num2);
                TextResult.setText("계산결과 : " + Result.toString());
            }
        });

        BtnSub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                Result = Double.parseDouble(num1) - Double.parseDouble(num2);
                TextResult.setText("계산결과 : " + Result.toString());
            }
        });

        BtnMul.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                Result = Double.parseDouble(num1) * Double.parseDouble(num2);
                TextResult.setText("계산결과 : " + Result.toString());
            }
        });

        BtnDiv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                Result = Double.parseDouble(num1) / Double.parseDouble(num2);
                TextResult.setText("계산결과 : " + Result.toString());
            }
        });

        BtnElse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                Result = Double.parseDouble(num1) % Double.parseDouble(num2);
                TextResult.setText("계산결과 : " + Result.toString());
            }
        });


        for(i = 0; i < numBtnIDs.length; i++){
            numBtns[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(i = 0; i < numBtnIDs.length; i++){
            final int index;
            index = i;

            numBtns[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(edit1.isFocused() == true){
                        num1 = edit1.getText().toString()
                                + numBtns[index].getText().toString();
                        edit1.setText(num1);
                    }
                    else if(edit2.isFocused() == true){
                        num2 = edit2.getText().toString()
                                + numBtns[index].getText().toString();
                        edit2.setText(num2);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
