package View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Sort {
	public Sort() {
	    
	}
        public static Comparator<String> getDateCompare() {
            SimpleDateFormat format = new SimpleDateFormat("EEE. MMM d, yyyy hh:mmaaa");
            Comparator<String> sortByDate = new Comparator<String>()
            {
                @Override
                public int compare(String d1, String d2) {
                    Date date1 = new Date();
                    Date date2 = new Date();
                    try {
            		date1 =format.parse(d1);
            		date2 = format.parse(d2);
                    }
                    catch(Exception e) {
                            System.out.print(e.getStackTrace());
                    }
                    return date1.compareTo(date2);
                }
            };
            return sortByDate;
        }
        public static Comparator<String> getPercentCompare() {
            Comparator<String> sortByGrade = new Comparator<String>() {
                @Override
                public int compare(String g1, String g2) {
                    if (Double.parseDouble(g1.substring(0, (g1.length() - 1))) < Double.parseDouble(g2.substring(0, (g2.length() - 1)))) {
                            return 1;
                        }
                    else if(Double.parseDouble(g1.substring(0, (g1.length() - 1))) > Double.parseDouble(g2.substring(0, (g2.length() - 1)))){
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            };
            return sortByGrade;
        }
        public static Comparator<String> getLevelCompare() {
            Comparator<String> sortByLevel = new Comparator<String>() {
               @Override
               public int compare(String l1, String l2) {
                   int apple = compareThe(l1, l2);
                   String l3 = "a";
                   String l4 = "b";
                   if (apple == 0) {
                       l3 = "a";
                       l4 = "a";
                   } else if (apple == 1) {
                       l3= "a";
                       l4 ="z";
                   } else if (apple == -1) {
                       l3 = "z";
                       l4 = "a";
                   }
                   return l3.compareTo(l4);
                }
            };
            return sortByLevel;
        }
    public static int compareThe(String l1, String l2) {
                    int apple = 0;
                    if (l1.equals("Beginner")) {
                        switch(l2) {
                            case "Beginner":
                                apple = 0;
                                break;
                            default:
                                apple = -1;
                                break;
                        }
                    } else
                    if(l1.equals("Easy")) {
                        switch(l2){
                            case "Beginner":
                                apple = 1;
                                break;
                            case "Easy":
                                apple = 0;
                                break;
                            default:
                                apple = -1;
                                break;
                        }
                    } else
                    if(l1.equals("Medium")) {
                        switch(l2){
                            case "Beginner":
                                apple = 1;
                                break;
                            case "Easy":
                                apple = 1;
                                break;
                            case "Medium":
                                apple = 0;
                                break;
                            default:
                                apple = -1;
                                break;
                        }
                    } else
                    if(l1.equals("Hard")) {
                        switch(l2){
                            case "Edit":
                                apple = -1;
                                break;
                            case "Challenge":
                                apple = -1;
                                break;
                            case "Hard":
                                apple = 0;
                                break;
                            default:
                                apple = 1;
                                break;
                        }
                    } else
                    if(l1.equals("Challenge")) {
                        switch(l2){
                            case "Edit":
                                apple = -1;
                                break;
                            case "Challenge":
                                apple = 0;
                                break;
                            default:
                                apple = 1;
                                break;
                        }
                    }
                    return apple;
                }
        
}
