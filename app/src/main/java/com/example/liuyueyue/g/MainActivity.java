package com.example.liuyueyue.g;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button btn_get;
    private Button btn_getBranch;
    private TextView tv_branch1, tv_branch2, tv_branch3,
            tv_branch4, tv_branch5, tv_branch6, tv_branch7,
            tv_branch8, tv_branch9, tv_branch10, tv_branch11,
            tv_branch12;
    private TextView totalData;
    private String totalDataMsg;
    private String brance5;
    private JSONObject jsonObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        jsonObject = JsonData.createJson();
        totalDataMsg = jsonObject.toString();

        totalDataMsg = jsonObject.toString();

        tv_branch1 = (TextView) findViewById(R.id.tv_branch1);
        tv_branch2 = (TextView) findViewById(R.id.tv_branch2);
        tv_branch3 = (TextView) findViewById(R.id.tv_branch3);
        tv_branch4 = (TextView) findViewById(R.id.tv_branch4);
        tv_branch5 = (TextView) findViewById(R.id.tv_branch5);
        tv_branch6 = (TextView) findViewById(R.id.tv_branch6);
        tv_branch7 = (TextView) findViewById(R.id.tv_branch7);
        tv_branch8 = (TextView) findViewById(R.id.tv_branch8);
        tv_branch9 = (TextView) findViewById(R.id.tv_branch9);
        tv_branch10 = (TextView) findViewById(R.id.tv_branch10);
        tv_branch11 = (TextView) findViewById(R.id.tv_branch11);
        tv_branch12 = (TextView) findViewById(R.id.tv_branch12);

        btn_get = (Button) findViewById(R.id.btn_get);
        btn_getBranch = (Button) findViewById(R.id.btn_getBrance);

        btn_get.setOnClickListener((View.OnClickListener) this);
        btn_getBranch.setOnClickListener((View.OnClickListener) this);


    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_get:
                totalData.setText(totalDataMsg);
                break;
            case R.id.btn_getBrance:
                try{
                    String name = jsonObject.getString("name");
                    tv_branch1.setText(name);

                    String gender = jsonObject.getString("gender");
                    tv_branch2.setText(gender);

                    int age = jsonObject.getInt("age");
                    tv_branch3.setText(String.valueOf(age));

                    String grilFriend = jsonObject.getString("grilFriend");
                    JSONArray grilArray = jsonObject.getJSONArray("grilFriend");
                    tv_branch4.setText(grilFriend);

                    StringBuilder sb = new StringBuilder();
                    for(int i = 0;i<grilArray.length();i++){
                        sb.append(grilArray.getString(i));
                        sb.append(".");

                    }
                    sb.deleteCharAt(sb.lastIndexOf("."));
                    tv_branch5.setText(sb);

                    String like = jsonObject.getString("like");
                    JSONObject likeObject = jsonObject.optJSONObject("like");
                    String look = likeObject.getString("look");
                    String eat = likeObject.getString("eat");

                    tv_branch6.setText(like);
                    tv_branch7.setText(look);
                    tv_branch8.setText(eat);

                    JSONArray boyArray = jsonObject.getJSONArray("boy");
                    tv_branch9.setText(boyArray.toString());

                    JSONArray boyObject = boyArray.optJSONArray(0);
                    String star = boyObject.getString(Integer.parseInt("偶像"));
                    tv_branch10.setText(star);

                    String goddess = boyObject.getString(Integer.parseInt("女神"));
                    tv_branch11.setText(goddess);

                    JSONObject brotherObject = boyArray.optJSONObject(1);
                    String oldBrother = brotherObject.getString("哥哥");

                    tv_branch12.setText(oldBrother);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            break;
        }
    }
}