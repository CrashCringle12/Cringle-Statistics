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
    Map<String, ArrayList<Song>> searchByName = new HashMap<>();
    Map<String, Song> searchSongName = new HashMap<>();
    Map<String, ArrayList<Song>> searchTier = new HashMap<>();
    Map<String, ArrayList<Song>> searchPercent = new HashMap<>();
    Map<Integer,ArrayList<Song>> searchTimesPlayed = new HashMap<>();
    Map<String, ArrayList<Song>> searchLastPlayed= new HashMap<>();
    Map<String, ArrayList<Song>> searchDifficulty = new HashMap<>();
    Map<String, ArrayList<Song>> searchModifiers = new HashMap<>();
    Map<String, ArrayList<Song>> searchType = new HashMap<>();
    Map<String, ArrayList<Song>> searchPack= new HashMap<>();
    
    ArrayList<Song> pack = new ArrayList<>();
    ArrayList<Difficulty> difficulties;
    Song song;
   
    String name;
    double percent;
    int score;
    String grade;
    RadarValues radar;
    NoteTypeHit nth;
    NoteScores Nscores;
    String prevPackName = "";
    ArrayList<Integer> arroz = new ArrayList<>();
    ArrayList<Integer> arroze = new ArrayList<>();
    ArrayList<Double> arro = new ArrayList<>();
    String packName;
    String songName;
    Difficulty difficulty;
    String steptype;
    String level;
    int numTimes;
 
    String date;
    HighScore highscores;
    public StatsData() {
        difficulties = new ArrayList<>();
        ReadStatisticsFromXML();
        

   }
    public void ReadStatisticsFromXML() {
        try {
            
            File stats = new File("src\\Model\\Casual-Stats.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document cStats = dBuilder.parse(stats);
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
                    //System.out.print(songString[1] + ":   " + songString[2] + "\n");
                    packName = songString[1];
                    songName = songString[2];
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
                     if (node1.getNodeType() == node1.ELEMENT_NODE) {
                        Element step = (Element) node1;
                        level = step.getAttribute("Difficulty");
                        steptype = step.getAttribute("StepsType");
                        //Let's make the step type prettier
                        if (steptype.equals("dance-single")) {
                            steptype = "Singles";
                        }
                        else {steptype = "Doubles";}
                        //System.out.println(steptype + ": " + level);

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
                                                //if (hsElementos.getParentNode() == node3) {
                                                    String nodeName = hsElementos.getNodeName();
                                                    String nodeValue = hsElementos.getTextContent();
                                                    //System.out.println(nodeName +  ": " + hsElementos.getTextContent());
                                                    switch(nodeName) {
                                                        case "Name":
                                                            name = nodeValue;
                                                            break;
                                                        case "Grade":
                                                            grade = nodeValue;
                                                            break;
                                                        case "Score":
                                                            score = Integer.parseInt(nodeValue);
                                                            break;
                                                        case "PercentDP":
                                                            percent = Double.parseDouble(nodeValue);
                                                            break;
                                                        case "DateTime":
                                                            date = nodeValue;
                                                            break;
                                                        case "TapNoteScores":
                                                            NodeList node5List = hsElementos.getChildNodes();
                                                            
                                                            for (int b = 0; b < node5List.getLength(); b++ ) {
                                                                if (node5List.item(b).getNodeType() == node5List.item(b).ELEMENT_NODE) {
                                                                    //System.out.println(b + ": " +(node5List.item(b)).getTextContent() + "-" + node5List.item(b).getNodeType());
                                                                    arroz.add(Integer.parseInt((node5List.item(b)).getTextContent()));
                                                                }
                                                            }
                                                            break;

                                                        case "RadarValues":
                                                            NodeList node6List = hsElementos.getChildNodes();
                                                            for (int b = 0; b < node6List.getLength(); b++ ) {
                                                                if (node6List.item(b).getNodeType() == node6List.item(b).ELEMENT_NODE) {
                                                                    arro.add(Double.parseDouble((node6List.item(b)).getTextContent()));
                                                                    if (arro.size() > 4) {
                                                                        arroze.add((int) Double.parseDouble((node6List.item(b)).getTextContent()));
                                                                    }
                                                                }
                                                            }
                                                            break;
                                                    }
                                                    

                                                //}
                                       }
                                        
                                   }
                                        nth = new NoteTypeHit(arroze.get(0), arroze.get(1), arroze.get(2), arroze.get(3), arroze.get(4), arroze.get(5), arroze.get(6), arroze.get(7), arroze.get(8));
                                        radar = new RadarValues(arro.get(0), arro.get(1), arro.get(2), arro.get(3), arro.get(4));
                                        Nscores = new NoteScores(arroz.get(0), arroz.get(1), arroz.get(2), arroz.get(3), arroz.get(4), arroz.get(5), arroz.get(6), arroz.get(7), arroz.get(8), arroz.get(9));
                                        highscores = new HighScore(name, grade, score, percent, date, radar, nth, Nscores);

                                }
                            }
                        }                   
                    }
                }
               difficulties.add(new Difficulty(songName, level, steptype, highscores));
                
            }
            }
            song = new Song(packName, songName, difficulties);
            if (song.getTitle() != "null") {
                pack.add(song);
            }
            if (packName != prevPackName) {
                searchPack.put(packName, pack);
            }
            prevPackName = packName;
         }
            
      } catch (IOException | ParserConfigurationException | SAXException e) {
         e.printStackTrace();
      }        
    }
    public ArrayList<String> viewData() {
        ArrayList<String> listo = new ArrayList<>();
        for (Song o : pack) {
            listo.add(o.toString());
        }
        return listo;
    }
}
