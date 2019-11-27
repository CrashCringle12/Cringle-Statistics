/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
/**
 *
 * @author Lamar Cooley
 */
@XmlRootElement(name="Stats")
@Data
public class Stats {
    @XmlElementWrapper(name="SongScores")
    @XmlElement
    List<Song> Song;
    
    
}
