package do1phin.mine2021.skyblock.data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("unchecked")
public class SkyblockData {

    private ProtectionType protectionType;

    private String[] collaborators;

    public SkyblockData(ProtectionType protectionType, String[] collaborators) {
        this.protectionType = protectionType;
        this.collaborators = collaborators;
    }

    public ProtectionType getProtectionType() {
        return protectionType;
    }

    public void setProtectionType(ProtectionType protectionType) {
        this.protectionType = protectionType;
    }

    public String[] getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(String[] collaborators) {
        this.collaborators = collaborators;
    }

    public String toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("protection-type", this.protectionType.value);
        jsonObject.put("collaborators", this.collaborators);
        return jsonObject.toString();
    }

    public static SkyblockData fromJSON(String json) {
        final JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
            return new SkyblockData((ProtectionType) jsonObject.get("projection-type"), (String[]) jsonObject.get("collaborators"));
        } catch (ParseException e) {
            return SkyblockData.getDefault();
        }
    }

    public static SkyblockData getDefault() {
        return new SkyblockData(ProtectionType.ALLOW_ONLY_OWNER, new String[0]);
    }

}
