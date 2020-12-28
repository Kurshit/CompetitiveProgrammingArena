//package com.kurshit.leetcode.pastgoogle;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//
//public class MostSimilarPathAirports {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public static List<String> similarAirportRoute(List<List<String>> routes, List<String> initial_routes) {
//
//		TreeMap<String, List<String>> edges = new TreeMap<>();
//
//
//		for(int i=0;i<routes.size();i++){
//
//			List<String> l1 = edges.getOrDefault(routes.get(i).get(0), new ArrayList<String>());
//			l1.add(routes.get(i).get((1)));
//			edges.put(routes.get(i).get(0), l1);
//
//			List<String> l2 = edges.getOrDefault(routes.get(i).get(1), new ArrayList<String>());
//			l2.add(routes.get(i).get((0)));
//			edges.put(routes.get(i).get(1), l2);			
//
//		}
//
//		int opt = -1;
//		List<String> route = new ArrayList<>();
//		Set<String> points = new HashSet<>();
//		List<String>ans = new ArrayList<>();
//
//		dfs(0,0,route,points,opt, initial_routes,edges,ans);        
//		return ans;
//
//	}
//
//	private static void dfs(int depth, int value, List<String> route, Set<String> points, int opt, List<String> initial_routes,
//			TreeMap<String, List<String>> edges, List<String> ans) {
//
//		if(depth==initial_routes.size()){
//			if(value>opt) {
//				opt=value;
//				ans=route;
//			}
//			return;
//		}
//
//		int max_value=value;
//		for(int i=depth;i<initial_routes.size();i++)
//			max_value+=initial_routes.get(i).length();
//		if(max_value<=opt) return;// trivial pruning
//
//		List<Pair> S;
//		if(depth==0){//need to choose the first airport, special case, there is no previous airport
//			for(List<String> it=edges.firstEntry().getValue() ; it!=edges.end(); ++it){
//				string name=it->first;
//				int v=cost(name,initial_route[0]);
//				S.push_back({v,name});
//			}
//		}
//		else{
//			string s0=route[depth-1];
//			for(string name:edges[s0])
//				S.push_back({cost(name,initial_route[depth]),name});            
//		}
//		sort(S.begin(),S.end());
//
//		for(int i=S.size()-1;i>=0;i--){
//			string airport=S[i].second;
//			if(points.count(airport)>0)continue;
//
//			points.emplace(airport);            
//			route.push_back(airport);            
//			dfs(depth+1,value+S[i].first,route,points,opt,initial_route,edges,ans);
//			points.erase(airport);
//			route.pop_back();
//		}
//	}
//
//
//
//}
//
//class Pair {
//	int first;
//	String second;
//}
