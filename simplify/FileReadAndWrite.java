import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Class for calendar serialization

public abstract class FileReadAndWrite {
private final File FILENAME = new File("Planned_Events.txt");
    public File getFile() {
        return FILENAME;
    }
    public ObjectOutputStream getObjectOutputStream() throws IOException {
        return new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream( getFile() )));
    }

    public ObjectInputStream getObjectInputStream() throws IOException, EOFException {
        return new ObjectInputStream(new BufferedInputStream(new FileInputStream( getFile() )));
    }
}
