package com.fro.gamefroscouting;

public class ResetValues {
    public void clearData(){
        Values.start_scout_name = null;
        Values.start_robot_pos = -1;
        Values.start_team_num = 0;
        Values.start_match_num += 1;
        Values.start_human_pos = -1;
        //auto
        Values.auto_leave_start = false;
        Values.auto_speaker = 0;
        Values.auto_amp = 0;
        Values.auto_trap = 0;
        //teleop
        Values.tele_ground_pickup = false;
        Values.tele_source_pickup = false;
        Values.tele_nSpeaker = 0;
        Values.tele_amp = 0;
        Values.tele_aSpeaker = 0;
        Values.tele_trap = 0;
        Values.tele_bonus = false;
        //endgame
        Values.eg_end_pos = -1;
        Values.eg_climb_type = -1;
        Values.eg_buddy_climb = false;
        Values.eg_spot_left = false;
        Values.eg_spot_center = false;
        Values.eg_spot_right = false;
        Values.eg_made = 0;
        Values.eg_missed = 0;
        //notes
        Values.notes_type_box = null;
        Values.notes_defends = 0;
        Values.notes_defended = 0;
        Values.notes_robo_break = false;
        Values.notes_robo_tip = false;
        Values.notes_penalty = false;
    }
}