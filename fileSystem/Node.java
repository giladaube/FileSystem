package fileSystem;

public interface Node<T> {
    public T getData();
    public void setData(T t);

    public Node getNext();
    public void setNext(Node n);
}
