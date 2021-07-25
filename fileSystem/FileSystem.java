package fileSystem;

public interface FileSystem<T> {
    public void add(T data);
    public void addTo(T data, int index);
    public void delete(T data);
    public void delete(int index);
    public T find(String name);
}
