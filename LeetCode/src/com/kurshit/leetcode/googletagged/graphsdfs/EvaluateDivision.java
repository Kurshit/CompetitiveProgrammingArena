package com.kurshit.leetcode.googletagged.graphsdfs;

/*
    Problem : Evaluate Division # 399
    Problem Source : https://leetcode.com/problems/evaluate-division/
    Solution Source : https://leetcode.com/problems/evaluate-division/solution/
    Problem : You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

    You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

    Return the answers to all queries. If a single answer cannot be determined, return -1.0.

    Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.



    Example 1:

    Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
    Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
    Explanation:
    Given: a / b = 2.0, b / c = 3.0
    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
    return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

 */


/*
    Solution Idea : Whenever there is a binary relationship between the equations, graph may always be used.

    We will use here Graph represented as HashMap and will perform the dfs
 */

import java.util.*;

public class EvaluateDivision {

    public static void main(String[] args) {
//        List<List<String>> equations = new ArrayList<>();
//        equations.add(Arrays.asList("a","b"));
//        equations.add(Arrays.asList("b","c"));
//
//        double[] values = {2.0, 3.0};
//
//        List<List<String>> queries = new ArrayList<>();
//
//        queries.add(Arrays.asList("a", "c"));
//        queries.add(Arrays.asList("b", "a"));
//        queries.add(Arrays.asList("a", "e"));
//        queries.add(Arrays.asList("a", "a"));
//        queries.add(Arrays.asList("x", "x"));
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1","x2"));
        equations.add(Arrays.asList("x2","x3"));
        equations.add(Arrays.asList("x3","x4"));
        equations.add(Arrays.asList("x4","x5"));

        double[] values = {3.0, 4.0, 5.0, 6.0};

        List<List<String>> queries = new ArrayList<>();

        queries.add(Arrays.asList("x2", "x4"));
        //queries.add(Arrays.asList("b", "a"));
        //queries.add(Arrays.asList("a", "e"));
        //queries.add(Arrays.asList("a", "a"));
        //queries.add(Arrays.asList("x", "x"));

        EvaluateDivision eval = new EvaluateDivision();
        System.out.println(Arrays.toString(eval.calcEquation(equations, values, queries)));

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);

            if(!graph.containsKey(a) || !graph.containsKey(b)) {
                result[i] = -1.0;
            } else if(a == b) {
                result[i] = 1.0;
            } else {
                HashSet<String> visited = new HashSet<>();
                result[i] = dfs(graph, a, b, visited, 1.0);
            }
        }

        return result;

    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0);
            String v = equation.get(1);
            graph.putIfAbsent(u, new HashMap<String, Double>());
            graph.putIfAbsent(v, new HashMap<String, Double>());

            graph.get(u).put(v, values[i]);
            graph.get(v).put(u, 1/values[i]);
        }

        return graph;

    }

    private double dfs(Map<String, Map<String, Double>> graph, String u, String v, HashSet<String> visited, double accProduct) {

        visited.add(u);
        double res = -1.0;

        Map<String, Double> nbr = graph.get(u);
        if(nbr.containsKey(v)) {
            res = accProduct * nbr.get(v);
        } else {
            for(Map.Entry<String, Double> entry : nbr.entrySet()) {
                String nextNode = entry.getKey();
                if(!visited.contains(nextNode)) {
                    res = dfs(graph, nextNode, v, visited, accProduct * entry.getValue());

                    if(res != -1.0)
                        break;
                }
            }
        }

        visited.remove(u);
        return  res;
    }
}
