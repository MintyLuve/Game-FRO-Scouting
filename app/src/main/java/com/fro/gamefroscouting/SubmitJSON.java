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
        try {jsonObject.put("ROBOT_START_POSITION",Values.start_robot_pos);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("MATCH_NUMBER", Values.start_match_num);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("HUMAN_PLAYER_POSITION",Values.start_human_pos);} catch (JSONException e) {throw new RuntimeException(e);}

        //auto page
        try {jsonObject.put("AUTO_LEAVE_START", Values.auto_leave_start);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_SPEAKER", Values.auto_speaker);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_AMP", Values.auto_amp);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("AUTO_TRAP", Values.auto_trap);} catch (JSONException e) {throw new RuntimeException(e);}

        //teleop page
        try {jsonObject.put("GROUND_PICKUP", Values.tele_ground_pickup);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("SOURCE_PICKUP", Values.tele_source_pickup);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_SPEAKER_NOT_AMPLIFIED", Values.tele_nSpeaker);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_SPEAKER_AMPLIFIED", Values.tele_aSpeaker);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_AMP", Values.tele_amp);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_TRAP", Values.tele_trap);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("TELEOP_COOPERTITION_BONUS", Values.tele_bonus);} catch (JSONException e) {throw new RuntimeException(e);}

        //endgame page
        try {jsonObject.put("ENDGAME_END_POSITION", Values.eg_end_pos);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ENDGAME_CLIMB_TYPE", Values.eg_climb_type);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ENDGAME_BUDDY_CLIMB", Values.eg_buddy_climb);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ENDGAME_SPOTLIGHT_LEFT", Values.eg_spot_left);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ENDGAME_SPOTLIGHT_CENTER", Values.eg_spot_center);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ENDGAME_SPOTLIGHT_RIGHT", Values.eg_spot_right);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ENDGAME_THROWS_MADE", Values.eg_made);} catch (JSONException e) {throw new RuntimeException(e);}
        try {jsonObject.put("ENDGAME_THROWS_MISSED", Values.eg_missed);} catch (JSONException e) {throw new RuntimeException(e);}


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