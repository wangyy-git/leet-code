package com.wanyy.ltd.datastructure.tree.balance;


public class SelfBlanceTree {

    private AVLNode root;

    public SelfBlanceTree() {
    }

    public AVLNode getRoot() {
        return root;
    }

    public SelfBlanceTree(AVLNode root) {
        this.root = root;
    }
    public void add(AVLNode newNode){
        if (this.root == null){
            this.root = newNode;
            return;
        }
        this.root.createSortTree(newNode);
    }

    public void delete(int value){
        if (root == null) return;
        if (root.left == null && root.right == null && root.value == value){
            this.root = null;
            return;
        }
        AVLNode target = search(value);
        if (target == null){ return; }
        AVLNode parent = searchParent(value);
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
            AVLNode lastRightNode = target.getRightBranchSmallestNode();
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
    public AVLNode search(int value){
        if (root == null) return null;
        return this.root.searchNode(value);
    }

    public AVLNode searchParent(int value){
        if (root == null) return null;
        return this.root.searchParentNode(value);
    }
}

class AVLNode{
    int value;
    AVLNode left;
    AVLNode right;
    
    public AVLNode(int value) {
        this.value = value;
    }

    public int getLeftHight(){
        if (this.left == null) return 0;
        return left.getHight();
    }

    public int getRightHight(){
        if (this.right == null) return 0;
        return right.getHight();
    }
    /**
     * 返回以当期节点为根节点的高度
     * 应该是左/右子树比较大的值
     */
    public int getHight(){
        //因为自身节点高度为1 所以+1
        return Math.max(left==null?0:left.getHight(),right==null?0:right.getHight()) + 1;
    }
    
    public void leftRotate(){
        AVLNode newNode = new AVLNode(this.value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.value= this.right.value;
        this.right= this.right.right;
        this.left = newNode;
    }

    public void rightRotate(){
        //1)	创建一个新节点newNode(以10这个值创建，即值等于当前根节点的值因为要将他移下去)；
        AVLNode newNode = new AVLNode(this.value);
        //2)	把新节点的右子树设置成当前节点的右子树：
        newNode.right= this.right;
        //3)	把新节点的左子树设置为当前节点的左子树的右子树：
        newNode.left = this.left.right;
        //4)	把当前节点的值换成左子节点的值：
        this.value= this.left.value;
        //5)	把当前节点的左子树设置成左子树的左子树：
        this.left = this.left.left;
        //6)	把当前节点的右子树设置为新节点：
        this.right = newNode;
    }
    public void createSortTree(AVLNode newNode){
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
        //这个方法是被root调用的
        // 右比左高 左旋转
        if (getRightHight() - getLeftHight() > 1){
            if (right != null && right.getRightHight() <right.getLeftHight()){
                //先对右子树进行右旋转
                this.right.rightRotate();
                //最整体左旋转
                this.leftRotate();
            } else {
                leftRotate();
            }
            return;
        }
        if (getLeftHight() - getRightHight() > 1){
            if (this.left!= null && left.getLeftHight() < left.getRightHight()){
                //先对左子树进行左旋转
                this.left.leftRotate();
                //最整体右旋转
                this.rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    public AVLNode getRightBranchSmallestNode(){
        if (this.right == null) return null;
        return this.right.getSmallestNode();
    }
    /**
     * 获取当前节点的最小节点
     */
    public AVLNode getSmallestNode(){
        if (this.left != null) {
            return this.left.getSmallestNode();
        } else {
            return this;
        }
    }

    public AVLNode searchNode(int value){
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

    public AVLNode searchParentNode(int value){
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
        return "AVLNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}