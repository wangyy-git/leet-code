package com.wanyy.ltd.datastructure.structure.recursion.puzzle;

/**
 * 迷宫回溯问题的实现
 */
public class Maze {
    public static void main(String[] args) {
        Maze maze = new Maze();
        int[][] mazeMap = new int[8][8];
        for (int i=0;i<mazeMap.length;i++){
            for (int j=0;j<mazeMap[i].length;j++){
                if (j==0 || i==0 || i==mazeMap.length-1 || j==mazeMap[i].length-1){
                    mazeMap[i][j] = 1;
                }
            }
        }
        mazeMap[3][1] = 1;
        mazeMap[3][2] = 1;
//        mazeMap[2][2] = 1;
//        mazeMap[1][2] = 1;
//        mazeMap[6][1] = 6;
        
        maze.showMaze(mazeMap);
        maze.calMaze(mazeMap,1,1);
        System.out.println("=================================");
        maze.showMaze(mazeMap);
        
    }

    /**
     * 解读迷宫
     * @param mazeMap   迷宫地图
     * @param iStart    i启动位置
     * @param jStart    j启动位置
     *   需要对具体某个位置定义一下当前状态：
     *   0 - 表示当前位置为初始状态
     *   1 - 表示当前位置为墙，不能再走
     *   2 - 表示当前位置已走过，不用再走了
     *   3 - 表示当前位置已走过，走不通
     *   也需要提前约定一个走的顺序 下 - 右 - 上 - 左
     */
    public boolean calMaze(int[][] mazeMap,int iStart,int jStart){
        if (mazeMap[6][1] == 2){ //表示走通了 实现了目标
            return true;
        } else if (mazeMap[iStart][jStart] == 0){ //表示当前位置还没有走  开始走
            mazeMap[iStart][jStart] = 2; //假定该位置是可以走的 且走通
            if (calMaze(mazeMap,iStart+1,jStart)){ //下
                return true;
            } else if (calMaze(mazeMap,iStart,jStart+1)) { //左
                return true;
            } else if (calMaze(mazeMap,iStart-1,jStart)) { //上
                return true;
            } else if (calMaze(mazeMap,iStart,jStart-1)) { //左
                return true;
            } else {
                mazeMap[iStart][jStart] = 3;
                return false;
            }
            

        } else {
            return false;
        }
        
    }
    
    
    public void showMaze(int[][] mazeMap){
        for (int[] m:mazeMap){
            for (int v:m){
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }
}
