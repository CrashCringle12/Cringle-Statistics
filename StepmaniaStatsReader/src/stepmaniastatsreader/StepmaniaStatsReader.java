package stepmaniastatsreader;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
/**
 *
 * @author L627B
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class StepmaniaStatsReader {

   public static void main(String[] args) {

      try {
         File stats = new File("src\\stepmaniastatsreader\\Casual-Stats.xml");
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
               String[] song = directory.split("/");
               
               try {
               System.out.print(song[1] + ":   " + song[2] + "\n");
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
                     String difficulty = step.getAttribute("Difficulty");
                     String steptype = step.getAttribute("StepsType");
                     //Let's make the step type prettier
                     if (steptype.equals("dance-single")) {
                         steptype = "Singles";
                     }
                     else {steptype = "Doubles";}
                     System.out.println(steptype + ": " + difficulty);
                     
 //********************************************************************************************************************************                       
                    //Let's get all the HighScore stuffs available for this song
                    NodeList hs = step.getElementsByTagName("HighScoreList");  
                    for (int t = 0; t < hs.getLength(); t++) {
                        Node node2 = hs.item(t);
                        if (node2.getNodeType() == node2.ELEMENT_NODE) {
                            Element hsElement = (Element) node2;
                            System.out.println(hsElement.getNodeName());
                            
 //********************************************************************************************************************************                              
                            NodeList highScoreList = hsElement.getElementsByTagName("HighScore");              
                            for (int w = 0; w < highScoreList.getLength(); w++) {
                                Node node3 = highScoreList.item(w);
                                //Now Let's label them properly
                                if (node1.getNodeType() == node3.ELEMENT_NODE) {
                                    Element highScoreElement = (Element) node3;
                                    System.out.println("\n" + highScoreElement.getNodeName() + " " + (w+1) );

 //********************************************************************************************************************************                                      
                                    //Checkpoint: All highscores are in this list called highScoreList. An individual highscore is a node called node3
                                    NodeList hsList = highScoreElement.getElementsByTagName("*");
                                    for (int r = 0; r < hsList.getLength(); r++) {
                                       Node node4 = hsList.item(r);
                                       if (node4.getNodeType() == node4.ELEMENT_NODE) {
                                            Element hsElementos = (Element) node4;
                                            if (hsElementos.getParentNode() == node3) {
                                                System.out.println(r + hsElementos.getNodeName());
                                            }
                                            
                                       }
                                   }
                                   
                                }
                         }
                   }                   
                  }
               }
            }
            }
            System.out.println("\n");
         }
      } catch (IOException | ParserConfigurationException | SAXException e) {
         e.printStackTrace();
      }
   }
}
