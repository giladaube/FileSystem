package fileSystem;

public abstract class AbstractNode<T> implements Node<T>{
    protected T data;
    protected Node next = null;

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T t) {
        data = t;
    }

    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public void setNext(Node n) {
        next = n;
    }
}
