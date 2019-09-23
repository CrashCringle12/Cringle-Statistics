package Model;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author L627B
 */
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import lombok.Data;

@Data
public class StatsData implements Searchable, Sortable, Displayable {
    private int sortField = 0;
    private int foundIndex;
    private boolean found = false;
    private int searchByField;
    private int firstLineToDisplay = 10;
    private int lineToHighlight = 0;
    private int lastLineToDisplay = 15;
    private int linesBeingDisplayed = 10;
    private int sortType = 0;
    int sortFire = -1;
    
    
     Map<String, String[]> searchName = new HashMap<>();
     Map<String, String[]> searchSong = new HashMap<>();
     Map<String, String[]> searchGrade = new HashMap<>();
     Map<String, String[]> searchPercent = new HashMap<>();
     Map<String, Integer> searchTimesPlayed = new HashMap<>();
     Map<String, String[]> searchLastPlayed= new HashMap<>();
     Map<String, String[]> searchLevel = new HashMap<>();
     Map<String, String[]> searchModifiers = new HashMap<>();
     Map<String, String[]> searchType = new HashMap<>();
     Map<String, String[]> searchPack= new HashMap<>();
     Map<String, String[]> searchDate= new HashMap<>();
     Map<String, String[]> searchScore= new HashMap<>();
    
    List<Integer> arroz = new ArrayList<>();
    List<Integer> arroze = new ArrayList<>();
    List<Double> arro = new ArrayList<>();
    ArrayList<Difficulty> difficulties;
    private List<Song> AllSongs = new ArrayList<>();
    private Song song;
   
    private String name;
    private double percent;
    private int score;
    private String grade;
    private RadarValues radar;
    private NoteTypeHit nth;
    private NoteScores Nscores;
    private String date;
    private ArrayList<HighScore> highscores = new ArrayList<>(); 
    private HighScore highscore;
    private String packName;
    private String songName;
    private String steptype;
    private String level;
    private int numTimes;
    private String prevPackName;

    private File stats;
    private ArrayList<String[]> displayedData;
    
    public StatsData(File file) {
        displayedData = new ArrayList<>();
        prevPackName = "";
        stats = file;
        difficulties = new ArrayList<>();
        ReadStatisticsFromXML();
        lastLineToDisplay = displayedData.size();
        firstLineToDisplay = 0;
        linesBeingDisplayed = 25;
        lineToHighlight = 35;
        sortField = 0;
        found = false;
        foundIndex = 10;
        searchByField = 0;
        Jsonb jsonb = JsonbBuilder.create();
        String jsonPerson = jsonb.toJson(getAllSongs());
        System.out.println(jsonPerson);

   }
    public final void ReadStatisticsFromXML() {
        try {
            int totTimes = 0;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document cStats = dBuilder.parse(getStats());
            cStats.getDocumentElement().normalize();

            //Creates the Header which displays the author and root information
            System.out.println("Stepmania Statistics Reader\n By Lamar Cooley-Russ \n\n\nRoot Element: " + cStats.getDocumentElement().getNodeName());
            System.out.println("----------------------------");

 //********************************************************************************************************************************           
         //This Basically gets every song and puts it into a nList
            NodeList nList = cStats.getElementsByTagName("Song");
            for (int i = 0; i < nList.getLength(); i++) {

                //Assigns that specific song to an nNode. Apparently nLists are not iterable, which is why I used this method
                Node nNode = nList.item(i);
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element theSong = (Element) nNode;

                  //This gets the attribute information of each song which is just the file path, and makes it look pretty
                  String directory = theSong.getAttribute("Dir");
                  String[] songString = directory.split("/");
                  try {
                	    if (songString[0].contains("@mem") ) {
                	    	setPackName("USB Songs");
                	    	setSongName(songString[1]);
                	    }
                	    else {
                            setPackName(songString[1]);
                            setSongName(songString[2]);
                	    }

                  }
                  catch (Exception y) {
                      System.out.println("There seems to be a problem");
                  }

    //********************************************************************************************************************************              
                  //Let's get all the steps available for this song
                  NodeList steps = theSong.getElementsByTagName("Steps");
                    
                  for (int count = 0; count < steps.getLength(); count++) {
                     Node node1 = steps.item(count);
                     //Now Let's label them properly
                     if (node1.getNodeType() == Node.ELEMENT_NODE) {
                            Element step = (Element) node1;
                            setLevel(step.getAttribute("Difficulty"));
                            setSteptype(step.getAttribute("StepsType"));
                            //Let's make the step type prettier
                            if (getSteptype().equals("dance-single")) {
                                    setSteptype("Singles");
                            }
                            else {  setSteptype("Doubles");}
                            //System.out.println(songName + " " + steptype + level + "\n");
    //********************************************************************************************************************************                       
                            //Let's get all the HighScore stuffs available for this song
                            NodeList hs = step.getElementsByTagName("HighScoreList");  
                            for (int t = 0; t < hs.getLength(); t++) {                               
                                Node node2 = hs.item(t);               
                                if (node2.getNodeType() == Node.ELEMENT_NODE) {
                                    Element hsElement = (Element) node2;
                                    NodeList hsInfo = hsElement.getElementsByTagName("NumTimesPlayed");
                                    for (int a = 0; a < hsInfo.getLength(); a++) {
                                        Element node9 = (Element) hsInfo.item(a);
                                        if (node9.getNodeType() == Node.ELEMENT_NODE) {
                                            numTimes = Integer.parseInt(node9.getTextContent());
                                        }
                                    }                   
    //********************************************************************************************************************************                              
                                    NodeList highScoreList = hsElement.getElementsByTagName("HighScore");
                                    for (int w = 0; w < highScoreList.getLength(); w++) {
                                        //System.out.println("New HighScore!!!! " + getSongName() + " " + level);
                                        Node node3 = highScoreList.item(w);
                                        //Now Let's label them properly
                                        if (node1.getNodeType() == Node.ELEMENT_NODE) {
                                            Element highScoreElement = (Element) node3;
                                            
    //********************************************************************************************************************************                                      
                                            //Checkpoint: All highscores are in this list called highScoreList. An individual highscore is a node called node3
                                            NodeList hsList = highScoreElement.getElementsByTagName("*");
                                            //Loops through each node that defines a highscore and creates a highscore object.
                                            for (int r = 0; r < hsList.getLength(); r++) {
                                               Node node4 = hsList.item(r);
                                               
                                               if (node4.getNodeType() == Node.ELEMENT_NODE) {
                                                   
                                                    Element hsElementos = (Element) node4;
                                                    String nodeName = hsElementos.getNodeName();
                                                    String nodeValue = hsElementos.getTextContent();
                                                    switch(nodeName) {
                                                        case "Name":
                                                            setName(nodeValue);
                                                            break;
                                                        case "Grade":
                                                            setGrade(convertGrade(nodeValue));
                                                            break;
                                                        case "Score":
                                                            setScore(Integer.parseInt(nodeValue));
                                                            break;
                                                        case "PercentDP":
                                                        	double value = Double.parseDouble(nodeValue);
                                                        	value = ((int) Math.round(value * 10000))/100.0;
                                                            setPercent(value);
                                                            break;
                                                        case "DateTime":
                                                            setDate(nodeValue);
                                                            break;
                                                        case "TapNoteScores":
                                                            NodeList node5List = hsElementos.getChildNodes();
                                                            for (int b = 0; b < node5List.getLength(); b++ ) {
                                                                if (node5List.item(b).getNodeType() == Node.ELEMENT_NODE) {
                                                                    //System.out.println(b + ": " +(node5List.item(b)).getTextContent() + "-" + node5List.item(b).getNodeType());
                                                                    getArroz().add(Integer.parseInt((node5List.item(b)).getTextContent()));
                                                                }
                                                            }
                                                            break;
                                                        case "RadarValues":
                                                            NodeList node6List = hsElementos.getChildNodes();
                                                            for (int b = 0; b < node6List.getLength(); b++ ) {
                                                                if (node6List.item(b).getNodeType() == Node.ELEMENT_NODE) {
                                                                    getArro().add(Double.parseDouble((node6List.item(b)).getTextContent()));
                                                                    if (getArro().size() > 4) {
                                                                        getArroze().add((int) Double.parseDouble((node6List.item(b)).getTextContent()));
                                                                    }
                                                                }
                                                            }
                                                            break;
                                                        }
                                                    }
                                                }
                                            //Gathering the high score data and storing in its respective objects
                                            setNth(new NoteTypeHit(getArroze().get(0), getArroze().get(1), getArroze().get(2), getArroze().get(3), getArroze().get(4), getArroze().get(5), getArroze().get(6), getArroze().get(7), getArroze().get(8)));
                                            setRadar(new RadarValues(getArro().get(0), getArro().get(1), getArro().get(2), getArro().get(3), getArro().get(4)));
                                            setNscores(new NoteScores(getArroz().get(0), getArroz().get(1), getArroz().get(2), getArroz().get(3), getArroz().get(4), getArroz().get(5), getArroz().get(6), getArroz().get(7), getArroz().get(8), getArroz().get(9)));
                                            setHighscore(new HighScore(getName(), getGrade(), getScore(), getPercent(), getDate(), getRadar(), getNth(), getNscores()));
                                            //Just adding that highscore to the list
                                            getHighscores().add(getHighscore());
                                        }

                                }
                                    
                            }
                            Difficulty stepDifficulty = new Difficulty(songName, numTimes, level, steptype, (ArrayList) highscores.clone());
                            totTimes += numTimes;
                            difficulties.add(stepDifficulty);                           
                            highscores.clear();
                            
                        }

                    }

                }
                  
            }
            
            setSong(new Song(getPackName(), getSongName(), (ArrayList) difficulties.clone(), totTimes));
            searchTimesPlayed.put(getSong().getTitle(), getSong().getTimesPlayed());
            totTimes = 0;
            if (!"null".equals(getSong().getTitle())) {
                getAllSongs().add(getSong());
                
            }
            difficulties.clear();
            System.out.println(getSong().getTitle() + getSong().getTimesPlayed());
            setPrevPackName(getPackName());       
        }   
            
        } catch (IOException | ParserConfigurationException | SAXException e) {
            }
        for (int i = 0; i < getAllSongs().size(); i++) {            
            for (int o = 0; o < getAllSongs().get(i).getDifficulties().size(); o++) {
            	String pack = getAllSongs().get(i).getPack();
            	String song = getAllSongs().get(i).getTitle();
            	String steptype = getAllSongs().get(i).getDifficulties().get(o).getSteptype();
            	String level = getAllSongs().get(i).getDifficulties().get(o).getLevel();
            	for (int w = 0; w < getAllSongs().get(i).getDifficulties().get(o).getPScores().size(); w++) {
            		String name = getAllSongs().get(i).getDifficulties().get(o).getPScores().get(w).getName();
            		String grade = getAllSongs().get(i).getDifficulties().get(o).getPScores().get(w).getGrade();
            		double percent = getAllSongs().get(i).getDifficulties().get(o).getPScores().get(w).getPercent();
            		int points = getAllSongs().get(i).getDifficulties().get(o).getPScores().get(w).getScore();
            		String date = getAllSongs().get(i).getDifficulties().get(o).getPScores().get(w).getDate();
            			SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            			SimpleDateFormat formate = new SimpleDateFormat("EEE. MMM d, yyyy hh:mmaaa");           			
						Date date1 = new Date();
						try {
							date1 = formatter6.parse(date);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						String datetime = formate.format(date1);
						
                        String[] obj = {pack, song, steptype, level, name, grade, percent + "%", points + "", datetime};
                        searchPack.put(pack, obj);
                        searchName.put(name, obj);
                        searchSong.put(song, obj);
                        searchType.put(steptype, obj);
                        searchLevel.put(level, obj);
                        searchGrade.put(grade, obj);
                        searchPercent.put(percent + "%", obj);
                        searchScore.put(points + "", obj);
                        searchDate.put(datetime, obj);
                        displayedData.add(obj);
            	}
            }
        }
    }

    public ArrayList<String> simplify() {
        ArrayList<String> str = new ArrayList<>();
        getAllSongs().forEach((n) -> {
            n.simplify().forEach((p) -> {
                str.add(p);
            });
        });
        return str;
    }
    public String convertGrade(String tierGrade) {
    	String dynamite = tierGrade;
    	switch(tierGrade) {
        case "Tier17":
            dynamite = "D";
            break;	
        case "Tier16":
            dynamite = "C-";
            break;
        case "Tier15":
            dynamite = "C";
            break;
        case "Tier14":
            dynamite = "C+";
            break;
        case "Tier13":
            dynamite = "B-";
            break;
        case "Tier12":
            dynamite = "B";
            break;
        case "Tier11":
            dynamite = "B+";
            break;
        case "Tier10":
            dynamite = "A-";
            break;
        case "Tier09":
            dynamite = "A";
            break;
        case "Tier08":
            dynamite = "A+ ";
            break;
        case "Tier07":
            dynamite = "S-";
            break;
        case "Tier06":
            dynamite = "S";
            break;
        case "Tier05":
            dynamite = "S+";
            break;
        case "Tier04":
            dynamite = "\u2606";
            break;
        case "Tier03":
            dynamite = "\u2606\u2606";
            break;
        case "Tier02":
            dynamite = "\u2606\u2606\u2606";
            break;
        case "Tier01":
            dynamite = "\u2606\u2606\u2606\u2606";
            break;
        case "Failed":
            dynamite = "Failure";
            break;	
    	}
		return dynamite;
    }
    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Pack");
        headers.add("Song");
        headers.add("StepType");
        headers.add("Level");
        headers.add("Name");
        headers.add("Grade");
        headers.add("Percent");
        headers.add("Points");
        headers.add("Date");
        return headers;
    }
    

    /**
     * @param searchByField the searchByField to set
     */
    public void setSearchByField(int searchByField) {
        this.searchByField = searchByField;
    }
    public int getAdditionalInfo(String nameOfSong) {
        
        return searchTimesPlayed.get(nameOfSong);
    }
    @Override
    public boolean search(String searchTerm) {
    	ArrayList<Map<String, String[]>> searches = new ArrayList<>();
    	searches.add(searchPack);
    	searches.add(searchSong);
    	searches.add(searchType);
    	searches.add(searchLevel);
    	searches.add(searchName);
    	searches.add(searchGrade);
    	searches.add(searchPercent);
    	searches.add(searchScore);
    	searches.add(searchDate);
        int counter = 0;
        for (int w = 0; w < 9; w++) {
            if(searchByField == w) {
                found = searches.get(w).containsKey(searchTerm);
                if (found) {
                for (String[] i : displayedData) {
                	
                    counter++;
                    if (i[w] == searches.get(w).get(searchTerm)[w]) {
                        
                        foundIndex = counter;
                    }
                }
                }
            }
        }

        return found;
    }
    /**
     * @param firstLineToDisplay the firstLineToDisplay to set
     */
    @Override
    public void setFirstLineToDisplay(int firstLineToDisplay) {
        
        this.firstLineToDisplay = firstLineToDisplay;
        if(firstLineToDisplay < 0) {
            this.firstLineToDisplay = 0;
        }
        if (firstLineToDisplay + linesBeingDisplayed > lastLineToDisplay) {
            this.firstLineToDisplay = (lastLineToDisplay - linesBeingDisplayed);
        }
    }

    /**
     * @return the lineToHighlight
     */
    @Override
    public int getLineToHighlight() {
        return lineToHighlight;
    }

    /**
     * @param lineToHighlight the lineToHighlight to set
     */
    @Override
    public void setLineToHighlight(int lineToHighlight) {
        this.lineToHighlight = lineToHighlight;
    }

    /**
     * @return the lastLineToDisplay
     */
    @Override
    public int getLastLineToDisplay() {
        return lastLineToDisplay;
    }

    /**
     * @param lastLineToDisplay the lastLineToDisplay to set
     */
    @Override
    public void setLastLineToDisplay(int lastLineToDisplay) {
        this.lastLineToDisplay = firstLineToDisplay + linesBeingDisplayed - 1;
    }


    @Override
    public void sort(int sortField, int sortType) {

        if (sortFire == sortField) {
                sortFire=-1;
                displayedData = Sort.getSorted(sortField, sortFire, displayedData);	
                }
        else {
                displayedData = Sort.getSorted(sortField, sortType, displayedData);
                sortFire = sortField;
                }
    }
    public boolean getFound() {
        return found;
    }

    /**
     * @param found the found to set
     */
    public void setFound(boolean found) {
        this.found = found;
    }

        
}

