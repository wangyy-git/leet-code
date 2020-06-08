package com.wanyy.ltd.datastructure.tree;

public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode() {
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 1)	先输出当前节点(初始的时候是root节点)；
     * 2)	如果左子节点不为空，则递归继续前序遍历；
     * 3)	如果右子节点不为空，则递归继续前序遍历；
     */
    public void preOrderIterator(){
        System.out.println(this);
        //递归向左遍历
        if (this.left != null){
            this.left.preOrderIterator();
        }
        //递归向右遍历
        if (this.right != null){
            this.right.preOrderIterator();
        }
    }

    public HeroNode preOrderSearch(int no){
        
        if (this.no == no){
            return this;
        }
        //递归向左遍历
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.preOrderSearch(no);
        }
        System.out.println("执行了前序查找...");
        if (heroNode != null){
            return heroNode;
        }
        
        //递归向右遍历
        if (this.right != null){
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }
    
    //在二叉树中判断是否存在  此步骤仅做删除即可
    public boolean deleteAll(int no){
        boolean isDelete = false;
        if (this.left != null && this.left.no == no){
            this.left = null;
            return true;
        } else if (this.right != null && this.right.no == no){
            this.right = null;
            return true;
        }
        if (this.left != null){
            isDelete = this.left.deleteAll(no);
        }
        if (isDelete) return true;
        
        if (this.right != null){
            isDelete = this.right.deleteAll(no);
        }
        return isDelete;
    }
    
    //TODO 非叶子节点不是完全删除
    //如果其下只有一个节点则用该节点代替
    //如果有两个子节点 左节点代替，右节点仍然作为右节点
    public boolean deleteAndReplace(int no){
        boolean delete = false;
        if (this.left != null && this.left.no == no){
            if (this.left.left != null && this.left.right != null){
                HeroNode right = this.left.right;
                this.left = this.left.left;
                this.left.right = right;
            } else if (this.left.left != null /*&& this.left.right == null 必然为true*/) {
                this.left = this.left.left;
                this.left.right = null;
            } else if(this.left.right != null){
                this.left = this.left.right;
                this.left.left = null;
            }
            return true;
        } else if (this.right != null && this.right.no == no){
            if (this.right.left != null && this.right.right != null){
                HeroNode right = this.right.right;
                this.right = this.right.left;
                this.right.right = right;
            } else if (this.right.left != null /*&& this.left.right == null 必然为true*/) {
                this.right = this.right.left;
                this.right.right = null;
            } else if(this.right.right != null){
                this.right = this.right.right;
                this.right.left = null;
            }
            return true;
        }

        if (this.left != null){
            delete = this.left.deleteAll(no);
        }
        if (delete) return true;

        if (this.right != null){
            delete = this.right.deleteAll(no);
        }
        return delete;
    }
    
    /**
     * 1)	如果当前节点的左子节点不为空，递归中序遍历；
     * 2)	输出当前节点；
     * 3)	如果当前节点的右子节点不为空，递归中序遍历；
     */
    public void infixOrderIterator(){
        //递归向左遍历
        if (this.left != null){
            this.left.infixOrderIterator();
        }
        System.out.println(this);
        //递归向右遍历
        if (this.right != null){
            this.right.infixOrderIterator();
        }
    }

    public HeroNode infixOrderSearch(int no){
        
        //递归向左遍历
        HeroNode heroNode = null;
        if (this.left != null){
//            System.out.println("左");
            heroNode = this.left.infixOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        System.out.println("执行了中序查找...");
        if (this.no == no){
            return this;
        }
        //递归向右遍历
        if (this.right != null){
//            System.out.println("右");
            heroNode = this.right.infixOrderSearch(no);
        }
        return heroNode;
    }

    /**
     * 1)	如果当前节点的左子节点不为空，递归后序遍历；
     * 2)	如果当前节点的右子节点不为空，递归后序遍历；
     * 3)	输出当前节点
     */
    public void afterOrderIterator(){

        //递归向左遍历
        if (this.left != null){
            this.left.afterOrderIterator();
        }
        //递归向右遍历
        if (this.right != null){
            this.right.afterOrderIterator();
        }
        System.out.println(this);
    }

    public HeroNode afterOrderSearch(int no){
        
        //递归向左遍历
        HeroNode heroNode = null;
        if (this.left != null){
            heroNode = this.left.afterOrderSearch(no);
        }
        if (heroNode != null){
            return heroNode;
        }
        
        //递归向右遍历
        if (this.right != null){
            heroNode = this.right.afterOrderSearch(no);
        }
        
        if (heroNode != null){
            return heroNode;
        }

        System.out.println("执行了后序查找...");
        if (this.no == no){
            return this;
        }
        return null;
    }
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
