package com.fro.gamefroscouting;

public class ClearValues {
    public void clearData(){
        Values.start_scout_name = null;
        Values.start_robo_pos = null;
        Values.start_team_num = 0;
        Values.start_match_num = 0;
        //auto
        Values.auto_end_pos = null;
        Values.auto_co_bo = 0;
        Values.auto_co_mi = 0;
        Values.auto_co_to = 0;
        Values.auto_cu_bo = 0;
        Values.auto_cu_mi = 0;
        Values.auto_cu_to = 0;
        Values.auto_leave_com = false;
        //teleop
        Values.tele_co_bo = 0;
        Values.tele_co_mi = 0;
        Values.tele_co_to = 0;
        Values.tele_cu_bo = 0;
        Values.tele_cu_mi = 0;
        Values.tele_cu_to = 0;
        Values.tele_ground = false;
        Values.tele_single = false;
        Values.tele_double = false;
        //endgame
        Values.eg_end_pos = null;
        //notes
        Values.notes_type_box = null;
        Values.notes_defends = 0;
        Values.notes_defended = 0;
        Values.notes_robo_break = false;
        Values.notes_robo_tip = false;
        Values.notes_penalty = false;
    }
}
