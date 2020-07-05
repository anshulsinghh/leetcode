class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        
        HashMap<Integer, ArrayList<Integer>> graph = generateGraph(numCourses, prerequisites);
        
        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegrees[prerequisites[i][0]]++;
        }
        
        int count = numCourses;
        Queue<Integer> bfs = new LinkedList<Integer>();
        
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) bfs.add(i);
        }
        
        while (!bfs.isEmpty()) {
            int course = bfs.poll();
            count--;
            
            for (int neighbor : graph.get(course)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    bfs.add(neighbor);
                }
            }
        }

        
        return count == 0;
    }
    
    private HashMap<Integer, ArrayList<Integer>> generateGraph(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        
        
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];
            int dependency = prerequisites[i][0];
            
            ArrayList<Integer> dependencies = graph.get(course);
            dependencies.add(dependency);
            graph.put(course, dependencies);
            
        }
        
        return graph;
    }
}
