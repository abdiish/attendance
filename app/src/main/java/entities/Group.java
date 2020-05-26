package entities;

public class Group {

    private String group_id;
    private String name_group;
    private String synchronize;

    public Group(String group_id, String name_group, String synchronize) {
        this.group_id = group_id;
        this.name_group = name_group;
        this.synchronize = synchronize;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getName_group() {
        return name_group;
    }

    public void setName_group(String name_group) {
        this.name_group = name_group;
    }

    public String getSynchronize() {
        return synchronize;
    }

    public void setSynchronize(String synchronize) {
        this.synchronize = synchronize;
    }
}
