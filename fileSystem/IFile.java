package fileSystem;

public interface IFile {
    public String getName();
    public void setName(String name);
    public String getColor();
    public void setColor(String color);
    public boolean equals(IFile o);
}
