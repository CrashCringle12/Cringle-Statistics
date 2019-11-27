/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

/**
 *
 * @author Lamar Cooley
 */
@XmlRootElement(name="TapNoteScores")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TapNoteScores {
        private int HitMine;
        private int AvoidMine;
        private int CheckpointMiss;
        private int Miss;
        private int W5;
        private int W4;
        private int W3; 
        private int W2;
        private int W1;
        private int CheckpointHit;
        public TapNoteScores(){}
        public TapNoteScores(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j) {
            HitMine = a;
            AvoidMine = b;
            CheckpointMiss = c;
            Miss = d;
            W5 = e;
            W4 = f;
            W3 = g;
            W2 = h;
            W1 = i;
            CheckpointHit = j;
        }

    }
