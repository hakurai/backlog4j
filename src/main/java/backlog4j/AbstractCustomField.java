package backlog4j;

import java.util.Map;

/**
 * @author eguchi
 */
abstract class AbstractCustomField implements CustomField {

    private final int id;
    private final String name;
    private final Type typeId;
    private final String description;
    private final boolean required;

    AbstractCustomField(Map<String, Object> map) {
        id = (Integer) map.get("id");
        name = (String) map.get("name");
        typeId = valueOfType((Integer)map.get("typeId"));
        description = (String)map.get("description");
        required = (Boolean)map.get("required");

    }

    protected Type valueOfType(int typeId){
        switch (typeId){
            case 1:
                return Type.STRING;
            case 2:
                return Type.TEXT;
            case 3:
                return Type.NUMBER;
            case 4:
                return Type.DATE;
            case 5:
                return Type.SINGLE_LIST;
            case 6:
                return Type.MULTIPLE_LIST;
            case 7:
                return Type.CHECKBOX;
            case 8:
                return Type.RADIO;

            default:
                return Type.UNDEFINED;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getTypeId() {
        return typeId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRequired() {
        return required;
    }
}
