package pt.lsts.imc;

public class ServoPosition extends IMCMessage {
    public static final int ID_STATIC = 281;


    public ServoPosition() {
        super(ID_STATIC);
    }

    public ServoPosition(IMCDefinition defs) {
        super(defs, ID_STATIC);
    }

    public ServoPosition(IMCMessage msg) {
        super(ID_STATIC);
        try {
            copyFrom(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ServoPosition create(Object... values) {
        ServoPosition m = new ServoPosition();
        for (int i = 0; i < values.length - 1; i += 2)
            m.setValue(values[i].toString(), values[i + 1]);
        return m;
    }

    public static ServoPosition clone(IMCMessage msg) throws Exception {
        ServoPosition m = new ServoPosition();
        if (msg == null)
            return m;
        if (msg.definitions != m.definitions) {
            msg = msg.cloneMessage();
            IMCUtil.updateMessage(msg, m.definitions);
        } else if (msg.getMgid() != m.getMgid()) {
            throw new Exception("incompatible types: " + msg.getAbbrev() + " and " + m.getAbbrev());
        }
        m.getHeader().values.putAll(msg.getHeader().values);
        m.values.putAll(msg.values);
        return m;
    }

    public short getId() {
        return getShort("id");
    }

    public ServoPosition setId(short id) {
        values.put("id", id);
        return this;
    }

    public double getValue() {
        return getDouble("value");
    }

    public ServoPosition setValue(double value) {
        values.put("value", value);
        return this;
    }

}