package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Sort {
	public Sort() {
		
	}

	public static ArrayList<String[]> getSorted(int sortField, int sortType, ArrayList<String[]> displayedData) {
        String[][] arroza = new String[displayedData.size()][9];;
		SimpleDateFormat format = new SimpleDateFormat("EEE. MMM d, yyyy hh:mmaaa");
        Comparator<String[]> sortScoresByDate = new Comparator<String[]>()
        {
            @Override
            public int compare(String[] pl1, String[] pl2)
            {
            	Date date1 = new Date();
            	Date date2 = new Date();
            	try {
            		date1 =format.parse(pl1[8]);
            		date2 = format.parse(pl2[8]);
            	}
            	catch(Exception e) {
            		System.out.print(e.getStackTrace());
            	}
            	if (sortField == sortType) {
                return date1.compareTo(date2);
            	}
            	else {return date2.compareTo(date1);}
            }
        };
        for (int i = 0; i < displayedData.size(); i++) {
            arroza[i] = displayedData.get(i);
        }
        if (sortField == sortType) {
        	switch (sortField) {
        	case 0:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][0].toUpperCase().compareTo(arroza[minPos][0].toUpperCase()) < arroza[minPos][0].toUpperCase().compareTo(arroza[t][0].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }
                break;
        	case 1:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][1].toUpperCase().compareTo(arroza[minPos][1].toUpperCase()) < arroza[minPos][1].toUpperCase().compareTo(arroza[t][1].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }
                break;
        	case 2:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][2].toUpperCase().compareTo(arroza[minPos][2].toUpperCase()) < arroza[minPos][2].toUpperCase().compareTo(arroza[t][2].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 3:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][3].toUpperCase().compareTo(arroza[minPos][3].toUpperCase()) < arroza[minPos][3].toUpperCase().compareTo(arroza[t][3].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 4:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][4].toUpperCase().compareTo(arroza[minPos][4].toUpperCase()) < arroza[minPos][4].toUpperCase().compareTo(arroza[t][4].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 5:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][5].toUpperCase().compareTo(arroza[minPos][5].toUpperCase()) < arroza[minPos][5].toUpperCase().compareTo(arroza[t][5].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 6:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (Double.parseDouble(arroza[t][6].substring(0, (arroza[t][6].length() - 1))) < Double.parseDouble(arroza[minPos][6].substring(0, (arroza[minPos][6].length() - 1)))) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 7:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (Integer.parseInt(arroza[t][7].substring(0, (arroza[t][7].length() - 1))) < Integer.parseInt(arroza[minPos][7].substring(0, (arroza[minPos][7].length() - 1)))) {
                            minPos = t;
                        }
                    }
                    //System.out.println(sortType);
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 8:
        		Arrays.sort(arroza, sortScoresByDate);
        	}
        }
        else {
        	switch (sortField) {
        	case 0:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][0].toUpperCase().compareTo(arroza[minPos][0].toUpperCase()) > arroza[minPos][0].toUpperCase().compareTo(arroza[t][0].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 1:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][1].toUpperCase().compareTo(arroza[minPos][1].toUpperCase()) > arroza[minPos][1].toUpperCase().compareTo(arroza[t][1].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 2:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][2].toUpperCase().compareTo(arroza[minPos][2].toUpperCase()) > arroza[minPos][2].toUpperCase().compareTo(arroza[t][2].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 3:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][3].toUpperCase().compareTo(arroza[minPos][3].toUpperCase()) > arroza[minPos][3].toUpperCase().compareTo(arroza[t][3].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 4:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][4].toUpperCase().compareTo(arroza[minPos][4].toUpperCase()) > arroza[minPos][4].toUpperCase().compareTo(arroza[t][4].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 5:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (arroza[t][5].toUpperCase().compareTo(arroza[minPos][5].toUpperCase()) > arroza[minPos][5].toUpperCase().compareTo(arroza[t][5].toUpperCase())) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 6:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (Double.parseDouble(arroza[t][6].substring(0, (arroza[t][6].length() - 1))) > Double.parseDouble(arroza[minPos][6].substring(0, (arroza[minPos][6].length() - 1)))) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 7:
                for (int i = 0; i < arroza.length - 1; i++) {
                    int minPos = i;
                    for (int t = i + 1; t < arroza.length; t++) {
                        if (Integer.parseInt(arroza[t][7].substring(0, (arroza[t][7].length() - 1))) > Integer.parseInt(arroza[minPos][7].substring(0, (arroza[minPos][7].length() - 1)))) {
                            minPos = t;
                        }
                    }
                    String[] temp = arroza[minPos];
                    arroza[minPos] = arroza[i];
                    arroza[i] = temp;
                }break;
        	case 8:
        		Arrays.sort(arroza, sortScoresByDate);
        	}

        }
        for (int i = 0; i < displayedData.size(); i++) {
            displayedData.set(i, arroza[i]);
        }
        return displayedData;

	}
}
