package models;

import java.util.ArrayList;
import java.util.Collections;

public class Group {

    private ArrayList<String> groupMembers;

    public Group() {
        this.groupMembers = new ArrayList<String>();
    }

    // returns small groups as an array of names
    public void addRandomMembersToGroup(ArrayList<String> names, int numberOfMembers) {
        Collections.shuffle(names);
        for (int i = 0; i < numberOfMembers; i++) {
            String name = names.get(0);
            groupMembers.add(name);
            names.remove(name);
        }
    }

    public ArrayList<String> getGroupMembers() {
        return groupMembers;
    }

    public int getSize() {
        return groupMembers.size();
    }
}