package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;

public class Cal2Controller {
    @FXML
    TextField input_world;

    @FXML
    private Label count_a,count_b,count_c,count_d,count_e,count_f,count_g,count_h,
            count_i,count_j,count_k,count_l,count_m,count_n,count_o,count_p,count_q,
            count_r,count_s,count_t,count_u,count_v,count_x,count_y,count_z,count_w,total_point;

    @FXML
    private Label words_list;

    ArrayList<String> words = new ArrayList<String>();

    HashMap<String, Letter> map = new HashMap<String, Letter>();


    @FXML
    private void submit(ActionEvent event){
        createMap();
        //System.out.println("submit");
        try{

            if(isValid(input_world.getText())){
                words.add(input_world.getText());
                calRemains(input_world.getText());
                words_list.setText(words.toString());

                if(isOver()){
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setContentText("Game Over!!!");
                    alert.show();
                }

            }else{
                // words_list.setText("test");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid word");
                alert.show();

                words_list.setText(words.toString());
            }

            //insert code
            //-display totalPoint
            //-change count letter
        }
        catch (Exception e){
            System.err.println("failed");
        }

        input_world.setText("");
    }

    //create hash map
    public void createMap(){
        map.put("count_a",new Letter(Integer.parseInt(count_a.getText().toString()),1));
        map.put("count_b",new Letter(Integer.parseInt(count_b.getText().toString()),3));
        map.put("count_c",new Letter(Integer.parseInt(count_c.getText().toString()),3));
        map.put("count_d",new Letter(Integer.parseInt(count_d.getText().toString()),2));
        map.put("count_e",new Letter(Integer.parseInt(count_e.getText().toString()),1));
        map.put("count_f",new Letter(Integer.parseInt(count_f.getText().toString()),4));
        map.put("count_g",new Letter(Integer.parseInt(count_g.getText().toString()),2));
        map.put("count_h",new Letter(Integer.parseInt(count_h.getText().toString()),4));
        map.put("count_i",new Letter(Integer.parseInt(count_i.getText().toString()),1));
        map.put("count_j",new Letter(Integer.parseInt(count_j.getText().toString()),8));
        map.put("count_k",new Letter(Integer.parseInt(count_k.getText().toString()),5));
        map.put("count_l",new Letter(Integer.parseInt(count_l.getText().toString()),1));
        map.put("count_m",new Letter(Integer.parseInt(count_m.getText().toString()),3));
        map.put("count_n",new Letter(Integer.parseInt(count_n.getText().toString()),1));
        map.put("count_o",new Letter(Integer.parseInt(count_o.getText().toString()),1));
        map.put("count_p",new Letter(Integer.parseInt(count_p.getText().toString()),3));
        map.put("count_q",new Letter(Integer.parseInt(count_q.getText().toString()),10));
        map.put("count_r",new Letter(Integer.parseInt(count_r.getText().toString()),1));
        map.put("count_s",new Letter(Integer.parseInt(count_s.getText().toString()),1));
        map.put("count_t",new Letter(Integer.parseInt(count_t.getText().toString()),1));
        map.put("count_u",new Letter(Integer.parseInt(count_u.getText().toString()),1));
        map.put("count_v",new Letter(Integer.parseInt(count_v.getText().toString()),4));
        map.put("count_x",new Letter(Integer.parseInt(count_x.getText().toString()),8));
        map.put("count_y",new Letter(Integer.parseInt(count_y.getText().toString()),4));
        map.put("count_z",new Letter(Integer.parseInt(count_z.getText().toString()),10));
        map.put("count_w",new Letter(Integer.parseInt(count_w.getText().toString()),4));
    }

    //input validation
    public boolean isValid(String input){
        // - is exited
        boolean check1 = !input.isEmpty();

        // - at least 8
        boolean check2 = input.length() <= 8;

        // - at least one vowel
        String word = input.toLowerCase();
        boolean check3 = word.contains("a") || word.contains("e")|| word.contains("i")|| word.contains("o")|| word.contains("u");

        // - not duplicated
        boolean check4 = !words.contains(input);

        // - if the letter remains
        boolean check5 = true;
        for(int i=0; i<input.length();i++){
            String letter = "count_"+input.charAt(i);
            //update remains
            int temp = map.get(letter).count;

            if(temp == 0){
                check5 = false;
            }
        }

        return check1 && check2 && check3 && check4 && check5;
    }

    public boolean isOver(){

        //check vowels
        boolean check1 = false;
        if(map.get("count_a").count ==0&&map.get("count_e").count ==0&&map.get("count_i").count ==0&&map.get("count_o").count ==0&&map.get("count_u").count ==0){
            check1 = true;
        }

        //check remained 1
        boolean check2 = false;
        int total = 0;
        for(HashMap.Entry<String, Letter> entry : map.entrySet()){

            total = total + entry.getValue().count;
        }
        if(total == 1){
            check2 = true;
        }

        return check1&&check2;
    }

    public void calRemains(String input){

       int total =  Integer.parseInt(total_point.getText().toString());


        input.toLowerCase();
        for(int i=0; i<input.length();i++){

            String letter = "count_"+input.charAt(i);

            //update remains
            int temp = map.get(letter).count-1;
            map.put(letter,new Letter(temp,map.get(letter).scoure));

            //update total point
            total = total+map.get(letter).scoure;

            updateNumbers();
        }

        total_point.setText(total+"");
    }


    //update the numbers in the view
    public void updateNumbers(){

        count_a.setText(map.get("count_a").count+"");
        count_b.setText(map.get("count_b").count+"");
        count_c.setText(map.get("count_c").count+"");
        count_d.setText(map.get("count_d").count+"");
        count_e.setText(map.get("count_e").count+"");
        count_f.setText(map.get("count_f").count+"");
        count_g.setText(map.get("count_g").count+"");
        count_h.setText(map.get("count_h").count+"");
        count_i.setText(map.get("count_i").count+"");
        count_j.setText(map.get("count_j").count+"");
        count_k.setText(map.get("count_k").count+"");
        count_l.setText(map.get("count_l").count+"");
        count_m.setText(map.get("count_m").count+"");
        count_n.setText(map.get("count_n").count+"");
        count_o.setText(map.get("count_o").count+"");
        count_p.setText(map.get("count_p").count+"");
        count_q.setText(map.get("count_q").count+"");
        count_r.setText(map.get("count_r").count+"");
        count_s.setText(map.get("count_s").count+"");
        count_t.setText(map.get("count_t").count+"");
        count_u.setText(map.get("count_u").count+"");
        count_v.setText(map.get("count_v").count+"");
        count_w.setText(map.get("count_w").count+"");
        count_x.setText(map.get("count_x").count+"");
         count_y.setText(map.get("count_y").count+"");
        count_z.setText(map.get("count_z").count+"");

    }

}
