package com.wanyy.ltd.datastructure.dataStru.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    //存储订单
    private List<String> vertexList = new ArrayList<>();
    //存储相邻矩阵
    private int[][] edges;
    //边的数目
    private int numOfEdges;
    public static void main(String[] args) {
        
    }
    
    public Graph(int num){
        edges = new int[num][num];
    }
    
    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     *
     * 添加边
     * @param v1    表示第一个点的下标   
     *              eg：顶点A B C 对应的下标是0 1 2 3
     * @param v2    表示第二个点的下标
     * @param weight    矩阵中对应的值
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        //因为是无向图
        edges[v1][v2] = weight;
        numOfEdges++;
    }
}
