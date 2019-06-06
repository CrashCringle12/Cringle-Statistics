/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author L627B
 */
public class NoteScores {
    int hitMine;
    int avoidMine;
    int checkpointMiss;
    int Miss;
    int w5;
    int w4;
    int w3;
    int w2;
    int w1;
    int checkpointHit;
    int letgo;
    int held;
    int missedHold;
    public NoteScores(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m) {
        hitMine = a;
        avoidMine = b;
        checkpointMiss = c;
        Miss = d;
        w5 = e;
        w4 = f;
        w3 = g;
        w2 = h;
        w1 = i;
        checkpointHit = j;
        letgo = k;
        held = l;
        missedHold = m;
    }
}
