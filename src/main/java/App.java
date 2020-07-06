import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import dao.Sql2oHeroDao;
import dao.Sql2oSquadDao;
import models.Hero;
import models.Squad;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);
        Sql2oSquadDao squadDao = new Sql2oSquadDao(sql2o);

        //get: show all heroes in all squads and show all squads
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> allSquads = squadDao.getAll();
            model.put("squads", allSquads);
            List<Hero> heroes = heroDao.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //show new squad form
        get("/squad/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> squads = squadDao.getAll(); //refresh list of links for navbar
            model.put("squads", squads);
            return new ModelAndView(model, "squad-form.hbs"); //new
        }, new HandlebarsTemplateEngine());


        //post: process new squad form
        post("/squads", (request, response) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            int squadSize = Integer.parseInt(request.queryParams("squadSize"));
            Squad newSquad = new Squad(name, cause, squadSize);
            squadDao.add(newSquad);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //delete All Heroes
        get("/heroes/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            heroDao.clearAllHeroes();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //delete Hero
        get("/heroes/heroes/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(request.params("id"));
            heroDao.deleteById(idOfHeroToDelete);
            response.redirect( "/");
            return null;
        }, new HandlebarsTemplateEngine());

        // form to add new hero
        get("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "newhero-form.hbs");
        }, new HandlebarsTemplateEngine());

       // process form input
//        post("/heroes", (request, response) -> {
 //           Map<String, Object> model = new HashMap<String, Object>();
 //           String name = request.queryParams("name");
 //           String nickname = request.queryParams("nickname");
 //           int age = Integer.parseInt(request.queryParams("age"));
 //           String power = request.queryParams("power");
//            String weakness = request.queryParams("weakness");
//            Hero newHero = new Hero(name, nickname, age, power, weakness, squadId);
//            heroDao.add(newHero);
 //           response.redirect("/");
 //           return null;
 //       }, new HandlebarsTemplateEngine());

        //list all heroes
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heroes = heroDao.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params(":id"));
            Hero foundHero = heroDao.findById(idOfHeroToFind);
            model.put("hero", foundHero);
            return new ModelAndView(model, "hero-dossier.hbs");
        },new HandlebarsTemplateEngine());

    }
}
