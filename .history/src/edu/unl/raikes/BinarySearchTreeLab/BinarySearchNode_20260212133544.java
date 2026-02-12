package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Blueprint for creating a specific node within the tree.
 */
class BinarySearchNode {
    protected BinarySearchNode parent;
    protected BinarySearchNode leftChild;
    protected BinarySearchNode rightChild;
    protected Person person;

    /**
     * Default constructor for creating a node.
     * @param person corresponding Person object
     */
    BinarySearchNode(Person person) {
        this.person = person;
    }

    /**
     * Checks if Person can be inserted, returns true and inserts if so, otherwise false.
     * @param data Person to be checked for insertion
     * @return true if can be inserted, false otherwise
     */
    boolean insert(Person data) {
        // If the person exists in the tree, returns false
        if (data == this.person) {
            return false;
        }
        // Else, recursively check based on comparison by key
        else if (Integer.compare(data.key, this.person.key) < 0) {
            // Checks if has no left child
            if (this.leftChild == null) {
                this.setLeftChild(new BinarySearchNode(data));
                return true;
            } // Otherwise, inserts the data at leftChild (recursively)
            else {
                return this.leftChild.insert(data);
            }
        }
        // Else, if the data's key is greater, go right
        else if (Integer.compare(data.key, person.key) > 0) {
            // Checks if has no right child
            if (rightChild == null) {
                setRightChild(new BinarySearchNode(data));
                return true;
            } // Otherwise, inserts the data at rightChild (recursively)
            else {
                return rightChild.insert(data);
            }
        }
        return false;
    }

    /**
     * Implements a binary search for a specific node based on the key.
     * @param key int
     * @return node we're looking for
     */
    BinarySearchNode search(int key) {
        // If the key is less than this node's key, search the left subtree
        if (this.leftChild != null && Integer.compare(key, this.person.key) < 0) {
            return leftChild.search(key);
        }
        // If the key is greater than this node's key, search the right subtree
        else if (this.rightChild != null && Integer.compare(key, this.person.key) > 0) {
            return rightChild.search(key);
        }
        // If the key matches this node's key, return this node
        else if (this.person.key == key) {
            return this;
        }
        // Otherwise, the key was not found in the tree
        else {
            return null;
        }
    }

    /**
     * Deletes the node with the given key from the subtree rooted at this node.
     * @param key the key of the node to delete
     * @return the Person that was deleted, or null if not found
     */
    Person delete(int key) {
        // Search for the node to delete; return null if not found
        BinarySearchNode node = search(key);
        if (node == null)
            return null;
        Person deleted = node.person;

        // Case 1: Node has no children (leaf node) -- remove it from its parent
        if (node.leftChild == null && node.rightChild == null) {
            if (node.parent.leftChild == node)
                node.parent.setLeftChild(null);
            else if (node.parent.rightChild == node)
                node.parent.setRightChild(null);
        }
        // Case 2: Node has two children -- replace with in-order successor then delete successor
        else if (node.leftChild != null && node.rightChild != null) {
            BinarySearchNode min = node.rightChild.getNodeWithMinValue();
            node.person = min.person;
            int minKey = min.person.key;
            min.delete(minKey);
        }
        // Case 3: Node has one child and is a left child -- replace with its non-null child
        else if (node.parent.leftChild == node) {
            BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setLeftChild(newLeftChild);
        }
        // Case 4: Node has one child and is a right child -- replace with its non-null child
        else if (node.parent.rightChild == node) {
            BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setRightChild(newRightChild);
        }

        return deleted;
    }

    /**
     * Recursively finds the node with the minimum key value in this subtree.
     * @return the node with the smallest key
     */
    BinarySearchNode getNodeWithMinValue() {
        if (leftChild == null)
            return this;
        else
            return leftChild.getNodeWithMinValue();
    }

    /**
     * Sets the left child of this node and updates the child's parent reference.
     * @param child the node to set as the left child, or null to remove it
     */
    void setLeftChild(BinarySearchNode child) {
        this.leftChild = child;
        if (child != null)
            child.parent = this;
    }

    /**
     * Sets the right child of this node and updates the child's parent reference.
     * @param child the node to set as the right child, or null to remove it
     */
    void setRightChild(BinarySearchNode child) {
        this.rightChild = child;
        if (child != null)
            child.parent = this;
    }

    /**
     * Returns a string representation of this subtree using a pre-order traversal
     * (left subtree, right subtree, then current node).
     * @return formatted string of all nodes in this subtree
     */
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        

        this.addToString(this, toReturn);
        

        return toReturn.toString();
    }

    private void addToString(BinarySearchNode node, StringBuilder toString) {
        if (node == null) {
            return;
        }

        addToString(node.leftChild, toString);
        addToString(node.rightChild, toString);

        toString.append("  " + node.person.toString() + "\n");
    }

}