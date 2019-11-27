package Model;

import javax.xml.parsers.*;

/**
 *
 * @author L627B
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lombok.Data;

@Data
public class StatsData {

    private Stats stats;
    private List<String[]> displayedData;
    private List<HighScore> sideData;
    public StatsData(File file) {
        jaxbXmlFileToObject(file);
    }

    private void jaxbXmlFileToObject(File xmlFile) {

        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Stats.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            stats = (Stats) jaxbUnmarshaller.unmarshal(xmlFile);
            fixData();
            System.out.println(stats.Song.get(0));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public List<String> getHeaders() {
        List<String> headers = new ArrayList<>();
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

    public void fixData() {
        displayedData = new ArrayList<>();
        sideData = new ArrayList<>();
        for (Song i : stats.getSong()) {
            i.songPack();
            String pack = i.getPack();
            String song = i.getTitle();
            for (Step o : i.getSteps()) {
                o.shortenType();
                String steptype = o.getStepsType();
                String level = o.getDifficulty();
                for (HighScore p : o.getPScores()) {
                    p.makeDateNice();
                    p.convertGrade();
                    String name = "".equals(p.Name) ? "[N/A]" : p.Name;
                    String grade = p.Grade;
                    double percent = Math.round(p.PercentDP*10000);
                    percent = percent/100;
                    int points = p.Score;
                    String date = p.DateTime;
                    p.getRadarv().makeScoresSimple();
                    sideData.add(p);
                    displayedData.add(new String[] {pack, song, steptype, level, name, grade, percent + "%", points + "", date});
                }
            }
        }
    }

}
