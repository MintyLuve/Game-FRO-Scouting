package com.fro.gamefroscouting;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class SubmitJSON {

    Calendar calendar = Calendar.getInstance();

    public void submitData(File path){
        JSONObject jsonObject = new JSONObject();

        try {jsonObject.put("SCOUTER_NAME", Values.start_scout_name);}
        catch (JSONException e) {throw new RuntimeException(e);}

        try {jsonObject.put("ROBOT_START_POSITION",Values.start_robo_pos);}
        catch (JSONException e) {throw new RuntimeException(e);}

        try {jsonObject.put("TEAM_NUMBER", Values.start_team_num);}
        catch (JSONException e) {throw new RuntimeException(e);}

        try {jsonObject.put("MATCH_NUMBER", Values.start_match_num);}
        catch (JSONException e) {throw new RuntimeException(e);}

        try {toJSON(jsonObject, path);} catch (IOException e) {e.printStackTrace();}
    }

    public void toJSON(JSONObject content, File path) throws IOException {
        // Class to put the data into a JSON object
        FileOutputStream writer = new FileOutputStream(new File(path, "CRESCENDO_SCOUTING_DATA_" + calendar.getTimeInMillis() + ".json"));
        writer.write(content.toString().getBytes());
        writer.close();
    }

    public void showToast(Context mContext, File path){
        Toast.makeText(mContext, path.toString(), Toast.LENGTH_SHORT).show();
    }

}
