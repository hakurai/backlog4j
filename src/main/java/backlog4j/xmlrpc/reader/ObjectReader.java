package backlog4j.xmlrpc.reader;

import backlog4j.BacklogException;

/**
 * @author eguchi
 */
public abstract class ObjectReader<T> {

    protected String name;

    public abstract void read(String source);

    public abstract T getObject();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addObject(String name, Object obj) {

    }

    public static ObjectReader<?> getObjectReader(String type) {

        if (type.equals("int") || type.equals("i4")) {
            return new IntegerReader();
        } else if (type.equals("boolean")) {
            return new BoolenaReader();
        } else if (type.equals("string")) {
            return new StringReader();
        } else if (type.equals("array")) {
            return new ArrayReader();
        } else if (type.equals("struct")) {
            return new StructReader();
        } else if (type.equals("base64")) {
            return new Base64Reader();
        } else {
            throw new BacklogException("Unsupported type : " + type);
        }


    }

}
