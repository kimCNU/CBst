import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class tests the methods that are defined in the CBst class. Each of the
 * tests will look at each of the cases mentioned in the class
 * 
 * @author Kimberly Jimenez
 * @version 03-26-2017
 */

public class CBstTest {

    /**
     * Pre-condition: I will not insert BinNodes into the tree and will call the
     * height method Post-condition: height should return 1 since the root is
     * the only node in the tree
     */
    @Test
    public void testHeightBaseCaseEmptyTree() {
        CBst tree = new CBst();
        int actual = tree.height();
        int expected = 0;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I only insert the root of a tree and call the height
     * method Post-condition: height should return 1 since the root is the only
     * node in the tree
     */
    @Test
    public void testHeightBaseCaseRoot() {
        CBst tree = new CBst();
        tree.insert('d');
        int actual = tree.height();
        int expected = 1;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will be inserting various BinNodes into the tree and
     * call the height method Post-condition: height should return 3 since the
     * root is the only node in the tree
     */

    @Test
    public void testHeightRecursiveCase() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('e');
        tree.insert('a');
        tree.insert('c');
        int actual = tree.height();
        int expected = 3;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert no BinNode into the tree and then call the
     * find method Post-condition: method should return FALSE since tree is
     * empty
     */
    @Test
    public void testBaseCaseFindEmptyTree() {
        CBst tree = new CBst();
        boolean actual = tree.find('a');
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the find method Post-condition: method should return FALSE since the
     * element that is being searched for is not in the tree.
     */
    @Test
    public void testFindReturnFalse() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('e');
        tree.insert('a');
        tree.insert('c');
        boolean actual = tree.find('g');
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the find method Post-condition: method should return TRUE since the
     * element that is being searched for is in the tree.
     */
    @Test
    public void testFindReturnTrue() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('e');
        tree.insert('a');
        tree.insert('c');
        boolean actual = tree.find('b');
        boolean expected = true;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert no BinNode into the tree and then call the
     * preorder method Post-condition: method should return empty string
     */
    @Test
    public void testBaseCasePreOrderEmptyTree() {
        CBst tree = new CBst();
        String actual = tree.preorder();
        String expected = "";
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the preorder method Post-condition: method should return d
     */
    @Test
    public void testBaseCasePreOrderOnlyRootInTree() {
        CBst tree = new CBst();
        tree.insert('d');
        String actual = tree.preorder();
        String expected = "d";
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the preorder method Post-condition: method should return dbf
     */
    @Test
    public void testBaseCasePreOrderDuplicateNodeInTree() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        String actual = tree.preorder();
        String expected = "dbf";
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert one BinNode into the tree and then call the
     * preorder method Post-condition: method should return cbaed
     */
    @Test
    public void testRecursiveCasePreOrder() {
        CBst tree = new CBst();
        tree.insert('c');
        tree.insert('b');
        tree.insert('a');
        tree.insert('e');
        tree.insert('d');
        String actual = tree.preorder();
        String expected = "cbaed";
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert one BinNode into the tree and then call the
     * remove method and the find method Post-condition: method should FALSE
     * since the tree will be empty
     */
    @Test
    public void testBaseCaseRemoveOneElement() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.remove('d');
        boolean actual = tree.find('d');
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will not insert BinNodes into the tree and then call the
     * remove method and the find method Post-condition: method should FALSE
     * since the tree is empty
     */
    @Test
    public void testBaseCaseRemoveEmptyTree() {
        CBst tree = new CBst();
        tree.remove(null);
        boolean actual = tree.find('d');
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the remove method and the find method Post-condition: method should FALSE
     * since the element being looked for is no longer in tree
     */
    @Test
    public void testRecursiveCaseRemoveRoot() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('a');
        tree.insert('c');
        tree.insert('e');
        tree.remove('d');
        boolean actual = tree.find('d');
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the remove method and the find method Post-condition: method should FALSE
     * since the element being looked for is no longer in tree
     */
    @Test
    public void testRecursiveCaseRemoveValueFromRightSubTree() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('a');
        tree.insert('c');
        tree.insert('e');
        tree.remove('f');
        boolean actual = tree.find('f');
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the remove method and the find method Post-condition: method should FALSE
     * since the element being looked for is no longer in tree
     */
    @Test
    public void testRecursiveCaseRemoveValueFromLeftSubTree() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('a');
        tree.insert('c');
        tree.insert('e');
        tree.remove('a');
        boolean actual = tree.find('a');
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert no BinNodes into the tree and then call the
     * isBalanced method Post-condition: method should return TRUE since tree is
     * empty
     */
    @Test
    public void testBaseCaseisBalancedEmptyTree() {
        CBst tree = new CBst();
        boolean actual = tree.isBalanced();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the isBalanced method Post-condition: method should return FALSE since
     * tree is not balanced
     */
    @Test
    public void testBaseCaseNotBalancedTree() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('f');
        tree.insert('e');
        tree.insert('g');
        boolean actual = tree.isBalanced();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the isBalanced method Post-condition: method should return TRUE since
     * tree is balanced
     */
    @Test
    public void testBaseCaseBalancedTree() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('f');
        tree.insert('b');
        tree.insert('c');
        boolean actual = tree.isBalanced();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert no BinNodes into the tree and then call the
     * position method Post-condition: method should return -1 since tree is
     * empty
     */
    @Test
    public void testBaseCasePositionEmptyTree() {
        CBst tree = new CBst();
        int actual = tree.position('a');
        int expected = -1;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert 1 BinNode into the tree and then call the
     * position method Post-condition: method should return 0 since tree only
     * has a root
     */
    @Test
    public void testBaseCasePositionOnlyRootInTree() {
        CBst tree = new CBst();
        tree.insert('a');
        int actual = tree.position('a');
        int expected = 0;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the position method Post-condition: method should return 6
     */
    @Test
    public void testRecursiveCasePosition() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('a');
        tree.insert('c');
        tree.insert('e');
        tree.insert('g');
        int actual = tree.position('g');
        int expected = 6;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the position method Post-condition: method should return 1
     */
    @Test
    public void testRecursiveCasePositionLeftNode() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('a');
        tree.insert('c');
        tree.insert('e');
        tree.insert('g');
        int actual = tree.position('b');
        int expected = 1;
        assertEquals(expected, actual);
    }

    /**
     * Pre-condition: I will insert several BinNodes into the tree and then call
     * the preorder method Post-condition: method should return dbf
     */
    @Test
    public void testInsertDuplicateNode() {
        CBst tree = new CBst();
        tree.insert('d');
        tree.insert('b');
        tree.insert('f');
        tree.insert('d');
        String actual = tree.preorder();
        String expected = "dbf";
        assertEquals(expected, actual);
    }
}
