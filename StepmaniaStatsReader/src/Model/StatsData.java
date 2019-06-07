package Model;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author L627B
 */
import java.io.File;
import static java.lang.Integer.parseInt;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class StatsData {
    private Map<String, ArrayList<Song>> searchByName = new HashMap<>();
    private Map<String, Song> searchSongName = new HashMap<>();
    private Map<String, ArrayList<Song>> searchTier = new HashMap<>();
    private Map<String, ArrayList<Song>> searchPercent = new HashMap<>();
    private Map<Integer,ArrayList<Song>> searchTimesPlayed = new HashMap<>();
    private Map<String, ArrayList<Song>> searchLastPlayed= new HashMap<>();
    private Map<String, ArrayList<Song>> searchDifficulty = new HashMap<>();
    private Map<String, ArrayList<Song>> searchModifiers = new HashMap<>();
    private Map<String, ArrayList<Song>> searchType = new HashMap<>();
    private Map<String, ArrayList<Song>> searchPack= new HashMap<>();
    
    private ArrayList<Integer> arroz = new ArrayList<>();
    private ArrayList<Integer> arroze = new ArrayList<>();
    private ArrayList<Double> arro = new ArrayList<>();

    private ArrayList<Song> pack = new ArrayList<>();
    private ArrayList<Difficulty> difficulties;
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
    private Difficulty difficulty;
    private String steptype;
    private String level;
    private int numTimes;
    private String prevPackName;

    private File stats;

    
    public StatsData() {
        difficulties = new ArrayList<>();
        prevPackName = "";
        stats = new File ("H:\\My Documents\\NetBeansProjects\\StatsReader\\StepmaniaStatsReader\\src\\Model\\Casual-Stats.xml");
        ReadStatisticsFromXML();

   }
    public void ReadStatisticsFromXML() {
        try {
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
                difficulties.clear();
                //Assigns that specific song to an nNode. Apparently nLists are not iterable, which is why I used this method
                Node nNode = nList.item(i);
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element theSong = (Element) nNode;

                  //This gets the attribute information of each song which is just the file path, and makes it look pretty
                  String directory = theSong.getAttribute("Dir");
                  String[] songString = directory.split("/");

                  try {
                    //System.out.print(songString[1] + ":   " + songString[2] + "\n");
                        setPackName(songString[1]);
                        setSongName(songString[2]);
                  }
                  catch (Exception y) {
                      System.out.println("There seems to be a problem");
                  }

    //********************************************************************************************************************************              
                  //Let's get all the steps available for this song
                  NodeList steps = theSong.getElementsByTagName("Steps");
                    
                  for (int count = 0; count < steps.getLength(); count++) {
                    highscores.clear();
                     Node node1 = steps.item(count);
                     //Now Let's label them properly
                     if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element step = (Element) node1;
                            setLevel(step.getAttribute("Difficulty"));
                            setSteptype(step.getAttribute("StepsType"));
                            //Let's make the step type prettier
                            if (getSteptype().equals("dance-single")) {
                                    setSteptype("Singles");
                            }
                            else {  setSteptype("Doubles");}
                            //System.out.println(steptype + ": " + level);
                            System.out.println(songName + " " + steptype + level + "\n");
    //********************************************************************************************************************************                       
                            //Let's get all the HighScore stuffs available for this song
                            NodeList hs = step.getElementsByTagName("HighScoreList");  
                            for (int t = 0; t < hs.getLength(); t++) {
                                Node node2 = hs.item(t);
                                
                                if (node2.getNodeType() == node2.ELEMENT_NODE) {
                                    Element hsElement = (Element) node2;
                                    //System.out.println("High Scores");

    //********************************************************************************************************************************                              
                                    NodeList highScoreList = hsElement.getElementsByTagName("HighScore");              
                                    for (int w = 0; w < highScoreList.getLength(); w++) {
                                        Node node3 = highScoreList.item(w);
                                        //Now Let's label them properly
                                        if (node1.getNodeType() == node3.ELEMENT_NODE) {
                                            Element highScoreElement = (Element) node3;
                                           // System.out.println("\n" + highScoreElement.getNodeName() + " " + (w+1) );

    //********************************************************************************************************************************                                      
                                            //Checkpoint: All highscores are in this list called highScoreList. An individual highscore is a node called node3
                                            NodeList hsList = highScoreElement.getElementsByTagName("*");
                                            
                                            for (int r = 0; r < hsList.getLength(); r++) {
                                               Node node4 = hsList.item(r);
                                               
                                               if (node4.getNodeType() == node4.ELEMENT_NODE) {
                                                    Element hsElementos = (Element) node4;
                                                    String nodeName = hsElementos.getNodeName();
                                                    String nodeValue = hsElementos.getTextContent();
                                                    //System.out.println(nodeName +  ": " + hsElementos.getTextContent());
                                                    switch(nodeName) {
                                                        case "Name":
                                                            setName(nodeValue);
                                                            break;
                                                        case "Grade":
                                                            setGrade(nodeValue);
                                                            break;
                                                        case "Score":
                                                            setScore(Integer.parseInt(nodeValue));
                                                            break;
                                                        case "PercentDP":
                                                            setPercent(Double.parseDouble(nodeValue));
                                                            break;
                                                        case "DateTime":
                                                            setDate(nodeValue);
                                                            break;
                                                        case "TapNoteScores":
                                                            NodeList node5List = hsElementos.getChildNodes();
                                                            for (int b = 0; b < node5List.getLength(); b++ ) {
                                                                if (node5List.item(b).getNodeType() == node5List.item(b).ELEMENT_NODE) {
                                                                    //System.out.println(b + ": " +(node5List.item(b)).getTextContent() + "-" + node5List.item(b).getNodeType());
                                                                    getArroz().add(Integer.parseInt((node5List.item(b)).getTextContent()));
                                                                }
                                                            }
                                                            break;
                                                        case "RadarValues":
                                                            NodeList node6List = hsElementos.getChildNodes();
                                                            for (int b = 0; b < node6List.getLength(); b++ ) {
                                                                if (node6List.item(b).getNodeType() == node6List.item(b).ELEMENT_NODE) {
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
                                            System.out.println(getHighscore().toString());
                                            System.out.println("*************************************");
                                            //Just adding that highscore to the list
                                            getHighscores().add(getHighscore());
                                        }
                                   
                                }
                            }                   
                        }
                    }
                    difficulty = new Difficulty(getSongName(), getLevel(), getSteptype(), getHighscores());
                    getDifficulties().add(difficulty);

                }
            }
            setSong(new Song(getPackName(), getSongName(), getDifficulties()));
            for (String g : song.simplify()) {
                System.out.println(g);
            }
                
            if (getSong().getTitle() != "null") {
                getPack().add(getSong());
            }
            if (getPackName() != getPrevPackName()) {
                getSearchPack().put(getPackName(), getPack());
            }
            setPrevPackName(getPackName());       
        }   
            
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            }
    }
    public ArrayList<String> simplify() {
        ArrayList<String> str = new ArrayList<>();
        for (Song n : pack) {
            for (String p : n.simplify()) {
                str.add(p);
            }
            
        }
        return str;
    }

    /**
     * @return the searchByName
     */
    public Map<String, ArrayList<Song>> getSearchByName() {
        return searchByName;
    }

    /**
     * @param searchByName the searchByName to set
     */
    public void setSearchByName(Map<String, ArrayList<Song>> searchByName) {
        this.searchByName = searchByName;
    }

    /**
     * @return the searchSongName
     */
    public Map<String, Song> getSearchSongName() {
        return searchSongName;
    }

    /**
     * @param searchSongName the searchSongName to set
     */
    public void setSearchSongName(Map<String, Song> searchSongName) {
        this.searchSongName = searchSongName;
    }

    /**
     * @return the searchTier
     */
    public Map<String, ArrayList<Song>> getSearchTier() {
        return searchTier;
    }

    /**
     * @param searchTier the searchTier to set
     */
    public void setSearchTier(Map<String, ArrayList<Song>> searchTier) {
        this.searchTier = searchTier;
    }

    /**
     * @return the searchPercent
     */
    public Map<String, ArrayList<Song>> getSearchPercent() {
        return searchPercent;
    }

    /**
     * @param searchPercent the searchPercent to set
     */
    public void setSearchPercent(Map<String, ArrayList<Song>> searchPercent) {
        this.searchPercent = searchPercent;
    }

    /**
     * @return the searchTimesPlayed
     */
    public Map<Integer,ArrayList<Song>> getSearchTimesPlayed() {
        return searchTimesPlayed;
    }

    /**
     * @param searchTimesPlayed the searchTimesPlayed to set
     */
    public void setSearchTimesPlayed(Map<Integer,ArrayList<Song>> searchTimesPlayed) {
        this.searchTimesPlayed = searchTimesPlayed;
    }

    /**
     * @return the searchLastPlayed
     */
    public Map<String, ArrayList<Song>> getSearchLastPlayed() {
        return searchLastPlayed;
    }

    /**
     * @param searchLastPlayed the searchLastPlayed to set
     */
    public void setSearchLastPlayed(Map<String, ArrayList<Song>> searchLastPlayed) {
        this.searchLastPlayed = searchLastPlayed;
    }

    /**
     * @return the searchDifficulty
     */
    public Map<String, ArrayList<Song>> getSearchDifficulty() {
        return searchDifficulty;
    }

    /**
     * @param searchDifficulty the searchDifficulty to set
     */
    public void setSearchDifficulty(Map<String, ArrayList<Song>> searchDifficulty) {
        this.searchDifficulty = searchDifficulty;
    }

    /**
     * @return the searchModifiers
     */
    public Map<String, ArrayList<Song>> getSearchModifiers() {
        return searchModifiers;
    }

    /**
     * @param searchModifiers the searchModifiers to set
     */
    public void setSearchModifiers(Map<String, ArrayList<Song>> searchModifiers) {
        this.searchModifiers = searchModifiers;
    }

    /**
     * @return the searchType
     */
    public Map<String, ArrayList<Song>> getSearchType() {
        return searchType;
    }

    /**
     * @param searchType the searchType to set
     */
    public void setSearchType(Map<String, ArrayList<Song>> searchType) {
        this.searchType = searchType;
    }

    /**
     * @return the searchPack
     */
    public Map<String, ArrayList<Song>> getSearchPack() {
        return searchPack;
    }

    /**
     * @param searchPack the searchPack to set
     */
    public void setSearchPack(Map<String, ArrayList<Song>> searchPack) {
        this.searchPack = searchPack;
    }

    /**
     * @return the arroz
     */
    public ArrayList<Integer> getArroz() {
        return arroz;
    }

    /**
     * @param arroz the arroz to set
     */
    public void setArroz(ArrayList<Integer> arroz) {
        this.arroz = arroz;
    }

    /**
     * @return the arroze
     */
    public ArrayList<Integer> getArroze() {
        return arroze;
    }

    /**
     * @param arroze the arroze to set
     */
    public void setArroze(ArrayList<Integer> arroze) {
        this.arroze = arroze;
    }

    /**
     * @return the arro
     */
    public ArrayList<Double> getArro() {
        return arro;
    }

    /**
     * @param arro the arro to set
     */
    public void setArro(ArrayList<Double> arro) {
        this.arro = arro;
    }

    /**
     * @return the pack
     */
    public ArrayList<Song> getPack() {
        return pack;
    }

    /**
     * @param pack the pack to set
     */
    public void setPack(ArrayList<Song> pack) {
        this.pack = pack;
    }

    /**
     * @return the difficulties
     */
    public ArrayList<Difficulty> getDifficulties() {
        return difficulties;
    }

    /**
     * @param difficulties the difficulties to set
     */
    public void setDifficulties(ArrayList<Difficulty> difficulties) {
        this.difficulties = difficulties;
    }

    /**
     * @return the song
     */
    public Song getSong() {
        return song;
    }

    /**
     * @param song the song to set
     */
    public void setSong(Song song) {
        this.song = song;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the percent
     */
    public double getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(double percent) {
        this.percent = percent;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the radar
     */
    public RadarValues getRadar() {
        return radar;
    }

    /**
     * @param radar the radar to set
     */
    public void setRadar(RadarValues radar) {
        this.radar = radar;
    }

    /**
     * @return the nth
     */
    public NoteTypeHit getNth() {
        return nth;
    }

    /**
     * @param nth the nth to set
     */
    public void setNth(NoteTypeHit nth) {
        this.nth = nth;
    }

    /**
     * @return the Nscores
     */
    public NoteScores getNscores() {
        return Nscores;
    }

    /**
     * @param Nscores the Nscores to set
     */
    public void setNscores(NoteScores Nscores) {
        this.Nscores = Nscores;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the highscores
     */
    public ArrayList<HighScore> getHighscores() {
        return highscores;
    }

    /**
     * @param highscores the highscores to set
     */
    public void setHighscores(ArrayList<HighScore> highscores) {
        this.highscores = highscores;
    }

    /**
     * @return the packName
     */
    public String getPackName() {
        return packName;
    }

    /**
     * @param packName the packName to set
     */
    public void setPackName(String packName) {
        this.packName = packName;
    }

    /**
     * @return the songName
     */
    public String getSongName() {
        return songName;
    }

    /**
     * @param songName the songName to set
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * @return the steptype
     */
    public String getSteptype() {
        return steptype;
    }

    /**
     * @param steptype the steptype to set
     */
    public void setSteptype(String steptype) {
        this.steptype = steptype;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the numTimes
     */
    public int getNumTimes() {
        return numTimes;
    }

    /**
     * @param numTimes the numTimes to set
     */
    public void setNumTimes(int numTimes) {
        this.numTimes = numTimes;
    }

    /**
     * @return the prevPackName
     */
    public String getPrevPackName() {
        return prevPackName;
    }

    /**
     * @param prevPackName the prevPackName to set
     */
    public void setPrevPackName(String prevPackName) {
        this.prevPackName = prevPackName;
    }

    /**
     * @return the stats
     */
    public File getStats() {
        return stats;
    }

    /**
     * @param stats the stats to set
     */
    public void setStats(File stats) {
        this.stats = stats;
    }

    /**
     * @return the highscore
     */
    public HighScore getHighscore() {
        return highscore;
    }

    /**
     * @param highscore the highscore to set
     */
    public void setHighscore(HighScore highscore) {
        this.highscore = highscore;
    }
}
