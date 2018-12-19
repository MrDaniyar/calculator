package daniyar.kalck;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView mTextView;
    private StringBuilder one = new StringBuilder("");
    private boolean colPoint = true;
    private int bracket = 0;
    private ScrollView scrollView;


    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButtonDivide;
    private Button mButtonAdd;
    private Button mButtonSubtract;
    private Button mButtonMultiply;
    private Button mButtonPoint;
    private Button mButtonDegree;
    private Button mButtonEqual;
    private Button mButtonDelete;
    private Button mButtonLeftBracket;
    private Button mButtonRightBracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setMovementMethod(new ScrollingMovementMethod());
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        mButton0 =(Button)findViewById(R.id.button0);

        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('0');
            }
        });

        mButton1 =(Button)findViewById(R.id.button1);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('1');
            }
        });

        mButton2 =(Button)findViewById(R.id.button2);

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('2');
            }
        });

        mButton3 =(Button)findViewById(R.id.button3);

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('3');
            }
        });

        mButton4 =(Button)findViewById(R.id.button4);

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('4');
            }
        });

        mButton5 =(Button)findViewById(R.id.button5);

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('5');
            }
        });

        mButton6 =(Button)findViewById(R.id.button6);

        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('6');
            }
        });

        mButton7 =(Button)findViewById(R.id.button7);

        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('7');
            }
        });

        mButton8 =(Button)findViewById(R.id.button8);

        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('8');
            }
        });

        mButton9 =(Button)findViewById(R.id.button9);

        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElement('9');
            }
        });

        mButtonAdd =(Button)findViewById(R.id.buttonAdd);

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addOperation('+');
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mButtonSubtract =(Button)findViewById(R.id.buttonSubtract);

        mButtonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addOperation('-');
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mButtonMultiply =(Button)findViewById(R.id.buttonMultiply);

        mButtonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addOperation('*');
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mButtonDivide =(Button)findViewById(R.id.buttonDivide);

        mButtonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addOperation('/');
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mButtonDegree =(Button)findViewById(R.id.buttonDegree);

        mButtonDegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addOperation('^');
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mButtonDelete = (Button)findViewById(R.id.buttonDelete);

        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteElement();
            }
        });

        mButtonPoint = (Button)findViewById(R.id.buttonPoint);

        mButtonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colPoint) {
                    if(one.length()==0) {
                        mTextView.setText(mTextView.getText() + ".");
                        one.append(".");
                        colPoint = false;
                    }
                    else if(whats(one.charAt(one.length() - 1))!=4){
                        mTextView.setText(mTextView.getText() + ".");
                        one.append(".");
                        colPoint = false;
                    }
                }
            }
        });

        mButtonLeftBracket = (Button)findViewById(R.id.buttonLeftBracket);

        mButtonLeftBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addOperation('(');
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mButtonRightBracket = (Button)findViewById(R.id.buttonRightBracket);

        mButtonRightBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addOperation(')');
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mButtonDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mTextView.setText("");
                one.delete(0,one.length());
                colPoint = true;
                bracket = 0;
                return false;
            }
        });

        mButtonEqual = (Button)findViewById(R.id.buttonEqual);

        mButtonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addOperation('=');
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollTo(0, scrollView.getHeight());
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }



    private void addElement(char e){
        if(one.length()==0) {
            mTextView.setText(mTextView.getText() + "" + e);
            one.append(e);
        }
        else if(whats(one.charAt(one.length() - 1))!=4){
            mTextView.setText(mTextView.getText() + "" + e);
            one.append(e);
        }
    }

    private void deleteElement(){
        StringBuilder deleteElement = new StringBuilder("");
        if (one.length()!=0) {
            deleteElement.append((mTextView.getText()).toString());
            char a = deleteElement.charAt(deleteElement.length()-1);
            if (a == ')')bracket++;
            else if (a == '(')bracket--;
            if (a == '.')colPoint = true;
            deleteElement.delete(deleteElement.length() - 1, deleteElement.length());
            mTextView.setText(deleteElement.toString());
            one.delete(one.length()-1,one.length());
        }
    }

    private int whats(char e){
        if(one.length()!=0) {
            if (e == '0' || e == '1' || e == '2' || e == '3' || e == '4' || e == '5' || e == '6' || e == '7' || e == '8' || e == '9') return 1;
            if (e == '*' || e == '/' || e == '^') return 2;
            if (e == ')') return 4;
            if (e == '(') return 5;
            if (e == '+') return 6;
        }
        return 0;
    }

    private int whatElement(char e, char er){
        if(one.length()!=0) {
            if (e == '0' || e == '1' || e == '2' || e == '3' || e == '4' || e == '5' || e == '6' || e == '7' || e == '8' || e == '9') return 1;
            if (e == '*' || e == '/' || e == '^') return 2;
            if (e == ')') return 4;
            if (e == '(') return 5;
            if (e == '+') return 6;
        }
        else if(er=='-'){
            if (one.length() == 0) {
                return 9;
            } else if (one.length() == 1 && whats(e) == 5) {
                return 9;
            } else if (one.length() > 1 && (whats(e) == 2 || whats(e) == 5)) {
                return 9;
            } else return 3;
        }
        return 0;
    }

    private void appEnd(char e){
        if(one.length()!=0){
            int o = whatElement(one.charAt(one.length() - 1), e);

            /*if(one.length()>1 &&e=='-' && whats(one.charAt(one.length() - 1))==2){
                mTextView.setText(mTextView.getText() + "" + e);
                one.append(e);
                colPoint = true;
            } постановка минуса после * / ^
            else */
            if (o == 1 || o == 4) {
                mTextView.setText(mTextView.getText() + "" + e);
                one.append(e);
                colPoint = true;
            } else if (o == 2 || o == 6) {
                deleteElement();
                mTextView.setText(mTextView.getText() + "" + e);
                one.append(e);
                colPoint = true;
            }
            if(o==5 && e=='-'){
                mTextView.setText(mTextView.getText() + "0" + e);
                one.append(0);
                one.append(e);
                colPoint = true;
            }
            if(one.length()>1){
                //замена для минуса ( ) ,число )
                if(whats(one.charAt(one.length() - 2))==4 || whats(one.charAt(one.length() - 2))==1) {
                    deleteElement();
                    mTextView.setText(mTextView.getText() + "" + e);
                    one.append(e);
                    colPoint = true;
                }
            }
        }
        else{
            if(whatElement(e,e)==9) {
                mTextView.setText(mTextView.getText() + "0" + e);
                one.append(0);
                one.append(e);
                colPoint = true;
            }
        }
    }

    private void addOperation(char e) throws Exception {
        //новый код
        switch (e){
            case '+':{
                appEnd(e);
                break;
            }
            case '-':{
                appEnd(e);
                break;
            }
            case '*':{
                appEnd(e);
                break;
            }
            case '/':{
                appEnd(e);
                break;
            }
            case '^':{
                appEnd(e);
                break;
            }
            case '=':{
                if(bracket!=0) {
                    mTextView.setText(mTextView.getText() + " = " + "Не закрытая скобка\n\n");
                    bracket = 0;
                    one.delete(0, one.length());
                    colPoint = true;
                }else if(one.length()!=0) {
                    if((one.length()>=1 && one.charAt(one.length()-1) != '-') && one.charAt(one.length()-1)!='.') {
                        ExpressionUtils expressionUtils = new ExpressionUtils(one.toString());
                        String answer = expressionUtils.answer();
                        mTextView.setText(mTextView.getText() + "=" + answer + "\n\n");
                        one.delete(0, one.length());
                        colPoint = true;
                        bracket = 0;
                    }
                }
                break;
            }
            case '(':{
                if(one.length()==0){
                    mTextView.setText(mTextView.getText() + "" + e);
                    one.append(e);
                    colPoint=true;
                    bracket++;
                }
                else {
                    int o=whatElement(one.charAt(one.length() - 1),e);
                    if ((o == 2 || o == 3 || o == 5 || o == 6 || o == 9 || o==0) && one.charAt(one.length() - 1)!='.'){
                        //если удалить &&, то можно использовать числа 0.(3) вместо 0.333
                        mTextView.setText(mTextView.getText() + "" + e);
                        one.append(e);
                        colPoint=true;
                        bracket++;
                    }
                }
                break;
            }
            case ')':{
                if(one.length()!=0) {
                    int o=whatElement(one.charAt(one.length() - 1),e);
                    if ((o == 1 || o == 4) && bracket > 0) {
                        mTextView.setText(mTextView.getText() + "" + e);
                        one.append(e);
                        colPoint = true;
                        bracket--;
                    }
                }
                break;
            }
        }
    }
}
