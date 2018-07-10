import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import models.Group;
import models.Randomiser;
import spark.template.velocity.VelocityTemplateEngine;
import spark.ModelAndView;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class RandomiserApp {

    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("public");

        ArrayList<String> names = new ArrayList<String>();
        names.add("Derek");
        names.add("Adri");
        names.add("Jack");
        names.add("Roddy");
        names.add("Pete");
        names.add("Cleyra");
        names.add("Tara");
        names.add("Campbell");
        names.add("Stevie");
        names.add("Richard");
        names.add("Greg");
        names.add("Stephan");
        names.add("Angelina");
        names.add("Matt");
        names.add("Craig");
        names.add("Joe");
        names.add("Debi");
        names.add("Farheen");
        names.add("Harjit");


        get("/randomiser/1", (req, res) -> {
            Collections.shuffle(names);
            String name = names.get(0);
            names.remove(0);
            HashMap<String, Object> model = new HashMap<>();
            model.put("name", name);
            model.put("everyone", names);
            model.put("template", "one.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);


        get("/randomiser/:numberOfMembersPerGroup", (req, res) -> {

            int numberOfMembersPerGroup = Integer.parseInt(req.params(":numberOfMembersPerGroup"));
            int numberOfGroups = names.size() / numberOfMembersPerGroup;

            Randomiser randomised = new Randomiser();
            HashMap<String, Object> model = new HashMap<>();

            for(int i = 0; i < numberOfGroups; i++ ) {
                Group smallGroup = new Group();
                smallGroup.addRandomMembersToGroup(names, numberOfMembersPerGroup);
                randomised.addGroupToGroups(smallGroup);
            }

            model.put("groups", randomised.getGroups()); // arrayList of groups
            model.put("last_id", numberOfGroups+1);
            model.put("group_size", numberOfMembersPerGroup);
            model.put("everyone", names); // arrayList of all members
            model.put("template", "groups.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);


    }

}
