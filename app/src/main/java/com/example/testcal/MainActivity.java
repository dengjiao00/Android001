 package com.example.testcal;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
    private Button ac;
    private Button equal_op;
    private Button back;
    private Button div_op;
    private Button add_op;
    private Button sub_op;
    private Button dot;
    private Button multiply_op;
    private TextView org;
    private Button percent;
    private Button dj;

    private void initWidgets() {
        org = findViewById(R.id.org);
        div_op = findViewById(R.id.div_op);
        add_op = findViewById(R.id.add_op);
        sub_op = findViewById(R.id.sub_op);
        multiply_op = findViewById(R.id.multiply_op);
        dot = findViewById(R.id.dot);
        equal_op = findViewById(R.id.equal_op);
        back = findViewById(R.id.back);
        ac = findViewById(R.id.ac);
        dj = findViewById(R.id.dj);
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
        percent = findViewById(R.id.percent);
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
        dj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smile();
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


    }

    private void smile() {
        Toast toast = new Toast((getApplicationContext()));
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View view = inflater.inflate(R.layout.layout_toast, null);
        ImageView imageView = view.findViewById(R.id.iv_toast);
        TextView textView = view.findViewById(R.id.tv_toast);
        imageView.setImageResource(R.drawable.smile1);
        textView.setText("嘿嘿！");
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    private void re() {
        String s = textExp.getText().toString();
        if (s.length() == 0) {
            warn();
        }
    }

    private void warn() {
        Toast toast = new Toast((getApplicationContext()));
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
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
        setContentView(R.layout.activity_main);
        initWidgets();
        addEventListener();
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
            Intent intent = new Intent(MainActivity.this, OrdinaryActivity.class);
            startActivity(intent);
        }
    }
}