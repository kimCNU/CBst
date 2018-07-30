/**
 * This class will implement a Binary Search Tree
 * 
 * @author Kimberly Jimenez
 * @version 3-19-2017
 *
 */
public class CBst implements CBstADT {

    private BinNode root;

    /**
     * Constructor for CBst class Root is set to null
     */
    public CBst() {
        root = null;
    }

    /**
     * Determine if the given Character is in this tree.
     * 
     * @param c
     *            the Character to find in the tree
     * @return true if c is in the true, otherwise false
     */
    @Override
    public Boolean find(Character c) {
        return findHelp(root, c);
    }

    /**
     * Helper method for find. Method recursively looks for the value that is
     * passes in
     * 
     * @param rt
     *            BinNode that will be looked at
     * @param c
     *            Character that is being looked for
     * @return true if the element is in the tree, otherwise false
     */
    private Boolean findHelp(BinNode rt, Character c) {
        if (rt == null) {
            return false;
        }
        else if (rt.getValue().compareTo(c) == 0) {
            return true;
        }
        else if (rt.getValue().compareTo(c) > 0) {
            return findHelp(rt.left, c);
        }
        else {
            return findHelp(rt.right, c);
        }
    }

    /**
     * Determine the height of this tree.
     * 
     * @return the height of the tree
     */
    @Override
    public Integer height() {
        return heightHelp(root);
    }

    /**
     * Helper method for height. Method will recursively calculate the height of
     * the tree
     * 
     * @param rt
     *            BinNode that is being looked at
     * @return the height of the tree
     */
    private Integer heightHelp(BinNode rt) {
        if (rt == null) {
            return 0;
        }
        else {
            return (1 + Math.max(heightHelp(rt.left), heightHelp(rt.right)));
        }

    }

    /**
     * Insert c into this tree. If c is already in the tree, ignore the insert
     * request.
     * 
     * @param c
     *            the Character to insert into the tree
     */
    @Override
    public void insert(Character c) {
        root = insertHelp(root, c);
    }

    /**
     * Helper method for insert. Method will recursively look at the BinNodes to
     * see where the element being passed in will be inserted
     * 
     * @param rt
     *            the BinNode that is being checked
     * @param c
     *            the value that is being inserted
     * @return the BinNode that is passed in
     */
    private BinNode insertHelp(BinNode rt, Character c) {
        if (rt == null) {
            return new BinNode(c);
        }
        else if (rt.getValue().compareTo(c) == 0) {
            return rt;
        }
        else if (rt.getValue().compareTo(c) >= 0) {
            rt.setLeft(insertHelp(rt.left, c));
        }
        else {
            rt.setRight(insertHelp(rt.right, c));
        }
        return rt;
    }

    /**
     * Determine if this tree is balanced. A tree is balanced if the tree is
     * empty or both of the following are true: the difference between the
     * heights of the left subtree and right subtrees is less than 2, AND both
     * subtrees are balanced
     * 
     * @return true if tree is balance, otherwise false
     */
    @Override
    public Boolean isBalanced() {
        return isBalancedHelp(root);
    }

    /**
     * Helper method for isBalanced. Method will return true or false if tree is
     * balanced
     * 
     * @param rt
     *            BinNode that is being looked at
     * @return true if tree is balanced, otherwise false
     */
    private Boolean isBalancedHelp(BinNode rt) {
        int lHeight;
        int rHeight;

        if (root == null) {
            return true;
        }

        lHeight = heightHelp(rt.left);
        rHeight = heightHelp(rt.right);

        return (Math.abs(lHeight - rHeight) <= 1);
    }

    /**
     * Determine the position of the given Character in this tree. The position
     * of the root is 0, its left kid is 1 and right kid is 2, and so on.
     * 
     * @param c
     *            the Character whose position is to be determined
     * @return position of c if c is in the tree, other -1
     */
    @Override
    public Integer position(Character c) {
        return positionHelp(root, c, 0);
    }

    /**
     * Helper method for position. Method will return position of the Node if it
     * is in the tree
     * 
     * @param rt
     *            BinNode that is being looked at
     * @param c
     *            element whose position you are trying to find
     * @return position of character in the tree, otherwise -1 if not in tree
     */
    private Integer positionHelp(BinNode rt, Character c, int pos) {
        if (!find(c)) {
            return -1;
        }
        else if (rt.getValue().compareTo(c) == 0) {
            return pos;
        }
        else if (rt.getValue().compareTo(c) > 0) {
            return positionHelp(rt.left, c, (2 * pos) + 1);
        }
        else {
            return positionHelp(rt.right, c, (2 * pos) + 2);
        }
    }

    /**
     * Determine the preorder traversal of this tree.
     * 
     * @return preorder traversal of the tree
     */
    @Override
    public String preorder() {
        return preorderHelp(root);
    }

    /**
     * Helper method for preorder. Method will recursively look through the tree
     * and return the preordered String
     * 
     * @param rt
     *            BinNode that is being looked at
     * @return preorder of the tree
     */
    private String preorderHelp(BinNode rt) {
        if (rt != null) {
            String a = "" + rt.getValue();
            String b = preorderHelp(rt.left);
            String c = preorderHelp(rt.right);
            return a + b + c;
        }
        else {
            return "";
        }
    }

    /**
     * Remove the given Character from this tree. Do nothing if the given
     * Character is not in this tree.
     * 
     * @param c
     *            the Character to remove
     */
    @Override
    public void remove(Character c) {
        boolean isThere = findHelp(root, c);
        if (isThere) {
            root = removeHelp(root, c);

        }
    }

    /**
     * Helper method for remove. Method will return the BinNode that will be
     * removed based off of the element that is passed in
     * 
     * @param rt
     *            BinNode that is being looked at
     * @param c
     *            Element that is to be removed
     * @return BinNode that will be removed
     */
    private BinNode removeHelp(BinNode rt, Character c) {
        if (rt == null) {
            return null;
        }
        if (rt.getValue().compareTo(c) > 0) {
            rt.setLeft(removeHelp(rt.left, c));
        }
        else if (rt.getValue().compareTo(c) < 0) {
            rt.setRight(removeHelp(rt.right, c));
        }
        else {
            if (rt.left == null) {
                return rt.right;
            }
            else if (rt.right == null) {
                return rt.left;
            }
            else {
                BinNode temp = getMax(rt.left);
                rt.setValue(temp.getValue());
                rt.setLeft(deleteMax(rt.left));
            }
        }
        return rt;
    }

    /**
     * This method is a helper method for remove. Method will return BinNode
     * that has highest value
     * 
     * @param rt
     *            BinNode that is being looked at
     * @return BinNode that has highest value
     */
    private BinNode getMax(BinNode rt) {
        if (rt.right == null) {
            return rt;
        }
        return getMax(rt.right);
    }

    /**
     * This is a helper method for remove. Method will remove the largest value
     * in a subtree
     * 
     * @param rt
     *            BinNode that is being looked at
     * @return BinNode that contains the biggest value
     */
    private BinNode deleteMax(BinNode rt) {
        if (rt.right == null) {
            return rt.left;
        }
        rt.setRight(deleteMax(rt.right));
        return rt;
    }

    /**
     * Node class that will be used in a Binary Search Tree (BST) implementation
     * 
     * @author Kimberly Jimenez
     * @version 3-19-2017
     *
     */
    public class BinNode {
        private Character value;
        private BinNode left;
        private BinNode right;

        /**
         * Default constructor left and right BinNodes are set to null
         */
        public BinNode() {
            left = null;
            right = null;
        }

        /**
         * Constructor for BinNode class, in which the value is set
         * 
         * @param ch
         *            value that the BinNode will contain
         */
        public BinNode(Character ch) {
            value = ch;
            left = null;
            right = null;
        }

        /**
         * Method will set the current root's left BinNode
         * 
         * @param leftValue
         *            BinNode that will have its value set
         */
        public void setLeft(BinNode leftValue) {
            this.left = leftValue;
        }

        /**
         * Method will set the current root's right BinNode
         * 
         * @param rightValue
         *            BinNode that will have its value set
         */
        public void setRight(BinNode rightValue) {
            this.right = rightValue;
        }

        /**
         * Method will set the value for the BinNode
         * 
         * @param c
         *            value that the BinNode will contain
         */
        public void setValue(Character c) {
            this.value = c;
        }

        /**
         * Method will return the Character that is in the current BinNode
         * 
         * @return value at the current BinNode
         */
        public Character getValue() {
            return value;
        }
    }
}
