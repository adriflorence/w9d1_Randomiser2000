package models;

import java.util.ArrayList;

public class Randomiser {

    private ArrayList<Group> groups;

    public Randomiser() {
        this.groups = new ArrayList<>();
    }

    public void addGroupToGroups(Group group) {
        groups.add(group);
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }
}
