import java.util.ArrayList;
import java.util.HashMap;
import spark.template.velocity.VelocityTemplateEngine;


import models.Group;
import spark.ModelAndView;

import static spark.Spark.get;

public class RandomiserApp {

    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

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


        get("/randomgroup", (req, res) -> {

            int numberOfMembers = 4;
            Group smallGroup = new Group();
            smallGroup.addRandomMembersToGroup(names, numberOfMembers);

            HashMap<String, Object> model = new HashMap<>();
            model.put("group", smallGroup.getGroupMembers());
            model.put("template", "groups.vtl");
            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

    }

}
