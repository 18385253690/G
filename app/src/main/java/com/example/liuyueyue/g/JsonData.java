package com.example.liuyueyue.g;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by liuyueyue on 2017/3/5.
 */

public class JsonData {

public static JSONObject createJson(){
    JSONObject jsonObject = new JSONObject();
    try{
        jsonObject.put("name","蜘蛛侠");
        jsonObject.put("gender","男");
        jsonObject.put("age",30);

        JSONArray gril = new JSONArray();
        gril.put("dada");
        gril.put("xiaoxiao");
        jsonObject.put("grilFriend",gril);

        JSONObject like = new JSONObject();
        like.put("eat","banana");
        like.put("look","running man");
        jsonObject.put("like",like);

        JSONArray boy = new JSONArray();
        JSONObject childer = new JSONObject();
        childer.put("偶像","乔丹");
        childer.put("女神","优雅");
        boy.put(0,childer);

        JSONObject brother = new JSONObject();
        brother.put("哥哥","勇敢");
        brother.put("妹妹","自信");
        boy.put(1,brother);
        jsonObject.put("boy",boy);

    } catch (JSONException e) {
        e.printStackTrace();
    }
    return jsonObject;
}


}
