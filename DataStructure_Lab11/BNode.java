package lab11;

import java.util.LinkedList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
    private E data;
    private BNode<E> left;
    private BNode<E> right;

    public BNode(E data, BNode<E> left, BNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public E getData() {
        return data;
    }

    public BNode<E> getLeft() {
        return left;
    }

    public BNode<E> getRight() {
        return right;
    }

    public void setLeft(BNode<E> left) {
        this.left = left;
    }

    public void setRight(BNode<E> right) {
        this.right = right;
    }

    //for add method
    public void add(BNode<E> root, E e) {
        if (root.getData().compareTo(e) > 0) {
            if (root.getLeft() == null) root.setLeft(new BNode<>(e));
            else add(root.getLeft(), e);
        } else {
            if (root.getRight() == null) root.setRight(new BNode<>(e));
            else add(root.getRight(), e);
        }
    }

    public BNode<E> search(BNode<E> root, E node) {
        if (root != null) {
            int compareValue = root.getData().compareTo(node);
            // like binary search
            if (compareValue > 0) return search(root.getLeft(), node);
            else if (compareValue < 0) return search(root.getRight(), node);
            else return root;
        } else return null;
    }

    //for depth method
    public int findDepth(BNode<E> node) {
        // if node have 2 child
        if (node.getLeft() != null && node.getRight() != null) {
            return Math.max(1 + findDepth(node.getLeft()), 1 + findDepth(node.getRight()));
        }
        // if node is leaf
        else if (node.getLeft() == null && node.getRight() == null) return 0;
            // if node have 1 child
        else return (node.getLeft() == null) ? 1 + findDepth(node.getRight()) : 1 + findDepth(node.getLeft());
    }

    //for size method
    public int countSize(BNode<E> root) {
        return (root == null) ? 0 : 1 + countSize(root.getRight()) + countSize(root.getLeft());
    }

    //for findMin method
    public E findMinWithBranch(BNode<E> e) {
        return (e.getLeft() == null) ? e.getData() : findMinWithBranch(e.getLeft());
    }

    //for findMax method
    public E findMaxWithBranch(BNode<E> e) {
        return (e.getRight() == null) ? e.getData() : findMaxWithBranch(e.getRight());
    }

    //for remove method
    public boolean remove(E e) {
        BNode<E> removeNode = search(this, e);
        if (removeNode == null) return false;
        else {
            BNode<E> parent = findNodeParent(this, e);
            //if Node don't have child
            if (removeNode.getLeft() == null && removeNode.getRight() == null) {
                if (parent.getData().compareTo(removeNode.getData()) < 0) parent.setRight(null);
                else parent.setLeft(null);
            }
            //if Node have 1 child
            else if (removeNode.getLeft() == null) parent.setRight(removeNode.getRight());
            else if (removeNode.getRight() == null) parent.setLeft(removeNode.getLeft());
                // if Node have 2 child
            else {
                BNode<E> newNode = findSuccessor(removeNode.getRight());
                // recreate Successor node
                remove(newNode.getData());
                newNode.setLeft(removeNode.getLeft());
                newNode.setRight(removeNode.getRight());
                // add Successor node
                if (parent.getData().compareTo(newNode.getData()) < 0) parent.setRight(newNode);
                else parent.setLeft(newNode);
            }
        }
        return true;
    }
    //remove root
    public BNode<E> removeRoot(E e) {
        BNode<E> removeNode = search(this, e);
        BNode<E> newNode = findSuccessor(removeNode.getRight());
        // recreate Successor node
        remove(newNode.getData());
        newNode.setLeft(removeNode.getLeft());
        newNode.setRight(removeNode.getRight());
        // add Successor node
        return newNode;
    }


    public BNode<E> findSuccessor(BNode<E> node) {
        return (node.getLeft() == null) ? node : findSuccessor(node.getLeft());
    }

    public BNode<E> findNodeParent(BNode<E> node, E data) {
        //if Node have 2 child
        if (node.getLeft() != null && node.getRight() != null) {
            if (node.getLeft().getData().compareTo(data) == 0 || node.getRight().getData().compareTo(data) == 0)
                return node;
            else {
                BNode<E> leftVal = findNodeParent(node.getLeft(), data);
                return (leftVal != null) ? leftVal : findNodeParent(node.getRight(), data);
            }
        }
        //if Node have 0 child
        else if (node.getLeft() == null && node.getRight() == null) return null;
            //if Node have 1 child
        else {
            if (node.getLeft() == null) {
                return (node.getRight().getData().compareTo(data) == 0) ? node : findNodeParent(node.getRight(), data);
            } else return (node.getLeft().getData().compareTo(data) == 0) ? node : findNodeParent(node.getLeft(), data);
        }
    }

    //for descendants method
    public List<E> addDescendants(BNode<E> node, E data) {
        List<E> result = new LinkedList<>();
        if (node != null) {
            if (node.getData().compareTo(data) != 0) result.add(node.getData());
            if (node.getLeft() != null) {
                result.addAll(addDescendants(node.left, data));
            }
            if (node.getRight() != null) {
                result.addAll(addDescendants(node.right, data));
            }
        }
        return result;
    }

    //for ancestor method
    public List<E> addAncestors(E data) {
        List<E> result = new LinkedList<>();
        int compareValue = this.getData().compareTo(data);
        if (compareValue != 0) result.add(this.getData());
        if (compareValue > 0 && this.left != null) {
            result.addAll(this.left.addAncestors(data));
        } else {
            if (this.right != null) {
                result.addAll(this.right.addAncestors(data));
            }
        }
        return result;
    }

    //print BST
    public void inorderPrint(BNode<E> node) {
        if (node.getLeft() != null) inorderPrint(node.getLeft());
        System.out.print(node + " ");
        if (node.getRight() != null) inorderPrint(node.getRight());
    }

    public void preorderPrint(BNode<E> node) {
        System.out.print(node + " ");
        if (node.getLeft() != null) preorderPrint(node.getLeft());
        if (node.getRight() != null) preorderPrint(node.getRight());
    }

    public void postorderPrint(BNode<E> node) {
        if (node.getLeft() != null) postorderPrint(node.getLeft());
        if (node.getRight() != null) postorderPrint(node.getRight());
        System.out.print(node + " ");
    }

    @Override
    public String toString() {
        return data + "";
    }
}
