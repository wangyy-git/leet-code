package com.wanyy.ltd.datastructure.tree.sortTree;

/**
 * 对于一个二叉排序树的任何一个非叶子节点:
 * 要求左子节点的值比当前节点的值小，右子节点比当前的值大；
 * 如果是相同的值，可以放在左子节点或者右子节点；
 */
public class BinarySortTree {
    private SortNode root;
    public BinarySortTree(SortNode root) {
        this.root = root;
    }
    public void add(SortNode newNode){
        if (this.root == null) return;
        this.root.createSortTree(newNode);
    }
    
    public void delete(int value){
        if (root == null) return;
        if (root.left == null && root.right == null && root.value == value){
            this.root = null;
            return;
        }
        SortNode target = search(value);
        if (target == null){ return; }
        SortNode parent = searchParent(value);
        //删除的是叶子节点
        if (target.left == null && target.right == null){
            if (parent.left != null && target.value == parent.left.value){
                parent.left = null;
            } else {
                //已经确认父子关系  不是左必是右
                parent.right = null;
            }
        }else if (target.left != null && target.right != null){
            //删除的是有两个子节点
            SortNode lastRightNode = target.getRightBranchSmallestNode();
            int temp = lastRightNode.value;
            this.delete(temp);
            target.value = temp;
        } else if (target.left != null){
            //待删除节点还有一个左子节点
            //假如剩余两个节点 删除root则存在其父节点不存在的情况 
            // 报空指针 加parent == null
            if (parent == null){
                this.root = target.left;
                System.out.println(root);
            } else if (target == parent.left){
                parent.left = target.left;
            } else {
                parent.right = target.left;
            }
        } else {
            if (parent == null){
                this.root = target.right;
                System.out.println(root);
            }else if (target == parent.left){
                parent.left = target.right;
            } else {
                parent.right = target.right;
            }
        }
    }
    
    public void infixList(){
        if (this.root == null) return;
        this.root.infixList();
    }
    public SortNode search(int value){
        if (root == null) return null;
        return this.root.searchNode(value);
    }

    public SortNode searchParent(int value){
        if (root == null) return null;
        return this.root.searchParentNode(value);
    }
}

class SortNode{
    int value;
    SortNode left;
    SortNode right;

    public SortNode(int value) {
        this.value = value;
    }

    public void createSortTree(SortNode newNode){
        if (newNode == null) return;
        //同当前节点比较
        if (this.value >= newNode.value ){
            if (this.left != null){
                this.left.createSortTree(newNode);
            } else {
                this.left = newNode;
            }
        } else {
            if (this.right != null){
                this.right.createSortTree(newNode);
            } else {
                this.right = newNode;
            }
        }
    }

    public SortNode getRightBranchSmallestNode(){
        if (this.right == null) return null;
        return this.right.getSmallestNode();
    }
    /**
     * 获取当前节点的最小节点
     */
    public SortNode getSmallestNode(){
        if (this.left != null) {
            return this.left.getSmallestNode();
        } else {
            return this;
        }
    }
    
    public SortNode searchNode(int value){
        if (this.value == value){
            return this;
        } else if (value <= this.value){
            if (this.left == null){
                return null;
            }
            return this.left.searchNode(value);
        } else {
            if (this.right == null){
                return null;
            }
            return this.right.searchNode(value);
        }
    }
    
    public SortNode searchParentNode(int value){
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)){
            return this;
        } else {
            //左不为空且比节点值小
            if (this.left != null && value <= this.value){
                return this.left.searchParentNode(value);
            } else if (this.right != null && value > this.value){
                //右不为空且比节点值大
                return this.right.searchParentNode(value);
            } else {
                //没有父节点
                return  null;
            }
        }
    }

    public void infixList(){
        if (this.left != null) this.left.infixList();
        System.out.println(this);
        if (this.right != null) this.right.infixList();
    }

    @Override
    public String toString() {
        return "SortNode{" +
                "value=" + value +
                '}';
    }
}
