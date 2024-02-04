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

        //start page
        try {jsonObject.put("SCOUTER_NAME", Values.start_scout_name);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TEAM_NUMBER", Values.start_team_num);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ROBOT_START_POSITION",Values.start_robo_pos);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("MATCH_NUMBER", Values.start_match_num);} catch (JSONException e) {throw new RuntimeException(e);}

        //auto page
        try {jsonObject.put("AUTO_LEAVE_COMMUNITY", Values.auto_leave_com);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_END_POSITION", Values.auto_end_pos);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_CONE_BOTTOM_ROW", Values.auto_co_bo);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_CONE_MIDDLE_ROW", Values.auto_co_mi);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_CONE_TOP_ROW", Values.auto_co_to);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_CUBE_BOTTOM_ROW", Values.auto_cu_bo);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_CUBE_MIDDLE_ROW", Values.auto_cu_mi);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_CUBE_TOP_ROW", Values.auto_cu_to);} catch (JSONException e) {throw new RuntimeException(e);}

        //teleop page
        try {jsonObject.put("GROUND_PICKUP", Values.tele_ground);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("SINGLE_STATION_PICKUP", Values.tele_single);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("DOUBLE_STATION_PICKUP", Values.tele_double);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_CONE_BOTTOM_ROW", Values.tele_co_bo);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_CONE_MIDDLE_ROW", Values.tele_co_mi);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_CONE_TOP_ROW", Values.tele_co_to);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_CUBE_BOTTOM_ROW", Values.tele_cu_bo);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_CUBE_MIDDLE_ROW", Values.tele_cu_mi);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_CUBE_TOP_ROW", Values.tele_cu_to);} catch (JSONException e) {throw new RuntimeException(e);}

        //notes page
        try {jsonObject.put("DEFENDED_THIS_ROBOT", Values.notes_defends);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("DEFENDED_BY_THIS_ROBOT", Values.notes_defended);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ROBOT_BREAK", Values.notes_robo_break);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ROBOT_TIP", Values.notes_robo_tip);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ANY_PENALTIES", Values.notes_penalty);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("NOTES_BOX", Values.notes_type_box);} catch (JSONException e) {throw new RuntimeException(e);}

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
