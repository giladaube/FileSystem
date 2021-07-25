package fileSystem;

// add index to every node, able to add and find nodes by index.
public class IndexFileSystem {
    private Node indexHead;
    private Node indexTail;
    private int index = 0;

    public IndexFileSystem() {
        indexHead = new FileNode<Node>(null);
        indexTail = indexHead;
    }

    public void addIndex(Node node) {
        if (indexTail.getData() != null) {
            indexTail.setNext(new FileNode<>(node));
            indexTail = indexTail.getNext();
        } else {
            indexTail.setData(node);
        }
        ((FileNode<Node>) indexTail).setIndex(index++);
    }

    public Node find(int index) {
        Node node = indexHead;
        while (node != null) {
            if (((FileNode) node).getIndex() == index) {
                return (Node) node.getData();
            }
        }
        return null;
    }
}