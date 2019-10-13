package edu.cmu.stuco.android.calculator;
/* Test */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button m9Button;
    private Button m8Button;
    private Button m7Button;
    private Button m6Button;
    private Button m5Button;
    private Button m4Button;
    private Button m3Button;
    private Button m2Button;
    private Button m1Button;
    private Button m0Button;
    private Button equalsButton;
    private Button plusButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextView mNumberTextView;
    private static String stringNum = "0";
    private static int strToInt;
    private static int firstNum;
    private static String lastOperPressed = "None";

    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX = "index";
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, strToInt); }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            strToInt = savedInstanceState.getInt(KEY_INDEX);
            stringNum = Integer.toString(strToInt);
        }
        mNumberTextView = (TextView) findViewById(R.id.calculated_text_view);
        mNumberTextView.setText(stringNum);
        m9Button = (Button) findViewById(R.id.button9);
        numUpdate(m9Button, "9");
        m8Button = (Button) findViewById(R.id.button8);
        numUpdate(m8Button, "8");
        m7Button = (Button) findViewById(R.id.button7);
        numUpdate(m7Button, "7");
        m6Button = (Button) findViewById(R.id.button6);
        numUpdate(m6Button, "6");
        m5Button = (Button) findViewById(R.id.button5);
        numUpdate(m5Button, "5");
        m4Button = (Button) findViewById(R.id.button4);
        numUpdate(m4Button, "4");
        m3Button = (Button) findViewById(R.id.button3);
        numUpdate(m3Button, "3");
        m2Button = (Button) findViewById(R.id.button2);
        numUpdate(m2Button, "2");
        m1Button = (Button) findViewById(R.id.button1);
        numUpdate(m1Button, "1");
        m0Button = (Button) findViewById(R.id.button0);
        numUpdate(m0Button, "0");
        equalsButton = (Button) findViewById(R.id.buttonEquals);
        plusButton = (Button) findViewById(R.id.buttonAdd);
        operUpdate(plusButton, "addition");
        subtractButton = (Button) findViewById(R.id.buttonSubtract);
        operUpdate(subtractButton, "subtraction");
        multiplyButton = (Button) findViewById(R.id.buttonMultiply);
        operUpdate(multiplyButton, "multiplication");
        divideButton = (Button) findViewById(R.id.buttonDivide);
        operUpdate(divideButton, "division");
        equalsButton = (Button) findViewById(R.id.buttonEquals);
        equalsUpdate(equalsButton);
    }
    public void numUpdate(final Button buttonName, final String num){
        buttonName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(lastOperPressed == "add" || lastOperPressed == "subtract" || lastOperPressed == "multiply" || lastOperPressed == "divide"){
                    if(firstNum == Integer.parseInt(mNumberTextView.getText().toString())){
                        mNumberTextView.setText("");
                    }
                }
                if(lastOperPressed == "Equals"){
                    mNumberTextView.setText("");
                    firstNum = 0;
                    lastOperPressed = "None";
                }
                if(mNumberTextView.getText().toString() == "Can't Divide by 0!"){
                    mNumberTextView.setText("0");
                }
                stringNum = mNumberTextView.getText().toString();
                stringNum = stringNum + num;
                strToInt = Integer.parseInt(stringNum);
                stringNum = Integer.toString(strToInt);
                mNumberTextView.setText(stringNum);
                if(lastOperPressed == "divide" & strToInt == 0){
                    mNumberTextView.setText("Can't Divide by 0!");
                    firstNum = 0;
                    lastOperPressed = "None";
                }
                Log.d(TAG, Integer.toString(firstNum));
            }
        });
    }
    public void operUpdate(final Button buttonName, final String opName){
        buttonName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(lastOperPressed == "add"){
                    firstNum = firstNum + strToInt;
                    mNumberTextView.setText(Integer.toString(firstNum));
                }
                else if(lastOperPressed == "subtract"){
                    firstNum = firstNum - strToInt;
                    mNumberTextView.setText(Integer.toString(firstNum));
                }
                else if(lastOperPressed == "multiply"){
                    firstNum = firstNum * strToInt;
                    mNumberTextView.setText(Integer.toString(firstNum));
                }
                else if(lastOperPressed == "divide"){
                    firstNum = firstNum / strToInt;
                    mNumberTextView.setText(Integer.toString(firstNum));
                }
                else if(lastOperPressed == "None" || lastOperPressed == "Equals"){
                    firstNum = Integer.parseInt(mNumberTextView.getText().toString());
                }
                if(opName == "addition"){
                    lastOperPressed = "add";
                }
                else if(opName == "subtraction"){
                    lastOperPressed = "subtract";
                }
                else if(opName == "multiplication"){
                    lastOperPressed = "multiply";
                }
                else if(opName == "division"){
                    lastOperPressed = "divide";
                }
            }
        });
    }
    public void equalsUpdate(final Button buttonName){
        buttonName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(lastOperPressed == "add"){
                    mNumberTextView.setText(Integer.toString(firstNum + strToInt));
                }
                else if(lastOperPressed == "subtract"){
                    mNumberTextView.setText(Integer.toString(firstNum - strToInt));
                }
                else if(lastOperPressed == "multiply"){
                    mNumberTextView.setText(Integer.toString(firstNum * strToInt));
                }
                else if(lastOperPressed == "divide"){
                    if(strToInt != 0) {
                        mNumberTextView.setText(Integer.toString(firstNum / strToInt));
                    }
                    else {
                        mNumberTextView.setText("Can't Divide by 0!");
                    }
                }
                lastOperPressed = "Equals";
            }
        });
    }

}
