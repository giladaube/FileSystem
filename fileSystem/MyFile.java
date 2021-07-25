package fileSystem;

public class MyFile implements IFile {
    private String name;
    private String color;

    public MyFile(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(IFile o) {
        return (name.equals(o.getName()) && color.equals(o.getColor()));
    }
}
