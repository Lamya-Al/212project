public class BSTNode <T>{
        public String key;
        public T data;
        public BSTNode<T> left, right;
        public BSTNode(String k, T val) {
            key = k;
            data = val;
            left = right = null;
        }
        public BSTNode(String k, T val, BSTNode<T> l, BSTNode<T> r) {
            key = k;
            data = val;
            left = l;
            right = r;
        }
    }
    //-------------------------------------------------
 class BST <T> {
    BSTNode<T> root, current;

    /**
     * Creates a new instance of BST
     */
    public BST() {
        root = current = null;
    }

    public boolean empty() {
        return root == null;
    }

    public boolean full() {
        return false;
    }

    public T retrieve() {
        return current.data;
    }

    public boolean findkey(String tkey) {
        BSTNode<T> p = root,q = root;
        if (empty())
            return false;
        while (p != null) {
            q = p;
            if (p.key.equals(tkey)) {
                current = p;
                return true;
            } else if (tkey.compareTo( p.key)<0){
                p = p.left;}
            else
                p = p.right;
        }
        current = q;
        return false;
    }

    public boolean insert(String k, T val) {
        BSTNode<T> p, q = current;
        if (findkey(k)) {
            current = q; // findkey() modified current
            return false; // key already in the BST
        }
        p = new BSTNode<T>(k, val);
        if (empty()) {
            root = current = p;
            return true;
        } else {
// current is pointing to parent of the new key
            if (k.compareTo(current.key)<0)
                current.left = p;
            else
                current.right = p;
            current = p;
            return true;
        }
    }

        public boolean removeKey(String k) {
            BSTNode<T> p = root;
            BSTNode<T> q = null; // Parent of p
            boolean found=false;
// Search for k
            while ((p != null)&&(!found)) {
                int res = k.compareTo(p.key);
                if (res < 0) {
                    q = p;
                    p = p.left;
                } else if (res > 0) {
                    q = p;
                    p = p.right;
                } else // Found the key
                    found=true;
            }
            if(found){
// Check the three cases
                if ((p.left != null) && (p.right != null)) { // Case 3: two
// children
// Search for the min in the right subtree
                    BSTNode<T> min = p.right;
                    q = p;
                    while (min.left != null) {
                        q = min;
                        min = min.left;
                    }
                    p.key = min.key;
                    p.data = min.data;
                    deleteNode(min,q);
                }
                else //case 1 and 2
                    deleteNode(p,q);
                current = root;
                return true;
            }
            return false; // Not found
        }
        private void deleteNode(BSTNode<T> n,BSTNode<T> parent) {
// parent is the parent of n. The method deletes node in (case1 and case 2)
            BSTNode<T> child;
            if (n.left != null)
                child = n.left;
            else
                child = n.right;
            if (parent == null) { // No parent for p, root must change
                root = child;
            } else {
                if (n.key.compareTo(parent.key) < 0) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }

    public boolean update(String key, T data){
        removeKey(current.key);
        return insert(key, data);
    }
}


