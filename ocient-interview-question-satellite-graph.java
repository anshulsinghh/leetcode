import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Satellite {
    public char id;
    public HashMap<Character, Satellite> connections;
    public Satellite(char id) {
        this.id = id;
        connections = new HashMap<>();
    }
}

class Pair {
    public int distance;
    public char satellite;
    public char prev;
    
    public Pair(int dist, char sat, char prev) {
        this.distance = dist; this.satellite = sat; this.prev = prev;
    }
}

class Graph {
    Satellite root;
    HashMap<Character, Satellite> satelliteMap;
    
    public Graph() {
        satelliteMap = new HashMap<>();
    }
    
    public void addSatellite(char satelliteId) {
        Satellite s = new Satellite(satelliteId);
        
        if (root == null) {
            root = s;
        }
        
        satelliteMap.put(s.id, s);
    }
    
    public void printGraph() {
        for (char c : satelliteMap.keySet()) {
            Satellite s = satelliteMap.get(c);
            System.out.println(s.id + " -> " + s.connections.keySet().toString());
        }
    }
    
    public void addConnection(char satelliteId1, char satelliteId2) {
        Satellite first = satelliteMap.get(satelliteId1);
        Satellite second = satelliteMap.get(satelliteId2);
        
        first.connections.put(second.id, second);
        second.connections.put(first.id, first);
    }
    
    public void removeSatellite(char satelliteId) {
        Satellite toRemove = satelliteMap.get(satelliteId);
        for (char c : toRemove.connections.keySet()) {
            Satellite s = satelliteMap.get(c);
            s.connections.remove(toRemove.id);
        }
        
        satelliteMap.remove(toRemove.id);
    }
    
    public void removeConnection(char satelliteId1, char satelliteId2) {
        Satellite first = satelliteMap.get(satelliteId1);
        Satellite second = satelliteMap.get(satelliteId2);
        
        first.connections.remove(second.id);
        second.connections.remove(first.id);
    }
    
    public String bfs(char sat1, char sat2) {
        HashMap<Character, Integer> bestDistances = new HashMap<>();
        HashMap<Character, Character> prevs = new HashMap<>();
        
        HashSet<Character> visited = new HashSet<>();
        Queue<Pair> bfs = new LinkedList<>();
        
        
        for (char c : satelliteMap.keySet()) bestDistances.put(c, Integer.MAX_VALUE);
        bfs.add(new Pair(0, sat1, '$'));
        bestDistances.put(sat1, 0);
        
        while (!bfs.isEmpty()) {
            Pair p = bfs.poll();
            char sat = p.satellite;
            int dist = p.distance;
            char prev = p.prev;
            
            if (!visited.contains(sat)) {
                visited.add(sat);

                bestDistances.put(sat, dist);
                prevs.put(sat, prev);
                                
                if (sat == sat2) break;
                
                Satellite curr = satelliteMap.get(sat);
                for (char c : curr.connections.keySet()) {
                    if (!visited.contains(c)) bfs.add(new Pair(dist+1, c, curr.id));
                }
            }
        }
        
        
        String res = "";
        
        char c = sat2;
        while (c != sat1) {
            char prev = prevs.get(c);
            
            res = c + "->" + res;
            
            c = prev;
        }
        res = sat1 + "->" + res;
        
        System.out.println(bestDistances.toString());
        System.out.println(prevs.toString());
        
        return res.substring(0, res.length()-2);
    }
}

public class Solution {
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Graph graph = new Graph();

        graph.addSatellite('A');
        graph.addSatellite('B');
        graph.addSatellite('C');
        graph.addSatellite('D');
        graph.addSatellite('E');
        graph.addSatellite('F');
        graph.addSatellite('G');
        graph.addSatellite('H');
        graph.addSatellite('I');
        graph.addSatellite('J');
        graph.addSatellite('K');
        
        graph.addConnection('A', 'B');
        graph.addConnection('A', 'D');
        graph.addConnection('A', 'E');
        graph.addConnection('A', 'K');
        graph.addConnection('A', 'I');

        graph.addConnection('B', 'C');
        graph.addConnection('B', 'G');

        graph.addConnection('C', 'D');
        graph.addConnection('C', 'J');

        graph.addConnection('D', 'E');

        graph.addConnection('E', 'F');

        graph.addConnection('H', 'I');
        //System.out.println(graph.dfs('F', 'H'));
        graph.addConnection('D', 'H');
        System.out.println(graph.bfs('H', 'C'));

    }
}
