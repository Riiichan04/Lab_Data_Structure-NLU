package lab11;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(25);
        tree.add(15);
        tree.add(50);
        tree.add(10);
        tree.add(22);
        tree.add(35);
        tree.add(70);
        tree.add(4);
        tree.add(12);
        tree.add(18);
        tree.add(24);
        tree.add(31);
        tree.add(44);
        tree.add(66);
        tree.add(90);
        tree.inorder();
        System.out.println();
        tree.preorder();
        System.out.println();
        tree.postorder();
        System.out.println();
        System.out.println(tree.descendants(15));
        System.out.println(tree.ancestors(90));
        System.out.println(tree.contains(25));
        System.out.println(tree.contains(100000));
        System.out.println(tree.depth(25));
        System.out.println(tree.depth(90));
        System.out.println(tree.height());
        System.out.println(tree.depth(15));
        System.out.println(tree.size());
        System.out.println(tree.remove(25));
        System.out.println(tree.remove(50));
        System.out.println(tree.remove(1000));
        System.out.println(tree.size());
        tree.inorder();
        System.out.println();
        System.out.println(tree.findMin());
        System.out.println(tree.findMax());
    }

}
