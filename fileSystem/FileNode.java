package fileSystem;

public class FileNode<T> extends AbstractNode<T> {
    protected int index = 0;

    public FileNode(T data) {
        super();
        setData(data);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int i) {
        index = i;
    }
}
