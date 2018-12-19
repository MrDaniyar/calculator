package daniyar.kalck;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;


public class MainActivity extends Activity {

    @BindView(R.id.textView) TextView mTextView;
    @BindView(R.id.scrollView) ScrollView scrollView;

    private StringBuilder one = new StringBuilder();
    private boolean colPoint = true;
    private int bracket = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button0)
    void setBtn0(){
        addElement('0');
    }

    @OnClick(R.id.button1)
    void setBtn1() {
        addElement('1');
    }

    @OnClick(R.id.button2)
    void setBtn2() {
        addElement('2');
    }

    @OnClick(R.id.button3)
    void setBtn3() {
        addElement('3');
    }

    @OnClick(R.id.button4)
    void setBtn4() {
        addElement('4');
    }

    @OnClick(R.id.button5)
    void setBtn5() {
        addElement('5');
    }

    @OnClick(R.id.button6)
    void setBtn6() {
        addElement('6');
    }

    @OnClick(R.id.button7)
    void setBtn7() {
        addElement('7');
    }

    @OnClick(R.id.button8)
    void setBtn8() {
        addElement('8');
    }

    @OnClick(R.id.button9)
    void setBtn9() {
        addElement('9');
    }

    @OnClick(R.id.buttonAdd)
    void setBtnAdd() {
        addOperation('+');
    }

    @OnClick(R.id.buttonSubtract)
    void setBtnSubtract() {
        addOperation('-');
    }

    @OnClick(R.id.buttonMultiply)
    void setBtnMultiply() {
        addOperation('*');
    }

    @OnClick(R.id.buttonDivide)
    void setBtnDivide() {
        addOperation('/');
    }

    @OnClick(R.id.buttonDegree)
    void setBtnDegree() {
        addOperation('^');
    }

    @OnClick(R.id.buttonLeftBracket)
    void setBtnLeftBracket() {
        addOperation('(');
    }

    @OnClick(R.id.buttonRightBracket)
    void setBtnRightBracket() {
        addOperation(')');
    }

    @OnClick(R.id.buttonDelete)
    void setBtnDelete() {
        deleteElement();
    }

    @OnClick(R.id.buttonPoint)
    void setBtnPoint() {
        if (colPoint) {
            if(one.length()==0) {
                mTextView.setText(String.format("%s.", mTextView.getText()));
                one.append(".");
                colPoint = false;
            }
            else if(whats(one.charAt(one.length() - 1))!=4){
                mTextView.setText(String.format("%s.", mTextView.getText()));
                one.append(".");
                colPoint = false;
            }
        }
    }

    @OnLongClick(R.id.buttonDelete)
    boolean setBtnDeleteLong(){
        mTextView.setText("");
        one.delete(0,one.length());
        colPoint = true;
        bracket = 0;
        return false;
    }

    @OnClick(R.id.buttonEqual)
    void setBtnEqual() {
        addOperation('=');
    }


    private void addElement(char e){
        if(one.length()==0) {
            mTextView.setText(String.format("%s%s", mTextView.getText(), e));
            one.append(e);
        }
        else if(whats(one.charAt(one.length() - 1))!=4){
            mTextView.setText(String.format("%s%s", mTextView.getText(), e));
            one.append(e);
        }
    }

    private void deleteElement(){
        StringBuilder deleteElement = new StringBuilder();
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

            if (o == 1 || o == 4) {
                mTextView.setText(String.format("%s%s", mTextView.getText(), e));
                one.append(e);
                colPoint = true;
            } else if (o == 2 || o == 6) {
                deleteElement();
                mTextView.setText(String.format("%s%s", mTextView.getText(), e));
                one.append(e);
                colPoint = true;
            }
            if(o==5 && e=='-'){
                mTextView.setText(String.format("%s0%s", mTextView.getText(), e));
                one.append(0);
                one.append(e);
                colPoint = true;
            }
            if(one.length()>1){
                //замена для минуса ( ) ,число )
                if(whats(one.charAt(one.length() - 2))==4 || whats(one.charAt(one.length() - 2))==1) {
                    deleteElement();
                    mTextView.setText(String.format("%s%s", mTextView.getText(), e));
                    one.append(e);
                    colPoint = true;
                }
            }
        }
        else{
            if(whatElement(e,e)==9) {
                mTextView.setText(String.format("%s0%s", mTextView.getText(), e));
                one.append(0);
                one.append(e);
                colPoint = true;
            }
        }
    }

    private void addOperation(char e) {
        //новый код
        try {
            switch (e) {
                case '+': {
                    appEnd(e);
                    break;
                }
                case '-': {
                    appEnd(e);
                    break;
                }
                case '*': {
                    appEnd(e);
                    break;
                }
                case '/': {
                    appEnd(e);
                    break;
                }
                case '^': {
                    appEnd(e);
                    break;
                }
                case '=': {
                    if (bracket != 0) {
                        mTextView.setText(String.format("%s = Не закрытая скобка\n\n", mTextView.getText()));
                        bracket = 0;
                        one.delete(0, one.length());
                        colPoint = true;
                    } else if (one.length() != 0) {
                        if ((one.length() >= 1 && one.charAt(one.length() - 1) != '-') && one.charAt(one.length() - 1) != '.') {
                            ExpressionUtils expressionUtils = new ExpressionUtils(one.toString());
                            String answer = expressionUtils.answer();
                            mTextView.setText(String.format("%s=%s\n\n", mTextView.getText(), answer));
                            one.delete(0, one.length());
                            colPoint = true;
                            bracket = 0;
                        }
                    }
                    break;
                }
                case '(': {
                    if (one.length() == 0) {
                        mTextView.setText(String.format("%s%s", mTextView.getText(), e));
                        one.append(e);
                        colPoint = true;
                        bracket++;
                    } else {
                        int o = whatElement(one.charAt(one.length() - 1), e);
                        if ((o == 2 || o == 3 || o == 5 || o == 6 || o == 9 || o == 0) && one.charAt(one.length() - 1) != '.') {
                            //если удалить &&, то можно использовать числа 0.(3) вместо 0.333
                            mTextView.setText(String.format("%s%s", mTextView.getText(), e));
                            one.append(e);
                            colPoint = true;
                            bracket++;
                        }
                    }
                    break;
                }
                case ')': {
                    if (one.length() != 0) {
                        int o = whatElement(one.charAt(one.length() - 1), e);
                        if ((o == 1 || o == 4) && bracket > 0) {
                            mTextView.setText(String.format("%s%s", mTextView.getText(), e));
                            one.append(e);
                            colPoint = true;
                            bracket--;
                        }
                    }
                    break;
                }
            }
        } catch (Exception er) {
            er.printStackTrace();
        }
    }
}
