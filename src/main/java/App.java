import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        // form to add new hero
        get("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "newhero-fom.hbs");
        }, new HandlebarsTemplateEngine());

       // process form input
        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String nickname = request.queryParams("nickname");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, nickname, age, power, weakness);
            model.put("hero", newHero);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //list all heroes
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(idOfHeroToFind);
            model.put("hero", foundHero);
            return new ModelAndView(model, "hero-dossier.hbs");
        },new HandlebarsTemplateEngine());
    }
}
