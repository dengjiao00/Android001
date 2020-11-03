package com.example.testcal;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class OrdinaryActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView textExp;
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button sin;
    private Button cos;
    private Button power;
    private Button radical_sign;
    private Button ac;
    private Button equal_op;
    private Button back;
    private Button div_op;
    private Button add_op;
    private Button sub_op;
    private Button dot;
    private Button multiply_op;
    private TextView org;
    private Button left_bracket;
    private Button right_bracket;
    private Button lg;
    private Button ln;
    private Button reciprocal;
    private Button factorial;
    private Button percent;
    private Button tan;

    private void initWidgets() {
        tan = findViewById(R.id.tan);
        left_bracket = findViewById(R.id.left_bracket);
        right_bracket = findViewById(R.id.right_bracket);
        org = findViewById(R.id.org);
        div_op = findViewById(R.id.div_op);
        add_op = findViewById(R.id.add_op);
        sub_op = findViewById(R.id.sub_op);
        multiply_op = findViewById(R.id.multiply_op);
        dot = findViewById(R.id.dot);
        equal_op = findViewById(R.id.equal_op);
        back = findViewById(R.id.back);
        ac = findViewById(R.id.ac);
        textExp = findViewById(R.id.text_exp);
        num0 = findViewById(R.id.num_0);
        num1 = findViewById(R.id.num_1);
        num2 = findViewById(R.id.num_2);
        num3 = findViewById(R.id.num_3);
        num4 = findViewById(R.id.num_4);
        num5 = findViewById(R.id.num_5);
        num6 = findViewById(R.id.num_6);
        num7 = findViewById(R.id.num_7);
        num8 = findViewById(R.id.num_8);
        num9 = findViewById(R.id.num_9);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        power = findViewById(R.id.power);
        radical_sign = findViewById(R.id.radical_sign);
        lg = findViewById(R.id.lg);
        ln = findViewById(R.id.ln);
        reciprocal = findViewById(R.id.reciprocal);
        factorial = findViewById(R.id.factorial);
        percent = findViewById(R.id.percent);
    }

    /**
     * 数n的阶乘
     *
     * @param n
     * @return
     */
    private int doFactorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 | n == 1) {
            return 1;
        } else {
            return n * doFactorial(n - 1);
        }
    }

    private void addEventListener() {
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String excuteData = textExp.getText().toString();
                    if (excuteData.length() >= 1 && (excuteData.charAt(excuteData.length() - 1) >= '0' && excuteData.charAt(excuteData.length() - 1) <= '9')) {
                        double res = Double.valueOf(excuteData) / 100;
                        org.setText(excuteData + "% " + "= " + String.format("%.4f", res));
                        textExp.setText("");
                    } else
                        warn();
                } catch (Exception e) {
                    warn();
                }
            }
        });
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String excuteData = textExp.getText().toString();
                try {
                    re();
                    if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                        return;
                    }
                    double res = Math.log10(Double.valueOf(excuteData));
                    org.setText("lg(" + excuteData + ") " + "= " + String.format("%.3f", res));
                }catch (Exception e){
                    warn();
                }

                textExp.setText("");
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String excuteData = textExp.getText().toString();
                try {
                    re();
                    if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                        return;
                    }
                    double res = Math.log(Double.valueOf(excuteData));
                    org.setText("lg(" + excuteData + ") " + "= " + String.format("%.3f", res));
                }catch (Exception e){
                    warn();
                }

                textExp.setText("");
            }
        });
        reciprocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String excuteData = textExp.getText().toString();
                try {
                    re();
                    if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                        return;
                    }
                    double res = 1 / (Double.valueOf(excuteData));
                    org.setText("1/" + excuteData + "= " + String.format("%f", res));
                }catch (Exception e){
                    warn();
                }

                textExp.setText("");
            }
        });
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String excuteData = textExp.getText().toString();
                try {
                    if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                        return;
                    }
                    int res = doFactorial(Integer.valueOf(excuteData));
                    org.setText(excuteData + "!" + "= " + String.format("%d", res));
                } catch (Exception e) {
                    warn();
                }

                textExp.setText("");
            }
        });
        left_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge2()) {
                    textExp.setText(textExp.getText().toString() + "(");
                } else
                    warn();
            }
        });
        right_bracket.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String s = textExp.getText().toString();
                try {
                    if (!(s.charAt(s.length()-1)>='0'&&s.charAt(s.length()-1)<='9'))
                        warn();
                    else if (s.length() > 1 && s.contains("(") && (s.charAt(s.length() - 1) >= '0' || s.charAt(s.length()) - 1 <= '9')) {
                        textExp.setText(textExp.getText().toString() + ")");
                    } else warn();
                } catch (Exception e) {
                    warn();
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    re();
                    if (judge())
                        textExp.setText(textExp.getText().toString() + ".");
                } catch (Exception e) {
                    warn();
                }

            }
        });
        add_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    re();
                    if (judge())
                        textExp.setText(textExp.getText().toString() + "+");
                } catch (Exception e) {
                    warn();
                }

            }
        });
        sub_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    re();
                    if (judge())
                        textExp.setText(textExp.getText().toString() + "-");
                } catch (Exception e) {
                    warn();
                }

            }
        });
        multiply_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    re();
                    if (judge())
                        textExp.setText(textExp.getText().toString() + "×");
                } catch (Exception e) {
                    warn();
                }

            }
        });
        div_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    re();
                    if (judge()) {
                        textExp.setText(textExp.getText().toString() + "÷");
                    }
                } catch (Exception e) {
                    warn();
                }

            }
        });
        equal_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (org.getText().toString().contains("^") && !org.getText().toString().contains("=")) {
                    power.callOnClick();
                } else {
                    String orgText = textExp.getText().toString();
                    String excuteText = orgText;
                    excuteText = excuteText.replace("÷", "/");
                    excuteText = excuteText.replace("×", "*");
                    try {
                        double res = Util.executeExpression(excuteText + "=");
                        org.setText(orgText + " = " + String.valueOf(res));
                        textExp.setText("");
                    } catch (Exception e) {
                        try {
                            double res = Double.valueOf(orgText);
                            org.setText(orgText + " = " + String.valueOf(res));
                            textExp.setText("");
                        } catch (Exception e1) {
                            warn();
                        }
                    }
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textExpString = textExp.getText().toString();
                if (!"".equals(textExpString)) {
                    textExp.setText(textExpString.substring(0, textExpString.length() - 1));
                }
            }
        });

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num0.getText().toString());
                } else
                    warn();
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num1.getText().toString());
                } else
                    warn();
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num2.getText().toString());
                } else
                    warn();
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num3.getText().toString());
                } else
                    warn();
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num4.getText().toString());
                } else
                    warn();
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num5.getText().toString());
                } else
                    warn();
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num6.getText().toString());
                } else
                    warn();
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num7.getText().toString());
                } else
                    warn();
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num8.getText().toString());
                } else
                    warn();
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (judge1()) {
                    textExp.setText(textExp.getText().toString() + num9.getText().toString());
                } else
                    warn();
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                try {
                    re();
                    if (excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                        warn();
                    }
                    double res = Math.sin(Math.toRadians(Double.valueOf(excuteData)));
                    org.setText("sin(" + excuteData + ") " + "= " + String.format("%.1f", res));
                } catch (Exception e) {
                    warn();
                }

                textExp.setText("");
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                try {
                    re();
                    if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                        return;
                    }
                    double res = Math.cos(Math.toRadians(Double.valueOf(excuteData)));
                    org.setText("cos(" + excuteData + ") " + "= " + String.format("%.1f", res));
                } catch (Exception e) {
                    warn();
                }

                textExp.setText("");
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                try {
                    re();
                    if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                        return;
                    }
                    double res = Math.tan(Math.toRadians(Double.valueOf(excuteData)));
                    org.setText("tan(" + excuteData + ") " + "= " + String.format("%.1f", res));
                } catch (Exception e) {
                    warn();
                }

                textExp.setText("");
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                try {
                    re();
                    if (org.getText().toString().contains("^")) {
                        double num1 = Double.valueOf(org.getText().toString().substring(0, org.getText().toString().indexOf("^")));
                        double num2 = Double.valueOf(textExp.getText().toString());
                        org.setText(num1 + "^" + num2 + " = " + Math.pow(num1, num2));

                    } else if (excuteData.length() != 0) {
                        org.setText(excuteData + "^");
                    }
                } catch (Exception e) {
                    warn();
                }
                textExp.setText("");

            }
        });
        radical_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    re();
                    String excuteData = textExp.getText().toString();
                    if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                        return;
                    }
                    double res = Math.sqrt(Double.valueOf(excuteData));
                    org.setText("√" + excuteData + "= " + String.format("%.1f", res));
                } catch (Exception e) {
                    warn();
                }

                textExp.setText("");
            }
        });
    }

    private void re() {
        String s = textExp.getText().toString();
        if (s.length() == 0) {
            warn();
        }
    }

    private void warn() {
        Toast toast = new Toast((getApplicationContext()));
        LayoutInflater inflater = LayoutInflater.from(OrdinaryActivity.this);
        View view = inflater.inflate(R.layout.layout_toast, null);
        ImageView imageView = view.findViewById(R.id.iv_toast);
        TextView textView = view.findViewById(R.id.tv_toast);
        imageView.setImageResource(R.drawable.ic_error1);
        textView.setText("错误输⼊，请重新输⼊!");
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    private boolean judge() {
        String s = textExp.getText().toString();
        char t = s.charAt(s.length() - 1);
        if (s.length() != 0 && (t != '+' && t != '-' && t != 'x' && t != '÷')) {
            return true;
        } else
            return false;
    }

    private boolean judge1() {
        String s = textExp.getText().toString();
        if (s.length() != 0 && s.charAt(s.length() - 1) == ')') {
            return false;
        } else
            return true;
    }

    private boolean judge2() {
        String s = textExp.getText().toString();
        if (s.length() != 0 && (s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9')) {
            return false;
        } else
            return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple);
        initWidgets();
        addEventListener();
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(OrdinaryActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

}

