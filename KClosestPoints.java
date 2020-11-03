import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// points = [(0,1),(2,3),(3,-1),(-1,1)]
// ref = (0,0)
// k = 2

// pointDist = [1, sqrt(13), sqrt(10), sqrt(2)]

// Main class should be named 'Solution'
class Solution {
    static class Coordinate {
        int x;
        int y;
        
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
    
    public static void main(String[] args) {
       List<Coordinate> points = new ArrayList<>();
       points.add(new Coordinate(0, 1));
       points.add(new Coordinate(2, 3));
       points.add(new Coordinate(3, -1));
       points.add(new Coordinate(-1, 1));
       
       Coordinate ref = new Coordinate(0, 0);
       int k = 2;
       
       System.out.println(kClosestPoints(points, ref, k));
    }
    
    public static Set<Coordinate> kClosestPoints(List<Coordinate> coords, Coordinate ref, int k) {
        if (k >= coords.size()) {
            return new HashSet<Coordinate>(coords);
        }
        
        PriorityQueue<Coordinate> pq = new PriorityQueue<Coordinate>(k, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate c1, Coordinate c2) {
                double c1Dist = distance(c1, ref);
                double c2Dist = distance(c2, ref);
                
                if (c1Dist > c2Dist) {
                    return -1;
                }
                else if (c2Dist > c1Dist) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });
        
        for (int i = 0; i < k; i++) {
            pq.add(coords.get(i));
        }
        
        for (int i = k; i < coords.size(); i++) {
            Coordinate curr = coords.get(i);
            double currDist = distance(curr, ref);
            
            if (currDist < distance(pq.peek(), ref)) {
                pq.poll();
                pq.add(curr);
            }
        }
        
        Set<Coordinate> closestPoints = new HashSet<>();
        
        while (!pq.isEmpty()) {
            closestPoints.add(pq.poll());
        }
        
        return closestPoints;
        
    }
    
    private static double distance(Coordinate c1, Coordinate c2) {
        return Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2));
    }
}