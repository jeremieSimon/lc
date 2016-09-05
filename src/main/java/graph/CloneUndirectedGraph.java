package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/clone-graph/
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class CloneUndirectedGraph {

     static class UndirectedGraphNode {
          int label;
          List<UndirectedGraphNode> neighbors;
          UndirectedGraphNode(int x) {
              label = x;
              neighbors = new ArrayList<UndirectedGraphNode>();
          }
        @Override
        public String toString() {
            return "UndirectedGraphNode [label=" + label + "]";
        }
    }

     public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
         Set<UndirectedGraphNode> undiscovered = new HashSet<>();
         Queue<UndirectedGraphNode> undiscoveredQueue = new LinkedList<>();
         Set<UndirectedGraphNode> discovered = new HashSet<>();

         undiscovered.add(node);
         undiscovered.addAll(node.neighbors);
         undiscoveredQueue.add(node);
         undiscoveredQueue.addAll(node.neighbors);

         while (!undiscovered.isEmpty()) {
             UndirectedGraphNode n = undiscoveredQueue.poll();
             undiscovered.remove(n);
             discovered.add(n);
             for (UndirectedGraphNode nei: n.neighbors) {
                 if (!discovered.contains(nei) && !undiscovered.contains(nei)) {
                     undiscovered.add(nei);
                     undiscoveredQueue.add(nei);
                  }
             }
         }
         Map<Integer, UndirectedGraphNode> clonedNodes = new HashMap<>();
         for (UndirectedGraphNode discoveredNode: discovered) {
             clonedNodes.put(discoveredNode.label,
                 new UndirectedGraphNode(discoveredNode.label));
         }

         for (UndirectedGraphNode discoveredNode: discovered) {
             UndirectedGraphNode clonedNode = clonedNodes.get(discoveredNode.label);
             List<UndirectedGraphNode> neighbors = new ArrayList<>();
             for (UndirectedGraphNode nei: discoveredNode.neighbors) {
                 neighbors.add(clonedNodes.get(nei.label));
             }
             clonedNode.neighbors = neighbors;
         }
         return clonedNodes.get(node.label);
     }

     public static void main(String[] args) {
         //{0,1,2#1,2#2,2}.
         UndirectedGraphNode n0 = new UndirectedGraphNode(0);
         System.out.println(cloneGraph(n0));
         UndirectedGraphNode n1 = new UndirectedGraphNode(1);
         UndirectedGraphNode n2 = new UndirectedGraphNode(2);
         List<UndirectedGraphNode> nei0 = new ArrayList<>();
         List<UndirectedGraphNode> nei1 = new ArrayList<>();
         List<UndirectedGraphNode> nei2 = new ArrayList<>();
         nei0.add(n1);
         nei0.add(n2);
         n0.neighbors = nei0;

         nei1.add(n0);
         nei1.add(n2);
         n1.neighbors = nei1;

         nei2.add(n0);
         nei2.add(n1);
         nei2.add(n2);
         n2.neighbors = nei2;

     }
}
