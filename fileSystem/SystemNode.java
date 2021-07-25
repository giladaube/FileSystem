package fileSystem;

// P should be Node (FileNode) and V should be Character
public class SystemNode<V> extends AbstractNode<Node> {
    protected V value;
    protected Node dataTail = null;

    public SystemNode() {
        super();
        data = null;
    }
    public SystemNode(V v) {
        this();
        value = v;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V v) {
        value = v;
    }
    @Override
    public void setData(Node node) {
        if (dataTail != null) {
            dataTail.setNext(node);
            dataTail = node;
        } else {
            data = node;
            dataTail = data;
        }
    }
}
