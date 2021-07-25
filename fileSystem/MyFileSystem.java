package fileSystem;

import java.util.function.Function;

public class MyFileSystem implements FileSystem<IFile> {
    private Node filesHead;
    private Node filesTail;
    private IndexFileSystem indexes;

    public MyFileSystem() {
        filesHead = new SystemNode<Character>();
        filesTail = filesHead;
        indexes = new IndexFileSystem();
    }

    @Override
    public void add(IFile data) {
        Node fileNode = new FileNode<IFile>(data);
        indexes.addIndex(fileNode);

        Node node = find(data.getName().toCharArray()[0]);
        if (node == null) {
            node = new SystemNode<Character>(Character.toLowerCase(data.getName().toCharArray()[0]));
            filesTail.setNext(node);
            filesTail = node;
        }
        node.setData(fileNode);
    }

    @Override
    public void addTo(IFile data, int index) {
        Node node = indexes.find(index);
        if (node != null) {
            node.setData(data);
        }
    }

    @Override
    public void delete(IFile data) {
        Node node = find(data.getName().toCharArray()[0]);
        Node[] nodes = find(node, (current) -> {
           return current.getData().equals(data);
        });

        if (nodes != null) {
            nodes[0].setNext(nodes[1].getNext());
            nodes[1].setNext(null);
        }
    }

    @Override
    public void delete(int index) {
        Node node = indexes.find(index);
        if (node != null) {
            delete((IFile) node.getData());
        }
    }

    @Override
    public IFile find(String name) {
        Node node = find(name.toCharArray()[0]);
        Node[] nodes = find(node, (current) -> {
            return ((FileNode<IFile>) current).getData().getName().equals(name);
        });
        if (nodes != null) {
            return ((FileNode<IFile>) nodes[1]).getData();
        }
        return null;
    }

    private Node[] find(Node node, Function<Node, Boolean> func) {
        Node current = (FileNode<IFile>) node.getData();
        Node prev = current;
        while (current != null) {
            if (func.apply(current)) {
                return new Node[]{prev, current};
            }
            prev = current;
            current = current.getNext();
        }
        return null;
    }

    private Node find(Character c) {
        c = Character.toLowerCase(c);
        Node node = filesHead;
        while (node != null) {
            if (((SystemNode) node).getValue() == c) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }
}
